package com.franco.tu_cv_spring_boot.tuCV.model;

import lombok.Data;

@Data
public class PersonalDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String professionalProfile;

}
