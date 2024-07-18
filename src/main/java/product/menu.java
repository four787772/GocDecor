package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class menu
 */
@WebServlet("/menu")
public class menu extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public menu() {
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

		String pos= request.getParameter("pos");
        HashMap<String, String> collapsed = new HashMap<>();
        HashMap<String, String> show = new HashMap<>();
        HashMap<String, String> active = new HashMap<>();

		if(pos!= null) {
        	if(pos.equalsIgnoreCase("uv")) {
        		collapsed.put("uv", "");
        		show.put("uv", "show");
        		active.put("uv", "active");
        	}else {
        		collapsed.put("Dashboard", "class=\"active" );
        	}
        }

		
		out.append("<!-- ======= Sidebar ======= -->");
		out.append("<aside id=\"sidebar\" class=\"sidebar\">");
		out.append("");
		out.append("<ul class=\"sidebar-nav\" id=\"sidebar-nav\">");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link \" href=\"index.html\">");
		out.append("<i class=\"bi bi-grid\"></i>");
		out.append("<span>Trang chủ</span>");
		out.append("</a>");
		out.append("</li><!-- End Trang chủ Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-menu-button-wide\"></i><span>Quản lí đơn hàng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"components-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"donhang\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách đơn hàng</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#forms-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-journal-text\"></i><span>Quản lí người dùng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"forms-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/Userview\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách admin</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Forms Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#tables-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-layout-text-window-reverse\"></i><span>Quản lí sản phẩm</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"tables-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminLight\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách sản phẩm</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminRating\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Đánh giá của người dùng</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Tables Nav -->");
		out.append("");
		
		out.append("");
		out.append("<li class=\"nav-heading\">Pages</li>");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"users-profile.html\">");
		out.append("<i class=\"bi bi-person\"></i>");
		out.append("<span>Hồ sơ cá nhân</span>");
		out.append("</a>");
		out.append("</li><!-- End Profile Page Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-faq.html\">");
		out.append("<i class=\"bi bi-question-circle\"></i>");
		out.append("<span>F.A.Q</span>");
		out.append("</a>");
		out.append("</li><!-- End F.A.Q Page Nav -->");
		
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-contact.html\">");
		out.append("<i class=\"bi bi-envelope\"></i>");
		out.append("<span>Liên hệ</span>");
		out.append("</a>");
		out.append("</li><!-- End Contact Page Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"/GocDecore/Adminlogin\">");
		out.append("<i class=\"bi bi-card-list\"></i>");
		out.append("<span>Đăng kí</span>");
		out.append("</a>");
		out.append("</li><!-- End Register Page Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"/GocDecore/Adminlogin\">");
		out.append("<i class=\"bi bi-box-arrow-in-right\"></i>");
		out.append("<span>Đăng nhập</span>");
		out.append("</a>");
		out.append("</li><!-- End Login Page Nav -->");
		out.append("</ul>");
		out.append("");
		out.append("</aside><!-- End Sidebar-->");
		out.append("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
