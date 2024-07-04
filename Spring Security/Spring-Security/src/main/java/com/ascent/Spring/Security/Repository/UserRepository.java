package com.ascent.Spring.Security.Repository;

import com.ascent.Spring.Security.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
        public User findByUsername(String username);
}

