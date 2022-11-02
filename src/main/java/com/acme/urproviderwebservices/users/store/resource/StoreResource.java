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
    private String email;
    private Long phoneNumber;
}
