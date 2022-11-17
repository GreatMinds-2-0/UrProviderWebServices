package com.acme.urproviderwebservices.inventory.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResource {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String category;

    private String description;

    @NotNull
    @NotBlank
    private String image;

    private int numberOfSales;

    private boolean available;
}
