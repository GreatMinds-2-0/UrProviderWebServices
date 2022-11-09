package com.acme.urproviderwebservices.sales.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateReviewResource {

    @NotNull
    @NotBlank
    private String title;


    private String description;

}
