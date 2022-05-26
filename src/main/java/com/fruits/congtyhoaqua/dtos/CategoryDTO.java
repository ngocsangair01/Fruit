package com.fruits.congtyhoaqua.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @NotBlank(message = "name not null")
    @Nationalized
    private String name;


    @Length(max = 5000)
    @Nationalized
    private String description;
}
