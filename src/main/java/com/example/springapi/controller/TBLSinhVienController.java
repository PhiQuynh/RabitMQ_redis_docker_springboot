package com.example.springapi.controller;

import com.example.springapi.dto.UpdateSinhVien;
import com.example.springapi.model.TBLSinhvien;
import com.example.springapi.service.TBLSinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tblSinhVien")
public class TBLSinhVienController {
    @Autowired
    TBLSinhVienService sinhvienService;
    @GetMapping
    public List<TBLSinhvien> getAllSinhvien() {
        return sinhvienService.getAllSinhvien();
    }

    @GetMapping("/{id}")
    public TBLSinhvien getSinhvienById(@PathVariable Long id) {
        return sinhvienService.getSinhvienById(id);
    }

    @PutMapping("/{id}")
    public TBLSinhvien updateSinhvien(@PathVariable Long id, @RequestBody UpdateSinhVien updatedSinhvien) {
        return sinhvienService.updateSinhvien(id, updatedSinhvien);
    }

    @DeleteMapping("/{id}")
    public void deleteSinhvien(@PathVariable Long id) {
        sinhvienService.deleteSinhvien(id);
    }
}