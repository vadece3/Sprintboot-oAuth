package com.vice.springboot.customer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data // generates getters, setters, equals, hashCode, toString
@NoArgsConstructor // generates a no-args constructor (required by JPA)
@AllArgsConstructor // generates a constructor with all fields
public class ConsumerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )

    private Integer consumerId;
    private String customerName;
    private String customerCity;
    private String contactsPerson;
    private String customerAddress;
    private String geolocalisation;
    private String dateOfBirth;


    public ConsumerModel(String customerName,
                         String customerCity,
                         String contactsPerson,
                         String customerAddress,
                         String geolocalisation,
                         String dateOfBirth) {
        this.customerName=customerName;
        this.customerCity=customerCity;
        this.contactsPerson=contactsPerson;
        this.customerAddress=customerAddress;
        this.geolocalisation=geolocalisation;
        this.dateOfBirth=dateOfBirth;
    }

    @Override
    public String toString() {
        return "customer [customerId=" + consumerId + ", customerName=" + customerName + ", customerCity=" + customerCity + ", contactsPerson=" + contactsPerson + ", customerAddress=" + customerAddress + ", geolocalisation=" + geolocalisation + ", dateOfBirth=" + dateOfBirth + "]";
    }


}

