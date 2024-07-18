package Donhang;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.*;
import object.DonObject;

import util.ConnectionPool;
import light.*;

/**
 * Servlet implementation class donhang
 */
@WebServlet("/donhang")
public class donhang extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public donhang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		// Tham chiếu Servlet header
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}
		out.append("<!-- ======= Sidebar ======= -->");
		out.append("<aside id=\"sidebar\" class=\"sidebar\">");
		out.append("");
		out.append("<ul class=\"sidebar-nav\" id=\"sidebar-nav\">");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"/GocDecore/View\">");
		out.append("<i class=\"bi bi-grid\"></i>");
		out.append("<span>Trang chủ</span>");
		out.append("</a>");
		out.append("</li><!-- End Dashboard Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link \" data-bs-target=\"#tables-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-layout-text-window-reverse\"></i><span>Quản lí đơn hàng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"components-nav\" class=\"nav-content collapse show \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"donhang\" class=\"active\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách đơn hàng</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Components Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#forms-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-journal-text\"></i><span>Quản lí người dùng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"forms-nav\" class=\"nav-content collapse show \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/Userview\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách admin</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Forms Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-menu-button-wide\"></i><span>Quản lí sản phẩm</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"tables-nav\" class=\"nav-content collapse show\" data-bs-parent=\"#\">");
		out.append("");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminLight\" >");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách sản phẩm</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminRating\" class=\"\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Đánh giá của người dùng</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("</ul>");
		out.append("</li><!-- End Tables Nav -->");
		out.append("");
		out.append("");
		out.append("<li class=\"nav-heading\">Pages</li>");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"users-profile.html\">");
		out.append("<i class=\"bi bi-person\"></i>");
		out.append("<span>Hồ sơ cá nhân</span>");
		out.append("</a>");
		out.append("</li><!-- End Profile Page Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-faq.html\">");
		out.append("<i class=\"bi bi-question-circle\"></i>");
		out.append("<span>F.A.Q</span>");
		out.append("</a>");
		out.append("</li><!-- End F.A.Q Page Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"pages-contact.html\">");
		out.append("<i class=\"bi bi-envelope\"></i>");
		out.append("<span>Liên hệ</span>");
		out.append("</a>");
		out.append("</li><!-- End Contact Page Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append("<a class=\"nav-link collapsed\" href=\"/GocDecore/AdminLogin\">");
		out.append("<i class=\"bi bi-box-arrow-in-right\"></i>");
		out.append("<span>Đăng xuất</span>");
		out.append("</a>");
		out.append("</li><!-- End Login Page Nav -->");
		out.append("</ul>");
		out.append("");
		out.append("</aside><!-- End Sidebar-->");

		out.append("<main id=\"main\" class=\"main\">");
		out.append("");
		out.append("<div class=\"pagetitle\">");
		out.append("<h1>Danh sách đơn hàng</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"/GocDecore/View\">Home</a></li>");
		out.append("<li class=\"breadcrumb-item\">Đơn hàng</li>");
		out.append("<li class=\"breadcrumb-item active\">Danh sách</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("<div>");
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
		DonFunction uf = new DonFunctionImpl(cp);
		LightFunction uf1 = new LightFunctionImpl(cp);

		if (cp == null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}

		// Lấy danh sách hiển thị
		ArrayList<DonObject> list = uf.getAccountFull();

		out.append("<table class=\"table table-striped table-hover table-sm\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th scope=\"col\">MaDH</th>");
		out.append("<th scope=\"col\">MaKH</th>");
		out.append("<th scope=\"col\">Tên KH</th>");
		out.append("<th scope=\"col\">SĐT</th>");
		out.append("<th scope=\"col\">MaSP</th>");
		out.append("<th scope=\"col\">Tên SP</th>");
		out.append("<th scope=\"col\">SL</th>");
		out.append("<th scope=\"col\">Giá</th>");
		out.append("<th scope=\"col\">Thành tiền</th>");
		out.append("<th scope=\"col\">Địa chỉ</th>");
		out.append("<th scope=\"col\">Ghi chú</th>");
		out.append("<th scope=\"col\">Ngày đặt</th>");
		out.append("<th scope=\"col\">edit</th>");
		out.append("<th scope=\"col\">del</th>");
		out.append("<th scope=\"col\">Trạng thái</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		list.forEach(item -> {
			out.append("<tr>");
			out.append("<th scope=\"row\">" + item.getOrder_id() + "</th>");
			out.append("<th scope=\"row\">" + item.getOrder_makh() + "</th>");
			out.append("<td class=\"text-center\">" + item.getOrder_namekh() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_sdt() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_masp() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_namesp() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_number() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_pricesp() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_pricefinaly() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_address() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_note() + "</td>");
			out.append("<td class=\"text-center\">" + item.getOrder_date() + "</td>");
			out.append("<td class=\"text-center\"><a href=\"/GocDecore/editDon?id=" + item.getOrder_id()
					+ "\"><i class=\"bi bi-pencil-square\"></i></a></td>");
			out.append("<td class=\"text-center\">" + "<a href=\"/GocDecore/delDon?id=" + item.getOrder_id() + "\" "
					+ "onclick=\"return confirm('Bạn có chắc chắn muốn xóa không?');\">"
					+ "<i class=\"bi bi-trash-fill\"></i>" + "</a>" + "</td>");

			LightObject nitem = uf1.getLight(item.getOrder_masp());
			out.append("<td class=\"text-center\"><button id=\"show-notification-btn-" + item.getOrder_id()
					+ "\" style=\"display: inline-block; padding: 10px 20px; font-size: 8px; font-weight: bold; text-align: center; text-decoration: none; background-color: #4154f1; color: #fff; border: none; border-radius: 20px; cursor: pointer; transition: background-color 0.3s ease;\" >Xác nhận</button></td>");
			
			if (nitem != null && nitem.getLight_img() != null && !nitem.getLight_img().isEmpty()) {
				out.append("<script>");
				out.append("document.addEventListener('DOMContentLoaded', function() {");
				out.append("const showNotificationBtn = document.getElementById('show-notification-btn-"
						+ item.getOrder_id() + "');");
				out.append("showNotificationBtn.addEventListener('click', () => {");
				out.append("const orderId = '" + item.getOrder_id() + "';");
				out.append("const customerId = '" + item.getOrder_makh() + "';");
				out.append("const LightImg = '" + nitem.getLight_img() + "';");
				out.append(
						"const notificationMessage = 'Đơn hàng với mã đơn: ' + orderId + ' đã được bàn giao đến đơn vị vận chuyển.';");

				// Lấy danh sách thông báo hiện tại từ localStorage
				out.append("let notifications = JSON.parse(localStorage.getItem('notifications')) || [];");

				// Thêm thông báo mới vào danh sách
				out.append(
						"notifications.push({ id: orderId, message: notificationMessage, customerId: customerId, LightImg: LightImg });");

				// Lưu lại danh sách thông báo vào localStorage
				out.append("localStorage.setItem('notifications', JSON.stringify(notifications));");

				// Hiển thị thông báo rằng thông báo đã được gửi
				out.append("alert('Thông báo đã được gửi đến khách hàng.');");

				out.append("showNotificationBtn.innerText = 'Đã xác nhận';");
				out.append("showNotificationBtn.style.backgroundColor = '#28a745';");
				out.append("showNotificationBtn.disabled = true;"); // Nếu bạn muốn nút không thể nhấn lại

				out.append("});");
				out.append("});");
				out.append("</script>");
			}

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
