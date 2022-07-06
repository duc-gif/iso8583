package com.example.iso8583.repository;

import com.example.iso8583.entity.Iso8583;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iso8583Repository extends JpaRepository<Iso8583,Long> {
}
