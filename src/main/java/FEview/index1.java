package FEview;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.*;
import object.LightObject;
import light.*;
import util.ConnectionPool;

/**
 * Servlet implementation class index1
 */
@WebServlet("/index1")
public class index1 extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public index1() {
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
        out.append("<!-- ======= Breadcrumbs ======= -->");
		out.append("<div class=\"breadcrumbs d-flex align-items-center\" style=\"background-image: url('img/thu.png');\">");
		out.append("<div class=\"container position-relative d-flex flex-column align-items-center\" data-aos=\"fade\">");
		out.append("");
		out.append("<h2>Product Searching</h2>");
		out.append("<ol>");
		out.append("<li><a href=\"/GocDecore/index\">Home</a></li>");
		out.append("<li>Product Searching</li>");
		out.append("</ol>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Breadcrumbs -->");
        out.append("");

        out.append("<main id=\"main\">");
        out.append("");

        String query = request.getParameter("query");
        if (query == null) {
            query = ""; // Ensure query is not null
        }

        // Perform search and retrieve results
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
        LightFunction lf = new LightFunctionImpl(cp);

        if (cp == null) {
            getServletContext().setAttribute("CPool", lf.getCP());
        }

        ArrayList<LightObject> list = lf.searchProducts(query);

        // Display search results
        out.println("<div class='container'>");
        out.println("<div class='row'>");

        for (LightObject item : list) {
        	DecimalFormat decimalFormat = new DecimalFormat("#,###");
            out.println("<div class='col-sm-3 deal-items'>");
            out.println("<div class='deal-cart-box'>");
            out.println("<div class='product-dealhot'>" + item.getLight_percen() + " %</div>");
            out.println("<a href='/GocDecore/detail?id=" + item.getLight_id() + "'>");
            out.println("<img class='product-img' src='img/light_img/" + item.getLight_img() + ".jpg' alt='features product'>");
            out.println("</a>");
            out.println("<p class='deal-cart-box11'>" + item.getLight_name() + "</p>");
            out.println("<a class='teadeal-btn-legal'>" + decimalFormat.format(item.getLight_pricelegal()) + "</a>");
            out.println("<a class='teadeal-btn'>" + decimalFormat.format(item.getLight_price()) + " VNĐ</a>");
            out.println("<a href='/GocDecore/giohang2?id=" + item.getLight_id() + "' class='btn border border-secondary rounded-pill px-3 py-1 mb-4'>");
            out.println("<i class='fa fa-cart-plus me-2'></i> Thêm Vào Giỏ Hàng");
            out.println("</a>");
            out.println("</div>");
            out.println("</div>");
        }

        out.println("</div>");
        out.println("</div>");
        
        
        out.append("</main><!-- End #main -->");
        out.append("");

        // Include footer
        RequestDispatcher fc = request.getRequestDispatcher("/footercustom");
        if (fc != null) {
            fc.include(request, response);
        }
	}

	private List<LightObject> performSearch(String searchQuery) {
		// TODO Auto-generated method stub
		return null;
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
