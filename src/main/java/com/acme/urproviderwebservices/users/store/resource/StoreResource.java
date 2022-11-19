package com.acme.urproviderwebservices.users.store.resource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StoreResource {
    private Long id;
    private String name;
    private String lastName;
    private String image;
    private String storeName;
    private String email;
    private String address;
    private long phone;
    private String password;
}
