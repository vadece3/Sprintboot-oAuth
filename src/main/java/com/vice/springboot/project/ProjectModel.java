package com.vice.springboot.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data // generates getters, setters, equals, hashCode, toString
@NoArgsConstructor // generates a no-args constructor (required by JPA)
@AllArgsConstructor // generates a constructor with all fields
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )

    private Integer id;
    private Integer consultantId;
    private Integer consumerId;
    private String projectName;
    private String startDate;
    private String endDate;
    private String Status;


    public ProjectModel(String projectName,
                        Integer consultantId,
                        Integer consumerId,
                        String startDate,
                        String endDate,
                        String Status) {
        this.projectName=projectName;
        this.consultantId=consultantId;
        this.consumerId=consumerId;
        this.startDate=startDate;
        this.endDate=endDate;
        this.Status=Status;
    }

}

