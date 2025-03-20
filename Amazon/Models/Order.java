package Models;

import java.util.Date;

public class Order {
    Product product;
    Date orderDate;
    String shippingAddress;
    OrderStatus orderStatus;

    public Order(Product product, Date orderDate, String shippingAddress, OrderStatus orderStatus) {
        this.product = product;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderStatus = orderStatus;
    }
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
