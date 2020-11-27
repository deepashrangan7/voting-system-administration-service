package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.UserRoleMapping;

@Repository
public interface SeedRepository extends JpaRepository<UserRoleMapping, Integer> {

}
