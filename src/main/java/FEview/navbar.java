package FEview;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Donhang.DonFunction;
import Donhang.DonFunctionImpl;
import object.CustomerObject;
import object.DonObject;
import util.ConnectionPool;

/**
 * Servlet implementation class navbar
 */
@WebServlet("/navbar")
public class navbar extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public navbar() {
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
		int count = 0;
		CustomerObject user = (CustomerObject) request.getSession().getAttribute("CustomerLogined");
    	if (user == null) {
			response.sendRedirect("/GocDecore/Customerlogin");
		} else {
		    int customerId = user.getCustomer_id(); // Lấy mã khách hàng từ đối tượng user
		    // Thêm đoạn mã JavaScript để lưu customerId vào localStorage
		    out.append("<script>");
		    out.append("localStorage.setItem('currentCustomerId', '" + customerId + "');");
		    out.append("</script>");
		    // Tiếp tục với mã xử lý đăng nhập khác của bạn
		    
		    ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			// Tạo đối tượng thực thi chức năng
			DonFunction uf = new DonFunctionImpl(cp);


			if (cp==null) {
				getServletContext().setAttribute("CPool", uf.getCP());
			}

	        // Lấy danh sách hiển thị
			ArrayList<DonObject> list = uf.getAccountFull();
			for(DonObject Item : list) {
				if(Item.getOrder_makh() == user.getCustomer_id()) {
					count += 1;
				}
			}
		    
		}
		
		
		
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("<title>Đèn trang trí decor</title>");
		out.append("<meta content=\"\" name=\"description\">");
		out.append("<meta content=\"\" name=\"keywords\">");
		out.append("");
		out.append("<!-- Favicons -->");
		out.append("<link href=\"/GocDecore/img/icon.png\" rel=\"icon\">");
		out.append("<link href=\"/GocDecore/img/icon.png\" rel=\"apple-touch-icon\">");
		out.append("");
		out.append("<!-- Google Fonts -->");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
		out.append("<link href=\"https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&family=Quicksand:wght@300..700&display=swap\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Vendor CSS Files -->");
		out.append("<link href=\"/GocDecore/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/all.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/aos.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/glightbox.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/swiper-bundle.min.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Template Main CSS File -->");
		out.append("<link href=\"/GocDecore/css/main.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/product-details.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/dealhot.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/main.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("</head>");
		out.append("<script>");
		out.append("function getQueryParam(param) {");
		out.append("    let urlParams = new URLSearchParams(window.location.search);");
		out.append("    return urlParams.get(param);");
		out.append("}");

		out.append("document.addEventListener('DOMContentLoaded', function() {");
		out.append("    if (getQueryParam('rating') === 'true') {");
		out.append("        alert('Cảm ơn sự đánh giá của bạn! Chúc bạn có một ngày tốt lành!');");
		out.append("    }");
		out.append("});");
		out.append("</script>");

		out.append("");
		out.append("<body>");
		out.append("");
		out.append("<!-- ======= Header ======= -->");
		out.append("<header id=\"header1\" class=\"header fixed-top d-flex align-items-center\">");
		out.append("<div class=\"container d-flex align-items-center justify-content-between\">");
		out.append("");
		out.append("<a href=\"/GocDecore/index\" class=\"logo d-flex align-items-center me-auto me-lg-0\">");
		out.append("<img src=\"/GocDecore/img/header (2).png\" alt=\"Logo\"><h1>Góc Decor<span>.</span></h1>");
		out.append("</a>");
		out.append("");
		out.append("<nav id=\"navbar\" class=\"navbar\">");
		out.append("<ul>");
		out.append("<li><a href=\"/GocDecore/index\" class=\"home\"><i class=\"fa-solid fa-house ihome\"></i></a></li>");
		out.append("<li><a href=\"/GocDecore/about\">Giới Thiệu</a></li>");
		out.append("<li><a href=\"/GocDecore/LightsView\">Sản phẩm</a></li>");
		out.append("<li><a href=\"/GocDecore/dealhot\">\"Deal Hot\"</a></li>");
		out.append("<li><a href=\"/GocDecore/blog\">Blog</a></li>");
		out.append("<li><a href=\"/GocDecore/contact\">Liên Hệ</a></li>");
		out.append("<li>");
		out.append("<form id=\"searchForm\" action=\"index1\" method=\"get\">");
		out.append("<div class=\"searchbar-container\">");
		out.append("<input type=\"text\" id=\"navbarSearchInput\" class=\"form-control\" name=\"query\" placeholder=\"Tìm kiếm ...\">");
		out.append("</div>");
		out.append("</form>");
		out.append("</li>");
		
		
//		out.append("<li><a href=\"/GocDecore/giohang1\" class=\"shop\"><i class=\"fa-solid fa-cart-shopping\"></i><span class=\"badge bg-success badge-number\">"+ count +"</span></a></li>");
		
		out.append("<a class=\"shop nav-item dropdown\" href=\"/GocDecore/giohang1\" >");
		out.append("<i class=\"fa-solid fa-cart-shopping\"></i>");
		out.append("<span class=\"badge bg-success badge-number\">"+count+"</span>");
		out.append("</a><!-- End Messages Icon -->");
		

		
		
		
		
		
		// Giả sử customerId được lưu trong localStorage khi người dùng đăng nhập
		// Ví dụ: localStorage.setItem('currentCustomerId', 'CUSTOMER_ID');

		out.append("<li class=\"nav-item dropdown\">");
		out.append("<a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">");
		out.append("<i class=\"fa-regular fa-comments\"></i>");

		// Đoạn mã JavaScript để hiển thị số lượng thông báo
		out.append("<script>");
		out.append("const currentCustomerId = localStorage.getItem('currentCustomerId');");
		out.append("const notifications = JSON.parse(localStorage.getItem('notifications')) || [];");

		// Lọc thông báo cho khách hàng hiện tại
		out.append("const customerNotifications = notifications.filter(notification => notification.customerId === currentCustomerId);");

		out.append("document.write('<span class=\"badge bg-success badge-number\">' + customerNotifications.length + '</span>');");
		out.append("</script>");

		out.append("</a><!-- End Messages Icon -->");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow messages\">");
		out.append("<li class=\"dropdown-header\">");
		out.append("Đăng nhập để xem <span id='notification-count'></span> thông báo");
		out.append("<a href=\"#\"><span class=\"badge rounded-pill bg-primary p-2 ms-2\">Chi tiết</span></a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<hr class=\"dropdown-divider\">");
		out.append("</li>");

		// Đoạn mã JavaScript để đọc và hiển thị thông báo từ Local Storage
		out.append("<script>");
		out.append("const notificationCountElement = document.getElementById('notification-count');");
		out.append("notificationCountElement.innerText = customerNotifications.length;");
		out.append("customerNotifications.slice().reverse().forEach((notification, index) => {");
		out.append("document.write('<li class=\"message-item\">');");
		out.append("document.write('<a href=\"#\">');");
		out.append("document.write('<img src=\"img/light_img/'+ notification.LightImg +'.jpg\" alt=\"\" class=\"rounded\">');");
		out.append("document.write('<div>');");
		out.append("document.write('<p>' + notification.message + '</p>');");
		out.append("document.write('<p>Vừa xong</p>');");
		out.append("document.write('</div>');");
		out.append("document.write('</a>');");
		out.append("document.write('</li>');");
		out.append("document.write('<li><hr class=\"dropdown-divider\"></li>');");
		out.append("});");
		out.append("</script>");

		out.append("<li class=\"dropdown-footer\">");
		out.append("<a href=\"#\">Show all messages</a>");
		out.append("</li>");
		out.append("</ul><!-- End Messages Dropdown Items -->");
		out.append("</li><!-- End Messages Nav -->");

		
		
		
		
		
		
		out.append("<li><a href=\"/GocDecore/Customerlogin\" class=\"log\"><i class=\"fa-regular fa-user\"></i></i></a></li>");
		
		out.append("</ul>");
		out.append("</nav><!-- .navbar -->");
		out.append("<i class=\"mobile-nav-toggle mobile-nav-show bi bi-list\"></i>");
		out.append("<i class=\"mobile-nav-toggle mobile-nav-hide d-none bi bi-x\"></i>");
		out.append("</div>");
		out.append("</header><!-- End Header -->");
		
		
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
