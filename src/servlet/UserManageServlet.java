package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoFactory;
import entity.User;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int userId = Integer.parseInt(request.getParameter("userId"));
//		System.out.println("UserManageServletDoGet");
//		System.out.println("userId:" + userId);
		chageAdmin(request, response);
		UserDao thisdao = UserDaoFactory.getDaoInstance();
		List<User> users = new ArrayList<User>();
		users = thisdao.getAll();
		if (users != null) {
			request.setAttribute("users", users);
			request.getRequestDispatcher("admin/userManage.jsp").forward(request, response);
		} else {
		}
	}

	private void chageAdmin(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("changeAdmin")==null) {
			return;
		}
		if (request.getParameter("changeAdmin").equals("ok")) {
			UserDao thisdao =UserDaoFactory.getDaoInstance();
			if (thisdao.changeAdmin(Integer.parseInt(request.getParameter("userId")))) {
				System.out.println("æ›´æ–°ç”¨æˆ·æ�ƒé™�æˆ�åŠŸ");
			} else {
				System.out.println("æ›´æ–°ç”¨æˆ·æ�ƒé™�å¤±è´¥");
			}
		}

		if (request.getParameter("changeAdmin").equals("no")) {
			UserDao thisdao = UserDaoFactory.getDaoInstance();
			if (thisdao.changeOrdinary(Integer.parseInt(request.getParameter("userId")))) {
				// æ›´æ–°æˆ�åŠŸ
				System.out.println("æ›´æ–°ç”¨æˆ·æ�ƒé™�æˆ�åŠŸ");
			} else {
				// æ›´æ–°å¤±è´¥
				System.out.println("æ›´æ–°ç”¨æˆ·æ�ƒé™�å¤±è´¥");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
