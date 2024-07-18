package product;

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
import util.ConnectionPool;
import object.*;

/**
 * Servlet implementation class Deal
 */
@WebServlet("/Deal")
public class Deal extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deal() {
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

		RequestDispatcher headerDispatcher = request.getRequestDispatcher("/header");
        if (headerDispatcher != null) {
            headerDispatcher.include(request, response);
        }
		out.append("<main id=\"main\" class=\"main\">");
		out.append("");
		out.append("<div class=\"pagetitle d-flex\">");
		out.append("<div>");
		out.append("<h1>Danh mục sản phẩm Deal</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"View\">Home</a></li>");
		out.append("<li class=\"breadcrumb-item\">Tables</li>");
		out.append("<li class=\"breadcrumb-item active\">General</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div>");
		out.append("<div class=\"d-flex justify-content-between\" >");
		out.append("<a href=\"/GocDecore/add\">");
		out.append("<button id=\"addProductBtn\" class=\"btn btn-primary\"><i class=\"bi bi-folder-plus\"></i>Add product</button>");
		out.append("</a>");
		out.append("</div>");
		out.append("</div><!-- End Page Title -->");
		out.append("");
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		LightFunction uf = new LightFunctionImpl(cp);


		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

        // Lấy danh sách hiển thị
		ArrayList<LightObject> list = uf.getAccount();

		out.append("<h5 class=\"card-title\">Danh sách sản phẩm</h5>");
		out.append("");
		out.append("<!-- Table with stripped rows -->");
		out.append("<table class=\"table table-striped table-hover table-sm\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th scope=\"col\">ID</th>");
		out.append("<th scope=\"col\">Tên</th>");
		out.append("<th scope=\"col\">Giá</th>");
		out.append("<th scope=\"col\">Giá gốc</th>");
		out.append("<th scope=\"col\">% giảm</th>");
		out.append("<th scope=\"col\">Chất liệu</th>");
		out.append("<th scope=\"col\">Màu</th>");
		out.append("<th scope=\"col\">Kích thước</th>");
		out.append("<th scope=\"col\">Tình trạng</th>");
		out.append("<th scope=\"col\">Link</th>");
		out.append("<th scope=\"col\">Edit</th>");
		out.append("<th scope=\"col\">Delete</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		list.forEach(item -> {
			out.append("<tr>");
			out.append("<th scope=\"row\">"+ item.getLight_id()+"</th>");
			out.append("<td>"+ item.getLight_name()+"</td>");
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			out.append("<td class=\"text-center\">"+ decimalFormat.format(item.getLight_price()) +"</td>");
			out.append("<td class=\"text-center\">"+ decimalFormat.format(item.getLight_pricelegal()) +"</td>");
			out.append("<td class=\"text-center\">"+ item.getLight_percen()+"</td>");
			out.append("<td>"+ item.getLight_material()+"</td>");
			out.append("<td>"+ item.getLight_color()+"</td>");
			out.append("<td class=\"text-center\">"+ item.getLight_size()+"</td>");
			out.append("<td>"+ item.getLight_state()+"</td>");
			out.append("<td>"+ item.getLight_img()+"</td>");
			out.append("<td class=\"text-center\"><a href=\"/GocDecore/edit?id=" + item.getLight_id() + "\"><i class=\"bi bi-pencil-square\"></i></a></td>");
			out.append("<td class=\"text-center\">" + "<a href=\"/GocDecore/del?id=" + item.getLight_id() + "\" " +"onclick=\"return confirm('Bạn có chắc chắn muốn xóa sản phẩm không?');\">" + "<i class=\"bi bi-trash-fill\"></i>" +"</a>" + "</td>");
			out.append("</tr>");
		});

		out.append("</tbody>");
		out.append("</table>");
		out.append("<!-- End Table with stripped rows -->");
		out.append("");
		out.append("</div>	");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("</main><!-- End #main -->");

		 RequestDispatcher f = request.getRequestDispatcher("/footer");
	        if (f != null) {
				f.include(request, response);
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
