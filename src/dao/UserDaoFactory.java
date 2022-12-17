package dao;

import impl.UserDaoImpl;


public class UserDaoFactory {
	public static UserDao getDaoInstance(){  
        return new UserDaoImpl() ;  
    }  
}
