package dao;

import impl.WineDaoImpl;

public class WineDaoFactory {
	public static WineDao getDaoInstance(){  
        return new WineDaoImpl() ;  
    }  
}
