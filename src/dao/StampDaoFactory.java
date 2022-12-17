package dao;

import impl.StampDaoImpl;

public class StampDaoFactory {
	public static StampDao getDaoInstance(){  
        return new StampDaoImpl() ;  
    }  
}