package com.acme.urproviderwebservices.users.supplier.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResource {
    private Long id;
    private String SupplierName ;
    private String Name ;
    private String LastName ;
    private String Email;
    private String Address ;
    private long Ruc ;
    private String Category ;
    private String Description ;
    private long Phone ;
    private String Password ;
    private long Likes ;
}
