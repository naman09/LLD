package Services;

import Models.Product;
import Models.ProductReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductReviewService {
    Map<Product, List<ProductReview>> productReviews;
    void addProductReview(Product product, ProductReview review) {
        if (!productReviews.containsKey(product)) {
            productReviews.put(product, new ArrayList<>());
        }
        productReviews.get(product).add(review);
    }
}
