package com.example.springapi.controller;

import com.example.springapi.dto.UpdateGiangVien;
import com.example.springapi.model.TBLGiangVien;
import com.example.springapi.service.TBLGiangvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tblGiangVien")
public class TBLGiangVienController {
    @Autowired
    TBLGiangvienService tblGiangvienService;
    @GetMapping
    public List<TBLGiangVien> getAllGiangVien() {
        return tblGiangvienService.getAllGiangVien();
    }

    @GetMapping("/{id}")
    public TBLGiangVien getGiangVienById(@PathVariable Long id) {
        return tblGiangvienService.getGiangVienById(id);
    }

    @PutMapping("/{id}")
    public TBLGiangVien updateGiangVien(@PathVariable Long id, @RequestBody UpdateGiangVien updatedGiangVien) {
        return tblGiangvienService.updateGiangVien(id, updatedGiangVien);
    }

    @DeleteMapping("/{id}")
    public void deleteGiangVien(@PathVariable Long id) {
        tblGiangvienService.deleteGiangVien(id);
    }
}
