package com.example.springapi.controller;

import com.example.springapi.dto.UpdateHuongDan;
import com.example.springapi.model.TBLHuongDan;
import com.example.springapi.service.TBLHuongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tblHuongDan")
public class TBLHuongDanController {
    @Autowired
    TBLHuongDanService huongDanService;
    @GetMapping
    public List<TBLHuongDan> getAllHuongDan() {
        return huongDanService.getAllHuongDan();
    }

    @GetMapping("/{id}")
    public TBLHuongDan getHuongDanById(@PathVariable Long id) {
        return huongDanService.getHuongDanById(id);
    }

    @PutMapping("/{id}")
    public TBLHuongDan updateHuongDan(@PathVariable Long id, @RequestBody UpdateHuongDan updatedHuongDan) {
        return huongDanService.updateHuongDan(id, updatedHuongDan);
    }

    @DeleteMapping("/{id}")
    public void deleteHuongDan(@PathVariable Long id) {
        huongDanService.deleteHuongDan(id);
    }
}