package product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Product {

    private String name;
    private String color;
    private int price;
    private LocalDate available;

}
