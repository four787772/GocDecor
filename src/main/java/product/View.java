package product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Donhang.DonFunction;
import Donhang.DonFunctionImpl;
import object.*;
import QLcustomer.CustomerFunction;
import QLcustomer.CustomerFunctionImpl;
import util.ConnectionPool;
import light.*;
/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Tìm thông tin đăng nhập
    	UserObject user = (UserObject) request.getSession().getAttribute("AdminLogined");
    	if (user == null) {
			response.sendRedirect("/GocDecore/AdminLogin");
		} else {
			view(request, response, user);
		}
    }


	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
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
		out.append("<a class=\"nav-link \" href=\"index.html\">");
		out.append("<i class=\"bi bi-grid\"></i>");
		out.append("<span>Trang chủ</span>");
		out.append("</a>");
		out.append("</li><!-- End Trang chủ Nav -->");
		out.append("");
		out.append("<li class=\"nav-item\">");
		out.append(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-menu-button-wide\"></i><span>Quản lí đơn hàng</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"components-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"donhang\">");
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
		out.append("<ul id=\"forms-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
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
				"<a class=\"nav-link collapsed\" data-bs-target=\"#tables-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.append(
				"<i class=\"bi bi-layout-text-window-reverse\"></i><span>Quản lí sản phẩm</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.append("</a>");
		out.append("<ul id=\"tables-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminLight\">");
		out.append("<i class=\"bi bi-circle\"></i><span>Danh sách sản phẩm</span>");
		out.append("</a>");
		out.append("</li>");
		out.append("<li>");
		out.append("<a href=\"/GocDecore/AdminRating\">");
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
		out.append("");



		out.append("<main id=\"main\" class=\"main\">");
		out.append("");
		out.append("<div class=\"pagetitle\">");
		out.append("<h1>Dashboard</h1>");
		out.append("<nav>");
		out.append("<ol class=\"breadcrumb\">");
		out.append("<li class=\"breadcrumb-item\"><a href=\"index.html\">Home</a></li>");
		out.append("<li class=\"breadcrumb-item active\">Dashboard</li>");
		out.append("</ol>");
		out.append("</nav>");
		out.append("</div><!-- End Page Title -->");
		out.append("<section class=\"section dashboard\">");
		out.append("<div class=\"row\">");
		out.append("");
		out.append("<!-- Left side columns -->");
		out.append("<div class=\"col-lg-8\">");
		out.append("<div class=\"row\">");
		out.append("");
		out.append("<!-- Sales Card -->");
		out.append("<div class=\"col-xxl-4 col-md-6\">");
		out.append("<div class=\"card info-card sales-card\">");
		out.append("");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Hôm nay</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong năm</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		DonFunction uf1 = new DonFunctionImpl(null);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf1.getCP());
		}
		
        // Lấy danh sách hiển thị
		ArrayList<DonObject> list1 = uf1.getAccount();
		int sldonhang= list1.size();
		int tonglai = 0;
		for (DonObject item : list1) {
		    tonglai += item.getOrder_number() * 0.75;
		}
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Đơn hàng<span>| Trong tháng</span></h5>");
		out.append("");
		out.append("<div class=\"d-flex align-items-center\">");
		out.append("<div class=\"card-icon rounded-circle d-flex align-items-center justify-content-center\">");
		out.append("<i class=\"bi bi-cart\"></i>");
		out.append("</div>");
		out.append("<div class=\"ps-3\">");
		out.append("<h6>"+sldonhang+"</h6>");
		out.append("<span class=\"text-success small pt-1 fw-bold\">12%</span> <span class=\"text-muted small pt-2 ps-1\">increase</span>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Sales Card -->");
		out.append("");
		out.append("<!-- Revenue Card -->");
		out.append("<div class=\"col-xxl-4 col-md-6\">");
		out.append("<div class=\"card info-card revenue-card\">");
		out.append("");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Lợi nhuận<span>| Trong tháng</span></h5>");
		out.append("");
		out.append("<div class=\"d-flex align-items-center\">");
		out.append("<div class=\"card-icon rounded-circle d-flex align-items-center justify-content-center\">");
		out.append("<i class=\"bi bi-currency-dollar\"></i>");
		out.append("</div>");
		out.append("<div class=\"ps-3\">");
		out.append("<h6>$"+ tonglai +"</h6>");
		out.append("<span class=\"text-success small pt-1 fw-bold\">8%</span> <span class=\"text-muted small pt-2 ps-1\">increase</span>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Revenue Card -->");
		out.append("");
		out.append("<!-- Customers Card -->");
		out.append("<div class=\"col-xxl-4 col-xl-12\">");
		out.append("");
		out.append("<div class=\"card info-card customers-card\">");
		out.append("");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		
		// Tạo đối tượng thực thi chức năng
		CustomerFunction uf = new CustomerFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", uf.getCP());
		}
		
        // Lấy danh sách hiển thị
		ArrayList<CustomerObject> list = uf.getAccount();
		int slcustomer = list.size();
		
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Khách hàng <span>| Trong năm</span></h5>");
		out.append("");
		out.append("<div class=\"d-flex align-items-center\">");
		out.append("<div class=\"card-icon rounded-circle d-flex align-items-center justify-content-center\">");
		out.append("<i class=\"bi bi-people\"></i>");
		out.append("</div>");
		out.append("<div class=\"ps-3\">");
		out.append("<h6>"+ 545 +"</h6>");
		out.append("<span class=\"text-danger small pt-1 fw-bold\">12%</span> <span class=\"text-muted small pt-2 ps-1\">tăng</span>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div><!-- End Customers Card -->");
		out.append("");
		
		List<Integer> matrix = new ArrayList<>();
		for(DonObject item : list1) {
			if (!matrix.contains(item.getOrder_number())) {
                matrix.add(item.getOrder_number());
            }
		}
		
		int maxsl = Collections.max(matrix);
		
		List<Integer> matrix1= new ArrayList<>();
		for (int i = 0; i <= maxsl; i++) {
			matrix1.add(i);
		}
		
		int n = matrix1.size();
		
		int[] matrix5 = new int[n];
		for (int i = 0; i < n; i++) {
            Set<Integer> uniqueCustomers1 = new HashSet<>();
            int targetQuantity = matrix1.get(i);

            for (DonObject item1 : list1) {
                if (item1.getOrder_number() == targetQuantity) {
                    uniqueCustomers1.add(item1.getOrder_id());
                }
            }
            matrix5[i] = uniqueCustomers1.size();
		}

		
		int[] matrix2 = new int[n];
		for (int i = 0; i < n; i++) {
            Set<Integer> uniqueCustomers = new HashSet<>();
            int targetQuantity = matrix1.get(i);

            for (DonObject item1 : list1) {
                if (item1.getOrder_number() == targetQuantity) {
                    uniqueCustomers.add(item1.getOrder_makh());
                }
            }
            matrix2[i] = uniqueCustomers.size();
		}

		Integer[] matrix3 = matrix1.toArray(new Integer[matrix1.size()]);
		
		double[] matrix4 = new double[matrix3.length];

		for (int i = 0; i < matrix3.length; i++) {
		    matrix4[i] = matrix3[i] * matrix5[i];
		    matrix4[i] = matrix4[i] *  0.75;
		}


		
		out.append("<!-- Reports -->");
		out.append("<div class=\"col-12\">");
		out.append("<div class=\"card\">");
		out.append("");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Báo cáo- thống kê <span>/Trong tháng</span></h5>");
		out.append("");
		out.append("<!-- Line Chart -->");
		out.append("<div id=\"reportsChart\"></div>");
		out.append("");
		out.append("<script>");
		out.append("document.addEventListener(\"DOMContentLoaded\", () => {");
		out.append("new ApexCharts(document.querySelector(\"#reportsChart\"), {");
		out.append("series: [{");
		out.append("name: 'Sales',");
		out.append("data: [");
		for (int i = 0; i < matrix5.length; i++) {
		    out.append(Integer.toString(matrix5[i]));
		    if (i < matrix5.length - 1) {
		        out.append(", ");
		    }
		}
		out.append("]");
		out.append("}, {");
		out.append("name: 'Revenue',");
		out.append("data: [");
		for (int i = 0; i < matrix4.length; i++) {
		    out.append(Double.toString(matrix4[i]));
		    if (i < matrix4.length - 1) {
		        out.append(", ");
		    }
		}
		out.append("]");
		out.append("}, {");
		out.append("name: 'Customers',");
		out.append("data: [");
		for (int i = 0; i < matrix2.length; i++) {
		    out.append(Integer.toString(matrix2[i]));
		    if (i < matrix2.length - 1) {
		        out.append(", ");
		    }
		}
		out.append("]");
		out.append("}],");
		out.append("chart: {");
		out.append("height: 350,");
		out.append("type: 'area',");
		out.append("toolbar: {");
		out.append("show: false");
		out.append("},");
		out.append("},");
		out.append("markers: {");
		out.append("size: 4");
		out.append("},");
		out.append("colors: ['#4154f1', '#2eca6a', '#ff771d'],");
		out.append("fill: {");
		out.append("type: \"gradient\",");
		out.append("gradient: {");
		out.append("shadeIntensity: 1,");
		out.append("opacityFrom: 0.3,");
		out.append("opacityTo: 0.4,");
		out.append("stops: [0, 90, 100]");
		out.append("}");
		out.append("},");
		out.append("dataLabels: {");
		out.append("enabled: false");
		out.append("},");
		out.append("stroke: {");
		out.append("curve: 'smooth',");
		out.append("width: 2");
		out.append("},");
		out.append("xaxis: {");
		out.append("categories: [");
		for (int i = 0; i < matrix3.length; i++) {
		    out.append(Integer.toString(matrix3[i]));
		    if (i < matrix3.length - 1) {
		        out.append(", ");
		    }
		}
		out.append("]");
		out.append("},");
		out.append("yaxis: {");
		out.append("min: 0,");
		out.append("max: 50,");
		out.append("labels: {");
		out.append("formatter: function (value) {");
		out.append("return value.toFixed(0);");
		out.append("}");
		out.append("}");
		out.append("},");
		out.append("tooltip: {");
		out.append("'x-1': {");
		out.append("formatter: function (value) {");
		out.append("return value.toFixed(2);");
		out.append("}");
		out.append("}");
		out.append("}");
		out.append("}).render();");
		out.append("});");
		out.append("</script>");
		out.append("<!-- End Line Chart -->");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Reports -->");
		out.append("");
		
		out.append("<!-- Reports -->");
		out.append("<div class=\"col-12\">");
		out.append("<div class=\"card\">");
		out.append("");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Hôm nay</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Năm</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		
		LightFunctionImpl lf = new LightFunctionImpl(cp);
		ArrayList<LightObject> list0 = new ArrayList<>();
		list0 = lf.get5MaxRevenue();		

		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Top 5 sản phẩm có doanh thu cao nhất <span>/Trong tháng</span></h5>");
		out.append("");
		out.append("<!-- Bar Chart -->");
		out.append("<canvas id=\"barChart\" style=\"max-height: 400px;\"></canvas>");
		out.append("<script>");
		out.append("document.addEventListener(\"DOMContentLoaded\", () => {");
		out.append("new Chart(document.querySelector('#barChart'), {");
		out.append("type: 'bar',");
		out.append("data: {");
		
		out.append("labels: ['" + list0.get(0).getLight_name() + "',"
						+ " '" + list0.get(1).getLight_name() + "',"
						+ " '" + list0.get(2).getLight_name() + "',"
						+ " '" + list0.get(3).getLight_name() + "',"
						+ " '" + list0.get(4).getLight_name() + "'],");
		out.append("datasets: [{");
		out.append("label: 'Doanh thu',");
		out.append("data: ["+list0.get(0).getLight_revenue()+", "+list0.get(1).getLight_revenue()+", "+list0.get(2).getLight_revenue()+", "+list0.get(3).getLight_revenue()+", "+list0.get(4).getLight_revenue()+"],");
		out.append("backgroundColor: [");
		out.append("'rgba(255, 99, 132, 0.2)',");
		out.append("'rgba(255, 205, 86, 0.2)',");
		out.append("'rgba(54, 162, 235, 0.2)',");
		out.append("'rgba(153, 102, 255, 0.2)',");
		out.append("'rgba(201, 203, 207, 0.2)'");
		out.append("],");
		out.append("borderColor: [");
		out.append("'rgb(255, 99, 132)',");
		out.append("'rgb(255, 205, 86)',");
		out.append("'rgb(54, 162, 235)',");
		out.append("'rgb(153, 102, 255)',");
		out.append("'rgb(201, 203, 207)'");
		out.append("],");
		out.append("borderWidth: 1");
		out.append("}]");
		out.append("},");
		out.append("options: {");
		out.append("scales: {");
		out.append("y: {");
		out.append("beginAtZero: true");
		out.append("}");
		out.append("}");
		out.append("}");
		out.append("});");
		out.append("});");
		out.append("</script>");
		out.append("<!-- End Bar CHart -->");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Reports -->");
		
		
		out.append("");
		out.append("<!-- Top Selling -->");
		out.append("<div class=\"col-12\">");
		out.append("<div class=\"card top-selling overflow-auto\">");
		out.append("");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Hôm nay</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Năm</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"card-body pb-0\">");
		out.append("<h5 class=\"card-title\">Top Bán chạy <span>| Trong tháng</span></h5>");
		out.append("");
		out.append("<table class=\"table table-borderless\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th scope=\"col\">Hình ảnh</th>");
		out.append("<th scope=\"col\">Sản phẩm</th>");
		out.append("<th scope=\"col\">Giá</th>");
		out.append("<th scope=\"col\">Lượt bán</th>");
		out.append("<th scope=\"col\">Doanh thu</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		
		ArrayList<LightObject> listSelling = new ArrayList<>();
		listSelling = lf.get5MaxSales_count();	
		for(LightObject item : listSelling) {
			out.append("<tr>");
			out.append("<th scope=\"row\"><a href=\"#\"><img src=\"img/light_img/"+item.getLight_img()+".jpg\" alt=\"\"></a></th>");
			out.append("<td><a href=\"#\" class=\"text-info fw-bold\">"+item.getLight_name()+"</a></td>");
			DecimalFormat df = new DecimalFormat("#,###");
			out.append("<td>"+df.format(item.getLight_price())+"</td>");
			out.append("<td class=\"fw-bold\">"+item.getSales_count()+"</td>");
			out.append("<td>"+df.format(item.getLight_revenue())+"</td>");
			out.append("</tr>");
			out.append("<tr>");
		}

		out.append("</tbody>");
		out.append("</table>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Top Selling -->");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Left side columns -->");
		out.append("");
		out.append("<!-- Right side columns -->");
		out.append("<div class=\"col-lg-4\">");
		out.append("");
		out.append("<!-- Recent Activity -->");
		out.append("<div class=\"card\">");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Hôm nay</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Năm</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"card-body\">");
		out.append("<h5 class=\"card-title\">Hoạt động gần đây <span>| Hôm nay</span></h5>");
		out.append("");
		out.append("<div class=\"activity\">");
		out.append("");
		out.append("<div class=\"activity-item d-flex\">");
		out.append("<div class=\"activite-label\">32 phút</div>");
		out.append("<i class='bi bi-circle-fill activity-badge text-success align-self-start'></i>");
		out.append("<div class=\"activity-content\">");
		out.append("Cập nhật <a href=\"#\" class=\"fw-bold text-dark\">sản phẩm</a> ");
		out.append("</div>");
		out.append("</div><!-- End activity item-->");
		out.append("");
		out.append("<div class=\"activity-item d-flex\">");
		out.append("<div class=\"activite-label\">43 phút</div>");
		out.append("<i class='bi bi-circle-fill activity-badge text-danger align-self-start'></i>");
		out.append("<div class=\"activity-content\">");
		out.append("Xem dữ liệu khách hàng, xem đánh giá và phản hồi của khách hàng");
		out.append("</div>");
		out.append("</div><!-- End activity item-->");
		out.append("");
		out.append("<div class=\"activity-item d-flex\">");
		out.append("<div class=\"activite-label\">3 giờ</div>");
		out.append("<i class='bi bi-circle-fill activity-badge text-primary align-self-start'></i>");
		out.append("<div class=\"activity-content\">");
		out.append("Cập nhật sản phẩm bán chạy, Thêm sản phẩm mới");
		out.append("</div>");
		out.append("</div><!-- End activity item-->");
		out.append("");
		out.append("<div class=\"activity-item d-flex\">");
		out.append("<div class=\"activite-label\">1 ngày</div>");
		out.append("<i class='bi bi-circle-fill activity-badge text-info align-self-start'></i>");
		out.append("<div class=\"activity-content\">");
		out.append(
				"Cập nhật bảng doanh số của tháng những <a href=\"#\" class=\"fw-bold text-dark\">Sản phẩm</a> theo danh mục");
		out.append("</div>");
		out.append("</div><!-- End activity item-->");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Recent Activity -->");
		out.append("");
		out.append("");
