package Models;

public class Product {
    String id;
    String name;
    ProductCategory productCategory;
    Double amount;
    Integer itemCount;
    User seller;

    public Double getAmount() {
        return this.amount;
    }

    public Integer getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getName() {
        return this.name;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return this.id == product.id;
    }
}
