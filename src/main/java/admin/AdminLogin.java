package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.UserObject;
import user.UserFunction;
import user.UserFunctionImpl;
import util.ConnectionPool;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
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

		// Tìm tham số báo lỗi nếu có
		String error = request.getParameter("err");
		String mess = "";
		if (error != null) {
			switch (error) {
			case "param":
				mess = "Tham số lấy giá trị không chính xác";
				break;
			case "value":
				mess = "Không tồn tại giá trị";
				break;
			case "notok":
				mess = "Đăng nhập không thành công";
				break;
			default:
				mess = "Không thành công";
			}
		}

		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("<title>GocDecor - Đăng nhập</title>");
		out.append("<meta content=\"\" name=\"description\">");
		out.append("<meta content=\"\" name=\"keywords\">");
		out.append("");
		out.append("<!-- Favicons -->");
		out.append("<link href=\"img/icon.png\" rel=\"icon\">");
		out.append("<link href=\"img/icon.png\" rel=\"apple-touch-icon\">");
		out.append("");
		out.append("<!-- Google Fonts -->");
		out.append("<link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">");
		out.append(
				"<link href=\"https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&family=Quicksand:wght@300..700&display=swap\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Vendor CSS Files -->");
		out.append("<link href=\"css/css-admin-product/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/boxicons.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/quill.snow.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/quill.bubble.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/remixicon.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/css-admin-product/style.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Template Main CSS File -->");
		out.append("<!-- Template Main CSS File -->");
		out.append("<link href=\"/GocDecore/css/main.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/product-details.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/GocDecore/css/dealhot.css\" rel=\"stylesheet\">");
		out.append("<style>");
		out.append("body {");
		out.append("background-image: url(\"img/hanhlogo.jpg\");");
		out.append("background-repeat: no-repeat;");
		out.append("background-position: center top;");
		out.append("background-attachment: scroll;");
		out.append("background-size: cover;");
		out.append("}");
		out.append("");
		out.append("</style>");
		out.append("</head>");
		out.append("");
		out.append("<body>");
		out.append("");
		out.append("<main>");
		out.append("<div class=\"container\">");
		out.append("");
		out.append(
				"<section class=\"section register min-vh-100 d-flex flex-column  justify-content-center align-items-center py-4 \">");
		out.append("<div class=\"container\">");
		out.append("<div class=\"row justify-content-center\">");
		out.append("<div class=\"col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center\">");
		out.append("<div class=\"card\">");
		out.append("                ");
		out.append("<div class=\"card-body\">");
		out.append("<div class=\"d-flex justify-content-center py-4\">");
		out.append("<a href=\"index.html\" class=\"logo d-flex align-items-center w-auto\">");
		out.append("<img src=\"img/header (2).png\" alt=\"\">");
		out.append("<span class=\"d-none d-lg-block\">GocDecor</span>");
		out.append("</a>");
		out.append("</div><!-- End Logo -->");
		out.append("<div>");
		out.append("<h5 class=\"card-title text-center pb-0 fs-4\">Đăng nhập vào tài khoản</h5>");
		out.append("<p class=\"text-center small\">Mời nhập tên đăng nhập và mật khẩu để vào tài khoản</p>");
		out.append("</div>");
		out.append("");
		out.append("<form class=\"row g-3 needs-validation\" novalidate action=\"\" method=\"post\">");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourUsername\" class=\"form-label\">Tên đăng nhập</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append(
				"<span class=\"input-group-text\" id=\"inputGroupPrepend\"><i class=\"bi bi-person-circle\"></i></span>");
		out.append("<input type=\"text\" name=\"username\" class=\"form-control\" id=\"yourUsername\" required>");
		out.append("<div class=\"invalid-feedback\">Xin nhập tên đăng nhập.</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourPassword\" class=\"form-label\">Mật khẩu</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append("<span class=\"input-group-text\" id=\"inputGroupPrepend\"><i class=\"bi bi-key-fill\"></i></span>");
		out.append("<input type=\"password\" name=\"password\" class=\"form-control\" id=\"yourPassword\" required>");
		out.append("<div class=\"invalid-feedback\">Xin nhập mật khẩu!</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<div class=\"form-check\">");
		out.append(
				"<input class=\"form-check-input\" type=\"checkbox\" name=\"remember\" value=\"true\" id=\"rememberMe\">");
		out.append("<label class=\"form-check-label\" for=\"rememberMe\">Luôn nhớ mật khẩu</label>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-12 d-flex justify-content-center\">");
		out.append("<button class=\"btn border border-danger rounded-pill px-4 py-2\" type=\"submit\"><i class=\"bi bi-box-arrow-in-right\"></i> Đăng nhập</button>");
		out.append("</div>");
		out.append("<div class=\"col-12\">");
		out.append(
				"<p class=\"small mb-0\">Bạn chưa có tài khoản? <a href=\"pages-register.html\">Tạo tài khoản mới</a></p>");
		out.append("</div>");
		out.append("</form>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</section>");
		out.append("");
		out.append("</div>");
		out.append("</main><!-- End #main -->");
		out.append("");
		out.append(
				"<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("<!-- Vendor JS Files -->");
		out.append("<script src=\"js/js-admin-product/apexcharts.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/bootstrap.bundle.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/chart.umd.js\"></script>");
		out.append("<script src=\"js/js-admin-product/echarts.min.js\"></script>");
		out.append("<script src=\"js/js-admin-product/quill.js\"></script>");
		out.append("<script src=\"js/js-admin-product/simple-datatables.js\"></script>");
		out.append("<script src=\"js/js-admin-product/tinymce.min.js\"></script>");
		out.append("<!-- <script src=\"js/js-admin-product/validate.js\"></script> -->");
		out.append("");
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"js/js-admin-product/main.js\"></script>");
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		if (name != null && pass != null) {
			name = name.trim();
			pass = pass.trim();

			if (!"".equalsIgnoreCase(name) && !"".equalsIgnoreCase(pass)) {
				// Tham chiếu ngữ cảnh ứng dụng
				ServletContext application = getServletConfig().getServletContext();

				// Tìm bộ quản lý kết nối
				ConnectionPool cp = (ConnectionPool) application.getAttribute("CPool");
				// Tạo đối tượng thực thi chức năng
				UserFunction uf = new UserFunctionImpl(cp);

				if (cp == null) {
					application.setAttribute("CPool", uf.getCP());
				}

				// Thực hiện đăng nhập
				UserObject user = uf.getUser(name, pass);
				// Trả về kết nối
				uf.releaseConnection();

				// Kiếm tra kết quả
				if (user != null) {
					// Tham chiếu phiên làm việc(session)
					HttpSession sision = request.getSession(true);

					// Đưa thông tin đăng nhập vào phiên
					sision.setAttribute("AdminLogined", user);

					// Chuyển sang giao diện chính
					response.sendRedirect("/GocDecore/View");

				} else {
					response.sendRedirect("/GocDecore/Adminlogin?err=notok");
				}
			} else {
				response.sendRedirect("/GocDecore/Adminlogin?err=value");
			}
		} else {
			response.sendRedirect("/GocDecore/Adminlogin?err=param");
		}
	}

}
