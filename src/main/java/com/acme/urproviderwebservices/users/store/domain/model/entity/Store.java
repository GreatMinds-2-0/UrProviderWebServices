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
    @NotBlank
    @Size(max = 60)
    private String name;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String storeName;
    @NotNull
    @NotBlank
    @Column(unique = true)
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String lastName;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String address;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private long phone;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String password;
    @NotNull
    @NotBlank
    @Size(max = 60)
    public String image;

}
