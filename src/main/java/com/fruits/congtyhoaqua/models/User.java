package com.fruits.congtyhoaqua.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fruits.congtyhoaqua.bases.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "account",unique = true)
    @NotBlank
    private String account;

    @Column(name = "password")
    @NotBlank

    private String password;
    @Column(name = "pre_name")
    @Nationalized
    @NotBlank
    private String preName;

    @Column(name = "name")
    @Nationalized
    @NotBlank
    private String name;
    
    @Column(name = "age")

    private Integer age;

    @Column(name = "address")
    @NotBlank
    @Length(max = 200000)
    private String address;

    @Column(name = "birthday")
    @NotBlank
    private String birthday;

    @Column(name = "avatar")
    @Length(max = 200000)

    private String avatar;

    @Column(name = "phoneNumber")
    @NotBlank
    private String phoneNumber;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private  Set<Bill> bills;

}
