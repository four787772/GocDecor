package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.UserObject;
import util.ConnectionPool;

/**
 * Servlet implementation class Userview
 */
@SuppressWarnings("unused")
@WebServlet("/Userview")
public class Userview extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userview() {
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

       // Tham chiếu Servlet header
        RequestDispatcher h = request.getRequestDispatcher("/header?pos=uv");
        if (h != null) {
        	h.include(request, response);
		}
        
        out.append("<!-- ======= Sidebar ======= -->");
		out.append("<aside id=\"sidebar\" class=\"sidebar\">");
		out.append("");
		out.append("<ul class=\"sidebar-nav\" id=\"sidebar-nav\">");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"/GocDecore/View\">");
		out.append("<i class=\"bi bi-grid\"></i>");
		out.append("<span>Trang chủ</span>");
		out.append("</a>");
		out.append("</li><!-- End Dashboard Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#forms-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-journal-text\"></i><span>Quản lí đơn hàng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"components-nav\" class=\"nav-content collapse show \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"donhang\" >");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách đơn hàng</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link \" data-bs-target=\"#tables-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-layout-text-window-reverse\"></i><span>Quản lí người dùng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"forms-nav\" class=\"nav-content collapse show \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/Userview\" class=\"active\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách admin</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Forms Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-menu-button-wide\"></i><span>Quản lí sản phẩm</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"tables-nav\" class=\"nav-content collapse show\" data-bs-parent=\"#\">");
		out.append("");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminLight\" >");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách sản phẩm</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminRating\" class=\"\">");
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
		out.append("<a class=\"nav-link collapsed\" href=\"/GocDecore/AdminLogin\">");
		out.append("<i class=\"bi bi-box-arrow-in-right\"></i>");
		out.append("<span>Đăng xuất</span>");
		out.append("</a>");
		out.append("</li><!-- End Login Page Nav -->");
		out.append("</ul>");
		out.append("");
		out.append("</aside><!-- End Sidebar-->");



        out.append("<main id=\"main\" class=\"main\">");
        out.append("");
        out.append("<div class=\"pagetitle\">");
        out.append("<h1>Danh sách người sử dụng</h1>");
        out.append("<nav>");
        out.append("<ol class=\"breadcrumb\">");
        out.append("<li class=\"breadcrumb-item\"><a href=\"Servlet_Web1/view\">Home</a></li>");
        out.append("<li class=\"breadcrumb-item\">Người sử dụng</li>");
        out.append("<li class=\"breadcrumb-item active\">Danh sách</li>");
        out.append("</ol>");
        out.append("</nav>");
        out.append("<div>");
		out.append("<a href=\"/GocDecore/adduser\">");
		out.append("<button id=\"addUserBtn\" class=\"btn btn-primary\"><i class=\"bi bi-folder-plus\"></i>Thêm mới admin</button>");
		out.append("</a>");
		out.append("</div>");
        out.append("</div><!-- End Page Title -->");
        out.append("");
        out.append("<section class=\"section\">");
        out.append("<div class=\"row\">");
        out.append("");
        out.append("<div class=\"card\">");
        out.append("<div class=\"card-body\">");

     // Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		UserFunction uf = new UserFunctionImpl(cp);


		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

        // Lấy danh sách hiển thị
		ArrayList<UserObject> list = uf.getUsers(null, 0,(byte) 10);

		out.append("<table class=\"table table-striped table-hover table-sm\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th scope=\"col\">Mã nhân viên</th>");
		out.append("<th scope=\"col\">Tên đăng nhập</th>");
		out.append("<th scope=\"col\">Email</th>");
		out.append("<th scope=\"col\">Mật khẩu</th>");
		out.append("<th scope=\"col\">Điện thoại</th>");
		out.append("<th scope=\"col\">Địa chỉ</th>");
		out.append("<th scope=\"col\">Ảnh</th>");
		out.append("<th scope=\"col\">Ngày vào</th>");
		out.append("<th scope=\"col\">edit</th>");
		out.append("<th scope=\"col\">del</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		list.forEach(item -> {
			out.append("<tr>");
			out.append("<th scope=\"row\">"+item.getUser_id()+"</th>");
			out.append("<td class=\"text-center\">"+item.getUser_name()+"</td>");
			out.append("<td class=\"text-center\">"+item.getUser_email()+"</td>");
			out.append("<td class=\"text-center\">"+item.getUser_pass()+"</td>");
			out.append("<td class=\"text-center\">"+item.getUser_phone()+"</td>");
			out.append("<td class=\"text-center\">"+item.getUser_address()+"</td>");
			out.append("<td class=\"text-center\">"+item.getUser_img()+"</td>");
			out.append("<td class=\"text-center\">"+item.getUser_date()+"</td>");
			out.append("<td class=\"text-center\"><a href=\"/GocDecore/edituser?id=" + item.getUser_id() + "\"><i class=\"bi bi-pencil-square\"></i></a></td>");
			out.append("<td class=\"text-center\">" + "<a href=\"/GocDecore/deluser?id=" + item.getUser_id() + "\" " +"onclick=\"return confirm('Bạn có chắc chắn muốn xóa không?');\">" + "<i class=\"bi bi-trash-fill\"></i>" +"</a>" + "</td>");
			out.append("</tr>");
		});

		out.append("</tbody>");
		out.append("</table>");
        out.append("  </main><!-- End #main -->");
        out.append("");

     // Tham chiếu Servlet footer
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
		doGet(request, response);
	}

}
