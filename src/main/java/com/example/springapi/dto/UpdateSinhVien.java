package com.example.springapi.dto;

import com.example.springapi.model.TBLKhoa;
import lombok.Data;

@Data
public class UpdateSinhVien {
    private String hotensv;
    private String namsinh;
    private String quequan;
    private TBLKhoa makhoa;
}
