package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.activemq.filter.function.regexMatchFunction;
import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;

import dao.OrderDao;
import dao.OrderDaoFactory;
import entity.Book;
import entity.Commodity;
import entity.Order;
import util.DbConnection;

public class OrderDaoImpl implements OrderDao{
	
	private Connection connection = null; 
	private PreparedStatement ps = null; 
	private DbConnection jdbc = null; 

	public OrderDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection;
	}
	public boolean addOrder(int commodityId,float price,int winnerId, int userId,String type){
		boolean state = false;
		try {
			
			String sql = "insert into t_order(commodity_id,price,winner_id,user_id,type) values(?,?,?,?,?);";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, commodityId);
			ps.setFloat(2, price);
			ps.setInt(3, winnerId);
			ps.setInt(4, userId);
			ps.setString(5, type);
			int updateCount = ps.executeUpdate();
			if(updateCount == 1){
				state = true;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	public int selectId(int id,String type) {
		int orderId = 0;
		String sql = "select * from t_order where commodity_id= '"+ id+"' and category='"+type+"'";
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
			orderId=rs.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderId;
	}
		public boolean deleteById(int id) {
		boolean state = false;
		String sql = "delete from t_order where id= '"+ id+"'";
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//更新
		int updateCount = 0;
		try {
			updateCount = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (updateCount == 1) {
			state =true;
		} 
		return state;
	}

	public Order getById(int id) {
		Order order = null;
		try {
			String sql = "select * from t_order where id=" + id;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				order = new Order();
				order.setId(rs.getInt("id"));
				order.setDate(rs.getTimestamp(("date")));
				order.setCommodityId(rs.getInt("commodity_id"));
				order.setPrice((rs.getFloat("price")));
				order.setUserId((rs.getInt("user_id")));
				
				order.setType((rs.getString("category")));
				order.setWinnerId((rs.getInt("winner_id")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

}
