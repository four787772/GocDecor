package FEview;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import light.*;
import rating.RatingFunctionImpl;
import object.LightObject;
import object.RatingObject;
import util.ConnectionPool;

/**
 * Servlet implementation class SingleLightView
 */
@WebServlet("/SingleLightView")
public class SingleLightView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SingleLightView() {
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

		RequestDispatcher n = request.getRequestDispatcher("/navbar");
		if (n != null) {
			n.include(request, response);
		}

		out.append("");
		out.append("");
		out.append("");
		out.append("<!-- ======= Breadcrumbs ======= -->");
		out.append(
				"<div class=\"breadcrumbs d-flex align-items-center\" style=\"background-image: url('img/thu.png');\">");
		out.append(
				"<div class=\"container position-relative d-flex flex-column align-items-center\" data-aos=\"fade\">");
		out.append("");
		out.append("<h2>Product Details</h2>");
		out.append("<ol>");
		out.append("<li><a href=\"index.html\">Home</a></li>");
		out.append("<li>Product Details</li>");
		out.append("</ol>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Breadcrumbs -->");
		out.append("");
		out.append("<!-- ======= events Details Section ======= -->");
		out.append("<!-- Single Product Start -->");

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		LightFunction lf = new LightFunctionImpl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", lf.getCP());
		}
		int lightId = Integer.parseInt(request.getParameter("id"));
		LightObject item = lf.getLight(lightId);
		out.append("<div class=\"container-fluid py-5\">");
		out.append("<div class=\"container py-5\">");
		out.append("<div class=\"row g-4 mb-5\">");
		out.append("<div class=\"col-lg-8 col-xl-9\">");
		out.append("<div class=\"row g-4\">");
		out.append("<div class=\"col-lg-6\">");
		out.append("<div class=\"border rounded\">");
		out.append("<a href=\"img/light_img/" + item.getLight_img() + ".jpg\" class=\"glightbox\">");
		out.append("<img src=\"img/light_img/" + item.getLight_img()
				+ ".jpg\" class=\"img-fluid rounded\" alt=\"Image\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-6\">");
		out.append("<h4 class=\"fw-bold mb-5\" id=\"light_name_head\">" + item.getLight_name() + "</h4>");
		out.append("<div class=\"d-flex justify-content-between\">");
		out.append("<div class=\"d-flex flex-column\">");
		out.append("<strong>");
		out.append("<p>Giá:</p>");
		out.append("<p>Kích thước:</p>");
		out.append("<p>Chất liệu:</p>");
		out.append("<p>Màu sắc:</p>");
		out.append("<p>Trạng thái:</p>");
		out.append("</strong>");
		out.append("</div>");
		out.append("<div class=\"d-flex flex-column align-items-end\">");
		// Khởi tạo đối tượng DecimalFormat với mẫu định dạng "#,###.00"
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		// Định dạng giá trị và thêm vào chuỗi out
		out.append("<p>" + decimalFormat.format(item.getLight_price()) + " VND </p>");
		out.append("<p>" + item.getLight_size() + "</p>");
		out.append("<p>" + item.getLight_material() + "</p>");
		out.append("<p>" + item.getLight_color() + "</p>");
		out.append("<p>" + item.getLight_state() + "</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("<p> Miễn phí lắp đặt < 15 Km - Free vận chuyển toàn quốc></p>");
		out.append("");
		out.append("<div class=\"d-flex align-items-center justify-content-center mt-5\">");
		out.append("<div class=\"input-group quantity mb-0\" style=\"width: 100px;\">");
		out.append("<div class=\"input-group-btn\">");
		out.append("<button class=\"btn btn-sm btn-minus rounded-circle bg-light border\">");
		out.append("<i class=\"fa fa-minus\"></i>");
		out.append("</button>");
		out.append("</div>");
		out.append("<input type=\"text\" class=\"form-control form-control-sm text-center border-0 bottom-8\"");
		out.append("value=\"1\">");
		out.append("<div class=\"input-group-btn\">");
		out.append("<button class=\"btn btn-sm btn-plus rounded-circle bg-light border\">");
		out.append("<i class=\"fa fa-plus\"></i>");
		out.append("</button>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"ms-3\">");
		out.append("<a href=\"giohang?id=" + item.getLight_id()
				+ "\" class=\"btn border border-danger rounded-pill px-4 py-2\">");
		out.append("<i class=\"fa fa-cart-plus me-2\"></i> Thêm Vào Giỏ Hàng");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("");
		out.append("<div class=\"col-lg-12\">");
		out.append("                            ");
		out.append(
				"<p>Đèn trang trí là một sản phẩm mang tính đặc thù, đòi hỏi tính thẩm mỹ & độ bền cao, nhiều tính năng và trên hết là vận hành an toàn. Với kinh nghiệm trên 10 năm trong ngành, chúng tôi khuyến nghị khách hàng nên lựa chọn các đơn vị cung cấp uy tín.</p>");
		out.append("<p>ĐÈN ÁNH SÁNG cam kết giá TỐT nhất SO VỚI CHẤT LƯỢNG </p>");
		out.append(
				"<p>ĐÈN ÁNH SÁNG không đánh đổi chất lượng để nhập hàng gia công giá rẻ. Cùng 1 mẫu đèn, chúng tôi chỉ nhập loại nét nhất, bền nhất từ các nhà máy uy tín vì “CHÚNG TÔI KHÔNG MUỐN DÀNH CẢ THANH XUÂN ĐỂ ĐI BẢO HÀNH”. </p>");
		out.append("                                ");
		out.append("</div>");
		out.append("                       ");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("<div class=\"col-lg-3 col-xl-3\">");
		out.append("<div class=\"row g-4 fruite\">");
		out.append("<div class=\"mb-4 categories-widget sidebar-widget\">");
		out.append("<div class=\"sidebar-widget\" data-aos=\"fade-up\">");
		out.append("<div class=\"sidebar-titel\">");
		out.append("<h4>Danh mục sản phẩm </h4>");
		out.append("</div>");
		out.append("<ul class=\"taglist\">");
		out.append("<li>");
		out.append("<div class=\"d-flex justify-content-between fruite-name\">");
		out.append("<a class=\"btn border border-danger\" href=\"/GocDecore/LightsView#menu-leep\">Đèn thả trần</a>");
		out.append("</div>");
		out.append("</li>");
		out.append("<li>");
		out.append("<div class=\"d-flex justify-content-between fruite-name\">");
		out.append("<a class=\"btn border border-danger\" href=\"/GocDecore/LightsView#menu-led\">Đèn để bàn</a>");
		out.append("</div>");
		out.append("</li>");
		out.append("<li>");
		out.append("<div class=\"d-flex justify-content-between fruite-name\">");
		out.append("<a class=\"btn border border-danger\" href=\"/GocDecore/LightsView#menu-cluster\">Đèn tường</a>");
		out.append("</div>");
		out.append("</li>");
		out.append("<li>");
		out.append("<div class=\"d-fleSx justify-content-between fruite-name\">");
		out.append("<a class=\"btn border border-danger\" href=\"/GocDecore/LightsView#menu-Europe\">Đèn sàn</a>");
		out.append("</div>");
		out.append("</li>");
		out.append("                                    ");
		out.append("</ul>");
		out.append("</div>");
		out.append("                            ");
		out.append("</div>");
		out.append("<div class=\"recent-post-widget sidebar-widget\" data-aos=\"fade-up\">");
		out.append("<div class=\"sidebar-title\">");
		out.append("<h4>Ưu đãi hot</h4>");
		out.append("</div>");
		out.append("<ul class=\"featured-prodcut-list\">");
		out.append("<li>");
		out.append("<a href=\"dealhot\" class=\"\" style=\"display: flex; align-items: center;\">");
		out.append(
				"<img src=\"img/img3/a1.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn thả thông tầng hình chú chim sải cánh JLD0179.");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"dealhot\" style=\"display: flex; align-items: center;\"> ");
		out.append(
				"<img src=\"img/img3/a2.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn chùm pha lê thông tầng nghệ thuật ZYL9820");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"dealhot\" style=\"display: flex; align-items: center;\">");
		out.append(
				"<img src=\"img/img3/a3.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn thả trần quả cầu thuỷ tinh hiện đại ZD6628.");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"dealhot\" style=\"display: flex; align-items: center;\">");
		out.append(
				"<img src=\"img/img3/a4.jpg\" alt=\"Featured Product\" style=\"width: 50px; height: 50px; margin-right: 1rem;\">");
		out.append("<p>");
		out.append("Đèn thả trần hình bông sen ZD6628.");
		out.append("</p>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("<!-- Ends Featurs Product Here -->");
		out.append("");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("");
		out.append("</div>");
		out.append("              ");
		out.append("                ");
		out.append("");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<!-- ======= Contact Section ======= -->");
		out.append("<section id=\"contact\" class=\"contact\">");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header\">");
		out.append("<h2>Contact Us</h2>");
		out.append("<p class=\"fw-bold\">Đánh giá sản phẩm</p>");
		out.append("</div>");
		out.append("");

		out.append("<form action=\"/GocDecore/SingleLightView?id=" + item.getLight_id()
				+ "\" method=\"post\" role=\"form\" class=\"php-email-form p-3 p-md-4\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-xl-6 form-group\">");
		out.append(
				"<input type=\"text\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"Tên khách hàng\" required>");
		out.append("</div>");
		out.append("<div class=\"col-xl-6 form-group\">");
		out.append(
				"<input type=\"number\" class=\"form-control\" name=\"phone\" id=\"phone\" placeholder=\"Số điện thoại\" required>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group\">");
		out.append("<input type=\"text\" class=\"form-control\" name=\"subject\" id=\"subject\" value=\"Sản phẩm: "
				+ item.getLight_name() + "\" readonly required>");
		out.append("</div>");
		out.append("<div class=\"form-group\">");
		out.append(
				"<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"5\" placeholder=\"Đánh giá\" required></textarea>");
		out.append("</div>");
		out.append("<div class=\"form-group d-flex\">");
		out.append("<label for=\"rating\" class=\"me-1 ms-3\">Điểm đánh giá: </label>");
		out.append("<div id=\"star-rating\">");
		out.append("<span class=\"star\" data-value=\"1\"> <i class=\"bi bi-star-fill\"></i></span>");
		out.append("<span class=\"star\" data-value=\"2\"> <i class=\"bi bi-star-fill\"></i></span>");
		out.append("<span class=\"star\" data-value=\"3\"> <i class=\"bi bi-star-fill\"></i></span>");
		out.append("<span class=\"star\" data-value=\"4\"> <i class=\"bi bi-star-fill\"></i></span>");
		out.append("<span class=\"star\" data-value=\"5\"> <i class=\"bi bi-star-fill\"></i></span>");
		out.append("</div>");
		out.append("</div>");
