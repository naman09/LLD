package Services;

import CustomExceptions.PaymentException;
import CustomExceptions.CancelOrderException;
import CustomExceptions.ProductOutOfStockException;
import Models.Order;
import Models.OrderStatus;
import Models.Product;
import Models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderService {
    Map<User, List<Order>> userOrders;
    IPaymentService paymentService;
    void placeOrder(Product product, User user, String shippingAddress, Date orderDate) throws ProductOutOfStockException, PaymentException{
        if (product.getItemCount() == 0) {
            throw new ProductOutOfStockException();
        }
        if (!paymentService.processPayment(product.getAmount())) {
            throw new PaymentException();
        }
        if(!userOrders.containsKey(user)) {
            userOrders.put(user, new ArrayList<>());
        }
        product.setItemCount(product.getItemCount()-1);
        userOrders.get(user).add(new Order(product, orderDate, shippingAddress, OrderStatus.IN_PROGRESS));
    }

    void cancelOrder(Order order) throws CancelOrderException{
        if (order.getOrderStatus() == OrderStatus.FULFILLED) {
            throw new CancelOrderException("Order " + order.toString() + " cannot be cancelled as it is already fulfilled");
        }
        Product product = order.getProduct();
        product.setItemCount(product.getItemCount()+1);
        order.setOrderStatus(OrderStatus.CANCELLED);
        //initiate refund
    }
    void changeShippingStatus(Order order, OrderStatus orderStatus) {
        order.setOrderStatus(orderStatus);
    }

    OrderStatus getShippingStatus(Order order) {
        return order.getOrderStatus();
    }
}
