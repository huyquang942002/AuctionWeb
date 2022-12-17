package dao;

import impl.BookDaoImpl;


public class BookDaoFactory {
	public static BookDao getBookDaoInstance(){  
        return new BookDaoImpl() ;  
    }  
}
