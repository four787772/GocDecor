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

import light.*;
import object.*;
import product.*;
import util.ConnectionPool;

/**
 * Servlet implementation class LightsView
 */
@WebServlet("/LightsView")
public class LightsView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";

	/**
	 * Default constructor.
	 */
	public LightsView() {
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
		RequestDispatcher n = request.getRequestDispatcher("/navbar");
		if (n != null) {
			n.include(request, response);
		}
		out.append("<!-- ======= Hero Section ======= -->");
		out.append(
				"<section id=\"hero\" class=\"hero d-flex align-items-center section-bg1\" style=\"background-image: url(img/pbg1.jpg); backdrop-filter: blur(100px);\" > ");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row\">");
		out.append(
				"<!-- <div class=\"col-lg-12 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start\"> -->");
		out.append("<div class=\"d-flex flex-column align-items-center\">");
		out.append("<h2 data-aos=\"fade-up\">Nâng tầm giá trị cho căn phòng của bạn</h2>");
		out.append(
				"<p data-aos=\"fade-up\" data-aos-delay=\"100\">Tỉ mỉ và tinh tế trong từng chi tiết, mẫu mã vô cùng đa dạng, phong phú về kiểu dáng, uy tín về chất lượng</p>");
		out.append("<div class=\"d-flex\" data-aos=\"fade-up\" data-aos-delay=\"200\">");
		out.append("<a href=\"#book-a-table\" class=\"btn-book-a-table\">Đặt mua ngay</a>");
		out.append(
				"<a href=\"https://youtu.be/BHtpz3QB2FA\" class=\"glightbox btn-watch-video d-flex align-items-center\" style=\"border: 2px solid rgb(182, 25, 25);padding:10px; border-radius: 50px;\">");
		out.append("<i class=\"bi bi-play-circle\"></i><span>Xem Video</span></a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section><!-- End Hero Section -->");
		out.append("");
		out.append("");
		out.append("<!-- ======= Menu Section ======= -->");
		out.append("<section id=\"menu\" class=\"menu\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header\">");
		out.append("<h2>Our Product</h2>");
		out.append("<p>Danh mục sản phẩm <span>Góc Decor.</span></p>");
		out.append("</div>");
		out.append("");
		out.append("<ul class=\"nav nav-tabs d-flex justify-content-center\" data-aos=\"fade-up\">");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link active show\" data-bs-toggle=\"tab\"  data-filter=\"*\">");
		out.append("<h4>Tất cả</h4>");
		out.append("</a>");
		out.append("</li><!-- End tab nav item -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link\" data-bs-toggle=\"tab\" data-filter=\"menu-Europe\">");
		out.append("<h4>Đèn sàn</h4>");
		out.append("</a>");
		out.append("</li><!-- End tab nav item -->");
		out.append("	  ");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link\" data-bs-toggle=\"tab\" data-filter=\"menu-leep\">");
		out.append("<h4>Đèn thả trần</h4>");
		out.append("</a>");
		out.append("</li><!-- End tab nav item -->");
		out.append("	  ");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link\" data-bs-toggle=\"tab\" data-filter=\"menu-led\">");
		out.append("<h4>Đèn để bàn</h4>");
		out.append("</a>");
		out.append("</li><!-- End tab nav item -->");
		out.append("	  ");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link\" data-bs-toggle=\"tab\" data-filter=\"menu-cluster\">");
		out.append("<h4>Đèn tường</h4>");
		out.append("</a>");
		out.append("</li><!-- End tab nav item -->");
		out.append("");
		out.append("</ul>");
		out.append("	");
		out.append("<div class=\"tab-content \" data-aos=\"fade-up\" data-aos-delay=\"300\">");
		out.append("");
		out.append("<div class=\"tab-pane fade\" id=\"menu-Europe\">");
		out.append("<div class=\"tab-header text-center\">");
		out.append("</div>");
		out.append("<div class=\"row gy-5\">");

		// Tim bo quan ly ket noi
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tao doi tuong thuc thi chuc nang
		LightFunction lf = new LightFunctionImpl(cp);

		if (cp == null) {
			getServletContext().setAttribute("CPool", lf.getCP());
		}

		// Lay danh sach LightObject tu co so du lieu
		ArrayList<LightObject> list = lf.getLights(1); // Gọi phương thức getLights để lấy dữ liệu

		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list);
		for (LightObject item : list) {
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id() + "\"><img src=\"" + imgPath
					+ "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>" + item.getLight_name() + "</h4>");
			out.append("<p class=\"ingredients\">");
			out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
			// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			// Định dạng giá trị và thêm vào chuỗi out
			out.append("" + decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id()
					+ "\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\" data-modal-id=\"product-details-1\">Chi tiết</button></a>");
			out.append("</div><!-- Menu Item -->");
		}

		out.append("</div>");
		out.append("");
		out.append("</div><!-- End Starter Menu Content -->");
		out.append("");

		out.append("<div class=\"tab-pane fade\" id=\"menu-leep\">");
		out.append("<div class=\"tab-header text-center\"> ");
		out.append("</div>");
		out.append("<div class=\"row gy-5\">");
		ArrayList<LightObject> list2 = lf.getLights(2); // Gọi phương thức getLights để lấy dữ liệu

		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list2);
		for (LightObject item : list2) {
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id() + "\"><img src=\"" + imgPath
					+ "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>" + item.getLight_name() + "</h4>");
			out.append("<p class=\"ingredients\">");
			out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
			// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			// Định dạng giá trị và thêm vào chuỗi out
			out.append("" + decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id()
					+ "\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\">Chi tiết</button></a>");
			out.append("</div><!-- Menu Item -->");
		}

		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div><!-- End leep Menu Content -->");
		out.append("");

		out.append("<div class=\"tab-pane fade\" id=\"menu-led\">");
		out.append("<div class=\"tab-header text-center\">");
		out.append("</div>");
		out.append("<div class=\"row gy-5\">");
		out.append("	");
		ArrayList<LightObject> list3 = lf.getLights(3); // Gọi phương thức getLights để lấy dữ liệu
		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list3);
		for (LightObject item : list3) {
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id() + "\"><img src=\"" + imgPath
					+ "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>" + item.getLight_name() + "</h4>");
			out.append("<p class=\"ingredients\">");
			out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
			// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			// Định dạng giá trị và thêm vào chuỗi out
			out.append("" + decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id()
					+ "\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\" data-modal-id=\"product-details-1\">Chi tiết</button></a>");
			out.append("</div><!-- Menu Item -->");
		}

		out.append("</div>");
		out.append("");
		out.append("</div><!-- End led Menu Content -->");
		out.append("");

		out.append("<div class=\"tab-pane fade active show\" id=\"menu-cluster\">");
		out.append("<div class=\"tab-header text-center \">");
		out.append("</div>");
		out.append("<div class=\"row gy-5\">");
		out.append("	");

		ArrayList<LightObject> list4 = lf.getLights(4); // Gọi phương thức getLights để lấy dữ liệu

		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list4);
		for (LightObject item : list4) {
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id() + "\"><img src=\"" + imgPath
					+ "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>" + item.getLight_name() + "</h4>");
			out.append("<p class=\"ingredients\">");
			out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
			// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			// Định dạng giá trị và thêm vào chuỗi out
			out.append("" + decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id()
					+ "\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\" data-modal-id=\"product-details-1\">Chi tiết</button></a>");
			out.append("</div><!-- Menu Item -->");
		}

		out.append("</div><!-- End Europe Menu Content -->");
		out.append("	");
		out.append("</div>");
		out.append("	");
		out.append("</div>");
		out.append("</section><!-- End Menu Section -->");
		out.append("");
		out.append("");

		out.append("<!-- ======= Events Section ======= -->");
		out.append("<section id=\"events\" class=\"events\">");
		out.append("<div class=\"container-fluid\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header\">");
		out.append("<p>Có thể bạn sẽ thích</p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"slides-3 swiper\" data-aos=\"fade-up\" data-aos-delay=\"100\">");

		LightFunction uf = new LightFunctionImpl(cp);
		ArrayList<LightObject> listEvent = uf.getAccount();

		out.append("<div class=\"swiper-wrapper\">");
		listEvent.forEach(item -> {
			if (item.getLight_percen() >= 20) { // Điều chỉnh phương thức lấy giá trị phần trăm
				out.append("<a href=\"/GocDecore/detail?id=" + item.getLight_id()
						+ "\" class=\"swiper-slide event-item d-flex flex-column justify-content-end\" >");
				out.append("<img class=\"img-event\" src=\"img/light_img/" + item.getLight_img()
						+ ".jpg\" alt=\"Background Image\">");
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				out.append("<div class=\"price align-self-start\">" + decimalFormat.format(item.getLight_price())
						+ "</div>");
				out.append("<p class=\"description\">");
				out.append("" + item.getLight_name() + "");
				out.append("</p>");
				out.append("<div class=\"discount\">Giảm đến " + item.getLight_percen() + " %</div>");
				out.append("</a><!-- End Event item -->");
			}
		});
		out.append("</div>");

		out.append("</div>");
		out.append("<div class=\"swiper-pagination\"></div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section><!-- End Events Section -->");

		out.append("");
		RequestDispatcher fc = request.getRequestDispatcher("/footercustom");
		if (fc != null) {
			fc.include(request, response);
		}
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
