package com.acme.urproviderwebservices.inventory.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateProductResource {

    @NotNull
    @NotBlank
    private String name;

    private String category;

    private String description;

    private int numberOfSales;


}
