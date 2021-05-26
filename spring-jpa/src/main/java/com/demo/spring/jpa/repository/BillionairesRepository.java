package com.demo.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.jpa.entity.Billionaires;

@Repository
public interface BillionairesRepository extends JpaRepository<Billionaires, Long> {

}