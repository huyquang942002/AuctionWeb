package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import entity.Commodity;
import entity.Stamp;
import entity.Watch;
import entity.Wine;

/**
 * Servlet implementation class MyBoughtServlet
 */
@WebServlet("/MyBoughtServlet")
public class MyBoughtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBoughtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int user_id = Integer.valueOf(request.getParameter("user_id"));
		List<Commodity> myGoodss = new ArrayList<Commodity>();
		myGoodss = getUserGoods(user_id);
		request.setAttribute("myGoodss", myGoodss);
		request.getRequestDispatcher("myAuction.jsp").forward(request, response);
	}

	public List<Commodity> getUserGoods(int user_id){
		List<Commodity> myGoodss = new ArrayList<Commodity>();
		BookDao newBookDao=BookDaoFactory.getBookDaoInstance();
		try {
			List<Book> BookList = newBookDao.getBookAll();
			for(int i=0;i<BookList.size();i++){
				if(BookList.get(i).getWinnerId() == user_id){
					Commodity goods = BookList.get(i);
					Book book=BookList.get(i);
					goods.setCommodityId(book.getId());
					myGoodss.add(goods);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WatchDao newWatchDao=WatchDaoFactory.getWatchDaoInstance();
		try {
			List<Watch> thisList = newWatchDao.getWatchAll();
			for(int i=0;i<thisList.size();i++){
				if(thisList.get(i).getWinnerId() == user_id){
					Commodity goods = thisList.get(i);
					Watch book=thisList.get(i);
					goods.setCommodityId(book.getId());
					myGoodss.add(goods);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StampDao newStampDao = StampDaoFactory.getDaoInstance();
		try {
			List<Stamp> thisList = newStampDao.getListAll();
			for (int i = 0; i < thisList.size(); i++) {
				if (thisList.get(i).getWinnerId() == user_id) {
					Commodity goods = thisList.get(i);
										Stamp book=thisList.get(i);
					goods.setCommodityId(book.getId());
					myGoodss.add(goods);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				WineDao newWineDao = WineDaoFactory.getDaoInstance();
		try {
			List<Wine> thisList = newWineDao.getListAll();
			for (int i = 0; i < thisList.size(); i++) {
				if (thisList.get(i).getWinnerId() == user_id) {
					Commodity goods = thisList.get(i);
										Wine book = thisList.get(i);
					goods.setCommodityId(book.getId());
					myGoodss.add(goods);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myGoodss;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
