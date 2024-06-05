package com.example.springapi.service;


import com.example.springapi.dto.UpdateDetai;
import com.example.springapi.model.TBLDetai;
import com.example.springapi.repository.TBLDetaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@EnableCaching
public class TBLDetaiService {

    @Autowired
    TBLDetaiRepository tblDetaiRepository;

    @Cacheable("tbldetails")
    public List<TBLDetai> getAllDetais() {
        doLongRunningTask();
        return tblDetaiRepository.findAll();
    }
    @Cacheable("tbldetails")
    public TBLDetai getDetaiById(String id) {
        doLongRunningTask();
        return tblDetaiRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "tbldetail", key = "#id")
    public UpdateDetai updateDetai(String id, UpdateDetai updatedDetai) {
        TBLDetai existingDetai = tblDetaiRepository.findById(id).orElse(null);
        if (existingDetai != null) {
            existingDetai.setTendt(updatedDetai.getTendt());
            existingDetai.setKinhphi(updatedDetai.getKinhphi());
            existingDetai.setNoithuctap(updatedDetai.getNoithuctap());
            TBLDetai updatedDetaiEntity = tblDetaiRepository.save(existingDetai);

            UpdateDetai updatedDetaiDTO = new UpdateDetai();
            updatedDetaiDTO.setMadt(updatedDetaiEntity.getMadt());
            updatedDetaiDTO.setTendt(updatedDetaiEntity.getTendt());
            updatedDetaiDTO.setKinhphi(updatedDetaiEntity.getKinhphi());
            updatedDetaiDTO.setNoithuctap(updatedDetaiEntity.getNoithuctap());

            return updatedDetaiDTO;
        }
        return null;
    }
    @CacheEvict(value = "tbldetail", key = "#id")
    public void deleteDetai(String id) {
        tblDetaiRepository.deleteById(id);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
