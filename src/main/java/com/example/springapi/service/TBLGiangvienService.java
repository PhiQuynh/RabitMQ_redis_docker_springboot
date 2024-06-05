package com.example.springapi.service;

import com.example.springapi.dto.UpdateGiangVien;
import com.example.springapi.model.TBLGiangVien;
import com.example.springapi.repository.TBLGiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TBLGiangvienService {
    @Autowired
    TBLGiangVienRepository tblGiangVienRepository;

    @Cacheable("tblGiangViens")
    public List<TBLGiangVien> getAllGiangVien() {
        doLongRunningTask();
        return (List<TBLGiangVien>) tblGiangVienRepository.findAll();
    }
    @Cacheable("tblGiangVien")
    public TBLGiangVien getGiangVienById(Long id) {
        doLongRunningTask();
        return tblGiangVienRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "tblGiangVien", key = "#tblGiangVien.id")
    public TBLGiangVien updateGiangVien(Long id, UpdateGiangVien updatedGiangVien) {
        TBLGiangVien existingGiangVien = tblGiangVienRepository.findById(id).orElse(null);
        if (existingGiangVien != null) {
            Long giangVienMagv = existingGiangVien.getMagv();
            existingGiangVien.setHotengv(updatedGiangVien.getHotengv());
            existingGiangVien.setLuong(updatedGiangVien.getLuong());
            return tblGiangVienRepository.save(existingGiangVien);
        }
        return null;
    }
    @CacheEvict(value = "tblGiangVien", key = "#id")
    public void deleteGiangVien(Long id) {
        tblGiangVienRepository.deleteById(id);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

