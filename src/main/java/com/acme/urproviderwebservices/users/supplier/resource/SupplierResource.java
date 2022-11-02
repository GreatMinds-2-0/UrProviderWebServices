package com.acme.urproviderwebservices.users.supplier.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResource {
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
}
