package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.*;
import util.*;
import light.*;

/**
 * Servlet implementation class edit
 */
@WebServlet("/EditLightView")
public class EditLightView extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditLightView() {
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
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		LightFunction lf = new LightFunctionImpl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", lf.getCP());
		}

		int lightId = Integer.parseInt(request.getParameter("id"));
		LightObject item = lf.getLight(lightId);

		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("<title>GocDecore - Cập nhật sản Phẩm</title>");
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
		out.append("");
		out.append("");
		out.append("<!-- =======================================================");
		out.append("* Template Name: NiceAdmin");
		out.append("* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/");
		out.append("* Updated: Apr 20 2024 with Bootstrap v5.3.3");
		out.append("* Author: BootstrapMade.com");
		out.append("* License: https://bootstrapmade.com/license/");
		out.append("======================================================== -->");
		out.append("</head>");
		out.append("");
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
		out.append("<a class=\"nav-link collapsed\" href=\"index.html\">");
		out.append("<i class=\"bi bi-grid\"></i>");
		out.append("<span>Trang chủ</span>");
		out.append("</a>");
		out.append("</li><!-- End Dashboard Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-menu-button-wide\"></i><span>Chiến lược</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"components-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"components-alerts.html\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Alerts</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"components-accordion.html\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Accordion</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"components-badges.html\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Badges</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#forms-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-journal-text\"></i><span>Đối tác</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"forms-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"forms-elements.html\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Shopee</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"forms-layouts.html\">");
		out.append("<i class=\"bi bi-circle\"></i><span>TikTok</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"forms-editors.html\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Lazada</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"forms-validation.html\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Amazon</span>");
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
		out.append("<a href=\"/GocDecore/AdminLight\" class=\"active\">");
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
		out.append("</ul>");
		out.append("");
		out.append("</aside><!-- End Sidebar-->");
		out.append("");
		out.append("<main id=\"main\" class=\"main\">");
		out.append("");
		out.append("<div class=\"pagetitle\">");
		out.append("<h1>Cập nhật sản phẩm</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"index.html\">Trang quản lý</a></li>");
		out.append("<li class=\"breadcrumb-item\" style=\"text-align: center;\">Sản phẩm</li>");
		out.append("<li class=\"breadcrumb-item active\">Cập nhật</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-11 mt-5\">");
		out.append("");
		out.append("<form class=\"row g-3\" action=\"/GocDecore/EditLightView\" method=\"post\">");
		out.append("<!-- Tên sản phẩm -->");
		out.append("<div class=\"row mb-2\">");
