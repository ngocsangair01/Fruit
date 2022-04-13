package com.fruits.congtyhoaqua.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitDTO {
    @NotBlank(message = "name not null")
    private String name;


    @Length(max = 200000)
    private MultipartFile avatar;


    @Length(max = 200000)
    private String description;


    @NotBlank(message = "expiry not null")
    private String expiry;


    @NotBlank(message = "amount not null")
    private Double amount;


    @NotBlank(message = "price in not null")
    private Integer priceIn;


    @NotBlank(message = "price out not null")
    private Integer priceOut;

    Set<Integer> idCategories;
}
