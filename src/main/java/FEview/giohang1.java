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
import javax.servlet.http.HttpSession;

import Donhang.DonFunction;
import Donhang.DonFunctionImpl;
import object.CustomerObject;
import object.DonObject;
import util.ConnectionPool;

/**
 * Servlet implementation class giohang1
 */
@WebServlet("/giohang1")
public class giohang1 extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang1() {
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
        
     
     
		out.append("<main id=\"main\">");
		out.append("");
		out.append("");
		out.append("");
		out.append("<!-- ======= Book A Table Section ======= -->");
		 HttpSession session1 = request.getSession();
	        String message = (String) session1.getAttribute("OrderMessage");

	        if (message != null) {
	            out.println("<script>alert('" + message + "');</script>");
	            session1.removeAttribute("OrderMessage");  // Remove message after displaying
	        }

		out.append("<section id=\"book-a-table\" class=\"book-a-table\">");
		out.append("<div class=\"container\">");
        out.append("<div class=\"card\" data-aos=\"fade-up\">");
        out.append("<div class=\"card-body\">");
        out.append("<h5 class=\"card-title text-center\">Danh sách đơn hàng</h5>");
        out.append("");
        HttpSession session = request.getSession();
        CustomerObject user = (CustomerObject) session.getAttribute("CustomerLogined");
        if (user == null) {
            // Xử lý khi người dùng chưa đăng nhập
        	response.sendRedirect("loginPage.jsp"); // Chuyển hướng đến trang đăng nhập
            return;
        }
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng
		DonFunction uf = new DonFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}
        // Lấy danh sách hiển thị
		ArrayList<DonObject> list = uf.getAccount();
        out.append("<!-- Table with hoverable rows -->");
        out.append("<table class=\"table table-hover\">");
        out.append("<thead>");
        out.append("<tr>");
        out.append("<th scope=\"col\" class=\"text-center\">MaDH</th>");
        out.append("<th scope=\"col\" class=\"text-center\">Tên sản phẩm</th>");
        out.append("<th scope=\"col\" class=\"text-center\">Giá SP</th>");
        out.append("<th scope=\"col\" class=\"text-center\">Số lượng</th>");
        out.append("<th scope=\"col\" class=\"text-center\">Thành Tiền</th>");
        /*out.append("<th scope=\"col\" class=\"text-center\">Sửa</th>");*/
        out.append("<th scope=\"col\" class=\"text-center\">Xóa</th>");
        out.append("</tr>");
        out.append("</thead>");
        out.append("<tbody>");
        list.forEach(item ->{
        	if(item.getOrder_makh() == user.getCustomer_id()) {
        		out.append("<tr>");
        		DecimalFormat decimalFormat = new DecimalFormat("#,###"); 
		        out.append("<th scope=\"row\" class=\"text-center\">"+item.getOrder_id()+"</th>");
		        out.append("<td class=\"text-center\">"+item.getOrder_namesp()+"</td>");
		        out.append("<td class=\"text-center\">"+ decimalFormat.format(item.getOrder_pricesp())+"</td>");
		        out.append("<td class=\"text-center\">"+item.getOrder_number()+"</td>"); 
		        out.append("<td class=\"text-center\">"+ decimalFormat.format(item.getOrder_pricefinaly())+"</td>");
		      /*  out.append("<td class=\"text-center\"><a href=\"/GocDecore/giohang2?id=" + item.getOrder_id() + "\"><i class=\"fa-regular fa-pen-to-square\"></i></a></td>");*/
		        out.append("<td class=\"text-center\">"+ "<a href=\"/GocDecore/delcustomer?id=" + item.getOrder_id() + "\" " +"onclick=\"return confirm('Bạn có chắc chắn muốn xóa sản phẩm không?');\">" + "<i class=\"fa-solid fa-trash-can\"></i></td>");
		        out.append("</tr>");
        	}
        });
       
        out.append("</tbody>");
        out.append("</table>");
        out.append("<!-- End Table with hoverable rows -->");
        out.append("");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header mt-3\">");
		out.append("<!-- <h2>Đặt mua sản phẩm</h2> -->");
		out.append("<p>Đặt mua sản phẩm</p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row g-0\">");
		out.append("");
		out.append("<div class=\"col-lg-4 reservation-img\" style=\"background-image: url(img/DH.jpg);\" data-aos=\"zoom-out\" data-aos-delay=\"200\"></div>");
		out.append("");
		out.append("<div class=\"col-lg-8 d-flex align-items-center reservation-form-bg\">");
		out.append("<form action=\"forms/book-a-table.php\" method=\"post\" role=\"form\" class=\"php-email-form\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("<div class=\"row gy-4\">");
		out.append("<div class=\"col-lg-4 col-md-6\">");
		out.append("<input type=\"text\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"Tên khách hàng\" data-rule=\"minlen:4\" data-msg=\"Please enter at least 4 chars\">");
		out.append("<div class=\"validate\"></div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 col-md-6\">");
		out.append("<input type=\"text\" class=\"form-control\" name=\"phone\" id=\"phone\" placeholder=\"Số điện thoại\" data-rule=\"minlen:4\" data-msg=\"Please enter at least 4 chars\">");
		out.append("<div class=\"validate\"></div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 col-md-6\">");
		out.append("<input type=\"number\" class=\"form-control\" name=\"count\" id=\"count\" placeholder=\"Số lượng\" data-rule=\"minlen:1\" data-msg=\"Please enter at least 1 chars\">");
		out.append("<div class=\"validate\"></div>");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<input type=\"text\" class=\"form-control\" name=\"product\" id=\"product\" placeholder=\"Tên sản phẩm\" data-rule=\"product\" data-msg=\"Please enter a valid email\">");
		out.append("<div class=\"validate\"></div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<input type=\"address\" class=\"form-control\" name=\"address\" id=\"address\" placeholder=\"Địa chỉ\" data-rule=\"address\" data-msg=\"Please enter a valid email\">");
		out.append("<div class=\"validate\"></div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<textarea class=\"form-control\" name=\"message\" rows=\"5\" placeholder=\"Ghi chú\"></textarea>");
		out.append("<div class=\"validate\"></div>");
		out.append("</div>");
		out.append("<div class=\"mb-3\">");
		out.append("<div class=\"loading\">Loading</div>");
		out.append("<div class=\"error-message\"></div>");
		out.append("<div class=\"sent-message\">Bạn đã đặt hàng thành công. Chúng tôi sẽ gọi lại cho bạn để xác nhận đơn hàng. Xin cảm ơn!</div>");
		out.append("</div>");
		out.append("<div class=\"text-center\"><button type=\"submit\">Đặt mua</button></div>");
		out.append("</form>");
		out.append("</div><!-- End Reservation Form -->");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</section><!-- End Book A Table Section -->");
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
