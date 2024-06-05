package com.example.springapi.service;

import com.example.springapi.dto.UpdateSinhVien;
import com.example.springapi.model.TBLSinhvien;
import com.example.springapi.repository.TBLSinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TBLSinhVienService {
    @Autowired
    TBLSinhVienRepository tblSinhVienRepository;

    @Cacheable("tblsinhviens")
    public List<TBLSinhvien> getAllSinhvien() {
        doLongRunningTask();
        return (List<TBLSinhvien>) tblSinhVienRepository.findAll();
    }
    @Cacheable("tblsinhvien")
    public TBLSinhvien getSinhvienById(Long id) {
        doLongRunningTask();
        return tblSinhVienRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "tblsinhvien", key = "#tblsinhvien.id")
    public TBLSinhvien updateSinhvien(Long id, UpdateSinhVien updatedSinhvien) {
        TBLSinhvien existingSinhvien = tblSinhVienRepository.findById(id).orElse(null);
        if (existingSinhvien != null) {
            existingSinhvien.setHotensv(updatedSinhvien.getHotensv());
            existingSinhvien.setNamsinh(updatedSinhvien.getNamsinh());
            existingSinhvien.setQuequan(updatedSinhvien.getQuequan());
            existingSinhvien.setMakhoa(updatedSinhvien.getMakhoa());
            return tblSinhVienRepository.save(existingSinhvien);
        }
        return null;
    }
    @CacheEvict(value = "tblsinhviens", key = "#id")
    public void deleteSinhvien(Long id) {
        tblSinhVienRepository.deleteById(id);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}