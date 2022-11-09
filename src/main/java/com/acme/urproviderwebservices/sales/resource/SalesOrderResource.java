package com.acme.urproviderwebservices.sales.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderResource {

    private Long id;
    private String status;
}
