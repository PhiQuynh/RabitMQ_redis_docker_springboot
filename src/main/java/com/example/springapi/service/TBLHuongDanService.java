package com.example.springapi.service;

import com.example.springapi.dto.UpdateHuongDan;
import com.example.springapi.model.TBLHuongDan;
import com.example.springapi.repository.TBLHuongDanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TBLHuongDanService {
    @Autowired
    TBLHuongDanRepository tblHuongDanRepository;

    @Cacheable("tblHuongDans")
    public List<TBLHuongDan> getAllHuongDan() {
        doLongRunningTask();
        return (List<TBLHuongDan>) tblHuongDanRepository.findAll();
    }
    @Cacheable("tblHuongDan")
    public TBLHuongDan getHuongDanById(Long id) {
        doLongRunningTask();
        return tblHuongDanRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "tblHuongDan", key = "#tblHuongDan.id")
    public TBLHuongDan updateHuongDan(Long id, UpdateHuongDan updatedHuongDan) {
        TBLHuongDan existingHuongDan = tblHuongDanRepository.findById(id).orElse(null);
        if (existingHuongDan != null) {
            existingHuongDan.setKetQua(updatedHuongDan.getKetQua());
            existingHuongDan.setGiangVien(updatedHuongDan.getGiangVien());
            existingHuongDan.setDetai(updatedHuongDan.getDetai());
            return tblHuongDanRepository.save(existingHuongDan);
        }
        return null;
    }
    @CacheEvict(value = "tblHuongDan", key = "#id")
    public void deleteHuongDan(Long id) {
        tblHuongDanRepository.deleteById(id);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}