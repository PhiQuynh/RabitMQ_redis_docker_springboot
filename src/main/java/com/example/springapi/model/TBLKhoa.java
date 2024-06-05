package com.example.springapi.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity
@Table(name = "tblkhoa")
@Getter
@Setter
public class TBLKhoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="Makhoa")
    private String makhoa;

    @Column(name ="Tenkhoa")
    private String tenkhoa;

    @Column(name ="Dienthoai")
    private String dienthoai;
}
