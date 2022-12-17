package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoFactory;
import entity.User;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = getUserSession(request,response);
		List<User> users = new ArrayList<User>();
		request.setAttribute("users", users);
		if(user == null){
		}else{
			request.getSession().setAttribute("user",user);
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			if(request.getParameter("login") != null && request.getParameter("login").toString().equals("no")){
				session.setAttribute("user",null);
				Cookie c = new Cookie("user",null);
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		
		request.getRequestDispatcher("NewIndex.jsp").forward(request, response);
		
	}
	public User getUserSession(HttpServletRequest request, HttpServletResponse response){
		User user = null;
		HttpSession session = request.getSession();
	
		if(session.getAttribute("user") == null){

			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie cookie:cookies){
					if(cookie.getName().equals("user")){
						String[] userCookie;
						try {
							userCookie = java.net.URLDecoder.decode(cookie.getValue(),"UTF-8").split(",");
							user = loginCookie(userCookie[0], userCookie[1]);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(user != null){
							session.setAttribute("username", cookie.getValue());
						}else{
							Cookie c = new Cookie(cookie.getName(),null);
							c.setMaxAge(0);
							response.addCookie(c);
						}
						
					}else{
					}
				}
			}
		}
		return user;
	}

	private User loginCookie(String username,String password){
		User user = null;
		UserDao userdao = UserDaoFactory.getDaoInstance();
		try {
			user = userdao.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
