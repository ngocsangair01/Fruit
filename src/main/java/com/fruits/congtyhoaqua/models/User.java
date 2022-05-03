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
    @Nationalized
    private String account;

    @Column(name = "password")
    @NotBlank
    @Nationalized
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
    @Nationalized
    private String address;

    @Column(name = "birthday")
    @NotBlank
    @Nationalized
    private String birthday;

    @Column(name = "avatar")
    @Length(max = 200000)
    private String avatar;

    @Column(name = "phoneNumber")
    @NotBlank
    @Nationalized
    private String phoneNumber;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private  Set<Bill> bills;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "id_user",referencedColumnName = "id_user"),
//            inverseJoinColumns = @JoinColumn(name = "id_role",referencedColumnName = "id_role"))
////    @JsonIgnore
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Role> roles;

}
