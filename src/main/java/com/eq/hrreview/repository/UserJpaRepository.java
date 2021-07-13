package com.eq.hrreview.repository;

import com.eq.hrreview.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserJpaRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
