package FEview;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Donhang.DonFunction;
import Donhang.DonFunctionImpl;
import light.LightFunction;
import light.LightFunctionImpl;

import object.DonObject;
import object.LightObject;
import util.ConnectionPool;

/**
 * Servlet implementation class giohang
 */
@WebServlet("/giohang")
public class giohang extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang() {
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
		out.append("<section id=\"book-a-table\" class=\"book-a-table\">");
		out.append("<div class=\"container\">");
		out.append("<div class=\"card\" data-aos=\"fade-up\">");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title text-center\">Danh sách đơn hàng</h5>");
		out.append("");
		out.append("<!-- Table with hoverable rows -->");
		out.append("<table class=\"table table-hover\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th scope=\"col\" class=\"text-center\">MaDH</th>");
		out.append("<th scope=\"col\" class=\"text-center\">Tên sản phẩm</th>");
		out.append("<th scope=\"col\" class=\"text-center\">Giá</th>");
		out.append("<th scope=\"col\" class=\"text-center\">Sửa</th>");
		out.append("<th scope=\"col\" class=\"text-center\">Xóa</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<th scope=\"row\" class=\"text-center\">1</th>");
		out.append("<td class=\"text-center\">Brandon Jacob</td>");
		out.append("<td class=\"text-center\">Designer</td>");
		out.append("<td class=\"text-center\"><i class=\"fa-regular fa-pen-to-square\"></i></td>");
		out.append("<td class=\"text-center\"><i class=\"fa-solid fa-trash-can\"></i></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("<!-- End Table with hoverable rows -->");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("<div class=\"section-header mt-3\">");
		out.append("<!-- <h2>Đặt mua sản phẩm</h2> -->");
		out.append("<p>Đặt mua sản phẩm</p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row g-0\">");
		out.append("");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		LightFunction uf = new LightFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}
		
		int lightId = Integer.parseInt(request.getParameter("id"));
		LightObject item = uf.getLight(lightId);
		out.append("<div class=\"col-lg-4 reservation-img\" data-aos=\"zoom-out\" data-aos-delay=\"200\">");
		out.append("<img src=\"img/light_img/"+item.getLight_img()+".jpg\" alt=\"Reservation Image\">");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-7 d-flex align-items-center reservation-form-bg\">");
		out.append("<form action=\"/GocDecore/giohang\" method=\"post\"  class=\"php-email-form\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("<div class=\"row gy-4\">");
		out.append("<div class=\"col-lg-4 col-md-6\">");
		out.append("<input type=\"text\" name=\"order_namekh\" class=\"form-control\"  placeholder=\"Tên khách hàng\" >");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 col-md-6\">");
		out.append("<input type=\"number\" class=\"form-control\" name=\"order_sdt\" placeholder=\"Số điện thoại\">");
		out.append("</div>");
		out.append("<div class=\"col-lg-4 col-md-6\">");
		out.append("<input type=\"number\" class=\"form-control\" name=\"order_soluong\" placeholder=\"Số lượng\" >");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mt-3\">");
		out.append("<div class=\"col-lg-4 col-md-6\">");
		out.append("<input type=\"number\" class=\"form-control\" name=\"light_id\" value=\""+ item.getLight_id()+"\" >");
		out.append("</div>");
		out.append("<div class=\"col-lg-8 col-md-6\">");
		out.append("<input type=\"text\" class=\"form-control\" name=\"order_namesp\"  value=\""+ item.getLight_name()+"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<input type=\"address\" class=\"form-control\" name=\"order_address\"  placeholder=\"Địa chỉ\" >");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<textarea class=\"form-control\" name=\"order_note\"  placeholder=\"Ghi chú\"></textarea>");
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
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    
	    
	   

	    ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
	    LightFunction uf = new LightFunctionImpl(cp);
	    DonFunction uf1 = new DonFunctionImpl(cp);
	    
	    if (cp == null) {
      		 getServletContext().setAttribute("CPool", uf1.getCP());
      	 	}
	   
	   
	    try {
	        String OrderNameKH = request.getParameter("order_namekh");
	        int OrderSdt = Integer.parseInt(request.getParameter("order_sdt"));
	        int OrderSL = Integer.parseInt(request.getParameter("order_soluong"));
	    	int lightId = Integer.parseInt(request.getParameter("light_id"));
	        String OrderNamesp = request.getParameter("order_namesp");          
	        String OrderAddress = request.getParameter("order_address");
	        String OrderNote = request.getParameter("order_note");
	     
	        LightObject nitem = uf.getLight(lightId);
	        DonObject item = new DonObject();
	        item.setOrder_namekh(OrderNameKH);
	        item.setOrder_sdt(OrderSdt);
	        item.setOrder_namesp(OrderNamesp);
	        item.setOrder_number(OrderSL);
	        item.setOrder_pricesp(nitem.getLight_price());
	        item.setOrder_address(OrderAddress);
	        item.setOrder_note(OrderNote);
	      

	        boolean result = uf1.addDon(item);
	        if (result) {
	            response.sendRedirect("/GocDecore/donhang"); // Điều hướng đến trang thành công
	        } else {
	            response.sendRedirect("/GocDecore/View"); // Điều hướng đến trang lỗi nếu không thành công
	        }
	    } catch (NumberFormatException | NullPointerException e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/View"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/View"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    }
	}

}
