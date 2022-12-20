package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.SaslException;

import dao.BookDao;
import dao.BookDaoFactory;
import dao.CommodityDao;
import dao.CommodityDaoFactory;
import dao.StampDao;
import dao.StampDaoFactory;
import dao.WatchDao;
import dao.WatchDaoFactory;
import dao.WineDao;
import dao.WineDaoFactory;
import entity.Book;
import entity.Commodity;
import entity.Stamp;
import util.DbConnection;

public class CommodityDaoImpl implements CommodityDao {
	
	private Connection connection = null;
	private PreparedStatement ps = null;
	private DbConnection jdbc = null; 

	public CommodityDaoImpl() {
		jdbc = new DbConnection();
		connection = jdbc.connection;
	}

	public List fuzzySerchBookList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_book where (category like '%"+ keyword + "%')or(introduce like '%" + keyword
				+ "%')";

		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));
				commodity.setCommodityId(rs.getInt(1));
				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}

	public List fuzzySerchWatchList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_watch where (category like '%" + keyword + "%')or(introduce like '%" + keyword
				+ "%')";

		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));
				commodity.setCommodityId(rs.getInt(1));
				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}

		public List fuzzySerchStampList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_stamp where (category like '%" + keyword + "%')or(introduce like '%" + keyword
				+ "%')";
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {

				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));

				commodity.setCommodityId(rs.getInt(1));

				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}
	
		public List fuzzySerchWineList(String keyword) {
		List<Commodity> ListAll = new ArrayList<Commodity>();
		String sql = "select * from t_wine where (category like '%" + keyword + "%')or(introduce like '%" + keyword
				+ "%')";
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i = 1;
			while (rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(i);
				i++;
				commodity.setUserId(rs.getInt(2));
				commodity.setType(rs.getString(3));
				commodity.setWinnerId(rs.getInt(4));
				commodity.setMaxPrice(rs.getInt(5));
				commodity.setPrice(rs.getFloat(6));

				commodity.setIntroduce(rs.getString(7));
				commodity.setPicture(rs.getString(8));
				commodity.setDate(rs.getTimestamp(9));
				commodity.setState(rs.getInt(10));
				commodity.setCommodityId(rs.getInt(1));
				ListAll.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListAll;
	}

	public List fuzzySerch(String keyWord) {
		List<Commodity> thisList = new ArrayList<Commodity>();
		
		CommodityDao commDao1 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityBook = new ArrayList<Commodity>();
		commodityBook = commDao1.fuzzySerchBookList(keyWord);
		for (int i = 0; i < commodityBook.size(); i++) {
			Commodity thiscommodity = commodityBook.get(i);
			thisList.add(thiscommodity);
		}
		CommodityDao commDao2 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityWatch = new ArrayList<Commodity>();
		commodityWatch = commDao2.fuzzySerchWatchList(keyWord);
		for (int i = 0; i < commodityWatch.size(); i++) {
			Commodity thiscommodity = commodityWatch.get(i);
			thisList.add(thiscommodity);
		}
		CommodityDao commDao3 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityStamp = new ArrayList<Commodity>();
		commodityStamp = commDao3.fuzzySerchStampList(keyWord);
		for (int i = 0; i < commodityStamp.size(); i++) {
			Commodity thiscommodity = commodityStamp.get(i);
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		CommodityDao commDao4 = CommodityDaoFactory.getDaoInstance();
		List<Commodity> commodityWine = new ArrayList<Commodity>();
		commodityWine = commDao4.fuzzySerchWineList(keyWord);
		for (int i = 0; i < commodityWine.size(); i++) {
			Commodity thiscommodity = commodityWine.get(i);
//					System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		return thisList;
	}
	@Override
	public List getAllList() {
		// TODO Auto-generated method stub
		List<Commodity> thisList = new ArrayList<Commodity>();

		// book
		BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		List<Commodity> commodityBook = new ArrayList<Commodity>();
		commodityBook = bookDao.getBookAll();
		for (int i = 0; i < commodityBook.size(); i++) {
			Commodity thiscommodity = commodityBook.get(i);
			thiscommodity.setCommodityId(commodityBook.get(i).getId());
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		
		//watch
		WatchDao watchDao= WatchDaoFactory.getWatchDaoInstance();
		List<Commodity> commodityWatch = new ArrayList<Commodity>();
		commodityWatch=watchDao.getWatchAll();
		for (int i = 0; i < commodityWatch.size(); i++) {
			Commodity thiscommodity = commodityWatch.get(i);
			thiscommodity.setCommodityId(commodityWatch.get(i).getId());
//			System.out.println(thiscommodity.getPrice());
			thisList.add(thiscommodity);
		}
		// stamp
		StampDao stampDao= StampDaoFactory.getDaoInstance();
		List<Commodity> commodityStamp = new ArrayList<Commodity>();
		commodityStamp=stampDao.getListAll();
		for (int i = 0; i < commodityStamp.size(); i++) {
			Commodity thiscommodity = commodityStamp.get(i);
			thiscommodity.setCommodityId(commodityStamp.get(i).getId());
			thisList.add(thiscommodity);
		}
		//wine
		WineDao wineDao = WineDaoFactory.getDaoInstance();
		List<Commodity> commodityWine = new ArrayList<Commodity>();
		commodityWine = wineDao.getListAll();
		for (int i = 0; i < commodityWine.size(); i++) {
			Commodity thiscommodity = commodityWine.get(i);
			thiscommodity.setCommodityId(commodityWine.get(i).getId());
			thisList.add(thiscommodity);
		}
		return thisList;
	}
}
