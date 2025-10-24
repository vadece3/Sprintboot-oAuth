package com.vice.springboot.entries;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data // generates getters, setters, equals, hashCode, toString
@NoArgsConstructor // generates a no-args constructor (required by JPA)
@AllArgsConstructor // generates a constructor with all fields
public class EntriesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )

    private Integer entriesId;
    private Integer consumerId;
    private Integer projectId;
    private String dateOfentry;
    private String hourOfEntry;


    public EntriesModel(Integer consumerId,
                        Integer projectId,
                        String dateOfentry,
                        String hourOfEntry) {

        this.consumerId=consumerId;
        this.projectId=projectId;
        this.dateOfentry=dateOfentry;
        this.hourOfEntry=hourOfEntry;
    }

}

