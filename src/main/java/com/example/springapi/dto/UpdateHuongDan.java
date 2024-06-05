package com.example.springapi.dto;

import com.example.springapi.model.TBLDetai;
import com.example.springapi.model.TBLGiangVien;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateHuongDan {
    private BigDecimal ketQua;
    private TBLGiangVien giangVien;
    private TBLDetai detai;
}
