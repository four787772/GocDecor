package FEview;

import java.io.IOException;

import blog.*;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import light.LightFunction;
import light.LightFunctionImpl;
import object.*;
import util.ConnectionPool;

/**
 * Servlet implementation class blog
 */
@WebServlet("/blog")
public class blog extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public blog() {
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
		out.append("<!-- ======= Breadcrumbs ======= -->");
		out.append("<div class=\"breadcrumbs d-flex align-items-center\" style=\"background-image: url('img/thu.png');\">");
		out.append("<div class=\"container position-relative d-flex flex-column align-items-center\" data-aos=\"fade\">");
		out.append("");
		out.append("<h2>Blogs</h2>");
		out.append("<ol>");
		out.append("<li><a href=\"/GocDecore/index\">Home</a></li>");
		out.append("<li>Blogs</li>");
		out.append("</ol>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Breadcrumbs -->");
		out.append("");
		out.append("<main id=\"main\">");
		out.append("");
		out.append("");
		out.append("");
		out.append("<!-- ======= Blog Section ======= -->");
		out.append("<section id=\"blog\" class=\"blog-details spad\" data-aos=\"fade-up\">");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-4 col-md-5 order-md-1 order-2\">");
		out.append("<div class=\"hero__categories\" id=\"hero-categories1\">");
		out.append("<div class=\"hero__categories__all\">");
		out.append("<i class=\"fa fa-bars\"></i>");
		out.append("<span>Danh mục sản phẩm</span>");
		out.append("</div>");
		out.append("<ul>");
		out.append("<li><a href=\"#\">Đèn thả trần</a></li>");
		out.append("<li><a href=\"#\">Đèn chùm ban công</a></li>");
		out.append("<li><a href=\"#\">Đèn để bàn</a></li>");
		out.append("<li><a href=\"#\">Đèn sàn</a></li>");
		out.append("<li><a href=\"#\">Đèn tường</a></li>");
		out.append("<li><a href=\"#\">Đèn bàn hiện đại</a></li>");
		out.append("<li><a href=\"#\">Đèn sàn phòng khách</a></li>");
		out.append("<li><a href=\"#\">Đèn tường ngoài trời</a></li>");
		out.append("<li><a href=\"#\">Đèn bàn decor</a></li>");
		out.append("<li><a href=\"#\">Đèn tường trong phòng</a></li>");
		out.append("<li><a href=\"#\">Đèn sàn phòng ngủ</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("<div class=\"blog__sidebar__item\">");
		out.append("<h4>Từ khóa </h4>");
		out.append("<div class=\"blog__sidebar__item__tags\">");
		out.append("<a href=\"#\">Đèn thả</a>");
		out.append("<a href=\"#\">Đèn chùm</a>");
		out.append("<a href=\"#\">Đèn để bàn</a>");
		out.append("<a href=\"#\">Đèn sàn</a>");
		out.append("<a href=\"#\">Đèn tường</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-8 col-md-7 order-md-1 order-1\" >");

		// Tim bo quan ly ket noi
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tao doi tuong thuc thi chuc nang
		BlogFunction lf = new BlogFunctionImpl(cp);

		if (cp == null) {
			getServletContext().setAttribute("CPool", lf.getCP());
		}

		// Lay danh sach LightObject tu co so du lieu
		ArrayList<BlogObject> list = lf.getBlogs(); // Gọi phương thức getLights để lấy dữ liệu

		for (BlogObject item : list) {
			out.append("<div class=\"row\">");
			out.append("<div class=\"blog__item\">");
			out.append("<div class=\"row\">");
			out.append("<div class=\"col-3 blog__item__pic\">");
			out.append("<img src=\"img/blog_img/" + item.getBlog_img()
					+ ".jpg\" alt=\"Cooking tips make cooking simple\">");
			out.append("</div>");
			out.append("<div class=\"col-9 blog__item__text\">");
			out.append("<h5><a href=\"#\">" + item.getBlog_title() + "</a></h5>");
			out.append("<p>" + item.getBlog_description() + "</p>");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
		}

//		out.append("<div class=\"row\">");
//		out.append("<div class=\"blog__item\">");
//		out.append("<div class=\"row\">");
//		out.append("<div class=\"col-3 blog__item__pic\">");
//		out.append("<img src=\"img/bl02.jpg\" alt=\"Cooking tips make cooking simple\">");
//		out.append("</div>");
//		out.append("<div class=\"col-9 blog__item__text\">");
//		out.append("<h5><a href=\"#\">Tăng Thêm Nét Đẹp Cho Không Gian Sống Với Đèn Cây Trang Trí Phòng Khách</a></h5>");
//		out.append("<p>Đèn cây trang trí phòng khách như một tác phẩm nghệ thuật, góp phần tạo nên sự độc đáo và thu hút cho không gian sống. Với kiểu dáng đa dạng, từ hiện đại đến cổ điển, từ đơn giản đến cầu kỳ, đèn cây mang đến nhiều lựa chọn phù hợp với phong cách thiết kế của mỗi gia đình.</p>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("<div class=\"row\">");
//		out.append("<div class=\"blog__item\">");
//		out.append("<div class=\"row\">");
//		out.append("<div class=\"col-3 blog__item__pic\">");
//		out.append("<img src=\"img/bl03.jpg\" alt=\"Cooking tips make cooking simple\">");
//		out.append("</div>");
//		out.append("<div class=\"col-9 blog__item__text\">");
//		out.append("<h5><a href=\"#\">Tại sao nên chọn đèn thả phòng khách hiện đại?</a></h5>");
//		out.append("<p>Trong thời đại hiện nay, khi mà kiến trúc và nội thất ngày càng phát triển, đèn thả phòng khách hiện đại đã trở thành lựa chọn hàng đầu của các gia chủ. Bởi chúng không chỉ mang đến ánh sáng lý tưởng cho không gian phòng khách mà còn là điểm nhấn độc đáo, góp phần nâng tầm thẩm mỹ cho ngôi nhà.</p>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("<div class=\"row\">");
//		out.append("<div class=\"blog__item\">");
//		out.append("<div class=\"row\">");
//		out.append("<div class=\"col-3 blog__item__pic\">");
//		out.append("<img src=\"img/bl04.jpg\" alt=\"6 ways to prepare breakfast for 30\">");
//		out.append("</div>");
//		out.append("<div class=\"col-9 blog__item__text\">");
//		out.append("<h5><a href=\"#\">Cách lựa chọn đèn led thả trần phù hợp với phòng ngủ</a></h5>");
//		out.append("<p>Phong cách nội thất của phòng ngủ sẽ quyết định kiểu dáng và màu sắc của đèn thả trần. Nếu phòng ngủ theo phong cách hiện đại, bạn có thể chọn đèn có thiết kế đơn giản, gọn gàng với màu sắc trung tính. Nếu phòng ngủ theo phong cách cổ điển, bạn có thể chọn đèn có thiết kế trang trí hơn với màu sắc ấm áp.</p>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</section>");
//		out.append("<!-- Blog Details Section End -->");
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
