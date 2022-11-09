package com.acme.urproviderwebservices.sales.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateSalesOrderResource {

    @NotNull
    @NotBlank
    private String status;
}
