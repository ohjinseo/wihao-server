package com.example.wihao.repository.user;

import com.example.wihao.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    public Boolean existsByUsername(String username);
}
