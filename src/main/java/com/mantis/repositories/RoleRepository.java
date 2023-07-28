package com.mantis.repositories;

import com.mantis.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "select * from tbl_role where name = :name",nativeQuery = true)
    Role findRoleByName(@Param("name") String name);


}
