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
 * Servlet implementation class contact
 */
@WebServlet("/contact")
public class contact extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact() {
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
		out.append("<!-- <section id=\"hero\" class=\"hero d-flex align-items-center section-bg1\" style=\"background-image: url(img/anhbgl.jpg); backdrop-filter: blur(100px);\" > ");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row\">");
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
		out.append("</section> -->");
		out.append("<!-- End Hero Section -->");
		out.append("");
		out.append("<main id=\"main\">");
		out.append("");
		out.append("<!-- ======= Contact Section ======= -->");
		out.append("<section id=\"contact\" class=\"contact\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header mt-3\">");
		out.append("<h2>Contact Us</h2>");
		out.append("<p>Liên hệ với chúng tôi</p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"mb-3 col-lg-12\">");
		out.append("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.3949546702947!2d105.7269721748634!3d21.056882080599483!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345456d4153617%3A0xc40efe204e622313!2zMTM0IFAuIE5o4buVbiwgWHXDom4gUGjGsMahbmcsIE5hbSBU4burIExpw6ptLCBIw6AgTuG7mWksIFZpZXRuYW0!5e0!3m2!1sen!2s!4v1713692520483!5m2!1sen!2s\" width=\"1300\" height=\"500\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\">");
		out.append("</iframe>");
		out.append("</div><!-- End Google Maps -->");
		out.append("");
		out.append("<div class=\"row gy-4\">");
		out.append("");
		out.append("<div class=\"col-md-6\">");
		out.append("<div class=\"info-item  d-flex align-items-center\">");
		out.append("<i class=\"icon bi bi-map flex-shrink-0\"></i>");
		out.append("<div>");
		out.append("<h3>Địa chỉ</h3>");
		out.append("<p>Số 134 Nhổn, Nam Từ Liêm, Hà Nội</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End Info Item -->");
		out.append("");
		out.append("<div class=\"col-md-6\">");
		out.append("<div class=\"info-item d-flex align-items-center\">");
		out.append("<i class=\"icon bi bi-envelope flex-shrink-0\"></i>");
		out.append("<div>");
		out.append("<h3>Địa chỉ email</h3>");
		out.append("<p>contact@example.com</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End Info Item -->");
		out.append("");
		out.append("<div class=\"col-md-6\">");
		out.append("<div class=\"info-item  d-flex align-items-center\">");
		out.append("<i class=\"icon bi bi-telephone flex-shrink-0\"></i>");
		out.append("<div>");
		out.append("<h3>Đường dây nóng: </h3>");
		out.append("<p>+1 5589 55488 55</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End Info Item -->");
		out.append("");
		out.append("<div class=\"col-md-6\">");
		out.append("<div class=\"info-item  d-flex align-items-center\">");
		out.append("<i class=\"icon bi bi-share flex-shrink-0\"></i>");
		out.append("<div>");
		out.append("<h3>Giờ mở cửa</h3>");
		out.append("<div><strong>T2 - T7:</strong> 9:00 - 23:00;");
		out.append("<strong>Chủ nhật</strong> : Đóng cửa");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div><!-- End Info Item -->");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("<form action=\"forms/contact.php\" method=\"post\" role=\"form\" class=\"php-email-form p-3 p-md-4\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-xl-6 form-group\">");
		out.append("<input type=\"text\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"Tên khách hàng\" required>");
		out.append("</div>");
		out.append("<div class=\"col-xl-6 form-group\">");
		out.append("<input type=\"number\" class=\"form-control\" name=\"phone\" id=\"phone\" placeholder=\"Số điện thoại\" required>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group\">");
		out.append("<input type=\"text\" class=\"form-control\" name=\"Sản phẩm\" id=\"subject\" placeholder=\" Tên sản phẩm\" required>");
		out.append("</div>");
		out.append("<div class=\"form-group\">");
		out.append("<textarea class=\"form-control\" name=\"message\" rows=\"5\" placeholder=\"Lời nhắn\" required></textarea>");
		out.append("</div>");
		out.append("<div class=\"my-3\">");
		out.append("<div class=\"loading\">Loading</div>");
		out.append("<div class=\"error-message\"></div>");
		out.append("<div class=\"sent-message\">Lời nhắn của bạn đã được gửi. Xin cảm ơn!</div>");
		out.append("</div>");
		out.append("<div class=\"text-center\"><button type=\"submit\">Gửi</button></div>");
		out.append("</form><!--End Contact Form -->");
		out.append("");
		out.append("</div>");
		out.append("</section><!-- End Contact Section -->");
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
