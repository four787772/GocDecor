package FEview;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.*;
import light.*;

import util.ConnectionPool;


/**
 * Servlet implementation class dealhot
 */
@WebServlet("/dealhot")
public class dealhot extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public dealhot() {
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
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		RequestDispatcher n = request.getRequestDispatcher("/navbar");
        if (n != null) {
			n.include(request, response);
		}
		out.append("<!-- ======= Hero Section ======= -->");
		out.append("<section id=\"hero\" data-aos=\"fade-up\" class=\"hero d-flex align-items-center section-bg1\" style=\"background-image: url(img/thu.png); backdrop-filter: blur(100px);\" > ");
		out.append("");
		out.append("</section><!-- End Hero Section -->");
		out.append("");
		out.append("<main id=\"main\">");
		out.append("<!-- Start Blog Content Here -->");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		LightFunction uf = new LightFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}
        // Lấy danh sách hiển thị
		ArrayList<LightObject> list = uf.getAccount();
		out.append("<section class=\"section-padding\" id=\"blog-page-content\" data-aos=\"fade-up\">");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row \">");
		out.append("<!-- Start Blog Content Here -->");
		out.append("<div class=\"col-md-9 col-md-push-3\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("");
		out.append("<!-- Start deal Product Here -->");
		out.append("");
		out.append("<div class=\"deal-product\">");
		out.append("<!-- Start deale Product Row -->");
		out.append("<div class=\"row deal-product-list\">");
		list.forEach(item ->{
			if(item.getLight_percen() > 1 && item.getLight_percen() < 20) {  // Điều chỉnh phương thức lấy giá trị phần trăm
		        out.append("<div class=\"col-sm-4 deal-items\">");
				out.append("<div class=\"deal-cart-box\">");
				out.append("<div class=\"product-dealhot\">"+item.getLight_percen()+" %</div>");
				out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id() + "\"> <!-- Thêm liên kết vào đây -->");
				out.append("<img class=\"product-img\" src=\"img/light_img/"+item.getLight_img()+".jpg\" alt=\"featurs product\">");
				out.append("</a>");

				out.append("<p class=\"deal-cart-box11\">"+item.getLight_name()+"</p>");
				out.append("<a class=\"teadeal-btn-legal\" >"+ decimalFormat.format(item.getLight_pricelegal()) +"</a>");
				out.append("<a class=\"teadeal-btn\" >"+ decimalFormat.format(item.getLight_price()) +" VNĐ</a>");
				out.append("<a href=\"/GocDecore/giohang2?id=" + item.getLight_id() + "\" class=\"btn border border-secondary rounded-pill px-3 py-1 mb-4\">");
				out.append("<i class=\"fa fa-cart-plus me-2\"></i> Thêm Vào Giỏ Hàng");
				out.append("</a>");
				out.append("</div>");
				out.append("</div>");
		    }
		});
		
		out.append("</div>");
		out.append("<!-- Ends deale Product Row -->");
		out.append("</div>");
		out.append("");
		out.append("<!-- Start deal Product Here -->");
		out.append("");
		out.append("");
		out.append("</div>");
		out.append("<!-- Ends Blog Content Here -->");
		out.append("");
		out.append("<!-- Start Side Bar Here -->");
		out.append("<div class=\"col-md-3 col-md-pull-9\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("<div class=\"side-bar\">");
		out.append("<!-- Start Search Box Widget -->");
		out.append("<div class=\"searchbar-container ml-auto\" data-aos=\"fade-up\">");
		out.append("<input class=\"form-control\" type=\"text\" placeholder=\"Tìm kiếm ...\">");
		out.append("<span class=\"search-icon\"><i class=\"fas fa-search\"></i></span>");
		out.append("</div>");
		out.append("<!-- Ends Search Box Widget -->");
		out.append("");
		out.append("");
		out.append("<!-- Start Range Slider Here -->");
		out.append("<div class=\"range-slider sidebar-widget\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div id=\"slider-range\"></div>");
		out.append("</div>");
		out.append("<!-- Ends Range Slider Here -->");
		out.append("");
		out.append("<!-- Start Categories Widget -->");
		out.append("<div class=\"categories-widget sidebar-widget\" data-aos=\"fade-up\">");
		out.append("<div class=\"sidebar-titel\">");
		out.append("<h4> All departments</h4>");
		out.append("</div>");
		out.append("<ul class=\"categories-item\">");
		out.append("<li><a href=\"/GocDecore/product#menu-Europe\">Đèn thả trần<span></span></a></li>");
		out.append("<li><a href=\"/GocDecore/product#menu-leep\">Đèn để bàn <span></span></a></li>");
		out.append("<li><a href=\"/GocDecore/product#menu-led\">Đèn tường <span></span></a></li>");
		out.append("<li><a href=\"/GocDecore/product#menu-cluster\">Đèn sàn <span></span></a></li>");
		out.append("<li><a href=\"/GocDecore/product#menu-leep\">Đèn bàn decor <span></span></a></li>");
		out.append("<li><a href=\"/GocDecore/product#menu-led\">Đèn tường ngoài trời <span></span></a></li>");
		out.append("<li><a href=\"/GocDecore/product#menu-cluster\">Đèn sàn phòng ngủ <span></span></a></li>");
		out.append("<li><a href=\"/GocDecore/product#menu-leep\">Đèn bàn hiện đại <span></span></a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("<!-- Ends Categories Widget -->");
		out.append("");
		out.append("<!-- Start Featurs Product Widget Here -->");
		out.append("<div class=\"recent-post-widget sidebar-widget\" data-aos=\"fade-up\">");
		out.append("<div class=\"sidebar-titel\">");
		out.append("<h4>Sản phẩm nổi bật</h4>");
		out.append("</div>");
		out.append("<ul class=\"featured-prodcut-list\">");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/detail\" style=\"display: flex; align-items: center;\">");
		out.append("<img src=\"img/img3/a1.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn thả thông tầng hình chú chim sải cánh JLD0179.");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/detail\" style=\"display: flex; align-items: center;\"> ");
		out.append("<img src=\"img/img3/a2.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn chùm pha lê thông tầng nghệ thuật ZYL9820");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/detail\" style=\"display: flex; align-items: center;\">");
		out.append("<img src=\"img/img3/a3.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn thả trần quả cầu thuỷ tinh hiện đại ZD6628.");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/detail\" style=\"display: flex; align-items: center;\">");
		out.append("<img src=\"img/img3/a4.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn thả trần hình bông sen ZD6628.");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("<!-- Ends Featurs Product Here -->");
		out.append("");
		out.append("<!-- Start Tag List widget Here -->");
		out.append("<div class=\"sidebar-widget\" data-aos=\"fade-up\">");
		out.append("<div class=\"sidebar-titel\">");
		out.append("<h4>Tag List </h4>");
		out.append("</div>");
		out.append("<ul class=\"taglist\">");
		out.append("<li><a href=\"#\">Nhẹ nhàng</a></li>");
		out.append("<li><a href=\"#\">Tinh tế</a></li>");
		out.append("<li><a href=\"#\">Tỉ mỉ</a></li>");
		out.append("<li><a href=\"#\">Chi tiết</a></li>");
		out.append("<li><a href=\"#\">Sang trọng</a></li>");
		out.append("<li><a href=\"#\">Qúy phái</a></li>");
		out.append("<li><a href=\"#\">Đẳng cấp</a></li>");
		out.append("<li><a href=\"#\">Nâng tầm</a></li>");
		out.append("");
		out.append("</ul>");
		out.append("</div>");
		out.append("<!-- Ends Tag List widget Here -->");
		out.append("</div>");
		out.append("</div>");
		out.append("<!-- Ends Side Bar Here -->");
		out.append("</div>");
		out.append("</div>");
		out.append("</section>");
		out.append("<!-- Ends Blog Content Here -->");
		out.append("");
		out.append("");
		out.append("");
		out.append("<!-- ======= Events Section ======= -->");
		out.append("<section id=\"events\" class=\"events\">");
		out.append("<div class=\"container-fluid\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header\">");
		out.append("<p>Chương trình giảm giá - ĐẶC BIỆT</p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"slides-3 swiper\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("<div class=\"swiper-wrapper\">");
		list.forEach(item ->{
			if(item.getLight_percen() >= 20) {  // Điều chỉnh phương thức lấy giá trị phần trăm
				out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id() + "\" class=\"swiper-slide event-item d-flex flex-column justify-content-end\" >");
				out.append("<img class=\"img-event\" src=\"img/light_img/"+item.getLight_img()+".jpg\" alt=\"Background Image\">");				
				out.append("<div class=\"price align-self-start\">"+ decimalFormat.format(item.getLight_price()) +"</div>");
				out.append("<p class=\"description\">");
				out.append(""+ item.getLight_name()+"");
				out.append("</p>");
				out.append("<div class=\"discount\">Giảm đến "+item.getLight_percen()+" %</div>");
				out.append("</a><!-- End Event item -->");
		    }
		});
		out.append("</div>");
		out.append("<div class=\"swiper-pagination\"></div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section><!-- End Events Section -->");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("</main><!-- End #main -->");
		out.append("");
		RequestDispatcher fc = request.getRequestDispatcher("/footercustom");
        if (fc != null) {
			fc.include(request, response);
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
