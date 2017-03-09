package com.huangtianci.myframeprototype.mvc.repository;

import com.huangtianci.myframeprototype.mvc.model.SecRole;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Huang Tianci
 * 角色 repository
 */
public interface RoleRepository extends CrudRepository<SecRole,Long> {
}
