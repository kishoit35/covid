package com.vyakta.covid.repository;

import com.vyakta.covid.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
