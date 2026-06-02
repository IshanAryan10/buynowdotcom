package com.dailycodework.buynowdotcom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//Entity informs that this class will become database table
//AllArgsConstructor is not used as we are not going to add images or new thing while adding product meaning we can do those things later too
@Entity
public class Product
{
    //Id means primary key
    @Id
    //Generated Value causes increment in value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> Images;

    public Product(String name, String brand, BigDecimal price, int inventory, String description,Category category ) {
        this.category = category;
        this.description = description;
        this.inventory = inventory;
        this.price = price;
        this.brand = brand;
        this.name = name;



    }
}
