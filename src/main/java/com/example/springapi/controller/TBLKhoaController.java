package com.example.springapi.controller;

import com.example.springapi.dto.UpdateKhoa;
import com.example.springapi.model.TBLKhoa;
import com.example.springapi.service.TBLKhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tblKhoa")
public class TBLKhoaController {
    @Autowired
    TBLKhoaService khoaService;
    @GetMapping
    public List<TBLKhoa> getAllKhoa() {
        return khoaService.getAllKhoa();
    }

    @GetMapping("/{id}")
    public TBLKhoa getKhoaById(@PathVariable String id) {
        return khoaService.getKhoaById(id);
    }

    @PutMapping("/{id}")
    public TBLKhoa updateKhoa(@PathVariable String id, @RequestBody UpdateKhoa updatedKhoa) {
        return khoaService.updateKhoa(id, updatedKhoa);
    }

    @DeleteMapping("/{id}")
    public void deleteKhoa(@PathVariable String id) {
        khoaService.deleteKhoa(id);
    }
}


