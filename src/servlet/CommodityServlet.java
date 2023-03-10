package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.BookDaoFactory;
import dao.StampDao;
import dao.StampDaoFactory;
import dao.WatchDao;
import dao.WatchDaoFactory;
import dao.WineDao;
import dao.WineDaoFactory;
import entity.Book;
import entity.Stamp;
import entity.Watch;
import entity.Wine;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class CommodityServlet
 */
@WebServlet("/CommodityServlet")
public class CommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		String type=request.getParameter("type");
		
		System.out.println(type);
		if(type.equals("book"))
		{
		    out.print(getBook());
//		System.out.println(Json);
		}
		else if (type.equals("watch")) {
			out.print(getWatch());
		}
		else if (type.equals("stamp")) {
			out.print(getStamp());
		}
		else if (type.equals("wine")) {
			out.print(getWine());
		}	
		out.close();
	}
	public JSONArray getBook() {
		BookDao thisDao = BookDaoFactory.getBookDaoInstance();
		List<Book> listAll = null;
		try {
			listAll = thisDao.getBookAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray Json=new JSONArray();
		for (int i = 0; i < listAll.size(); i++) {
			Book bb = listAll.get(i);
			Json.add(i,bb);
		}
		return Json;
	}
	public JSONArray getWatch() {
		WatchDao thisDao = WatchDaoFactory.getWatchDaoInstance();
		List<Watch> listAll = null;
		try {
			listAll = thisDao.getWatchAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray Json=new JSONArray();
		for (int i = 0; i < listAll.size(); i++) {
			Watch bb = listAll.get(i);
//         	System.out.println(bb.getPicture());
			Json.add(i,bb);
//			System.out.println(WatchJson.getString(i));
		}
		return Json;
	}

		public JSONArray getStamp() {
		StampDao thisDao = StampDaoFactory.getDaoInstance();
		List<Stamp> listAll = null;
		try {
			listAll = thisDao.getListAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				JSONArray Json = new JSONArray();
		for (int i = 0; i < listAll.size(); i++) {
						Stamp bb = listAll.get(i);
//	         	System.out.println(bb.getPicture());
			Json.add(i, bb);
//				System.out.println(WatchJson.getString(i));
		}
		return Json;
	}

	public JSONArray getWine() {
		WineDao thisDao = WineDaoFactory.getDaoInstance();
		List<Wine> listAll = null;
		try {
			listAll = thisDao.getListAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray Json = new JSONArray();
		for (int i = 0; i < listAll.size(); i++) {
		
			Wine bb = listAll.get(i);
//		         	System.out.println(bb.getPicture());
			Json.add(i, bb);
//					System.out.println(WatchJson.getString(i));
		}
		return Json;
	}
}
