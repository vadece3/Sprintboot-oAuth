package com.vice.springboot.customer;

import com.vice.springboot.Role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consumers")
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consumerId;

    private String customerName;
    private String customerCity;
    private String contactsPerson;
    private String customerAddress;
    private String geolocalisation;
    private String dateOfBirth;

    // NEW: many-to-many mapping
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "consumer_roles",
            joinColumns = @JoinColumn(name = "consumer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}

