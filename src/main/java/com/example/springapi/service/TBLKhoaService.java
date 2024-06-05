package com.example.springapi.service;

import com.example.springapi.dto.UpdateKhoa;
import com.example.springapi.model.TBLKhoa;
import com.example.springapi.repository.TBLKhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TBLKhoaService {
    @Autowired
    TBLKhoaRepository tblKhoaRepository;

    @Cacheable("tblKhoas")
    public List<TBLKhoa> getAllKhoa() {
        doLongRunningTask();
        return (List<TBLKhoa>) tblKhoaRepository.findAll();
    }
    @Cacheable("tblKhoa")
    public TBLKhoa getKhoaById(String id) {
        doLongRunningTask();
        return tblKhoaRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "tblKhoa", key = "#tblKhoa.id")
    public TBLKhoa updateKhoa(String id, UpdateKhoa updatedKhoa) {
        TBLKhoa existingKhoa = tblKhoaRepository.findById(id).orElse(null);
        if (existingKhoa != null) {
            existingKhoa.setTenkhoa(updatedKhoa.getTenkhoa());
            existingKhoa.setDienthoai(updatedKhoa.getDienthoai());
            return tblKhoaRepository.save(existingKhoa);
        }
        return null;
    }
    @CacheEvict(value = "tblKhoa", key = "#id")
    public void deleteKhoa(String id) {
        tblKhoaRepository.deleteById(id);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}