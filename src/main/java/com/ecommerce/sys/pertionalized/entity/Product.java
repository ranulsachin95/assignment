package com.ecommerce.sys.pertionalized.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Product Id cannot be null")
    @NotBlank(message = "Product Id is mandatory")
    private String productId;

    @NotNull(message = "Category cannot be null")
    @NotBlank(message = "Category is mandatory")
    private String category;

    @NotNull(message = "Brand cannot be null")
    @NotBlank(message = "Brand is mandatory")
    private String brand;
}
