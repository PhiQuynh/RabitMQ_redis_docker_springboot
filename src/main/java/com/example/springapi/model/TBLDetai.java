package com.example.springapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;

@Entity
@Table(name = "tbldetai")
@Getter
@Setter
public class TBLDetai {
    @Id
    @Column(name = "Madt")
    private String madt;

    @Column(name ="Tendt")
    private String tendt;

    @Column(name ="Kinhphi")
    private Long kinhphi;

    @Column(name ="Noithuctap")
    private String noithuctap;
}
