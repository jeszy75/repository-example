package product;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import com.github.javafaker.Faker;

public class Main {

    public static void main(String[] args) throws IOException {
        var repository = new ProductRepository();
        var faker = new Faker();
        for (var i = 0; i < 10; i++) {
            var product = Product.builder()
                    .name(faker.commerce().productName())
                    .color(faker.commerce().color())
                    .price(faker.number().numberBetween(1, 1000))
                    .available(LocalDate.now().minusDays(faker.number().numberBetween(0, 365)))
                    .build();
            repository.add(product);
        }
        System.out.println("All products:");
        repository.findAll().forEach(System.out::println);
        repository.saveToFile(new File("products.json"));
        repository.clear();
        repository.loadFromFile(new File("products.json"));
        System.out.println("Cheapest products:");
        repository.findCheapest(3).forEach(System.out::println);
    }

}
