package com.huangtianci.myframeprototype.mvc.repository;

import com.huangtianci.myframeprototype.mvc.model.SecUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Huang Tianci
 * 用户 repository
 */
public interface UserRepository extends CrudRepository<SecUser,String> {
}
