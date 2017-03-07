package com.huangtianci.myframeprototype.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long id;

    @NotNull
    private String name;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "userName", referencedColumnName = "userName")})
    private List<User> userList;
}
