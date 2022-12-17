package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dao.UserDao;
import dao.UserDaoFactory;
import entity.User;
import util.DbConnection;

public class UserDaoImpl implements UserDao {

	private Connection connection = null;
	private PreparedStatement ps = null;
	private DbConnection jdbc = null; 

	public UserDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection;
	}

	@Override
	public void insert(User aa) throws Exception {
		// TODO Auto-generated method stub

	}
	public boolean changeAdmin(int id) {
		boolean isOk = false;
		try {
			String sql = "update t_user set admin='"+0+"' where id="+id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if(updateCount == 1){
				isOk = true;
			}else{
				isOk = false;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
	public boolean changeOrdinary(int id) {
		boolean isOk = false;
		try {
			String sql = "update t_user set admin='"+1+"' where id="+id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if(updateCount == 1){
				isOk = true;
			}else{
				isOk = false;
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
	@Override
	public boolean update(int userId) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql = "update t_user set auction_number=auction_number+" + 1 + " where id=" + userId;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			connection.close();
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
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from t_user where id=" + id;
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

	@Override
	public List getAll(){
		// TODO Auto-generated method stub
		List<User> listAll = new ArrayList<User>() ;   
		User user = null;
		try {
			String sql = "select * from t_user";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setAuction_number(rs.getInt("auction_number"));
				user.setBought_number(rs.getInt("bought_number"));
				user.setAdmin(rs.getInt("admin"));
				listAll.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
        return listAll;
	}

	@Override
	public User getById(int user_id) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			String sql = "select * from t_user where id=" + user_id;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setAuction_number(rs.getInt("auction_number"));
				user.setBought_number(rs.getInt("bought_number"));
				user.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

	// ç™»å½•æ“�ä½œ
	public User login(String username, String password) throws Exception {
		User resultUser = null;
		String sql = "select * from t_user where name=? and password=?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setName(rs.getString("name"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setPhone(rs.getString("phone"));
			resultUser.setAddress(rs.getString("address"));
			resultUser.setBought_number(rs.getInt("bought_number"));
			resultUser.setAuction_number(rs.getInt("auction_number"));
			resultUser.setAdmin(rs.getInt("admin"));
		}
		return resultUser;
	}

		public int register(String username, String password) {
		int updateCount = 0;
		try {
			String querySql = "select * from t_user where name='" + username + "'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(querySql);
			if (result.next()) {
				connection.close();
				return 1;
			} else {
				String sql = "insert into t_user(name,password) values(?,?)";
				ps = connection.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				updateCount = ps.executeUpdate();
				System.out.println(updateCount);
				connection.close();
				if (updateCount == 1) {
					return 0;
				} else {
					return 1;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public User GetByName(String username) {
		User user = null;
		String querySql = "select * from t_users where name='" + username + "'";
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(querySql);
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setBought_number(rs.getInt("bought_number"));
				user.setAuction_number(rs.getInt("auction_number"));
				user.setAdmin(rs.getInt("admin"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public int JudgeName(String username) throws SQLException {
		String querySql = "select * from t_user where name='" + username + "'";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(querySql);
		if (result.next()) {
			connection.close();
			return 1;
		} else {
			return 0;
		}
	}

	public boolean AlterUserPassword(int user_id, String password) {
		try {
			String sql = "update t_user set password='" + password + "' where id=" + user_id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			connection.close();
			if (updateCount == 1) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean AlterUsername(int user_id, String username) {
		try {
			String sql = "update t_user set name='" + username + "' where id=" + user_id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			connection.close();
			if (updateCount == 1) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public User querUser(int user_id) {
		User user = null;
		try {
			String sql = "select * from t_user where id=" + user_id;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setAuction_number(rs.getInt("auction_number"));
				user.setBought_number(rs.getInt("bought_number"));
				user.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

	public boolean addUserAuctionNumber(int user_id, int count) {
		try {
			String sql = "update t_user set auction_number=auction_number+" + count + " where id=" + user_id;
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

	public boolean addUserBoughtNumber(int user_id) {
		try {
			String sql = "update t_user set bought_number=bought_number+" + 1 + " where id=" + user_id;
			Statement statement = connection.createStatement();
			int updateCount = statement.executeUpdate(sql);
			if (updateCount == 1) {
				return true;
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean decreaseUserAuctionNumber(int user_id, int count) {
			try {
				String sql = "update t_user set auction_number=auction_number-" + count + " where id=" + user_id;
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
	
	public boolean decreaseUserBoughtNumber(int user_id) {
		try {
			String sql = "update t_user set bought_number=bought_number-" + 1 + " where id=" + user_id;
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