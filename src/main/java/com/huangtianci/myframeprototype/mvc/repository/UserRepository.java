package com.huangtianci.myframeprototype.mvc.repository;

import com.huangtianci.myframeprototype.mvc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
