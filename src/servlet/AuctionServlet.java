package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.BookDao;
import dao.BookDaoFactory;
import dao.StampDao;
import dao.StampDaoFactory;
import dao.UserDao;
import dao.UserDaoFactory;
import dao.WatchDao;
import dao.WatchDaoFactory;
import dao.WineDao;
import dao.WineDaoFactory;
import entity.Book;
import entity.Stamp;
import entity.User;
import entity.Watch;
import entity.Wine;


/**
 * Servlet implementation class AuctionServlet
 */
@WebServlet("/AuctionServlet")
public class AuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		response.sendRedirect("IndexServlet");
//		doPost(request, response);
		System.out.println("AuctionServletDoPost");
		//èŽ·å�–å•†å“�id
		int id=Integer.valueOf(request.getParameter("id"));
		String type=request.getParameter("type");
//		System.out.println(id);
		System.out.println("auctionServletType:"+type);
		
//		System.out.println(time);
//		response.sendRedirect("auction.jsp");
		if (type.equals("book")) {
			try {
				Book thisEntity = getBook(request, response, id);
				Long time = getBookTime(id);
				User user=getUser(request, response,thisEntity.getUserId());
				float maxPrice=thisEntity.getMaxPrice();
				System.out.println("maxPrice:"+maxPrice);
				float price=thisEntity.getPrice();
//				System.out.println(user.getName());
				if(thisEntity != null) {
					request.setAttribute("type", type);
					request.setAttribute("user", user);
					request.setAttribute("time", time);
					request.setAttribute("price", price);
					request.setAttribute("maxPrice", maxPrice);
					request.setAttribute("commodity", thisEntity);
					request.getRequestDispatcher("auction.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//wacth
		else if (type.equals("watch")) {
			try {
				Watch thisEntity = getWatch(request, response, id);
				Long time = getWatchTime(id);
				User user=getUser(request, response,thisEntity.getUserId());
				float maxPrice=thisEntity.getMaxPrice();
				System.out.println("maxPrice:"+maxPrice);
				float price=thisEntity.getPrice();
//				System.out.println(user.getName());
				if(thisEntity != null) {
					request.setAttribute("type", type);
					request.setAttribute("user", user);
					request.setAttribute("time", time);
					request.setAttribute("price", price);
					request.setAttribute("maxPrice", maxPrice);
					request.setAttribute("commodity", thisEntity);
					request.getRequestDispatcher("auction.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//stamp
		else if (type.equals("stamp")) {
			try {
				Stamp thisEntity = getStamp(request, response, id);
				Long time = getStampTime(id);
				User user=getUser(request, response,thisEntity.getUserId());
				float maxPrice=thisEntity.getMaxPrice();
				System.out.println("maxPrice:"+maxPrice);
				float price=thisEntity.getPrice();
//				System.out.println(user.getName());
				if(thisEntity != null) {
					request.setAttribute("type", type);
					request.setAttribute("user", user);
					request.setAttribute("time", time);
					request.setAttribute("price", price);
					request.setAttribute("maxPrice", maxPrice);
					request.setAttribute("commodity", thisEntity);
					request.getRequestDispatcher("auction.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// wine
		else if (type.equals("wine")) {
			try {
				Wine thisEntity = getWine(request, response, id);
				Long time = getWineTime(id);
				User user = getUser(request, response, thisEntity.getUserId());
				float maxPrice = thisEntity.getMaxPrice();
				System.out.println("maxPrice:" + maxPrice);
				float price = thisEntity.getPrice();
//						System.out.println(user.getName());
				if (thisEntity != null) {
					request.setAttribute("type", type);
					request.setAttribute("user", user);
					request.setAttribute("time", time);
					request.setAttribute("price", price);
					request.setAttribute("maxPrice", maxPrice);
					request.setAttribute("commodity", thisEntity);
					request.getRequestDispatcher("auction.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private Long getWatchTime(int id) {
		// TODO Auto-generated method stub
		Long time = null;
		WatchDao thisDao=WatchDaoFactory.getWatchDaoInstance();
		try {
			time = thisDao.getSecond(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}

	private Watch getWatch(HttpServletRequest request, HttpServletResponse response, int id) {
		// TODO Auto-generated method stub
		Watch thisEntity = null;
		WatchDao thisDao=WatchDaoFactory.getWatchDaoInstance();
		thisEntity = thisDao.getById(id);
		if(thisEntity==null) {
			System.out.println("Không có sản phẩm ! ");
		}
		return thisEntity;
	}

	public Book getBook(HttpServletRequest request, HttpServletResponse response,int id){
		Book thisEntity = null;
		BookDao thisDao=BookDaoFactory.getBookDaoInstance();
		try {
			thisEntity = thisDao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(thisEntity==null) {
			System.out.println("Không có sản phẩm !");
		}
		return thisEntity;
	}
	public User getUser(HttpServletRequest request, HttpServletResponse response,int user_id){
		User user = null;
		UserDao userdao = UserDaoFactory.getDaoInstance();
		try {
			user = userdao.getById(user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		doGet(request, response);
//		PrintWriter out = response.getWriter();

		int user_id = Integer.valueOf(request.getParameter("user_id"));
		int winner_id = Integer.valueOf(request.getParameter("winner_id"));
		String type = String.valueOf(request.getParameter("type"));
		int goods_id = Integer.valueOf(request.getParameter("goods_id"));
		int max_price = Integer.valueOf(request.getParameter("max_price"));
		
		User user = getUser(request, response,user_id);
//		if (winner_id!=user.getId()) {
//			//+1
//			UserDao thisUserDao=UserDaoFactory.getDaoInstance();
//			thisUserDao.addUserBoughtNumber(user_id);
//		}
		// ä¿®æ”¹
		updateMax_price(type,goods_id, max_price, winner_id);
		if (type.equals("book")) {
			Book thisEntity = getBook(request, response, goods_id);
			float maxPrice=thisEntity.getMaxPrice();
//			System.out.println("maxPrice:"+maxPrice);
			float price=thisEntity.getPrice();
			Long time = getBookTime(goods_id);
			if (thisEntity != null) {
				request.setAttribute("commodity", thisEntity);
				request.setAttribute("user", user);
				request.setAttribute("type", type);
				request.setAttribute("time", time);
				//èŽ·å�–åŽŸæ•°æ�®
				request.setAttribute("price", price);
				request.setAttribute("maxPrice", maxPrice);
				request.getRequestDispatcher("auction.jsp").forward(request, response);
			}
		}
		//watch
		if (type.equals("watch")) {
			Watch thisEntity = getWatch(request, response, goods_id);
			float maxPrice=thisEntity.getMaxPrice();
//			System.out.println("maxPrice:"+maxPrice);
			float price=thisEntity.getPrice();
			Long time = getWatchTime(goods_id);
			if (thisEntity != null) {
				request.setAttribute("commodity", thisEntity);
				request.setAttribute("user", user);
				request.setAttribute("type", type);
				request.setAttribute("time", time);
				//èŽ·å�–åŽŸæ•°æ�®
				request.setAttribute("price", price);
				request.setAttribute("maxPrice", maxPrice);
				request.getRequestDispatcher("auction.jsp").forward(request, response);
			}
		}
		// stamp
		if (type.equals("stamp")) {
			Stamp thisEntity = getStamp(request, response, goods_id);
			float maxPrice = thisEntity.getMaxPrice();
//					System.out.println("maxPrice:"+maxPrice);
			float price = thisEntity.getPrice();
			Long time = getStampTime(goods_id);
			if (thisEntity != null) {
				request.setAttribute("commodity", thisEntity);
				request.setAttribute("user", user);
				request.setAttribute("type", type);
				request.setAttribute("time", time);
				// èŽ·å�–åŽŸæ•°æ�®
				request.setAttribute("price", price);
				request.setAttribute("maxPrice", maxPrice);
				request.getRequestDispatcher("auction.jsp").forward(request, response);
			}
		}
		//wine
		if (type.equals("wine")) {
			Wine thisEntity = getWine(request, response, goods_id);
			float maxPrice = thisEntity.getMaxPrice();
//					System.out.println("maxPrice:"+maxPrice);
			float price = thisEntity.getPrice();
			Long time = getWineTime(goods_id);
			if (thisEntity != null) {
				request.setAttribute("commodity", thisEntity);
				request.setAttribute("user", user);
				request.setAttribute("type", type);
				request.setAttribute("time", time);
				// èŽ·å�–åŽŸæ•°æ�®
				request.setAttribute("price", price);
				request.setAttribute("maxPrice", maxPrice);
				request.getRequestDispatcher("auction.jsp").forward(request, response);
			}
		}
	}

	public void updateMax_price(String type,int goods_id, int max_price, int winner_id) {
		if (type.equals("book")) {
			BookDao goodsdao = BookDaoFactory.getBookDaoInstance();
			goodsdao.updateMax_price(goods_id, max_price, winner_id);
		}
		if (type.equals("watch")) {
			WatchDao goodsdao = WatchDaoFactory.getWatchDaoInstance();
			goodsdao.updateMax_price(goods_id, max_price, winner_id);
		}
		if (type.equals("stamp")) {
			StampDao goodsdao = StampDaoFactory.getDaoInstance();
			goodsdao.updateMax_price(goods_id, max_price, winner_id);
		}
		if (type.equals("wine")) {
			WineDao goodsdao = WineDaoFactory.getDaoInstance();
			goodsdao.updateMax_price(goods_id, max_price, winner_id);
		}
	}
//
	
	private long getBookTime(int id){
		Long time = null;
		BookDao bookDao=BookDaoFactory.getBookDaoInstance();
		try {
			time = bookDao.getSecond(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	
	//stamp
	private Long getStampTime(int id) {
		// TODO Auto-generated method stub
		Long time = null;
		StampDao thisDao=StampDaoFactory.getDaoInstance();
		try {
			time = thisDao.getSecond(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	//stamp
	private Stamp getStamp(HttpServletRequest request, HttpServletResponse response, int id) {
		// TODO Auto-generated method stub
		Stamp thisEntity = null;
		StampDao thisDao=StampDaoFactory.getDaoInstance();
		thisEntity = thisDao.getById(id);
		if(thisEntity==null) {
			System.out.println("èŽ·å�–ç‰©å“�å¤±è´¥");
		}
		return thisEntity;
	}

	// wine
	private Long getWineTime(int id) {
		// TODO Auto-generated method stub
		Long time = null;
		WineDao thisDao = WineDaoFactory.getDaoInstance();
		try {
			time = thisDao.getSecond(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}

	// wine
	private Wine getWine(HttpServletRequest request, HttpServletResponse response, int id) {
		// TODO Auto-generated method stub
		Wine thisEntity = null;
		WineDao thisDao = WineDaoFactory.getDaoInstance();
		thisEntity = thisDao.getById(id);
		if (thisEntity == null) {
			System.out.println("èŽ·å�–ç‰©å“�å¤±è´¥");
		}
		return thisEntity;
	}
}