//		out.append("<!-- News & Updates Traffic -->");
//		out.append("<div class=\"card\">");
//		out.append("<div class=\"filter\">");
//		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
//		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
//		out.append("<li class=\"dropdown-header text-start\">");
//		out.append("<h6>Filter</h6>");
//		out.append("</li>");
//		out.append("");
//		out.append("<li><a class=\"dropdown-item\" href=\"#\">Hôm nay</a></li>");
//		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong tháng</a></li>");
//		out.append("<li><a class=\"dropdown-item\" href=\"#\">Trong năm</a></li>");
//		out.append("</ul>");
//		out.append("</div>");
//		out.append("");
//		out.append("<div class=\"card-body pb-0\">");
//		out.append("<h5 class=\"card-title\">Tin tức cập nhật<span>| Hôm nay</span></h5>");
//		out.append("");
//		out.append("<div class=\"news\">");
//		LightFunction uu = new LightFunctionImpl(cp);
//		ArrayList<LightObject> list22 = uu.getAccount();
//		List<LightObject> last5 = list22.subList(Math.max(list22.size() - 5, 0), list22.size());
//		for(LightObject Item1 : last5) {
//			out.append("<div class=\"post-item clearfix\">");
//			out.append("<img src=\"img/light_img/"+ Item1.getLight_img()+".jpg\" alt=\"\">");
//			out.append("<h4><a href=\"GocDecore/Deal\"></a></h4>");
//			out.append("<p>"+ Item1.getLight_name()+"</p>");
//		}
//		out.append("</div>");
//		out.append("</div><!-- End sidebar recent posts-->");
//		out.append("");
//		out.append("</div>");
//		out.append("</div><!-- End News & Updates -->");
//		out.append("");
//		out.append("");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
//		out.append("</div>");
		out.append("<!-- Budget Report -->");
		out.append("<div class=\"card\">");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Today</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Month</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">This Year</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("<div class=\"card-body pb-0\">");
		out.append("<h5 class=\"card-title\">Báo cáo ngân sách <span>| Trong tháng</span></h5>");
		out.append("<div id=\"budgetChart\" style=\"min-height: 400px;\" class=\"echart\"></div>");
		out.append("<script>");
		out.append("document.addEventListener(\"DOMContentLoaded\", () => {");
		out.append("var budgetChart = echarts.init(document.querySelector(\"#budgetChart\")).setOption({");
		out.append("legend: {");
		out.append("data: ['Allocated Budget', 'Actual Spending']");
		out.append("},");
		out.append("radar: {");
		// out.append("shape: 'circle',");
		out.append("indicator: [{");
		out.append("name: 'Sales',");
		out.append("max: 6500");
		out.append("},");
		out.append("{");
		out.append("name: 'Administration',");
		out.append("max: 16000");
		out.append("},");
		out.append("{");
		out.append("name: 'Information Technology',");
		out.append("max: 30000");
		out.append("},");
		out.append("{");
		out.append("name: 'Customer Support',");
		out.append("max: 38000");
		out.append("},");
		out.append("{");
		out.append("name: 'Development',");
		out.append("max: 52000");
		out.append("},");
		out.append("{");
		out.append("name: 'Marketing',");
		out.append("max: 25000");
		out.append("}]");
		out.append("},");
		out.append("series: [{");
		out.append("name: 'Budget vs spending',");
		out.append("type: 'radar',");
		out.append("data: [{");
		out.append("value: [4200, 3000, 20000, 35000, 50000, 18000],");
		out.append("name: 'Allocated Budget'");
		out.append("},");
		out.append("{");
		out.append("value: [5000, 14000, 28000, 26000, 42000, 21000],");
		out.append("name: 'Actual Spending'");
		out.append("}]");
		out.append("}]");
		out.append("});");
		out.append("});");
		out.append("</script>");
		out.append("</div>");
		out.append("</div><!-- End Budget Report -->");

		
		out.append("<!-- Website Traffic -->");
		out.append("<div class=\"card\">");
		out.append("<div class=\"filter\">");
		out.append("<a class=\"icon\" href=\"#\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-three-dots\"></i></a>");
		out.append("<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow\">");
		out.append("<li class=\"dropdown-header text-start\">");
		out.append("<h6>Filter</h6>");
		out.append("</li>");
		out.append("");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Hôm nay</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Tháng</a></li>");
		out.append("<li><a class=\"dropdown-item\" href=\"#\">Năm</a></li>");
		out.append("</ul>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"card-body pb-0\">");
		out.append("<h5 class=\"card-title\">Lượng truy cập website<span>| Hôm nay</span></h5>");
		out.append("");
		out.append("<div id=\"trafficChart\" style=\"min-height: 400px;\" class=\"echart\"></div>");
		out.append("");
		out.append("<script>");
		out.append("document.addEventListener(\"DOMContentLoaded\", () => {");
		out.append("echarts.init(document.querySelector(\"#trafficChart\")).setOption({");
		out.append("tooltip: {");
		out.append("trigger: 'item'");
		out.append("},");
		out.append("legend: {");
		out.append("top: '5%',");
		out.append("left: 'center'");
		out.append("},");
		out.append("series: [{");
		out.append("name: 'Access From',");
		out.append("type: 'pie',");
		out.append("radius: ['40%', '70%'],");
		out.append("avoidLabelOverlap: false,");
		out.append("label: {");
		out.append("show: false,");
		out.append("position: 'center'");
		out.append("},");
		out.append("emphasis: {");
		out.append("label: {");
		out.append("show: true,");
		out.append("fontSize: '18',");
		out.append("fontWeight: 'bold'");
		out.append("}");
		out.append("},");
		out.append("labelLine: {");
		out.append("show: false");
		out.append("},");
		out.append("data: [{");
		out.append("value: 1048,");
		out.append("name: 'Search Engine'");
		out.append("},");
		out.append("{");
		out.append("value: 735,");
		out.append("name: 'Direct'");
		out.append("},");
		out.append("{");
		out.append("value: 580,");
		out.append("name: 'Email'");
		out.append("},");
		out.append("{");
		out.append("value: 484,");
		out.append("name: 'Union Ads'");
		out.append("},");
		out.append("{");
		out.append("value: 300,");
		out.append("name: 'Video Ads'");
		out.append("}");
		out.append("]");
		out.append("}]");
		out.append("});");
		out.append("});");
		out.append("</script>");
		out.append("");
		out.append("</div>");
		out.append("</div><!-- End Website Traffic -->");

		

		out.append("</div><!-- End Right side columns -->");
		out.append("");

		out.append("</div>");
		out.append("</section>");
		out.append("");
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
		doGet(request, response);
	}

	
		
}
