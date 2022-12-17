package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Book;

public interface BookDao {
	
	public boolean insert(int userId,Float price, String introduce,String imgUrl) throws Exception;

	
	public void update(Book book) throws Exception;

	
	public boolean delete(int id);

	
	public List getBookAll();

	
	public Book getById(int index) throws Exception;
	
	public long getSecond(int id) throws SQLException;
	
	public boolean updateMax_price(int goods_id, float max_price, int winner_id);
	
	public boolean updateOrder(int goods_id, float max_price, int winner_id);
}
