package com.vice.springboot.consultant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data // generates getters, setters, equals, hashCode, toString
@NoArgsConstructor // generates a no-args constructor (required by JPA)
@AllArgsConstructor // generates a constructor with all fields
public class ConsultantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )

    private Integer consultantId;
    private String consultantName;
    private String availability;
    private String profilePicture;
    private Integer consultantWorkLoad;


    public ConsultantModel(String consultantName,
                           String availability,
                           String profilePicture,
                           Integer consultantWorkLoad) {
        this.consultantName=consultantName;
        this.availability=availability;
        this.profilePicture=profilePicture;
        this.consultantWorkLoad=consultantWorkLoad;
    }

    @Override
    public String toString() {
        return "EntriesModel [consultantId=" + consultantId + ", consultantName=" + consultantName + ", availability=" + availability + ", profilePicture=" + profilePicture + ", consultantWorkLoad=" + consultantWorkLoad + "]";
    }


}

