package com.acme.urproviderwebservices.users.supplier.domain.model.entity;

import com.acme.urproviderwebservices.inventory.domain.model.entity.Product;
import com.acme.urproviderwebservices.shared.domain.model.BaseModel;
import com.acme.urproviderwebservices.shared.exception.ResourceValidationException;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;


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
    @Size(max = 200)
    private String image;

    @NotNull
    @NotBlank
    @Column(unique = true)
    @Size(max = 60)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String address;


    private long ruc;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String category;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;



    private long phone;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String password;
    private int likes = 1;

    // Relationship

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER, mappedBy = "supplier")
    private List<Product> products = new ArrayList<>();

    //Create Product by supplier
    public Supplier addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }


        if (!products.isEmpty()) {
            if(products.stream().anyMatch(products -> products.getName().equals(product.getName())))
                throw new ResourceValidationException("Product", "A product with the same name already exists");
        }
        products.add(new Product().withName(product.getName())
                        .withCategory(product.getCategory())
                        .withImage(product.getImage())
                        .withAvailable(product.isAvailable())
                        .withDescription(product.getDescription())
                .withSupplier(this));

        return this;
    }
    //Delete Product by supplier
    public Supplier deleteProduct(long productId){
        Product product= products.stream().filter(p -> p.getId()==productId).findAny().orElse(null);
        products.remove(product);
        return this;
    }

    //Update Product by supplier
    public  Supplier updateProduct(Product product,Long productId ){
        if (!products.isEmpty()) {
            if(products.stream().anyMatch(products -> (products.getName().equals(product.getName()))&&(!products.getId().equals(productId))))
                throw new ResourceValidationException("Product", "A product with the same name already exists");
        }

        Product item= products.stream().filter(p -> p.getId().equals(productId)).findAny().orElse(null);
        int index= products.indexOf(item);
       products.set(index,item
               .withName(product.getName())
               .withCategory(product.getCategory())
               .withImage(product.getImage())
               .withAvailable(product.isAvailable())
               .withDescription(product.getDescription()));

        return this;
    }
}
