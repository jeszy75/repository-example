package product;

import java.util.Comparator;
import java.util.List;

import util.repository.GsonRepository;

public class ProductRepository extends GsonRepository<Product> {

    public ProductRepository() {
        super(Product.class);
    }

    public List<Product> findCheapest(int n) {
        return elements.stream()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .limit(n)
                .toList();
    }

}
