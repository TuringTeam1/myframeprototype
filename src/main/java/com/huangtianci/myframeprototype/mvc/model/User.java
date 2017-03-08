package com.huangtianci.myframeprototype.mvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @NotNull
    @Getter
    @Setter
    private String userName;

    @NotNull
    @Setter
    private String passWord;

    @NotNull
    @Getter
    @Setter
    private String firstName;

    @NotNull
    @Getter
    @Setter
    private String lastName;

    @NotNull
    @Getter
    @Setter
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "userList", fetch = FetchType.LAZY)
    @Setter
    private List<Role> roleList;

    @JsonIgnore    //生成json不包含此字段,必须打在Getter上面
    public String getPassWord() {
        return passWord;
    }

}
