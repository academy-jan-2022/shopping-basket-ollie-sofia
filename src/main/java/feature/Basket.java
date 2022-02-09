package feature;

public class Basket {
    public Integer userId;
    public String date;
    private String total = "0";

    public Basket(Integer userId, String date) {
        this.userId = userId;
        this.date = date;
    }

    public String checkContent() {
        String header = "- Basket Created on " + this.date + "\n";
        String total = "- Total: £" + this.total;
        return header + total;
    }
}
