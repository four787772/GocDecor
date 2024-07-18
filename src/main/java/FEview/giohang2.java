package FEview;

import java.io.IOException;

import java.io.PrintWriter;

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
import object.LightObject;
import object.DonObject;
import util.ConnectionPool;
import light.*;

/**
 * Servlet implementation class giohang2
 */
@WebServlet("/giohang2")
public class giohang2 extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang2() {
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
		// TODO Auto-generated method stub
		RequestDispatcher n = request.getRequestDispatcher("/navbar");
        if (n != null) {
        	n.include(request, response);
		}
        out.append("<section id=\"book-a-table\" class=\"book-a-table\">");
        out.append("<div class=\"container\">");
        out.append("<div class=\"card\" data-aos=\"fade-up\">");
//        out.append("<div class=\"card-body\">");
//        out.append("<h5 class=\"card-title text-center\">Danh sách đơn hàng</h5>");
//        out.append("");
//        out.append("<!-- Table with hoverable rows -->");
//        out.append("<table class=\"table table-hover\">");
//        out.append("<thead>");
//        out.append("<tr>");
//        out.append("<th scope=\"col\" class=\"text-center\">STT</th>");
//        out.append("<th scope=\"col\" class=\"text-center\">Tên sản phẩm</th>");
//        out.append("<th scope=\"col\" class=\"text-center\">Giá SP</th>");
//        out.append("<th scope=\"col\" class=\"text-center\">Số lượng</th>");
//        out.append("<th scope=\"col\" class=\"text-center\">Thành Tiền</th>");
//        out.append("<th scope=\"col\" class=\"text-center\">Sửa</th>");
//        out.append("<th scope=\"col\" class=\"text-center\">Xóa</th>");
//        out.append("</tr>");
//        out.append("</thead>");
//        out.append("<tbody>");
//        out.append("<tr>");
//        out.append("<th scope=\"row\" class=\"text-center\"></th>");
//        out.append("<td class=\"text-center\"></td>");
//        out.append("<td class=\"text-center\"></td>");
//        out.append("<td class=\"text-center\"></td>");
//        out.append("<td class=\"text-center\"></td>");
//        out.append("<td class=\"text-center\"><i class=\"fa-regular fa-pen-to-square\"></i></td>");
//        out.append("<td class=\"text-center\"><i class=\"fa-solid fa-trash-can\"></i></td>");
//        out.append("</tr>");
//        out.append("</tbody>");
//        out.append("</table>");
//        out.append("<!-- End Table with hoverable rows -->");
//        out.append("");
//        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        HttpSession session = request.getSession();
        CustomerObject user = (CustomerObject) session.getAttribute("CustomerLogined");
        if (user == null) {
            // Xử lý khi người dùng chưa đăng nhập
            out.append("<p class=\"text-center\">Vui lòng đăng nhập để đặt mua sản phẩm.</p>");
            return;
        }
    	
        out.append("<div class=\"container\" data-aos=\"fade-up\">");
        out.append("");
        out.append("<div class=\"section-header mt-3\">");
        out.append("<!-- <h2>Đặt mua sản phẩm</h2> -->");
        out.append("<p>Đặt mua sản phẩm</p>");
        out.append("</div>");
        out.append("");
        out.append("<div class=\"row g-0\">");
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
        LightFunction uf = new LightFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}
		
		int lightId = Integer.parseInt(request.getParameter("id"));
		LightObject item = uf.getLight(lightId);
		out.append("<div class=\"col-lg-4 reservation-img me-1\" data-aos=\"zoom-out\" data-aos-delay=\"200\">");
		out.append("<img src=\"img/light_img/"+item.getLight_img()+".jpg\" alt=\"Reservation Image\">");
		out.append("</div>");
		out.append("");
        out.append("<div class=\"col-lg-7 d-flex align-items-center justify-content-center reservation-form-bg\">");
        out.append("<form action=\"/GocDecore/giohang2\" method=\"post\" >");
        out.append("<div class=\"row gy-4\">");
        out.append("<div class=\"col-lg-6 col-md-6\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_namekh\"  value=\""+ user.getCustomer_name()+"\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-6 col-md-6\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"order_sdt\" value=\""+ user.getCustomer_phone()+"\"  class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
        out.append("</div>");
        out.append("<div class=\"row mt-3\">");
        out.append("<div class=\"col-lg-6 col-md-6\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"light_id\" value=\""+ item.getLight_id()+"\"  class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"col-lg-6 col-md-6\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"order_soluong\" class=\"form-control\" placeholder=\"Số lượng\">");
		out.append("</div>");
		out.append("</div>");
        out.append("</div>");
        out.append("<div class=\"form-group mt-3\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"order_makh\" value=\""+ user.getCustomer_id()+"\"  class=\"form-control\" >");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_namesp\" value=\""+ item.getLight_name()+"\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_address\"  value=\""+ user.getCustomer_address()+"\" class=\"form-control\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_note\" class=\"form-control\" placeholder=\"Ghi chú\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"form-group mt-3\">");
		out.append("<div class=\"col-sm-10 d-flex justify-content-center\">");
		out.append("<button type=\"submit\" class=\"btn btn-primary\">Đặt mua</button>");
		out.append("<button type=\"button\" class=\"btn btn-primary ms-3\" onclick=\"history.back()\">Cancel</button>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</form><!-- End General Form Elements -->");
        out.append("</div><!-- End Reservation Form -->");
        out.append("");
        out.append("</div>");
        out.append("");
        out.append("</div>");
        out.append("</section><!-- End Book A Table Section -->");
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
	    	int CustomerId = Integer.parseInt(request.getParameter("order_makh"));
	        String OrderNamesp = request.getParameter("order_namesp");          
	        String OrderAddress = request.getParameter("order_address");
	        String OrderNote = request.getParameter("order_note");
	     
	       LightObject nitem = uf.getLight(lightId);
	        DonObject item = new DonObject();
	        item.setOrder_makh(CustomerId);
	        item.setOrder_namekh(OrderNameKH);
	        item.setOrder_sdt(OrderSdt);
	        item.setOrder_masp(nitem.getLight_id());
	        item.setOrder_namesp(OrderNamesp);
	        item.setOrder_number(OrderSL);
	        item.setOrder_pricesp(nitem.getLight_price());
	        item.setOrder_address(OrderAddress);
	        item.setOrder_note(OrderNote);
	      

	        boolean result = uf1.addDon(item);
	        if (result) {
	        	HttpSession session1 = request.getSession(true);
	            session1.setAttribute("OrderMessage", "Đơn hàng của bạn đã được thêm thành công!"); // Store the success message
	            response.sendRedirect("/GocDecore/giohang1");// Điều hướng đến trang thành công
	        } else {
	            response.sendRedirect("/GocDecore/index"); // Điều hướng đến trang lỗi nếu không thành công
	        }
	    } catch (NumberFormatException | NullPointerException e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/index"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/index"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    }
	}

}
