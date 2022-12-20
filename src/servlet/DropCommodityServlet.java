package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.BookDaoFactory;
import dao.OrderDao;
import dao.OrderDaoFactory;
import dao.StampDao;
import dao.StampDaoFactory;
import dao.UserDao;
import dao.UserDaoFactory;
import dao.WatchDao;
import dao.WatchDaoFactory;
import dao.WineDao;
import dao.WineDaoFactory;

/**
 * Servlet implementation class DeletCommodityServlet
 */
@WebServlet("/DropCommodityServlet")
public class DropCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropCommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int commodityId = Integer.parseInt(request.getParameter("commodityId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String type = request.getParameter("type");
		System.out.println("DropCommodityServlet");
		System.out.println(commodityId);
		System.out.println(type);
		int winnerId=Integer.parseInt(request.getParameter("winnerId"));
		System.out.println("winnerId:"+winnerId);
	
		if (winnerId!=0) {
		
			OrderDao thisDao=OrderDaoFactory.getDaoInstance();
			int orderId=thisDao.selectId(commodityId, type);
			System.out.println("orderId:"+orderId);
			if (orderId!=0) {
				OrderDao thisDao1=OrderDaoFactory.getDaoInstance();
				int orderWinnerId=thisDao1.getById(orderId).getWinnerId();
				System.out.println("orderWinnerId:"+orderWinnerId);
//				int winnerId=Integer.parseInt(request.getParameter("winnerId"));
				if (orderWinnerId==winnerId) {
					updateWinner(winnerId);
				}
					dropOrder(commodityId,type);
			}
			
		}
		dropCommodity(commodityId,type);
		updateUser(userId);
		response.sendRedirect("CommodityManageServlet?level=guanliyuan&page=4&start=0");
	}
	private void updateWinner(int winnerId) {
		UserDao thisDao =UserDaoFactory.getDaoInstance();
		if (thisDao.decreaseUserBoughtNumber(winnerId)) {
			System.out.println("");
		}
	}
	private void updateUser(int userId) {
		// TODO Auto-generated method stub
		UserDao thisDao =UserDaoFactory.getDaoInstance();
		if (thisDao.decreaseUserAuctionNumber(userId,1)) {
			System.out.println("");
		}
	}

	private void dropCommodity(int commodityId,String type){
		if (type.equals("book")) {
			BookDao bookDao=BookDaoFactory.getBookDaoInstance();
			if (bookDao.delete(commodityId)) {
				System.out.println("");
			}
			else {
				System.out.println("");
			}
		}
		if (type.equals("watch")) {
			WatchDao thisDao=WatchDaoFactory.getWatchDaoInstance();
			if (thisDao.delete(commodityId)) {
				System.out.println("");
			}
			else {
				System.out.println("");
			}
		}
		if (type.equals("stamp")) {
			StampDao thisDao = StampDaoFactory.getDaoInstance();
			if (thisDao.delete(commodityId)) {
				System.out.println("");
			}
			else {
				System.out.println("");
			}
		}
		if (type.equals("wine")) {
			WineDao thisDao = WineDaoFactory.getDaoInstance();
			if (thisDao.delete(commodityId)) {
				System.out.println("");
			} else {
				System.out.println("");
			}
		}
	}
	private void dropOrder(int commodityId,String type)
	{
		OrderDao thisDao=OrderDaoFactory.getDaoInstance();
		int orderId=thisDao.selectId(commodityId, type);
		OrderDao thisDao1=OrderDaoFactory.getDaoInstance();
		if (thisDao1.deleteById(orderId)) {
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
