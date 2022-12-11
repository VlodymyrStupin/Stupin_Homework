package ua.stupin.entity;


import lombok.*;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Product {
    private ObjectId id;
    @NonNull
    private String name;
    @NonNull
    private int quantity;
    @NonNull
    private BigDecimal price;
}
