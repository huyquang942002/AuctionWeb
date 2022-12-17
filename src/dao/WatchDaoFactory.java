package dao;

import impl.WatchDaoImpl;


public class WatchDaoFactory {
	public static WatchDao getWatchDaoInstance(){  
        return new WatchDaoImpl() ;  
    }  
}
