package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dao.BookDao;
import dao.BookDaoFactory;
import entity.Book;
import util.DbConnection;


public class BookDaoImpl implements BookDao{
	private Connection connection = null;
	private PreparedStatement ps = null;
	private DbConnection jdbc = null; 

	public BookDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection; 
	}
	
	@Override
	public boolean insert(int userId,Float price, String introduce,String imgUrl) throws Exception {
		// TODO Auto-generated method stub
		int updateCount = 0;
		try {
			String sql = "insert into t_book(user_id,price,introduce,picture) values(?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
		    ps.setFloat(2, price);
		    ps.setString(3,introduce);
		    ps.setString(4, imgUrl);
		    updateCount = ps.executeUpdate();
		    connection.close();
		    if(updateCount == 1){
		        return true;
		    }else{
		        return false;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;    
	}
	
	@Override
	public void update(Book book) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean delete(int id) {
		try {
			String sql = "delete from t_book where id=" + id;
			Statement statement =connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if (updateCount == 1) {

				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
// hiện danh sách các sách có trong líut
	@Override
	public List getBookAll(){
		// TODO Auto-generated method stub
		List<Book> BookAll = new ArrayList<Book>() ;  
        String sql = "select * from t_book;" ;  
   
        try{  
       
            ps = connection.prepareStatement(sql) ;   
            ResultSet rs = ps.executeQuery() ;  
            while(rs.next()){  
                Book book = new Book() ;  
                book.setId(rs.getInt(1));  
                book.setUserId(rs.getInt(2));  
                book.setType(rs.getString(3));  
                book.setWinnerId(rs.getInt(4));  
                book.setMaxPrice(rs.getInt(5));
                book.setPrice(rs.getFloat(6));
                
                
                book.setIntroduce(rs.getString(7));  
                book.setPicture(rs.getString(8));
                book.setDate(rs.getTimestamp(9)); 
                book.setState(rs.getInt(10)); 
                BookAll.add(book) ;  
            }  
            rs.close() ;  
            ps.close() ;  
        }  
        catch (Exception e){  
            try {
				throw new Exception(e) ;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
        }  
        finally{  
              
            try {
				connection.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }  
        return BookAll ;  
	}

	public Book getById(int goods_id) {
		Book goods = null;
		try {
			String sql = "select * from t_book where id=" + goods_id;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				goods = new Book();
				goods.setId(rs.getInt("id"));
				goods.setDate(rs.getTimestamp(("date")));
				goods.setIntroduce(rs.getString("introduce"));
				goods.setMaxPrice((rs.getFloat("max_price")));
				goods.setPicture((rs.getString("picture")));

				goods.setPrice((rs.getFloat("price")));
				goods.setType((rs.getString("category")));
				goods.setUserId((rs.getInt("user_id")));

				goods.setWinnerId((rs.getInt("winner_id")));
				goods.setState((rs.getInt("state")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	public long getSecond(int id) throws SQLException {
		
		long second = 0;
		String sql = "select * from t_book where id=" + id;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		Date newDate = rs.getTimestamp("date");
		Date nowDate=new Date();
		
		second=newDate.getTime()+259200000-nowDate.getTime();
	
		System.out.println(newDate);
		return second;
	}

		public boolean updateMax_price(int goods_id, float max_price, int winner_id) {
		try {
			String sql = "update t_book set max_price=" + max_price + ",winner_id=" + winner_id + " where id="
					+ goods_id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if (updateCount == 1) {
								return true;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public boolean updateOrder(int goods_id, float max_price, int winner_id) {
		try {
			String sql = "update t_book set state=2,max_price=" + max_price + ",winner_id=" + winner_id + " where id="
					+ goods_id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if (updateCount == 1) {
					return true;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
}
