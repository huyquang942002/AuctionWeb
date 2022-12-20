package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoFactory;
import entity.User;

/**
 * Servlet implementation class AlertUserServlet
 */
@WebServlet("/AlterUserServlet")
public class AlterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
		System.out.println("toGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("toPost");
		request.setCharacterEncoding("UTF-8");
		String modify = request.getParameter("modify");
		System.out.println(modify);
		if(modify.equals("password")){
			modifyPassword(request, response,Integer.valueOf(request.getParameter("user_id")), request.getParameter("password"));
		}
//		if(modify.equals("username")){
//			modifyUsername(request, response,Integer.valueOf(request.getParameter("user_id")), request.getParameter("username"));
//		}
	}
//	
			public void modifyPassword(HttpServletRequest request, HttpServletResponse response,int user_id,String password) throws IOException{
			UserDao userdao = UserDaoFactory.getDaoInstance();
			if(passwordIsOk(user_id, request.getParameter("yuanpassword")) && userdao.AlterUserPassword(user_id, password)){
				if (request.getParameter("yuanpassword").equals(password)) {
					System.out.println("");
					response.sendRedirect("alterUser.jsp?user_id="+request.getParameter("user_id")+"&error=newPassWord=oldPassWord");
				}
				else if(!request.getParameter("yuanpassword").equals(password)){
				System.out.println("");
				response.sendRedirect("UserServlet?user_id="+request.getParameter("user_id"));
				}
				else{
					System.out.println("");
					response.sendRedirect("alterUser.jsp?user_id="+request.getParameter("user_id")+"&error=systemError");
				}
			}
			else{
				System.out.println("");
				response.sendRedirect("alterUser.jsp?user_id="+request.getParameter("user_id")+"&error=oloPasswordError");
			}
		}
		public boolean passwordIsOk(int user_id,String password){
			UserDao userdao =UserDaoFactory.getDaoInstance();
			User user = userdao.querUser(user_id);
			if(user.getPassword().equals(password)){
				return true;
			}
			return false;
		}

}
