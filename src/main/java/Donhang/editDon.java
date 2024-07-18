package Donhang;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.DonObject;
import util.ConnectionPool;

/**
 * Servlet implementation class editDon
 */
@WebServlet("/editDon")
public class editDon extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editDon() {
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

		RequestDispatcher h = request.getRequestDispatcher("/header?pos=uv");
        if (h != null) {
        	h.include(request, response);
		}
        out.append("<main id=\"main\" class=\"main\">");
		out.append("<div class=\"pagetitle\">");
		out.append("<h1>Add information</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"GocDecore/View\">Home</a></li>");
		out.append("<li class=\"breadcrumb-item\">Forms</li>");
		out.append("<li class=\"breadcrumb-item active\">Elements</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-6 ms-3\">");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">General Form Elements</h5>");
		out.append("<form action=\"/GocDecore/editDon\" method=\"post\">");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		DonFunction uf = new DonFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

		int OrderId = Integer.parseInt(request.getParameter("id"));
		DonObject item = uf.getDon(OrderId);
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Mã đơn hàng</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"order_id\" class=\"form-control\" value=\"" + item.getOrder_id() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputText\" class=\"col-sm-2 col-form-label\">Tên KH</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_namekh\" class=\"form-control\" value=\"" + item.getOrder_namekh() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">SĐT</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"order_sdt\" class=\"form-control\" value=\"" + item.getOrder_sdt() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"input\" class=\"col-sm-2 col-form-label\">Tên SP</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_namesp\" class=\"form-control\" value=\"" + item.getOrder_namesp() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Số Lượng</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"order_number\" class=\"form-control\" value=\"" + item.getOrder_number() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Giá 1 SP</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"number\" name=\"order_pricesp\" class=\"form-control\" value=\"" + item.getOrder_pricesp() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"input\" class=\"col-sm-2 col-form-label\">Địa chỉ</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_address\" class=\"form-control\" value=\"" + item.getOrder_address() +"\">");
		out.append("</div>");
		out.append("</div>");
		out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputAddress\" class=\"col-sm-2 col-form-label\">Ghi chú</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"text\" name=\"order_note\" class=\"form-control\" value=\"" + item.getOrder_note() +"\">");
		out.append("</div>");
		out.append("</div>");
		/*out.append("<div class=\"row mb-3\">");
		out.append("<label for=\"inputDate\" class=\"col-sm-2 col-form-label\">Date</label>");
		out.append("<div class=\"col-sm-10\">");
		out.append("<input type=\"date\" name=\"order_date\" class=\"form-control\" value=\"" + item.getOrder_date() +"\">");
		out.append("</div>");
		out.append("</div>");*/
		out.append("<div class=\"row mb-3\">");
		out.append("<div class=\"col-sm-10 d-flex justify-content-center\">");
		out.append("<button type=\"submit\" class=\"btn btn-primary\">Edit Don</button>");
		out.append("<button type=\"submit\" class=\"btn btn-primary ms-3\" onclick=\"history.back()\">cancel</button>");
		out.append("</div>");
		out.append("</div>");
		out.append("</form><!-- End General Form Elements -->");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</section>");
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
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");

	    ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
	    DonFunction uf = new DonFunctionImpl(cp);
	    if (cp == null) {
   		 	getServletContext().setAttribute("CPool", uf.getCP());
   	 	}
	    try {

	        int OrderId = Integer.parseInt(request.getParameter("order_id"));
	        String OrderNamekh = request.getParameter("order_namekh");
	        int OrderSDT = Integer.parseInt(request.getParameter("order_sdt"));
	        String OrderNameSP = request.getParameter("order_namesp");
	        int OrderNumber = Integer.parseInt(request.getParameter("order_number"));
	        int OrderPriceSP = Integer.parseInt(request.getParameter("order_pricesp"));
	        String OrderAddress = request.getParameter("order_address");
	        String OrderNote = request.getParameter("order_note");
	       /*String OrderDate = request.getParameter("order_date");*/

	        DonObject item = new DonObject();
	        item.setOrder_id(OrderId);
	        item.setOrder_namekh(OrderNamekh);
	        item.setOrder_sdt(OrderSDT);
	        item.setOrder_namesp(OrderNameSP);
	        item.setOrder_number(OrderNumber);
	        item.setOrder_pricesp(OrderPriceSP);
	        item.setOrder_address(OrderAddress);
	        item.setOrder_note(OrderNote);
	        /*item.setOrder_date(OrderDate);*/

	        boolean result = uf.editDon(item);
	        if (result) {
	            response.sendRedirect("/GocDecore/donhang?success=true"); // Điều hướng đến trang thành công
	        } else {
	            response.sendRedirect("/GocDecore/Deal"); // Điều hướng đến trang lỗi nếu không thành công
	        }
	    } catch (NumberFormatException | NullPointerException e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/Deal"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("/GocDecore/Deal"); // Điều hướng đến trang lỗi nếu có ngoại lệ xảy ra
	    }
	}

}
