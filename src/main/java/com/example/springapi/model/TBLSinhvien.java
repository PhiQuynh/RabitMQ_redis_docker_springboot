package com.example.springapi.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "tblsinhvien")
@Getter
@Setter
public class TBLSinhvien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="Masv")
    private Long masv;

    @Column(name ="Hotensv")
    private String hotensv;

    @Column(name ="Namsinh")
    private String namsinh;

    @Column(name ="Quequan")
    private String quequan;

    @ManyToOne
    @JoinColumn(name = "Makhoa")
    private TBLKhoa makhoa;

}
