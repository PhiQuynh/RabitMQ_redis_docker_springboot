package com.example.springapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tblgiangvien")
@Getter
@Setter
public class TBLGiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Magv")
    private Long magv;

    @Column(name = "Hotengv")
    private String hotengv;

    @Column(name = "Luong")
    private BigDecimal luong;

    @ManyToOne
    @JoinColumn(name = "Makhoa")
    private TBLKhoa tblKhoa;
}