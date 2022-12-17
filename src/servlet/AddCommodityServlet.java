package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
import entity.Commodity;


@WebServlet("/AddCommodityServlet")
public class AddCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("message", "");
		request.setAttribute("path", "");
		String filename = null;
		String savePath = this.getServletContext().getRealPath("/imges");
		File file = new File(savePath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> list = null;
		try {
			list = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				if (!ServletFileUpload.isMultipartContent(request)) {
					return;
		}
		System.out.println(list.toString());
		for (FileItem item : list) {
			filename = item.getName();
			if (filename == null || filename.trim().equals("")) {
				continue;
			}

			
			filename = filename.substring(filename.lastIndexOf("\\") + 1);
			if (filename.substring(filename.lastIndexOf(".") + 1).equals("png")
					|| filename.substring(filename.lastIndexOf(".") + 1).equals("jpg")
					|| filename.substring(filename.lastIndexOf(".") + 1).equals("JPG")
					|| filename.substring(filename.lastIndexOf(".") + 1).equals("PNG")
					|| filename.substring(filename.lastIndexOf(".") + 1).equals("jpeg")) {
				InputStream in = item.getInputStream();
				FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
				request.setAttribute("path", "images" + "\\" + filename);

				int len = 0;
				byte buffer[] = new byte[1024];
				while ((len = in.read(buffer)) > 0)
				{
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
				item.delete();
			} else {
				System.out.println("å¿…é¡»ä¸�ä¼ å›¾ç‰‡!");
				return;
			}
		}
		System.out.println(filename);
		String imgUrl = "imges/" + filename;

		int userId = Integer.valueOf(request.getParameter("userId"));
		System.out.println("userId:" + userId);
		Float price = null;
		String introduce = null;
		String type = null;
		Iterator<FileItem> thisItem = list.iterator();
		while (thisItem.hasNext()) {
			FileItem thisItem2 = thisItem.next();
			String thisItemName = thisItem2.getFieldName();
			if (thisItem2.isFormField()) {
				if (thisItemName.equals("price")) {
					price = Float.parseFloat(thisItem2.getString("utf-8"));
					System.out.println(price);
				} else if (thisItemName.equals("introduce")) {
					introduce = thisItem2.getString("utf-8");
					System.out.println(introduce);
				} else if (thisItemName.equals("select")) {
					type = thisItem2.getString("utf-8");
					System.out.println(type);
				}
			}
		}
		addCommodity(type, userId,price,introduce,imgUrl);
		addUserCommodity(userId);
		request.setAttribute("message", "ä¸�ä¼ æˆ�å�Ÿ");
		request.setAttribute("imgUrl", imgUrl);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}
	public void addUserCommodity(int userId) {
		UserDao thisDao=UserDaoFactory.getDaoInstance();
		try {
			if (thisDao.update(userId)) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addCommodity(String type, int userId,Float price,String introduce,String imgUrl) {
		if (type.equals("book")) {
			BookDao thisDao=BookDaoFactory.getBookDaoInstance();
			try {
				if (thisDao.insert(userId, price, introduce, imgUrl)) {
					
				}else {
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (type.equals("watch")) {
			WatchDao thisDao=WatchDaoFactory.getWatchDaoInstance();
			try {
				if (thisDao.insert(userId, price, introduce, imgUrl)) {
					
				}else {
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (type.equals("stamp")) {
			StampDao thisDao=StampDaoFactory.getDaoInstance();
			try {
				if (thisDao.insert(userId, price, introduce, imgUrl)) {
					
				}else {
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (type.equals("wine")) {
			WineDao thisDao=WineDaoFactory.getDaoInstance();
			try {
				if (thisDao.insert(userId, price, introduce, imgUrl)) {
				}else {
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

