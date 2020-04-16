package com.vyakta.covid.repository;

import com.vyakta.covid.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
