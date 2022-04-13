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
public class ManufactureDTO {
    @Length(max = 200000)
    @NotBlank(message = "name not null")
    private String name;


    @Length(max = 200000)
    private String address;

    private String phoneNumber;
}
