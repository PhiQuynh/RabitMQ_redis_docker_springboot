package com.example.springapi.controller;

import com.example.springapi.dto.UpdateDetai;
import com.example.springapi.model.TBLDetai;
import com.example.springapi.service.TBLDetaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tblDetail")
@RequiredArgsConstructor
public class TBLDetaiController {

    private final TBLDetaiService tblDetaiService;

    @GetMapping
    public List<TBLDetai> getAllDetais() {
        return tblDetaiService.getAllDetais();
    }

    @GetMapping("/{id}")
    public TBLDetai getDetaiById(@PathVariable String id) {
        return tblDetaiService.getDetaiById(id);
    }

    @PutMapping("/{id}")
    public UpdateDetai updateDetai(@PathVariable String id, @RequestBody UpdateDetai updatedDetai) {
        return tblDetaiService.updateDetai(id, updatedDetai);
    }

    @DeleteMapping("/{id}")
    public void deleteDetai(@PathVariable String id) {
        tblDetaiService.deleteDetai(id);
    }

}
