package dao;

import impl.CommodityDaoImpl;

public class CommodityDaoFactory {
	public static CommodityDao getDaoInstance(){  
        return new CommodityDaoImpl() ;  
    }  
}
