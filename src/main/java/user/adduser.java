package user;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.UserObject;
import util.ConnectionPool;

/**
 * Servlet implementation class adduser
 */
@WebServlet("/adduser")
public class adduser extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public adduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		RequestDispatcher h = request.getRequestDispatcher("/header?pos=uv");
        if (h != null) {
        	h.include(request, response);
		}

        out.append("<main id=\"main\" class=\"main\">");
		out.append("<div class=\"pagetitle\">");
		out.append("<h1>Add information</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"index.html\">Home</a></li>");
		out.append("<li class=\"breadcrumb-item\">Forms</li>");
		out.append("<li class=\"breadcrumb-item active\">Elements</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-6 ms-3\">");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">General Form Elements</h5>");
		out.append("<form action=\"/GocDecore/adduser\" method=\"post\">");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Mã NV</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"user_id\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputText\" class=\"col-sm-2 col-form-label\">Name</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"user_name\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputEmail\" class=\"col-sm-2 col-form-label\">Email</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"email\" name=\"user_email\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputPassword\" class=\"col-sm-2 col-form-label\">Password</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"password\" name=\"user_pass\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Phone Number</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"user_phone\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputAddress\" class=\"col-sm-2 col-form-label\">Address</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"user_address\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">File Upload</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input class=\"form-control\" name=\"user_img\" type=\"file\" id=\"formFile\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputDate\" class=\"col-sm-2 col-form-label\">Date</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"date\" name=\"user_date\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<div class=\"col-sm-10 d-flex justify-content-center\">");
		out.append("<button type=\"submit\" class=\"btn btn-primary\">Add admin</button>");
		out.append("<button type=\"submit\" class=\"btn btn-primary ms-3\" onclick=\"history.back()\">cancel</button>");
		out.append("</div>");
		out.append("</div>");
		out.append("</form><!-- End General Form Elements -->");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section>");
		out.append("</main><!-- End #main -->");

		RequestDispatcher f = request.getRequestDispatcher("/footer");
		if (f != null) {
			f.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		UserFunction uf = new UserFunctionImpl(cp);

		if (cp == null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

		try {
			int userId = Integer.parseInt(request.getParameter("user_id"));
			String userName = request.getParameter("user_name");
			String userEmail = request.getParameter("user_email");
			String userPass = request.getParameter("user_pass");
			int userPhone = Integer.parseInt(request.getParameter("user_phone"));
			String userAddress = request.getParameter("user_address");
			String userImg = request.getParameter("user_img");
			String userDate = request.getParameter("user_date");

			UserObject item = new UserObject();
			item.setUser_id(userId);
			item.setUser_name(userName);
			item.setUser_email(userEmail);
			item.setUser_pass(userPass);
			item.setUser_phone(userPhone);
			item.setUser_address(userAddress);
			item.setUser_img(userImg);
			item.setUser_date(userDate);

			boolean result = uf.addUser(item);
			if (result) {
				response.sendRedirect("/GocDecore/Userview?success1=true"); // Điều hướng đến trang thành công
			} else {
				response.sendRedirect("/GocDecore/View"); // Điều hướng đến trang lỗi nếu không thành công
			}
		} catch (NumberFormatException | NullPointerException e) {
			e.printStackTrace();
			response.sendRedirect("/GocDecore/View"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/GocDecore/View"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
		}
	}

}
