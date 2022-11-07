package com.acme.urproviderwebservices.sales.domain.model.entity;

import com.acme.urproviderwebservices.shared.domain.model.BaseModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salesOrders")
public class SalesOrder extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean status;

    //Relationship with Suppliers and Stores
}
