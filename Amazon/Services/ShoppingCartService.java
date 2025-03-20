package Services;

import Models.Product;
import Models.User;

import java.util.*;

public class ShoppingCartService {
    Map<User, Set<Product>> userShoppingCart;

    void addProductToCart(Product product, User user) {
        if (!userShoppingCart.containsKey(user)) {
            userShoppingCart.put(user, new HashSet<>());
        }
        userShoppingCart.get(user).add(product);
    }
    void removeProductToCart(Product product, User user) {
        if (!userShoppingCart.containsKey(user)) {
            throw new IllegalArgumentException("user does not have shopping cart");
        }
        if (!userShoppingCart.get(user).contains(product)) {
            throw new IllegalArgumentException("user cart does not have the product " + product.toString());
        }
        userShoppingCart.get(user).remove(product);
    }
}
