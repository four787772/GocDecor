package FEview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class footercustom
 */
@WebServlet("/footercustom")
public class footercustom extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public footercustom() {
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
		out.append("<!-- ======= Footer ======= -->");
		out.append("<footer id=\"footer\" class=\"footer\">");
		out.append("");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row gy-3\">");
		out.append("<div class=\"col-lg-3 col-md-6 d-flex\">");
		out.append("<i class=\"bi bi-geo-alt icon\"></i>");
		out.append("<div>");
		out.append("<h4>Địa chỉ</h4>");
		out.append("<p>");
		out.append("Số 134, Nhổn <br>");
		out.append("Quận Nam Từ Liêm, Hà Nội<br>");
		out.append("</p>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-6 footer-links d-flex\">");
		out.append("<i class=\"bi bi-telephone icon\"></i>");
		out.append("<div>");
		out.append("<h4>Đường dây nóng</h4>");
		out.append("<p>");
		out.append("<strong>SĐT:</strong> +1 5589 55488 55<br>");
		out.append("<strong>Email:</strong> info@example.com<br>");
		out.append("</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-6 footer-links d-flex\">");
		out.append("<i class=\"bi bi-clock icon\"></i>");
		out.append("<div>");
		out.append("<h4>Giờ mở cửa</h4>");
		out.append("<p>");
		out.append("<strong>T2 - T7: </strong>9:00 - 23:00<br>");
		out.append("Chủ nhật: Đóng cửa");
		out.append("</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-6 footer-links\">");
		out.append("<h4>Liên hệ với chúng tôi qua:</h4>");
		out.append("<div class=\"social-links d-flex\">");
		out.append("<a href=\"#\" class=\"twitter\"><i class=\"bi bi-twitter\"></i></a>");
		out.append("<a href=\"#\" class=\"facebook\"><i class=\"bi bi-facebook\"></i></a>");
		out.append("<a href=\"#\" class=\"instagram\"><i class=\"bi bi-instagram\"></i></a>");
		out.append("<a href=\"#\" class=\"linkedin\"><i class=\"bi bi-linkedin\"></i></a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"container\">");
		out.append("<div class=\"copyright\">");
		out.append("&copy; Copyright <strong><span>Góc Decor.</span></strong> All Rights Reserved");
		out.append("</div>");
		out.append("<div class=\"credits\">");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</footer><!-- End Footer -->");
		out.append("<!-- End Footer -->");
		out.append("");
		out.append("<a href=\"#\" class=\"scroll-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("<div id=\"preloader\"></div>");
		out.append("");
		out.append("<!-- Vendor JS Files -->");
		out.append("<script src=\"js/bootstrap.bundle.min.js\"></script>");
		out.append("<script src=\"js/aos.js\"></script>");
		out.append("<script src=\"js/glightbox.min.js\"></script>");
		out.append("<script src=\"js/purecounter_vanilla.js\"></script>");
		out.append("<script src=\"js/swiper-bundle.min.js\"></script>");
//		out.append("<script src=\"js/validate.js\"></script>");

		out.append("");
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"js/main.js\"></script>");
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
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
