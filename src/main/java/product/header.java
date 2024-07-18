package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class header
 */
@WebServlet("/header")
public class header extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public header() {
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
		out.append("alert('Cập nhật thành công!');"); // Sử dụng alert để hiển thị thông báo
		out.append("}");
		out.append("});");

		out.append("document.addEventListener('DOMContentLoaded', function() {");
		out.append("if (getQueryParam('success1') === 'true') {");
		out.append("alert('Thêm mới thành công!');"); // Sử dụng alert để hiển thị thông báo
		out.append("}");
		out.append("});");
		
		out.append("document.addEventListener('DOMContentLoaded', function() {");
		out.append("if (getQueryParam('success2') === 'true') {");
		out.append("alert('Đã xóa thành công!');"); // Sử dụng alert để hiển thị thông báo
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
		out.append("<span class=\"d-none d-md-block dropdown-toggle ps-2\">Hanh</span>");
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
//		RequestDispatcher m = request.getRequestDispatcher("/menu");
//        if (m != null) {
//			m.include(request, response);
//		}
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
