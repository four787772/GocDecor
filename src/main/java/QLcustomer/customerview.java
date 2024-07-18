package QLcustomer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.CustomerObject;
import util.ConnectionPool;

/**
 * Servlet implementation class customerview
 */
@WebServlet("/customerview")
public class customerview extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerview() {
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
        PrintWriter out = response.getWriter();

       // Tham chiếu Servlet header
        RequestDispatcher h = request.getRequestDispatcher("/header?pos=uv");
        if (h != null) {
        	h.include(request, response);
		}



        out.append("<main id=\"main\" class=\"main\">");
        out.append("");
        out.append("<div class=\"pagetitle\">");
        out.append("<h1>Danh sách người sử dụng</h1>");
        out.append("<nav>");
        out.append("<ol class=\"breadcrumb\">");
        out.append("<li class=\"breadcrumb-item\"><a href=\"Servlet_Web1/view\">Home</a></li>");
        out.append("<li class=\"breadcrumb-item\">Người sử dụng</li>");
        out.append("<li class=\"breadcrumb-item active\">Danh sách</li>");
        out.append("</ol>");
        out.append("</nav>");
        out.append("<div>");
		out.append("<a href=\"/GocDecore/addCustomer\">");
		out.append("<button id=\"addCustomerBtn\" class=\"btn btn-primary\"><i class=\"bi bi-folder-plus\"></i>Add Admin</button>");
		out.append("</a>");
		out.append("</div>");
        out.append("</div><!-- End Page Title -->");
        out.append("");
        out.append("<section class=\"section\">");
        out.append("<div class=\"row\">");
        out.append("");
        out.append("<div class=\"card\">");
        out.append("<div class=\"card-body\">");

     // Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		CustomerFunction uf = new CustomerFunctionImpl(cp);


		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

        // Lấy danh sách hiển thị
		ArrayList<CustomerObject> list = uf.getCustomers(null, 0,(byte) 10);

		out.append("<table class=\"table table-striped table-hover table-sm\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th scope=\"col\">Mã nhân viên</th>");
		out.append("<th scope=\"col\">Tên đăng nhập</th>");
		out.append("<th scope=\"col\">Email</th>");
		out.append("<th scope=\"col\">Mật khẩu</th>");
		out.append("<th scope=\"col\">Điện thoại</th>");
		out.append("<th scope=\"col\">Địa chỉ</th>");
		out.append("<th scope=\"col\">Ảnh</th>");
		out.append("<th scope=\"col\">Ngày vào</th>");
		out.append("<th scope=\"col\">edit</th>");
		out.append("<th scope=\"col\">del</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		list.forEach(item -> {
			out.append("<tr>");
			out.append("<th scope=\"row\">"+item.getCustomer_id()+"</th>");
			out.append("<td class=\"text-center\">"+item.getCustomer_name()+"</td>");
			out.append("<td class=\"text-center\">"+item.getCustomer_email()+"</td>");
			out.append("<td class=\"text-center\">"+item.getCustomer_pass()+"</td>");
			out.append("<td class=\"text-center\">"+item.getCustomer_phone()+"</td>");
			out.append("<td class=\"text-center\">"+item.getCustomer_address()+"</td>");
			out.append("<td class=\"text-center\">"+item.getCustomer_img()+"</td>");
			out.append("<td class=\"text-center\">"+item.getCustomer_date()+"</td>");
			out.append("<td class=\"text-center\"><a href=\"/GocDecore/editCustomer?id=" + item.getCustomer_id() + "\"><i class=\"bi bi-pencil-square\"></i></a></td>");
			out.append("<td class=\"text-center\">" + "<a href=\"/GocDecore/delCustomer?id=" + item.getCustomer_id() + "\" " +"onclick=\"return confirm('Bạn có chắc chắn muốn xóa không?');\">" + "<i class=\"bi bi-trash-fill\"></i>" +"</a>" + "</td>");
			out.append("</tr>");
		});

		out.append("</tbody>");
		out.append("</table>");
        out.append("  </main><!-- End #main -->");
        out.append("");

     // Tham chiếu Servlet footer
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
