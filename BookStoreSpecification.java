public interface BookStoreSpecification {
    void restockProduct(int productId, int quantity);
    double inventoryValue();
}
