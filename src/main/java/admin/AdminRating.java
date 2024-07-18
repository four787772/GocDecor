package admin;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import light.*;
import object.LightObject;
import object.RatingObject;
import rating.RatingFunctionImpl;
import util.ConnectionPool;

/**
 * Servlet implementation class AdminLight
 */
@WebServlet("/AdminRating")
public class AdminRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRating() {
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
		response.setContentType(CONTENT_TYPE);
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("<title>GocDecore - Sản Phẩm</title>");
		out.append("<meta content=\"\" name=\"description\">");
		out.append("<meta content=\"\" name=\"keywords\">");
		out.append("");
		out.append("<!-- Favicons -->");
		out.append("<link href=\"img/icon.png\" rel=\"icon\">");
		out.append("<link href=\"img/apple-touch-icon.png\" rel=\"apple-touch-icon\">");
		out.append("");
		out.append("<!-- Google Fonts -->");
		out.append("<link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">");
		out.append(
				"<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Vendor CSS Files -->");
		out.append("<link href=\"css/css-admin-product/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/boxicons.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/quill.snow.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/quill.bubble.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/remixicon.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/style_table.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Template Main CSS File -->");
		out.append("<link href=\"css/css-admin-product/style.css\" rel=\"stylesheet\">");
		out.append("</head>");
		out.append("");

		out.append("<script>");
		out.append("function getQueryParam(param) {");
		out.append("let urlParams = new URLSearchParams(window.location.search);");
		out.append("return urlParams.get(param);");
		out.append("}");

		out.append("document.addEventListener('DOMContentLoaded', function() {");
		out.append("if (getQueryParam('success') === 'true') {");
		out.append("alert('Cập nhật sản phẩm thành công!');"); // Sử dụng alert để hiển thị thông báo
		out.append("}");
		out.append("});");

		out.append("document.addEventListener('DOMContentLoaded', function() {");
		out.append("if (getQueryParam('success1') === 'true') {");
		out.append("alert('Thêm mới sản phẩm thành công!');"); // Sử dụng alert để hiển thị thông báo
		out.append("}");
		out.append("});");
		out.append("</script>");

		out.append("<body>");
		out.append("");
		out.append("<!-- ======= Header ======= -->");
		out.append("<header id=\"header\" class=\"header fixed-top d-flex align-items-center\">");
		out.append("");
		out.append("<div class=\"d-flex align-items-center justify-content-between\">");
		out.append("<a href=\"index.html\" class=\"logo d-flex align-items-center\">");
		out.append("<img src=\"img/header (2).png\" alt=\"\">");
		out.append("<span class=\"d-none d-lg-block\">Góc Decore.</span>");
		out.append("</a>");
		out.append("<i class=\"bi bi-list toggle-sidebar-btn\"></i>");
		out.append("</div><!-- End Logo -->");
		out.append("");
		out.append("<div class=\"search-bar\" >");
		out.append(
				"<form class=\"search-form d-flex align-items-center\"style=\"border-radius: 50px;\" method=\"POST\" action=\"#\">");
		out.append("<input type=\"text\" name=\"query\" placeholder=\"Tìm kiếm\" title=\"Enter search keyword\">");
		out.append("<button type=\"submit\" title=\"Search\"><i class=\"bi bi-search\"></i></button>");
		out.append("</form>");
		out.append("</div><!-- End Search Bar -->");
		out.append("");
		out.append("<nav class=\"header-nav ms-auto\">");
		out.append("<ul class=\"d-flex align-items-center\">");
		out.append("");
		out.append("<li class=\"nav-item d-block d-lg-none\">");
		out.append("<a class=\"nav-link nav-icon search-bar-toggle \" href=\"#\">");
		out.append("<i class=\"bi bi-search\"></i>");
		out.append("</a>");
		out.append("</li><!-- End Search Icon-->");
		out.append("");
		out.append("<li class=\"nav-item dropdown\">");
		out.append("");
		out.append("<a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">");
		out.append("<i class=\"bi bi-bell\"></i>");
		out.append("<span class=\"badge bg-danger badge-number\">2</span>");
		out.append("</a><!-- End Notification Icon -->");
		out.append("");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications\">");
		out.append("<li class=\"dropdown-header\">");
		out.append("Bạn có 2 thông báo mới");
		out.append("<a href=\"#\"><span class=\"badge rounded-pill bg-primary p-2 ms-2\">Xem chi tiết</span></a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li class=\"notification-item\">");
		out.append("<i class=\"bi bi-exclamation-circle text-warning\"></i>");
		out.append("<div>");
		out.append("<h4>Lorem Ipsum</h4>");
		out.append("<p>Quae dolorem earum veritatis oditseno</p>");
		out.append("<p>30 min. ago</p>");
		out.append("</div>");
		out.append("</li>");
		out.append("");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li class=\"notification-item\">");
		out.append("<i class=\"bi bi-x-circle text-danger\"></i>");
		out.append("<div>");
		out.append("<h4>Atque rerum nesciunt</h4>");
		out.append("<p>Quae dolorem earum veritatis oditseno</p>");
		out.append("<p>1 hr. ago</p>");
		out.append("</div>");
		out.append("</li>");
		out.append("");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("<li class=\"dropdown-footer\">");
		out.append("<a href=\"#\">Xem chi tiết thêm</a>");
		out.append("</li>");
		out.append("");
		out.append("</ul><!-- End Notification Dropdown Items -->");
		out.append("");
		out.append("</li><!-- End Notification Nav -->");
		out.append("");
		out.append("<li class=\"nav-item dropdown\">");
		out.append("");
		out.append("<a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">");
		out.append("<i class=\"bi bi-chat-left-text\"></i>");
		out.append("<span class=\"badge bg-success badge-number\">3</span>");
		out.append("</a><!-- End Messages Icon -->");
		out.append("");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow messages\">");
		out.append("<li class=\"dropdown-header\">");
		out.append("Bạn có 3 tin nhắn mới");
		out.append("<a href=\"#\"><span class=\"badge rounded-pill bg-primary p-2 ms-2\">Xem chi tiết</span></a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li class=\"message-item\">");
		out.append("<a href=\"#\">");
		out.append("<img src=\"img/messages-1.jpg\" alt=\"\" class=\"rounded-circle\">");
		out.append("<div>");
		out.append("<h4>Maria Hudson</h4>");
		out.append("<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>");
		out.append("<p>4 hrs. ago</p>");
		out.append("</div>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li class=\"message-item\">");
		out.append("<a href=\"#\">");
		out.append("<img src=\"img/messages-2.jpg\" alt=\"\" class=\"rounded-circle\">");
		out.append("<div>");
		out.append("<h4>Anna Nelson</h4>");
		out.append("<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>");
		out.append("<p>6 hrs. ago</p>");
		out.append("</div>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li class=\"message-item\">");
		out.append("<a href=\"#\">");
		out.append("<img src=\"img/messages-3.jpg\" alt=\"\" class=\"rounded-circle\">");
		out.append("<div>");
		out.append("<h4>David Muldon</h4>");
		out.append("<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>");
		out.append("<p>8 hrs. ago</p>");
		out.append("</div>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li class=\"dropdown-footer\">");
		out.append("<a href=\"#\">Xem chi tiết thêm</a>");
		out.append("</li>");
		out.append("");
		out.append("</ul><!-- End Messages Dropdown Items -->");
		out.append("");
		out.append("</li><!-- End Messages Nav -->");
		out.append("");
		out.append("<li class=\"nav-item dropdown pe-3\">");
		out.append("");
		out.append(
				"<a class=\"nav-link nav-profile d-flex align-items-center pe-0\" href=\"#\" data-bs-toggle=\"dropdown\">");
		out.append("<img src=\"img/profile-img.jpg\" alt=\"Profile\" class=\"rounded-circle\">");
		out.append("<span class=\"d-none d-md-block dropdown-toggle ps-2\">Four</span>");
		out.append("</a><!-- End Profile Iamge Icon -->");
		out.append("");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow profile\">");
		out.append("<li class=\"dropdown-header\">");
		out.append("<h6>Nguyễn Mỹ Hạnh</h6>");
		out.append("<span>Web Designer</span>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li>");
		out.append("<a class=\"dropdown-item d-flex align-items-center\" href=\"users-profile.html\">");
		out.append("<i class=\"bi bi-person\"></i>");
		out.append("<span>My Profile</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li>");
		out.append("<a class=\"dropdown-item d-flex align-items-center\" href=\"users-profile.html\">");
		out.append("<i class=\"bi bi-gear\"></i>");
		out.append("<span>Quản lý tài khoản</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li>");
		out.append("<a class=\"dropdown-item d-flex align-items-center\" href=\"pages-faq.html\">");
		out.append("<i class=\"bi bi-question-circle\"></i>");
		out.append("<span>Hỗ trợ</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");
		out.append("");
		out.append("<li>");
		out.append("<a class=\"dropdown-item d-flex align-items-center\" href=\"#\">");
		out.append("<i class=\"bi bi-box-arrow-right\"></i>");
		out.append("<span>Đăng xuất</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("");
		out.append("</ul><!-- End Profile Dropdown Items -->");
		out.append("</li><!-- End Profile Nav -->");
		out.append("");
		out.append("</ul>");
		out.append("</nav><!-- End Icons Navigation -->");
		out.append("");
		out.append("</header><!-- End Header -->");
		out.append("");
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
				"<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-menu-button-wide\"></i><span>Quản lí đơn hàng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"components-nav\" class=\"nav-content collapse show \" data-bs-parent=\"#sidebar-nav\">");
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
		out.append("<ul id=\"forms-nav\" class=\"nav-content collapse show \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/Userview\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách admin</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Forms Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link \" data-bs-target=\"#tables-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-layout-text-window-reverse\"></i><span>Sản Phẩm</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"tables-nav\" class=\"nav-content collapse show\" data-bs-parent=\"#\">");
		out.append("");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminLight\" class=\"\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách sản phẩm</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminRating\" class=\"active\">");
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
		out.append("");
		out.append("<main id=\"main\" class=\"main\">");
		out.append("");
		out.append("<div class=\"pagetitle\">");
		out.append("<h1>Đánh giá của người dùng</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"AdminDashboard\">Trang chủ</a></li>");
		out.append("<li class=\"breadcrumb-item\">Sản Phẩm</li>");
		out.append("<li class=\"breadcrumb-item active\">Đánh giá của người dùng</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");
		out.append("");
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12\">");
		out.append("");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		out.append(
				"<h5 class=\"card-title\" style=\"text-align: center;\"><strong>ĐÁNH GIÁ CỦA NGƯỜI DÙNG</strong></h5>");
		out.append("");
