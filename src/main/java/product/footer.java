package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class footer
 */
@WebServlet("/footer")
public class footer extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public footer() {
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
		
		out.append("");
		out.append("<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("<!-- Vendor JS Files -->");
		out.append("<script src=\"/GocDecore/assets/vendor/apexcharts/apexcharts.min.js\"></script>");
		out.append("<script src=\"/GocDecore/assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>");
		out.append("<script src=\"/GocDecore/assets/vendor/chart.js/chart.umd.js\"></script>");
		out.append("<script src=\"/GocDecore/assets/vendor/echarts/echarts.min.js\"></script>");
		out.append("<script src=\"/GocDecore/assets/vendor/quill/quill.js\"></script>");
		out.append("<script src=\"/GocDecore/assets/vendor/simple-datatables/simple-datatables.js\"></script>");
		out.append("<script src=\"/GocDecore/assets/vendor/tinymce/tinymce.min.js\"></script>");
		out.append("<script src=\"/GocDecore/assets/vendor/php-email-form/validate.js\"></script>");
		out.append("");
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"/GocDecore/assets/js/main.js\"></script>");
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
		out.close();
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
