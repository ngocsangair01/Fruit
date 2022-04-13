package com.fruits.congtyhoaqua.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "account not null")
    private String account;


    @NotBlank(message = "password not null")
    private String password;


    @NotBlank(message = "pre name not null")
    private String preName;


    @NotBlank(message = "name not null")
    private String name;


    private Integer age;


    @Length(max = 200000)
    private String address;


    @NotBlank(message = "birthday not null")
    private String birthday;


    @Length(max = 200000)
    private MultipartFile avatar;


    @NotBlank(message = "phone number not null")
    private String phoneNumber;
}
