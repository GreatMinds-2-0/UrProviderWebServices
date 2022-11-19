package com.acme.urproviderwebservices.users.store.domain.model.entity;

import com.acme.urproviderwebservices.shared.domain.model.BaseModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")
public class Store extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 60)
    private String storeName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;


    @Size(max = 60)
    private String lastName;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;


    @Size(max = 60)
    private String address;

    private long phone;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String password;


    @NotBlank
    @Size(max = 200)
    private String image;
}
