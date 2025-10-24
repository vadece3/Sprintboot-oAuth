package com.vice.springboot.customer;

import lombok.Data;
import java.util.Set;

@Data
public class ConsumerRequest {
    private String customerName;
    private String customerCity;
    private String contactsPerson;
    private String customerAddress;
    private String geolocalisation;
    private String dateOfBirth;
    private Set<Integer> roleIds; // JSON will contain role IDs here
}

