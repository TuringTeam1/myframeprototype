package com.huangtianci.myframeprototype.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author Huang Tianci
 * 权限实体类
 */
@Entity
@Table(name = "sec_permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecPermission implements Serializable {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long id;

    @Column(name="name", unique=true, nullable=false)
    @NotNull
    private String name;

    @Column(name="permission", unique=true, nullable=false)
    @NotNull
    private String permission;

    @NotNull
    private String type;//权限类型，0．表示目录　1，表示菜单．2，表示按扭

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private SecPermission parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SecPermission> childrenList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "permissionList")
    private List<SecRole> secRoleList;


}
