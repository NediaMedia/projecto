

public class DVD extends Product {
    private String category;

    public DVD(String name, String category, double price, int stock) {
        super(name, price, stock);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
