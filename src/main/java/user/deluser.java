package user;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.UserObject;
import util.ConnectionPool;

/**
 * Servlet implementation class deluser
 */
@WebServlet("/deluser")
public class deluser extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public deluser() {
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
		int UserId = Integer.parseInt(request.getParameter("id"));

        // Xử lý xóa sản phẩm
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
        UserFunction uf = new UserFunctionImpl(cp);
        if (cp == null) {
            getServletContext().setAttribute("CPool", uf.getCP());
        }
        UserObject nItem = uf.getUser(UserId);
        boolean result = uf.delUser(nItem);

        if (result) {
            response.sendRedirect("/GocDecore/Userview?success2=true"); // Điều hướng đến trang Deal nếu xóa thành công
        } else {
            response.sendRedirect("/GocDecore/View"); // Điều hướng đến trang lỗi nếu không thành công
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
