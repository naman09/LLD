package Services;

import Models.Product;
import Models.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductCatalogService {
    Map<String, List<Product>> productsByName;
    Map<ProductCategory, List<Product>> productsByCategory;

    List<Product> searchProductByName(String name) {
        return productsByName.get(name);
    }
    List<Product> searchProductByCategory(ProductCategory category) {
        return productsByCategory.get(category);
    }

    void addNewProduct(Product product) {
        if (!productsByName.containsKey(product.getName())) {
            productsByName.put(product.getName(), new ArrayList<>());
            productsByCategory.put(product.getProductCategory(), new ArrayList<>());
        }
        productsByName.get(product.getName()).add(product);
        productsByName.get(product.getProductCategory()).add(product);
    }

}
