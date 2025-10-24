package com.vice.springboot.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vice.springboot.customer.Consumer;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<Consumer> consumers;
}

