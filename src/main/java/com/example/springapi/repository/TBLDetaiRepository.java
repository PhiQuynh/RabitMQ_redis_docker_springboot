package com.example.springapi.repository;

import com.example.springapi.model.TBLDetai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface TBLDetaiRepository extends JpaRepository<TBLDetai, String> {
//    TBLDetai findByMadt(String madt);
}
