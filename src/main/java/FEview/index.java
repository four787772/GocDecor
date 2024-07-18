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

import light.LightFunction;
import light.LightFunctionImpl;
import object.LightObject;
import util.ConnectionPool;

/**
 * Servlet implementation class giaodien
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
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
		RequestDispatcher n = request.getRequestDispatcher("/navbar");
        if (n != null) {
			n.include(request, response);
		}
		out.append("<!-- ======= Hero Section ======= -->");
		out.append("<section id=\"hero\" class=\"hero d-flex align-items-center section-bg1\" style=\"background-image: url(img/anhbgl.jpg); backdrop-filter: blur(100px);\" > ");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row\">");
		out.append("<!-- <div class=\"col-lg-12 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start\"> -->");
		out.append("<div class=\"d-flex flex-column align-items-center\">");
		out.append("<h2 data-aos=\"fade-up\">Nâng tầm giá trị cho căn phòng của bạn</h2>");
		out.append("<p data-aos=\"fade-up\" data-aos-delay=\"100\">Tỉ mỉ và tinh tế trong từng chi tiết, mẫu mã vô cùng đa dạng, phong phú về kiểu dáng, uy tín về chất lượng</p>");
		out.append("<div class=\"d-flex\" data-aos=\"fade-up\" data-aos-delay=\"200\">");
		out.append("<a href=\"#book-a-table\" class=\"btn-book-a-table\">Đặt mua sản phẩm</a>");
		out.append("<a href=\"https://youtu.be/BHtpz3QB2FA\" class=\"glightbox btn-watch-video d-flex align-items-center\" style=\"border: 2px solid rgb(182, 25, 25);padding:10px; border-radius: 50px;\">");
		out.append("<i class=\"bi bi-play-circle\"></i><span>Xem Video</span></a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section><!-- End Hero Section -->");
		out.append("");
		out.append("<main id=\"main\">");
		out.append("");
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
		ArrayList<LightObject> list = lf.getLights(1);  // Gọi phương thức getLights để lấy dữ liệu

		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list);	
		for(int i = 0; i < 4; i++) {
			LightObject item = list.get(i);
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
			out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\"><img src=\"" + imgPath + "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>"+ item.getLight_name()+"</h4>");
			out.append("<p class=\"ingredients\">");
				out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
				// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				// Định dạng giá trị và thêm vào chuỗi out
				out.append(""+decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\" data-modal-id=\"product-details-1\">Chi tiết</button></a>");
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
		ArrayList<LightObject> list2 = lf.getLights(2);  // Gọi phương thức getLights để lấy dữ liệu

		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list2);
		for(int i = 0; i < 4; i++) {
			LightObject item = list2.get(i);
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
			out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\"><img src=\"" + imgPath + "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>"+ item.getLight_name()+"</h4>");
			out.append("<p class=\"ingredients\">");
				out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
				// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				// Định dạng giá trị và thêm vào chuỗi out
				out.append(""+decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\" data-modal-id=\"product-details-1\">Chi tiết</button></a>");
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
		ArrayList<LightObject> list3 = lf.getLights(3);  // Gọi phương thức getLights để lấy dữ liệu
		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list3);
		for(int i = 0; i < 4; i++) {
			LightObject item = list3.get(i);
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
			out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\"><img src=\"" + imgPath + "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>"+ item.getLight_name()+"</h4>");
			out.append("<p class=\"ingredients\">");
				out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
				// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				// Định dạng giá trị và thêm vào chuỗi out
				out.append(""+decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\" data-modal-id=\"product-details-1\">Chi tiết</button></a>");
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
		
		ArrayList<LightObject> list4 = lf.getLights(4);  // Gọi phương thức getLights để lấy dữ liệu

		// Gán danh sách vào thuộc tính request
		request.setAttribute("light", list4);
		for(int i = 0; i < 4; i++) {
			LightObject item = list4.get(i);
			out.append("<div class=\"col-lg-3 menu-item\">");
			String imgPath = "img/light_img/" + item.getLight_img() + ".jpg";
		    out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\"><img src=\"" + imgPath + "\" class=\"menu-img img-fluid\" alt=\"\"></a>");
			out.append("<h4>"+ item.getLight_name()+"</h4>");
			out.append("<p class=\"ingredients\">");
				out.append("Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc");
			out.append("</p>");
			out.append("<p class=\"price\">");
				// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				// Định dạng giá trị và thêm vào chuỗi out
				out.append(""+decimalFormat.format(item.getLight_price()));
			out.append("</p>");
			out.append("<a href=\"/GocDecore/detail?id="+item.getLight_id()+"\" class=\"card-link\"><button class=\"btn btn-detail btn-white btn-outline-danger btn-hover-white\" data-modal-id=\"product-details-1\">Chi tiết</button></a>");
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
		out.append("<p>Chương trình giảm giá đặc biệt</p>");
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
		out.append("<div class=\"swiper-pagination\"></div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section><!-- End Events Section -->");
		out.append("");

		out.append("<!-- ======= Testimonials Section ======= -->");
		out.append("<section id=\"testimonials\" class=\"testimonials section-bg\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header\">");
		out.append("<p>Phản hồi của khách hàng về <span>Góc Decor.</span></p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"slides-1 swiper\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("<div class=\"swiper-wrapper\">");
		out.append("");
		out.append("<div class=\"swiper-slide\">");
		out.append("<div class=\"testimonial-item\">");
		out.append("<div class=\"row gy-4 justify-content-center\">");
		out.append("<div class=\"col-lg-6\">");
		out.append("<div class=\"testimonial-content\">");
		out.append("<p>");
		out.append("<i class=\"bi bi-quote quote-icon-left\"></i>");
		out.append("Đợt mình làm trang trí cho quá cafe phải sử dụng đèn LED dây nhiều, ra mấy cửa hàng mua giá cũng chẳng rẻ nhưng khổ mang về dùng được vài tháng đã thấy xuống cấp kinh khủng, đoạn thì tối hẳn, đoạn thì các mắt nhỏ chết nhiều quá. May quá hỏi bạn bè được giới thiệu bên Đền Tốt, các bạn ấy tư vấn nhiệt tình, mình lấy cũng không nhiều nhưng được để giá như giá bán buôn luôn, về dùng thấy chất lượng khác hẳn, ánh sáng rất dễ chịu và bền...");
		out.append("<i class=\"bi bi-quote quote-icon-right\"></i>");
		out.append("</p>");
		out.append("<h3>Chị Linh</h3>");
		out.append("<h4>Cafe Phương Linh</h4>");
		out.append("<div class=\"stars\">");
		out.append("<i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-2 text-center col-xs-3\">");
		out.append("<img src=\"img/testimonials/testimonials-1.jpg\" class=\"img-fluid testimonial-img\" alt=\"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End testimonial item -->");
		out.append("");
		out.append("<div class=\"swiper-slide\">");
		out.append("<div class=\"testimonial-item\">");
		out.append("<div class=\"row gy-4 justify-content-center\">");
		out.append("<div class=\"col-lg-6\">");
		out.append("<div class=\"testimonial-content\">");
		out.append("<p>");
		out.append("<i class=\"bi bi-quote quote-icon-left\"></i>");
		out.append("Công ty sử dụng đèn LED dây rất nhiều trong các công trình trang trí nội thất nên rất cần chất lượng ổn định cho khách hàng để đảm bảo uy tín. Cũng đã vấp mấy công trình đầu không am hiểu nên sử dụng LED dây bên ngoài thị trường chất lượng không đảm bảo nên khách cũng phàn nàn nhiều. Từ ngày tìm được Đèn Tốt làm nhà cung cấp mọi việc được giải quyết triệt để, giá cả rất tốt và mình cũng nhận được rất nhiều phản hồi tốt từ khách hàng của công ty mình.");
		out.append("<i class=\"bi bi-quote quote-icon-right\"></i>");
		out.append("</p>");
		out.append("<h3>Chị Phương Nga</h3>");
		out.append("<h4>Công ty trang trí nội thất Hòa Bình</h4>");
		out.append("<div class=\"stars\">");
		out.append("<i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-2 text-center\">");
		out.append("<img src=\"img/testimonials/testimonials-2.jpg\" class=\"img-fluid testimonial-img\" alt=\"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End testimonial item -->");
		out.append("");
		out.append("<div class=\"swiper-slide\">");
		out.append("<div class=\"testimonial-item\">");
		out.append("<div class=\"row gy-4 justify-content-center\">");
		out.append("<div class=\"col-lg-6\">");
		out.append("<div class=\"testimonial-content\">");
		out.append("<p>");
		out.append("<i class=\"bi bi-quote quote-icon-left\"></i>");
		out.append("Thời gian trước mua LED dây loại dán 5M các cửa hàng hay bán để làm cho khách, nhưng dùng chỉ được ít ngày là đèn hay bị hư, khách lại phải vất và mang tranh ra để làm lại. Tìm kiếm mãi thì được giới thiệu đến Đèn Tốt, từ ngày dùng sản phẩm các bạn ấy cung cấp thì tỉ lệ khách phải mang tranh quay lại cửa hàng gần như không còn nữa.");
		out.append("<i class=\"bi bi-quote quote-icon-right\"></i>");
		out.append("</p>");
		out.append("<h3>Anh Tú</h3>");
		out.append("<h4>Xưởng khung tranh BORO</h4>");
		out.append("<div class=\"stars\">");
		out.append("<i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-2 text-center\">");
		out.append("<img src=\"img/testimonials/testimonials-3.jpg\" class=\"img-fluid testimonial-img\" alt=\"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End testimonial item -->");
		out.append("");
		out.append("<div class=\"swiper-slide\">");
		out.append("<div class=\"testimonial-item\">");
		out.append("<div class=\"row gy-4 justify-content-center\">");
		out.append("<div class=\"col-lg-6\">");
		out.append("<div class=\"testimonial-content\">");
		out.append("<p>");
		out.append("<i class=\"bi bi-quote quote-icon-left\"></i>");
		out.append("Được bàn giao căn hộ cuối năm ngoái, kiểm tra qua tôi phát choáng với hệ thống đèn hắt âm trần bên trong trần thạch cao nhà mình, có tới vài chục chiếc đèn tuýp chắc sơ sơ công suất cũng lên tới 600W, từ hôm về chả giám bật đèn vì ngồn điện kinh khủng. Mình qua được các bạn tư vấn chuyển qua dùng LED dây sử dụng, tình ra chi phí chẳng hết là bao, lắp đặt cũng tiện lợi nhanh chóng, các bạn ấy lắp cho luôn. ");
		out.append("<i class=\"bi bi-quote quote-icon-right\"></i>");
		out.append("</p>");
		out.append("<h3>Anh Lâm</h3>");
		out.append("<h4> Chung cư Vinaconex</h4>");
		out.append("<div class=\"stars\">");
		out.append("<i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-2 text-center\">");
		out.append("<img src=\"img/testimonials/testimonials-4.jpg\" class=\"img-fluid testimonial-img\" alt=\"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End testimonial item -->");
		out.append("");
		out.append("</div>");
		out.append("<div class=\"swiper-pagination\"></div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</section><!-- End Testimonials Section -->");
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
