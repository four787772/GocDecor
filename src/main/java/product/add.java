package product;

import java.io.IOException;
import light.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.LightObject;
import util.ConnectionPool;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		RequestDispatcher h = request.getRequestDispatcher("/header");
        if (h != null) {
        	h.include(request, response);
		}




			out.append("<main id=\"main\" class=\"main\">");
			out.append("");
			out.append("<div class=\"pagetitle\">");
			out.append("<h1>Add information</h1>");
			out.append("<nav>");
			out.append("<ol class=\"breadcrumb\">");
			out.append("<li class=\"breadcrumb-item\"><a href=\"index.html\">Home</a></li>");
			out.append("<li class=\"breadcrumb-item\">Forms</li>");
			out.append("<li class=\"breadcrumb-item active\">Elements</li>");
			out.append("</ol>");
			out.append("</nav>");
			out.append("</div><!-- End Page Title -->");
			out.append("");
			out.append("<section class=\"section\">");
			out.append("<div class=\"row\">");
			out.append("<div class=\"col-lg-6 ms-3\">");
			out.append("");
			out.append("<div class=\"card\">");
			out.append("<div class=\"card-body\">");
			out.append("<h5 class=\"card-title\">Nhập thông tin sản phầm mới</h5>");
			out.append("");
			out.append("<!-- General Form Elements -->");
			out.append("<form action=\"/GocDecore/add\" method=\"post\">");
//			out.append("<div class=\"row mb-3\">");
//			out.append("<label for=\"inputText\"class=\"col-sm-2 col-form-label\">Mã SP</label>");
//			out.append("<div class=\"col-sm-10\">");
//			out.append("<input type=\"text\"  name=\"Light_id\" class=\"form-control\">");
//			out.append("</div>");
//			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputEmail\" class=\"col-sm-2 col-form-label\">Tên SP</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"text\" name=\"Light_name\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Giá gốc</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"number\" name=\"Light_pricelegal\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Phần trăm</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"number\" name=\"Light_percen\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Chất liệu</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"text\" name=\"Light_material\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Màu sắc</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"text\" name=\"Light_color\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Kích thước</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"text\" name=\"Light_size\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label class=\"col-sm-2 col-form-label\">Tình trạng</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<select name=\"Light_state\" class=\"form-select\" aria-label=\"Default select example\">");
			out.append("<option selected>Open this select menu</option>");
			out.append("<option value=\"Còn hàng\">Còn hàng</option>");
			out.append("<option value=\"Hết hàng\">Hết hàng</option>");
			out.append("</select>");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Link</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"text\" name=\"Light_img\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<label for=\"inputNumber\" class=\"col-sm-2 col-form-label\">Phân loại</label>");
			out.append("<div class=\"col-sm-10\">");
			out.append("<input type=\"number\" name=\"Category_id\" class=\"form-control\">");
			out.append("</div>");
			out.append("</div>");
			out.append("<div class=\"row mb-3\">");
			out.append("<div class=\"col-sm-10 d-flex justify-content-center\">");
			out.append("<button type=\"submit\" class=\"btn btn-primary\">Thêm mới sản phẩm</button>");
			out.append("<button type=\"button\" class=\"btn btn-primary ms-3\" onclick=\"history.back()\">Hủy</button>");
			out.append("</div>");
			out.append("</div>");
			out.append("");
			out.append("</form><!-- End General Form Elements -->");
			out.append("");
			out.append("</div>");
			out.append("</div>");
			out.append("");
			out.append("</div>");
			out.append("");
			out.append("<div class=\"col-lg-4 ms-3\">");
			out.append("<div class=\"row\">");
			out.append("<div class=\"card\">");
			out.append("<div class=\"card-body\">");
			out.append("<h5 class=\"card-title\">Tooltips Examples</h5>");
			out.append("<p>Hover over the buttons below to see the four tooltips directions: top, right, bottom, and left. </p>");
			out.append("");
			out.append("<!-- Tooltips Examples -->");
			out.append("<button type=\"button\" class=\"btn btn-secondary mb-2 me-3\" data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"Tooltip on top\">");
			out.append("Tooltip on top");
			out.append("</button>");
			out.append("<button type=\"button\" class=\"btn btn-secondary mb-2 me-3\" data-bs-toggle=\"tooltip\" data-bs-placement=\"right\" title=\"Tooltip on right\">");
			out.append("Tooltip on right");
			out.append("</button>");
			out.append("<button type=\"button\" class=\"btn btn-secondary mb-2 me-3\" data-bs-toggle=\"tooltip\" data-bs-placement=\"bottom\" title=\"Tooltip on bottom\">");
			out.append("Tooltip on bottom");
			out.append("</button>");
			out.append("<button type=\"button\" class=\"btn btn-secondary mb-2 me-3\" data-bs-toggle=\"tooltip\" data-bs-placement=\"left\" title=\"Tooltip on left\">");
			out.append("Tooltip on left");
			out.append("</button>");
			out.append("<!-- End Tooltips Examples -->");
			out.append("");
			out.append("</div>");
			out.append("");
			out.append("");
			out.append("</div>");
			out.append("");
			out.append("</div>");
			out.append("<div class=\"row\">");
			out.append("<div class=\"card\">");
			out.append("<div class=\"card-body\">");
			out.append("<h5 class=\" row card-title\">Area Chart</h5>");
			out.append("");
			out.append("<!-- Area Chart -->");
			out.append("<div id=\"areaChart\"></div>");
			out.append("");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
			out.append("</div>");
			out.append("</section>");
			out.append("");
			out.append("</main><!-- End #main -->");
			out.append("");


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
	    LightFunction uf = new LightFunctionImpl(cp);

	    try {
	    	 if (cp == null) {
	    		 getServletContext().setAttribute("CPool", uf.getCP());
	    	 }
//	        int lightId = Integer.parseInt(request.getParameter("Light_id"));
	        String lightName = request.getParameter("Light_name");
	        int lightPrice = Integer.parseInt(request.getParameter("Light_price"));
	        
	        int lightPercen = Integer.parseInt(request.getParameter("Light_percen"));
	        String lightMaterial = request.getParameter("Light_material");
	        String lightColor = request.getParameter("Light_color");
	        String lightSize = request.getParameter("Light_size");
	        String lightState = request.getParameter("Light_state");
	        String lightImg = request.getParameter("Light_img");
	        int Category_id = Integer.parseInt(request.getParameter("Category_id"));

	        LightObject item = new LightObject();
	        item.setLight_name(lightName);
	        item.setLight_price(lightPrice);
	        item.setLight_percen(lightPercen);
	        item.setLight_material(lightMaterial);
	        item.setLight_color(lightColor);
	        item.setLight_size(lightSize);
	        item.setLight_state(lightState);
	        item.setLight_img(lightImg);

	        boolean result = uf.addLight(item);
	        if (result) {
	            response.sendRedirect("/GocDecore/AdminLight"); // Điều hướng đến trang thành công
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
