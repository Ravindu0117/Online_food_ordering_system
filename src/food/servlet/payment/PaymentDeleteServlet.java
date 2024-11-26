package food.servlet.payment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.PaymentDao;
import food.model.Payment;

@WebServlet("/deletepayment")
public class PaymentDeleteServlet extends HttpServlet {
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

		int payment_id = Integer.parseInt(request.getParameter("payment_id"));
		System.out.println("payment_id"+payment_id);
		System.out.println("deleting .....................");
		try {
			PaymentDao.deletePayment(payment_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listpayment");
	}

	

}