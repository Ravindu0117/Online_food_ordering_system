package food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food.dbconnection.DbConnection;
import food.model.Payment;

public class PaymentDao {

    private static final String INSERT_PAYMENTS_SQL = "INSERT INTO payment " +
            "(payment_method, amount, payment_date, card_number, card_holder_name) " +
            "VALUES (?, ?, ?, ?, ?);";

    private static final String SELECT_PAYMENT_BY_ID = "SELECT payment_id, payment_method, amount, payment_date, card_number, card_holder_name " +
            "FROM payment WHERE payment_id = ?;";

    private static final String SELECT_ALL_PAYMENTS = "SELECT * FROM payment;";

    private static final String DELETE_PAYMENT_SQL = "DELETE FROM payment WHERE payment_id = ?;";

    private static final String UPDATE_PAYMENT_SQL = "UPDATE payment SET payment_method = ?, amount = ?, payment_date = ?, " +
            "card_number = ?, card_holder_name = ? WHERE payment_id = ?;";

    public PaymentDao() {
    }

    DbConnection dbconnection = new DbConnection();

    public void insertPayment(Payment payment) throws SQLException {
        System.out.println(INSERT_PAYMENTS_SQL);

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENTS_SQL)) {
            preparedStatement.setString(1, payment.getPayment_method());
            preparedStatement.setString(2, payment.getAmount());
            preparedStatement.setString(3, payment.getPayment_date());
            preparedStatement.setString(4, payment.getCard_number());
            preparedStatement.setString(5, payment.getCard_holder_name());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }
    }

    public Payment selectPayment(int id) {
        Payment payment = null;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String payment_method = rs.getString("payment_method");
                String amount = rs.getString("amount");
                String payment_date = rs.getString("payment_date");
                String card_number = rs.getString("card_number");
                String card_holder_name = rs.getString("card_holder_name");

                payment = new Payment(id, payment_method, amount, payment_date, card_number, card_holder_name);
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }

        return payment;
    }

    public List<Payment> selectAllPayments() {
        List<Payment> listpayment = new ArrayList<>();

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYMENTS)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int payment_id = rs.getInt("payment_id");
                String payment_method = rs.getString("payment_method");
                String amount = rs.getString("amount");
                String payment_date = rs.getString("payment_date");
                String card_number = rs.getString("card_number");
                String card_holder_name = rs.getString("card_holder_name");

                listpayment.add(new Payment(payment_id, payment_method, amount, payment_date, card_number, card_holder_name));
            }
        } catch (SQLException e) {
            dbconnection.printSQLException(e);
        }

        return listpayment;
    }

    public boolean deletePayment(int id) throws SQLException {
        boolean rowDeleted;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENT_SQL)) {
            statement.setInt(1, id);
            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    public boolean updatePayment(Payment payment) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PAYMENT_SQL)) {
            statement.setString(1, payment.getPayment_method());
            statement.setString(2, payment.getAmount());
            statement.setString(3, payment.getPayment_date());
            statement.setString(4, payment.getCard_number());
            statement.setString(5, payment.getCard_holder_name());
            statement.setInt(6, payment.getPayment_id());

            rowUpdated = statement.executeUpdate() > 0;
        }

        return rowUpdated;
    }
}