//		out.append("<div class=\"row col-lg-3\">");
//		out.append("<a href=\"/GocDecore/AddLightView\"><button class=\"btn border border-danger d-flex justify-content-center mb-2\">Thêm mới sản phẩm</button></a>");
//		out.append("</div>");
		out.append("<!-- Table with stripped rows -->");
		out.append("<table class=\"table datatable table-striped\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<!-- <th>");
		out.append("<b>N</b>ame");
		out.append("</th>");
		out.append("<th>Ext.</th>");
		out.append("<th>City</th>");
		out.append("<th data-type=\"date\" data-format=\"YYYY/DD/MM\">Start Date</th>");
		out.append("<th>Completion</th> -->");
		out.append("<th class=\"tableID\">ID đánh giá</th>");
		out.append("<th>ID người dùng</th>");
		out.append("<th>ID sản phẩm</th>");
		out.append("<th>Tên người dùng</th>");
		out.append("<th>SĐT</th>");
		out.append("<th>Điểm đánh giá</th>");
		out.append("<th>Đánh giá</th>");
//			out.append("<th>Hình ảnh</th>");
//			out.append("<th>Phân loại</th>");
//			out.append("<th>Phản hồi</th>");
//			out.append("<th>Xóa</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");

		// Tim bo quan ly ket noi
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tao doi tuong thuc thi chuc nang
		RatingFunctionImpl lf = new RatingFunctionImpl(cp);

		if (cp == null) {
			getServletContext().setAttribute("CPool", lf.getCP());
		}

		// Lay danh sach LightObject tu co so du lieu
		ArrayList<RatingObject> list = lf.getRatings(); // Gọi phương thức getLights để lấy dữ liệu

		// Gán Danh sách sản phẩm vào thuộc tính request
		request.setAttribute("rating", list);

		// Lấy Danh sách sản phẩm từ thuộc tính request
		ArrayList<RatingObject> lightList = (ArrayList<RatingObject>) request.getAttribute("rating");

		// Kiểm tra Danh sách sản phẩm không null và không rỗng trước khi duyệt qua
		if (lightList != null && !lightList.isEmpty()) {
			for (RatingObject item : list) {
				out.append("<tr>");
				out.append("<td>" + item.getRating_id() + "</td>");
				out.append("<td>" + item.getUser_id() + "</td>");
				out.append("<td>" + item.getLight_id() + "</td>");
				out.append("<td>" + item.getUser_name() + "</td>");
				out.append("<td>" + item.getUser_phone() + "</td>");
				out.append("<td>" + item.getVote() + "</td>");
				out.append("<td>" + item.getRating_description() + "</td>");
				out.append("<td><a href=\"/GocDecore/EditLightView?id=" + item.getRating_id()
						+ "\"><i class=\"bi bi-send-plus-fill\"></i></a></td>");
////				out.append("<td><a href=\"/GocDecore/DelLightView?id="+ item.getLight_id()+ "\"><i class=\"bi bi-trash\"></i></a></td>");
//				out.append("<td><a href=\"/GocDecore/DelLightView?id=" + item.getLight_id() + "\" onclick='return confirm(\"Bạn có chắc chắn muốn xóa sản phẩm này?\")'><i class='bi bi-trash'></i></a></td>");
				out.append("</tr>");
			}
		} else {
			out.append("<tr><td colspan='11'>Không có dữ liệu</td></tr>");
		}

		out.append("</tbody>");
		out.append("</table>");
		out.append("<!-- End Table with stripped rows -->");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("</main><!-- End #main -->");
		out.append("");
		out.append(
				"<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("<!-- Vendor JS Files -->");
		out.append("<script src=\"js/js-admin-product/apexcharts.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/bootstrap.bundle.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/chart.umd.js\"></script>");
		out.append("<script src=\"js/js-admin-product/echarts.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/quill.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/simple-datatables.js\"></script>");
		out.append("<script src=\"js/js-admin-product/tinymce.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/validate.js\"></script>");
		out.append("");
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"js/js-admin-product/main.js\"></script>");
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
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
