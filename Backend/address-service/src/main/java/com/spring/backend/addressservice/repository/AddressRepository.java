package com.spring.backend.addressservice.repository;


import com.spring.backend.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(value = "SELECT * FROM address WHERE user_id =?1", nativeQuery = true)
    Address findAllAddressByUserId(int id);
}