//		Biến ẩn lưu giá trị sao
		out.append("<input type=\"hidden\" id=\"rating_id\" name=\"rating_id\" required>");
		int userId = (int) (Math.random() * 1000000);
		out.append("<input type=\"hidden\" id=\"user_id\" name=\"user_id\" value=\"" + userId + "\" required>");
		out.append("<input type=\"hidden\" id=\"light_id\" name=\"light_id\" value=\"" + item.getLight_id()
				+ "\" required>");
		out.append("<div class=\"text-center\"><button type=\"submit\">Gửi</button></div>");

		out.append("</form>");

		out.append("");
		out.append("</div>");
		out.append("</section><!-- End Contact Section -->");

		out.append("</div>");
		out.append("</main><!-- End #main -->");
		out.append("");
		RequestDispatcher fc = request.getRequestDispatcher("/footercustom");
		if (fc != null) {
			fc.include(request, response);
		}
		// Add the JavaScript to handle star rating
		out.append("<script>");
		out.append("const stars = document.querySelectorAll('.star');");
		out.append("const ratingInput = document.getElementById('rating_id');");

		out.append("stars.forEach(star => {");
		out.append("    star.addEventListener('mouseover', () => {");
		out.append("        highlightStars(star.getAttribute('data-value'));");
		out.append("    });");
		out.append("    star.addEventListener('mouseout', () => {");
		out.append("        resetStars();");
		out.append("        highlightStars(ratingInput.value);");
		out.append("    });");
		out.append("    star.addEventListener('click', () => {");
		out.append("        ratingInput.value = star.getAttribute('data-value');");
		out.append("        highlightStars(ratingInput.value);");
		out.append("    });");
		out.append("});");

		out.append("function highlightStars(ratingValue) {");
		out.append("    stars.forEach(star => {");
		out.append("        if (star.getAttribute('data-value') <= ratingValue) {");
		out.append("            star.classList.add('hover');");
		out.append("        } else {");
		out.append("            star.classList.remove('hover');");
		out.append("        }");
		out.append("    });");
		out.append("}");

		out.append("function resetStars() {");
		out.append("    stars.forEach(star => {");
		out.append("        star.classList.remove('hover');");
		out.append("    });");
		out.append("}");
		out.append("</script>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập mã hóa UTF-8 cho request và response
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int Light_id = Integer.parseInt(request.getParameter("light_id"));
		// Lấy ConnectionPool từ ServletContext
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		RatingFunctionImpl lf = new RatingFunctionImpl(cp);

		try {
			// Lấy các thông số từ request
//            int rating_id = Integer.parseInt(request.getParameter("rating_id"));
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String user_name = request.getParameter("name");
			int user_phone = Integer.parseInt(request.getParameter("phone"));
			int vote = Integer.parseInt(request.getParameter("rating_id"));
			String rating_desString = request.getParameter("message");
			out.println("hello");

			// Tạo đối tượng LightObject và thiết lập các thuộc tính
			RatingObject item = new RatingObject();
			item.setUser_id(user_id);
			item.setLight_id(Light_id);
			item.setUser_name(user_name);
			item.setUser_phone(user_phone);
			item.setVote(vote);
			item.setRating_description(rating_desString);

			// Gọi phương thức addLight để thêm đối tượng mới
			boolean rs = lf.addRating(item);
			System.out.println(rs);
			out.println(rs);

			if (rs) {
				// response.sendRedirect("/GocDecore/LightsView?success=true"); // Sửa lỗi dấu
				// hỏi
				response.sendRedirect("/GocDecore/SingleLightView?id=" + Light_id + "&rating=true");
			} else {
				response.sendRedirect("/GocDecore/AddLight"); // Điều hướng đến trang thêm sản phẩm nếu không thành công
			}

		} catch (NumberFormatException | NullPointerException e) {
			e.printStackTrace();
			response.sendRedirect("/GocDecore/about");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/GocDecore/AdminLight"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
		}

	}

}
