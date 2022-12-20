package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.StampDao;
import dao.StampDaoFactory;
import entity.Stamp;
import entity.Watch;
import util.DbConnection;

public class StampDaoImpl implements StampDao{
	private Connection connection = null; 
	private PreparedStatement ps = null;
	private DbConnection jdbc = null; 

	public StampDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection;
	}

	public List getListAll(){
		
		List<Stamp> ListAll = new ArrayList<Stamp>() ;  
        String sql = "select * from t_stamp;" ;  
        
        try{  
            ps = connection.prepareStatement(sql) ;   
            ResultSet rs = ps.executeQuery() ;  
            while(rs.next()){  
            	 Stamp thisEntity = new Stamp() ;  
            	 thisEntity.setId(rs.getInt(1));  
            	 thisEntity.setUserId(rs.getInt(2));  
            	 thisEntity.setType(rs.getString(3));  
            	 thisEntity.setWinnerId(rs.getInt(4));  
            	 thisEntity.setMaxPrice(rs.getFloat(5));
            	 thisEntity.setPrice(rs.getInt(6));
                 
                 
            	 thisEntity.setIntroduce(rs.getString(7));  
            	 thisEntity.setPicture(rs.getString(8));
            	 thisEntity.setDate(rs.getTimestamp(9)); 
            	 thisEntity.setState(rs.getInt(10)); 
                 ListAll.add(thisEntity) ;  
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
        try {
			connection.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ListAll ;  
	}
	
		public Stamp getById(int id) {
		Stamp thisEntity = null;
		try {
			String sql = "select * from t_stamp where id=" + id;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				thisEntity = new Stamp();
				thisEntity.setId(rs.getInt("id"));
				thisEntity.setDate(rs.getTimestamp(("date")));
				thisEntity.setIntroduce(rs.getString("introduce"));
				thisEntity.setMaxPrice((rs.getFloat("max_price")));
				thisEntity.setPicture((rs.getString("picture")));

				thisEntity.setPrice((rs.getFloat("price")));
				thisEntity.setType((rs.getString("category")));
				thisEntity.setUserId((rs.getInt("user_id")));

				thisEntity.setWinnerId((rs.getInt("winner_id")));
				thisEntity.setState((rs.getInt("state")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thisEntity;
	}
	
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
			String sql = "update t_stamp set max_price=" + max_price + ",winner_id=" + winner_id + " where id="
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
				String sql = "update t_stamp set state=2,max_price=" + max_price + ",winner_id=" + winner_id + " where id="
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
			String sql = "delete from t_stamp where id=" + id;
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
		

	@Override
	public boolean insert(int userId,Float price, String introduce,String imgUrl) throws Exception {
		// TODO Auto-generated method stub
				int updateCount = 0;
		try {
			String sql = "insert into t_stamp(user_id,price,introduce,picture) values(?,?,?,?);";
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
}
