package dao;

import entity.Order;


public interface OrderDao {
	
	public boolean addOrder(int commodityId,float price,int winnerId, int userId,String type);

	public int selectId(int id,String type);
	
	public boolean deleteById(int id);

	public Order getById(int id);
}
