package com.long1dep.comp_sell.repository;

import com.long1dep.comp_sell.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
