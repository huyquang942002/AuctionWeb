package dao;

import impl.OrderDaoImpl;

public class OrderDaoFactory {
	public static OrderDao getDaoInstance(){  
        return new OrderDaoImpl() ;  
    }  
}
