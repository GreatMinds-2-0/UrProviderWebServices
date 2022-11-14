package com.acme.urproviderwebservices.users.supplier.domain.model.entity;

import com.acme.urproviderwebservices.inventory.domain.model.entity.Product;
import com.acme.urproviderwebservices.shared.domain.model.BaseModel;
import com.acme.urproviderwebservices.shared.exception.ResourceValidationException;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String supplierName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String lastName;


    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;


    @NotNull
    @NotBlank
    @Size(max = 100)
    private String address ;

    @NotNull
    @NotBlank
    private long ruc ;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String category ;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String description ;

    @NotNull
    @NotBlank
    private long phone ;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String Password;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String image;

    @NotNull
    @NotBlank
    public long Likes ;







    // Relationship

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER, mappedBy = "supplier")
    private Set<Product> products = new HashSet<>();

    public Supplier addProduct(String productName) {
        if (products == null) {
            products = new HashSet<>();
        }

        if (!products.isEmpty()) {
            if(products.stream().anyMatch(product -> product.getName().equals(productName)))
                throw new ResourceValidationException("Product", "A product with the same name already exists");
        }

        products.add(new Product()
                .withName(productName)
                .withSupplier(this));

        return this;
    }
}
