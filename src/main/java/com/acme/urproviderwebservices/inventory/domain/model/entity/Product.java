package com.acme.urproviderwebservices.inventory.domain.model.entity;

import com.acme.urproviderwebservices.shared.domain.model.BaseModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    //private Long supplierId;
    //private String image;
    //private Bool available;
    private String category;
    private String description;
    private int numberOfSales;

    //Relationship with supplier
}
