package food.servlet.pdf;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.PaymentDao;
@WebServlet("/paymentpdf")
public class PaymentPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDao PaymentDao;

	public void init() {
		PaymentDao = new PaymentDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		RequestDispatcher dispatcher = request.getRequestDispatcher("ExportpaymentPdf.jsp");
		dispatcher.forward(request, response);
	}

	
}