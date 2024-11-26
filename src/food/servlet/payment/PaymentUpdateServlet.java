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


@WebServlet("/updatepayment")
public class PaymentUpdateServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("payment_id"));
		String payment_method = request.getParameter("payment_method");
		String amount = request.getParameter("amount");
		String payment_date = request.getParameter("payment_date");
		String card_number = request.getParameter("card_number");
		String card_holder_name = request.getParameter("card_holder_name");
	

		Payment payment = new Payment(id,payment_method, amount, payment_date, card_number ,card_holder_name);
		try {
			PaymentDao.updatePayment(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listpayment");
		
	}

	

}