package com.example.iso8583.repository;

import com.example.iso8583.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT p FROM Customer p WHERE p.acctNo LIKE :acctNo")
    Customer findByInquiry(@Param("acctNo") String acctNo);

}
