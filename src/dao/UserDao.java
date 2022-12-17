package dao;

import java.sql.SQLException;
import java.util.List;

import entity.User;


public interface UserDao {

	public void insert(User aa) throws Exception;


	public boolean update(int userId) throws Exception;


	public boolean delete(int id) throws Exception;

	public boolean changeAdmin(int id);

	public boolean changeOrdinary(int id);

	public List getAll();

	public User getById(int index);

	public User login(String username,String password) throws Exception;

	public int register(String username, String password);

	public User GetByName(String username);

	public int JudgeName(String username) throws SQLException;

	public boolean AlterUsername(int user_id,String username);
	public boolean AlterUserPassword(int user_id,String password);

	public User querUser(int user_id);

	public boolean addUserBoughtNumber(int user_id);
	public boolean addUserAuctionNumber(int user_id,int count);

	public boolean decreaseUserAuctionNumber(int user_id, int count);

	public boolean decreaseUserBoughtNumber(int user_id);
}
