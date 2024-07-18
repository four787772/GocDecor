package FEview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class about
 */
@WebServlet("/about")
public class about extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public about() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
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
				"<section id=\"hero\" class=\"hero d-flex align-items-center section-bg1\" style=\"background-image: url(img/anhbgl.jpg); backdrop-filter: blur(100px);\" > ");
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
		out.append("<main id=\"main\">");
		out.append("");
		out.append("<!-- ======= About Section ======= -->");
		out.append("<section id=\"about\" class=\"about\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header\">");
		out.append("<h2>About Us</h2>");
		out.append("<p>Chào mừng quý khách đến với <span>Góc Decor.</span></p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row\">");
		out.append(
				"<div class=\"col-lg-8 position-relative about-img\" style=\"background-image: url(img/A.jpg) ;\" data-aos=\"fade-up\", data-aos-delay=\"150\">");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 d-flex align-items-end\" data-aos=\"fade-up\" data-aos-delay=\"300\">");
		out.append("<div class=\"content ps-0 ps-lg-5\">");
		out.append("<p class=\"fst-italic\">");
		out.append(
				"Đèn decor là thiết bị trang trí nội thất góp phần mang đến cho không gian sống của gia đình thêm thẩm mỹ và ấn tượng, sang trọng hơn. ");
		out.append("</p>");
		out.append("<ul>");
		out.append(
				"<!--<li><i class=\"bi bi-check2-all\"></i> Trong một không gian thiết kế hiện đại, nội thất trang trí hiện đại thì việc chọn lựa một mẫu đèn chùm mang phong cách hiện đại hài hòa, phù hợp với sẽ giúp tạo nên một tổng thể hài hòa, ấn tượng.</li>-->");
		out.append(
				"<li><i class=\"bi bi-check2-all\"></i>  Với những không gian mang phong cách thiết kế cổ kính, sang trọng thì việc lựa chọn một chiếc đèn chùm phong cách cổ điển, kiểu dáng cầu kì sẽ tạo nên một sự kết hợp hoàn hảo nhất.</li>");
		out.append(
				"<li><i class=\"bi bi-check2-all\"></i> Các sản phẩm đèn chùm cao cấp được sản xuất theo dây truyền công nghệ hiện đại, chất liệu cao cấp vì vậy trong quá trình sử dụng đảm bảo an toàn tuyệt đối cho người dùng.</li>");
		out.append("</ul>");
		out.append("<p>");
		out.append(
				"Mẫu đèn decor đẹp, giá rẻ được xem là một trong những thiết bị trang trí giúp không gian ngôi nhà bạn trở nên hoàn hảo hơn về mặt giá trị thẩm mỹ. ");
		out.append("</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</section><!-- End About Section -->");
		out.append("");
		out.append("<!-- ======= Why Us Section ======= -->");
		out.append("<section id=\"why-us\" class=\"why-us section-bg\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"row gy-4\">");
		out.append("");
		out.append("<div class=\"col-lg-4\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("<div class=\"why-box\">");
		out.append("<h3>Tinh thần <span>Góc Decor.</span></h3>");
		out.append("<p>");
		out.append(
				"Chúng tôi cam kết mang đến cho Quý khách hàng những sản phẩm có chất lượng tốt nhất, hiện đại nhất bằng chính sự trân trọng, niềm tin và trách nhiệm của mình với kim chỉ nam hành động \"Kinh doanh gắn liền với Uy tín, Chất lượng\".");
		out.append("</p>");
		out.append("</div>");
		out.append("</div><!-- End Why Box -->");
		out.append("");
		out.append("<div class=\"col-lg-8 d-flex align-items-center\">");
		out.append("<div class=\"row gy-4\">");
		out.append("");
		out.append("<div class=\"col-xl-4\" data-aos=\"fade-up\" data-aos-delay=\"200\">");
		out.append("<div class=\"icon-box d-flex flex-column justify-content-center align-items-center\">");
		out.append("<i class=\"bi bi-clipboard-data\"></i>");
		out.append("<h4>Kinh nghiệm</h4>");
		out.append(
				"<p>Với kinh nghiệm được đúc kết nhiều năm trong lĩnh vực trang trí, thiết kế và thi công đèn nội ngoại thất</p>");
		out.append("</div>");
		out.append("</div><!-- End Icon Box -->");
		out.append("");
		out.append("<div class=\"col-xl-4\" data-aos=\"fade-up\" data-aos-delay=\"300\">");
		out.append("<div class=\"icon-box d-flex flex-column justify-content-center align-items-center\">");
		out.append("<i class=\"bi bi-gem\"></i>");
		out.append("<h4>Uy tín</h4>");
		out.append(
				"<p>Chúng tôi sẽ làm bạn hài lòng với sự lựa chọn của mình bằng chất lượng sản phẩm, dịch vụ, giá tốt nhất. </p>");
		out.append("</div>");
		out.append("</div><!-- End Icon Box -->");
		out.append("");
		out.append("<div class=\"col-xl-4\" data-aos=\"fade-up\" data-aos-delay=\"400\">");
		out.append("<div class=\"icon-box d-flex flex-column justify-content-center align-items-center\">");
		out.append("<i class=\"fa-solid fa-location-dot\"></i>");
		out.append("<h4>Địa chỉ mua hàng</h4>");
		out.append(
				"<p>Với sự đa dạng về địa chỉ cung cấp đèn nội, ngoại thất ở Hà Nội, quý khách có thể dễ dàng chọn lựa được mẫu đèn ưng ý nhất.</p>");
		out.append("</div>");
		out.append("</div><!-- End Icon Box -->");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section><!-- End Why Us Section -->");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
