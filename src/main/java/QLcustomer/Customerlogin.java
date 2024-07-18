package QLcustomer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.CustomerObject;
import util.ConnectionPool;

/**
 * Servlet implementation class Customerlogin
 */
@WebServlet("/Customerlogin")
public class Customerlogin extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customerlogin() {
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
		out.append("<title>Đèn trang trí decor</title>");
		out.append("<meta content=\"\" name=\"description\">");
		out.append("<meta content=\"\" name=\"keywords\">");
		out.append("");
		out.append("<!-- Favicons -->");
		out.append("<link href=\"img/icon.png\" rel=\"icon\">");
		out.append("<link href=\"img/icon.png\" rel=\"apple-touch-icon\">");
		out.append("");
		out.append("<!-- Google Fonts -->");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
		out.append("<link href=\"https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&family=Quicksand:wght@300..700&display=swap\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Vendor CSS Files -->");
		out.append("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/all.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/aos.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/glightbox.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"css/swiper-bundle.min.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Template Main CSS File -->");
		out.append("<link rel=\"stylesheet\" href=\"css/login.css\">");
		out.append("");
		out.append("</head>");
		out.append("");
		out.append("<body style=\"background-image: url('img/lgUser.jpeg')\">");
		out.append("");
		out.append("<div class=\"container\">");
		out.append("");
		out.append("<div id=\"login\" class=\"container\">");
		out.append("<div class=\"row justify-content-center\">");
		out.append("<div class=\"col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center\">");
		out.append("");
		out.append("<div class=\"d-flex justify-content-center py-4\">");
		out.append("<a href=\"\" class=\"logo d-flex align-items-center w-auto\">");
		out.append("<img src=\"img/header (2).png\" alt=\"\">");
		out.append("<span class=\"d-none d-lg-block\" style=\"color: red;\">Góc Decor</span>");
		out.append("</a>");
		out.append("</div><!-- End Logo -->");
		out.append("");
		if (!"".equalsIgnoreCase(mess)) {
			out.append("<div class=\"row mb-4\"> ");
			out.append("<div class=\"col-sm-12 text-center pt-2 text-bg-danger fs-4\"> ");
			out.append(mess);
			out.append("</div> ");
			out.append("</div> ");
		}
		out.append("<div id=\"login-form\" class=\"card mb-3\">");
		out.append("");
		out.append("<div class=\"card-body\">");
		out.append("");
		out.append("<div class=\"pt-4 pb-2\">");
		out.append("<h5 class=\"card-title text-center pb-0 fs-4\">Đăng nhập để vào tài khoản</h5>");
		out.append("<p class=\"text-center small\">Xin mời nhập tên đăng nhập và mật khẩu của bạn!</p>");
		out.append("</div>");
		out.append("");
		out.append("<form class=\"row g-3 needs-validation\" method=\"post\" novalidate>");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourUsername\" class=\"form-label\">Tên đăng nhập</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append("<label class=\"input-group-text shadow-sm text-bg-primary border-primary\">");
		out.append("<i class=\"fa-solid fa-user\"></i>");
		out.append("</label>");
		out.append("<input type=\"text\" name=\"username\" class=\"form-control\" id=\"yourUsername\" required>");
		out.append("<div class=\"invalid-feedback\">Mời nhập tên đăng nhập</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourPassword\" class=\"form-label\">Mật khẩu</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append("<label class=\"input-group-text shadow-sm text-bg-primary border-primary\">");
		out.append("<i class=\"fa-solid fa-key\"></i> ");
		out.append("</label>");
		out.append("<input type=\"password\" name=\"password\" class=\"form-control\" id=\"yourPassword\" required>");
		out.append("<div class=\"invalid-feedback\">Mời nhập tên đăng nhập</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<div class=\"form-check\">");
		out.append("<input class=\"form-check-input\" type=\"checkbox\" name=\"remember\" value=\"true\" id=\"rememberMe\">");
		out.append("<label class=\"form-check-label\" for=\"rememberMe\">Luôn nhớ</label>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-12\">");
		out.append("<button class=\"btn btn-primary w-100\"  type=\"submit\">Đăng nhập</button>");
		out.append("</div>");
		out.append("<div class=\"col-12\">");
		out.append("<p class=\"small mb-0\">Bạn chưa có tài khoản? <a href=\"#\" id=\"show-register\">Tạo tài khoản mới</a></p>");
		out.append("");
		out.append("</div>");
		out.append("</form>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("<div id=\"register-form\" class=\"card mb-3\">");
		out.append("");
		out.append("<div class=\"card-body\">");
		out.append("");
		out.append("<div class=\"pt-4 pb-2\">");
		out.append("<h5 class=\"card-title text-center pb-0 fs-4\">Tạo tài khoản mới</h5>");
		out.append("<p class=\"text-center small\">Mời nhập thông tin cá nhân để tạo tài khoản</p>");
		out.append("</div>");
		out.append("");
		out.append("<form class=\"row g-3 needs-validation\" novalidate>");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourName\" class=\"form-label\">Họ và tên</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append("<label class=\"input-group-text shadow-sm text-bg-primary border-primary\">");
		out.append("<i class=\"fa-regular fa-user\"></i>");
		out.append("</label>");
		out.append("<input type=\"text\" name=\"name\" class=\"form-control\" id=\"yourName\" required>");
		out.append("<div class=\"invalid-feedback\">Mời nhập tên của bạn!</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourEmail\" class=\"form-label\">Địa chỉ Email</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append("<label class=\"input-group-text shadow-sm text-bg-primary border-primary\">");
		out.append("<i class=\"fa-regular fa-envelope\"></i>");
		out.append("</label>");
		out.append("<input type=\"email\" name=\"email\" class=\"form-control\" id=\"yourEmail\" required>");
		out.append("<div class=\"invalid-feedback\">Mời nhập địa chỉ Email!</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourUsername\" class=\"form-label\">Tên đăng nhập</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append("<label class=\"input-group-text shadow-sm text-bg-primary border-primary\">");
		out.append("<i class=\"fa-solid fa-user\"></i>");
		out.append("</label>");
		out.append("<input type=\"text\" name=\"username\" class=\"form-control\" id=\"yourUsername\" required>");
		out.append("<div class=\"invalid-feedback\">Mời nhập tên đăng nhập!</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<label for=\"yourPassword\" class=\"form-label\">Mật khẩu</label>");
		out.append("<div class=\"input-group has-validation\">");
		out.append("<label class=\"input-group-text shadow-sm text-bg-primary border-primary\">");
		out.append("<i class=\"fa-solid fa-key\"></i> ");
		out.append("</label>");
		out.append("<input type=\"password\" name=\"password\" class=\"form-control\" id=\"yourPassword\" required>");
		out.append("<div class=\"invalid-feedback\">Mời nhập mật khẩu!</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("<div class=\"col-12\">");
		out.append("<div class=\"form-check\">");
		out.append("<input class=\"form-check-input\" name=\"terms\" type=\"checkbox\" value=\"\" id=\"acceptTerms\" required>");
		out.append("<label class=\"form-check-label\" for=\"acceptTerms\">Tôi đồng ý! </label>");
		out.append("<div class=\"invalid-feedback\">Bạn nên đồng ý trước khi đăng kí tài khoản</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-12\">");
		out.append("<button class=\"btn btn-primary w-100\" type=\"submit\">Tạo tài khoản</button>");
		out.append("</div>");
		out.append("<div class=\"col-12\">");
		out.append("<p class=\"small mb-0\">Bạn đã có tài khoản? <a href=\"#\" id=\"show-login\">Đăng nhập</a></p>");
		out.append("");
		out.append("</div>");
		out.append("</form>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"js/login.js\"></script>");
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
				CustomerFunction uf = new CustomerFunctionImpl(cp);


				if (cp==null) {
					application.setAttribute("CPool", uf.getCP());
				}

				// Thực hiện đăng nhập
				CustomerObject user = uf.getCustomer(name, pass);
				//Trả về kết nối
				uf.releaseConnection();

				// Kiếm tra kết quả
				if (user != null) {
					// Tham chiếu phiên làm việc(session)
					HttpSession sision = request.getSession(true);

					// Đưa thông tin đăng nhập vào phiên
					sision.setAttribute("CustomerLogined", user);

					// Chuyển sang giao diện chính
					response.sendRedirect("/GocDecore/index");


				} else {
					response.sendRedirect("/GocDecore/Customerlogin?err=notok");
				}
			} else {
				response.sendRedirect("/GocDecore/Adminlogin?err=value");
			}
		} else {
			response.sendRedirect("/GocDecore/Adminlogin?err=param");
		}
	}


}
