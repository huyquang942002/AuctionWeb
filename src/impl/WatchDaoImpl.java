package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.WatchDao;
import entity.Book;
import entity.Watch;
import util.DbConnection;

public class WatchDaoImpl implements WatchDao{
	private Connection connection = null;
	private PreparedStatement ps = null;
	private DbConnection jdbc = null;

	public WatchDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection; 
	}
	public boolean insert(int userId,Float price, String introduce,String imgUrl) throws Exception {
		// TODO Auto-generated method stub
		int updateCount = 0;
		try {
			String sql = "insert into t_watch(user_id,price,introduce,picture) values(?,?,?,?);";
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
	public List getWatchAll(){
		// TODO Auto-generated method stub
		List<Watch> WatchAll = new ArrayList<Watch>() ;  
        String sql = "select * from t_watch;" ;  
        try{  
            ps = connection.prepareStatement(sql) ;   
            ResultSet rs = ps.executeQuery() ;  
            while(rs.next()){  
            	 Watch book = new Watch() ;  
                 book.setId(rs.getInt(1));  
                 book.setUserId(rs.getInt(2));  
                 book.setType(rs.getString(3));  
                 book.setWinnerId(rs.getInt(4));  
                 book.setMaxPrice(rs.getFloat(5));
                 book.setPrice(rs.getInt(6));
                 
                 
                 book.setIntroduce(rs.getString(7));  
                 book.setPicture(rs.getString(8));
                 book.setDate(rs.getTimestamp(9)); 
                 book.setState(rs.getInt(10)); 
                WatchAll.add(book) ;  
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
        return WatchAll ;  
	}
	
	public Watch getById(int goods_id) {
		Watch goods = null;
		try {
			String sql = "select * from t_watch where id=" + goods_id;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				goods = new Watch();
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
	
	

	@Override
	public Long getSecond(int id) {
		// TODO Auto-generated method stub
		long second = 0;
		String sql = "select * from t_watch where id=" + id;
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date newDate = null;
		try {
			newDate = rs.getTimestamp("date");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date nowDate=new Date();
		
		second=newDate.getTime()+259200000-nowDate.getTime();

		System.out.println(newDate);
		return second;
	}
	public boolean updateMax_price(int goods_id, float max_price, int winner_id) {
		try {
			String sql = "update t_watch set max_price=" + max_price + ",winner_id=" + winner_id + " where id="
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
			String sql = "update t_watch set state=2,max_price=" + max_price + ",winner_id=" + winner_id + " where id="
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

	public boolean delete(int id) {
		try {
			String sql = "delete from t_watch where id=" + id;
			Statement statement = connection.createStatement();
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

	
}
