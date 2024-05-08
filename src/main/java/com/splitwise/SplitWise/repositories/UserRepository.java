package com.splitwise.SplitWise.repositories;

import com.splitwise.SplitWise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
