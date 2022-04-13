package com.fruits.congtyhoaqua.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @Length(max = 200000)
    @NotBlank(message = "name not null")
    private String name;


    @Length(max = 200000)
    @NotBlank(message = "address not null")
    private String address;

    private String phoneNumber;

    private String email;

    private Integer numberOfPurchases;
}