//		    out.append("<div class=\"col-md-3\">");
//		        out.append("<label for=\"Light_id\" class=\"form-label\">ID sản phẩm</label>");
//		    out.append("</div>");
//		    out.append("<div class=\"col-md-9\">");
//		        out.append("<input type=\"number\" class=\"form-control\" id=\"Light_id\" name=\"Light_id\" placeholder=\"" + item.getLight_id() + "\">");
//		    out.append("</div>");
		out.append("<input type=\"hidden\" name=\"id\" value=\"" + item.getLight_id() + "\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Light_name\" class=\"form-label\">Tên sản phẩm</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		out.append("<input type=\"text\" class=\"form-control\" id=\"Light_name\" name=\"Light_name\" placeholder=\""
				+ item.getLight_name() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Giá -->");
		out.append("<div class=\"row mb-2\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Light_price\" class=\"form-label\">Giá</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		out.append(
				"<input type=\"number\" class=\"form-control\" id=\"Light_price\" name=\"Light_price\" placeholder=\""
						+decimalFormat.format(item.getLight_price())+ "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Chất liệu -->");
		out.append("<div class=\"row mb-2\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Light_material\" class=\"form-label\">Chất liệu</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		out.append(
				"<input type=\"text\" class=\"form-control\" id=\"Light_material\" name=\"Light_material\" placeholder=\""
						+ item.getLight_material() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Màu sắc -->");
		out.append("<div class=\"row mb-2\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Light_color\" class=\"form-label\">Màu sắc</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		out.append("<input type=\"text\" class=\"form-control\" id=\"Light_color\" name=\"Light_color\" placeholder=\""
				+ item.getLight_color() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Kích thước -->");
		out.append("<div class=\"row mb-2\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Light_size\" class=\"form-label\">Kích thước</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		out.append("<input type=\"text\" class=\"form-control\" id=\"Light_size\" name=\"Light_size\" placeholder=\""
				+ item.getLight_size() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Tình trạng -->");
		out.append("<div class=\"row mb-2\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Light_state\" class=\"form-label\">Tình trạng</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		out.append("<input type=\"text\" class=\"form-control\" id=\"Light_state\" name=\"Light_state\" placeholder=\""
				+ item.getLight_state() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Hình ảnh -->");
		out.append("<div class=\"row mb-2\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Light_img\" class=\"form-label\">Hình ảnh</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		out.append("<input type=\"text\" class=\"form-control\" id=\"Light_img\" name=\"Light_img\" placeholder=\""
				+ item.getLight_img() + "\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Mã danh mục -->");
		out.append("<div class=\"row mb-2\">");
		out.append("<div class=\"col-md-3\">");
		out.append("<label for=\"Category_id\" class=\"form-label\">Mã danh mục</label>");
		out.append("</div>");
		out.append("<div class=\"col-md-9\">");
		out.append(
				"<input type=\"number\" class=\"form-control\" id=\"Category_id\" name=\"Category_id\" placeholder=\""
						+ item.getCategory_id() + "\">");
		out.append("</div>");
		out.append("</div>");

		out.append("<!-- Nút bấm -->");
		out.append("<div class=\"text-center\">");
		out.append(
				"<button type=\"submit\" class=\"btn btn-danger me-3\" style=\"border-radius: 50px;\" >Cập nhật</button>");

		out.append(
				"<button type=\"reset\" class=\"btn btn-dark\" onclick=\"history.back()\" style=\"border-radius: 50px;\">Hủy</button>");

		out.append("</div>");
		out.append("</form>");
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		LightFunction lf = new LightFunctionImpl(cp);
		PrintWriter out = response.getWriter();
		try {
			// Lấy các thông số từ request
//		        String lightIdStr = request.getParameter("Light_id");
			String lightName = request.getParameter("Light_name");
			String lightPriceStr = request.getParameter("Light_price");
			String lightMaterial = request.getParameter("Light_material");
			String lightColor = request.getParameter("Light_color");
			String lightSize = request.getParameter("Light_size");
			String lightState = request.getParameter("Light_state");
			String lightImg = request.getParameter("Light_img");
			String categoryIdStr = request.getParameter("Category_id");

			// Chuyển đổi các tham số thành số nguyên
//		        int lightId = Integer.parseInt(lightIdStr);
			int lightPrice = Integer.parseInt(lightPriceStr);
			int categoryId = Integer.parseInt(categoryIdStr);

			// Tạo đối tượng LightObject và thiết lập các thuộc tính
			LightObject item = new LightObject();
			item.setLight_id(Integer.parseInt(request.getParameter("id")));
//		        item.setLight_id(lightId);
			item.setLight_name(lightName);
			item.setLight_price(lightPrice);
			item.setLight_material(lightMaterial);
			item.setLight_color(lightColor);
			item.setLight_size(lightSize);
			item.setLight_state(lightState);
			item.setLight_img(lightImg);
			item.setCategory_id(categoryId);

			// Gọi phương thức editLight để chỉnh sửa đối tượng
			boolean rs = lf.editLight(item);
			if (rs) {
				response.sendRedirect("/GocDecore/AdminLight?success=true"); // Điều hướng đến trang quản lý sản phẩm
																				// sau khi thêm thành công
			} else {
				response.sendRedirect("/GocDecore/AddLight"); // Điều hướng đến trang thêm sản phẩm nếu không thành công
			}

		} catch (NumberFormatException | NullPointerException e) {
			e.printStackTrace();
			out.print("loi 1");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("Loi 2");

		}

	}
}