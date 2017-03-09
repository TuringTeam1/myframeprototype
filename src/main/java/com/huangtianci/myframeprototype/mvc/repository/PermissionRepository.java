package com.huangtianci.myframeprototype.mvc.repository;

import com.huangtianci.myframeprototype.mvc.model.SecPermission;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Huang Tianci
 * 权限repository，spring data在项目启动的时候会生成具体的实现
 */
public interface PermissionRepository extends CrudRepository<SecPermission,Long> {
}
