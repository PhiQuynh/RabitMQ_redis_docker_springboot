package com.example.springapi.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
@Entity
@Table(name = "tblhuongdan")
@Getter
@Setter
public class TBLHuongDan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Masv")
    private Long masv;

    @Column(name ="KetQua")
    private BigDecimal ketQua;

    @ManyToOne
    @JoinColumn(name = "Magv")
    private TBLGiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "Madt")
    private TBLDetai detai;
}
