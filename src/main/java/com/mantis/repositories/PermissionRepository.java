package com.mantis.repositories;

import com.mantis.data.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    @Query(value = "select * from tbl_permission where name = :name",nativeQuery = true)
    Permission findPermByName(@Param("name") String name);

}
