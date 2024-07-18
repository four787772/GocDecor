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
 * Servlet implementation class edituser
 */
@WebServlet("/edituser")
public class edituser extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public edituser() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher h = request.getRequestDispatcher("/header?pos=uv");
        if (h != null) {
        	h.include(request, response);
		}



        out.append("<main id=\"main\" class=\"main\">");
		out.append("");
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
		out.append("");
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-6 ms-3\">");
		out.append("");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">General Form Elements</h5>");
		out.append("");
		out.append("<!-- General Form Elements -->");
		out.append("<form action=\"/GocDecore/edituser\" method=\"post\">");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		UserFunction uf = new UserFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

		int userId = Integer.parseInt(request.getParameter("id"));
		UserObject item = uf.getUser(userId);
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputId\" class=\"col-sm-2 col-form-label\">Mã NV</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"user_id\" class=\"form-control\" value=\"" + item.getUser_id() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputText\" class=\"col-sm-2 col-form-label\">Name</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"user_name\" class=\"form-control\" value=\" " + item.getUser_name() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputEmail\" class=\"col-sm-2 col-form-label\">Email</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"email\" name=\"user_email\" class=\"form-control\" value=\" " + item.getUser_email() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputPassword\" class=\"col-sm-2 col-form-label\">Password</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"password\" name=\"user_pass\" class=\"form-control\" value=\" " + item.getUser_pass() + " \">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Phone Number</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"user_phone\" class=\"form-control\" value=\"" + item.getUser_phone() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputAddress\" class=\"col-sm-2 col-form-label\">Address</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"user_address\" class=\"form-control\" value=\" " + item.getUser_address() + " \">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">File Upload</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input class=\"form-control\" name=\"user_img\" type=\"file\" id=\"formFile\" value=\" " + item.getUser_img() + " \">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputDate\" class=\"col-sm-2 col-form-label\">Date</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"date\" name=\"user_date\" class=\"form-control\" value=\" " + item.getUser_date() + " \">");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row mb-3\">");
		out.append("<div class=\"col-sm-10 d-flex justify-content-center\">");
		out.append("<button type=\"submit\" class=\"btn btn-primary\">Edit user</button>");
		out.append("<button type=\"submit\" class=\"btn btn-primary ms-3\" onclick=\"history.back()\">cancel</button>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</form><!-- End General Form Elements -->");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("</main><!-- End #main -->");
		out.append("");

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

	        int UserId = Integer.parseInt(request.getParameter("user_id"));
	        String UserName = request.getParameter("user_name");
	        String UserEmail = request.getParameter("user_email");
	        String UserPass = request.getParameter("user_pass");
	        int UserPhone = Integer.parseInt(request.getParameter("user_phone"));
	        String UserAddress = request.getParameter("user_address");
	        String UserImg = request.getParameter("user_img");
	        String UserDate = request.getParameter("user_date");


	        UserObject item = new UserObject();
	        item.setUser_id(UserId);
	        item.setUser_name(UserName);
	        item.setUser_email(UserEmail);
	        item.setUser_pass(UserPass);
	        item.setUser_phone(UserPhone);
	        item.setUser_address(UserAddress);
	        item.setUser_img(UserImg);
	        item.setUser_date(UserDate);

	        boolean result = uf.editUser(item);
	        if (result) {
	            response.sendRedirect("/GocDecore/Userview?success=true"); // Điều hướng đến trang thành công
	        } else {
	            response.sendRedirect("/GocDecore/Deal"); // Điều hướng đến trang lỗi nếu không thành công
	        }
	    } catch (NumberFormatException | NullPointerException e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/Deal"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/Deal"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    }
	}

}
