package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import object.*;
import light.*;
import util.ConnectionPool;

/**
 * Servlet implementation class del
 */
@WebServlet("/DelLightView")
public class DelLightView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		int productId = -1;
		try {
			productId = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect("/GocDecore/ErrorPage"); // Điều hướng đến trang lỗi nếu id không hợp lệ
			return;
		}

		// Xử lý xóa sản phẩm
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		LightFunction uf = new LightFunctionImpl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

		LightObject nItem = uf.getLight(productId);
		if (nItem == null) {
			response.sendRedirect("/GocDecore/ErrorPage"); // Điều hướng đến trang lỗi nếu không tìm thấy sản phẩm
			return;
		}

		boolean result = uf.delLight(nItem);

		if (result) {
			response.sendRedirect("/GocDecore/AdminLight?success2=true"); // Điều hướng đến trang Deal nếu xóa thành công
		} else {
			response.sendRedirect("/GocDecore/ErrorPage"); // Điều hướng đến trang lỗi nếu không thành công
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
