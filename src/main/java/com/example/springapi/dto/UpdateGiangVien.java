package com.example.springapi.dto;

import com.example.springapi.model.TBLKhoa;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateGiangVien {
    private String hotengv;
    private BigDecimal luong;
    private TBLKhoa makhoa;
}
