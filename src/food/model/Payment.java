package food.model;

public class Payment {
    private int payment_id;
    private String payment_method;
    private String amount;
    private String payment_date;
    private String card_number;
    private String card_holder_name;

    public Payment(int payment_id, String payment_method, String amount, String payment_date, String card_number, String card_holder_name) {
        this.payment_id = payment_id;
        this.payment_method = payment_method;
        this.amount = amount;
        this.payment_date = payment_date;
        this.card_number = card_number;
        this.card_holder_name = card_holder_name;
    }

    public Payment(String payment_method, String amount, String payment_date, String card_number, String card_holder_name) {
        this.payment_method = payment_method;
        this.amount = amount;
        this.payment_date = payment_date;
        this.card_number = card_number;
        this.card_holder_name = card_holder_name;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_holder_name() {
        return card_holder_name;
    }

    public void setCard_holder_name(String card_holder_name) {
        this.card_holder_name = card_holder_name;
    }
}
