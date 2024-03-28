package com.ecommerce.sys.pertionalized.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shopper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Shopper Id cannot be null")
    @NotBlank(message = "Shopper Id is mandatory")
    private String shopperId;


    @OneToMany(mappedBy="shopper")
    private List<Shelf> shelf;


}
