package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Stamp;
import entity.Watch;

public interface StampDao {
    public List getListAll();  
   	public Stamp getById(int id);
	public Long getSecond(int id) throws SQLException;
	public boolean updateMax_price(int goods_id, float max_price, int winner_id);
	public boolean updateOrder(int goods_id, float max_price, int winner_id);

	public boolean insert(int userId,Float price, String introduce,String imgUrl) throws Exception;
	public boolean delete(int id);
}
