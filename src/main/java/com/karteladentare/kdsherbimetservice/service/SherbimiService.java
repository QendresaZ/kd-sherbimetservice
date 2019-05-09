package com.karteladentare.kdsherbimetservice.service;

import com.karteladentare.kdsherbimetservice.domain.Sherbimi;
import com.karteladentare.kdsherbimetservice.repository.SherbimiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SherbimiService {

    @Autowired
    private SherbimiRepository sherbimiRepository;

    public List<Sherbimi> ktheTeGjithaSherbimet() {
        return sherbimiRepository.findAll();
    }

    public Sherbimi ktheSherbimin(Long id){
        Optional<Sherbimi> sherbimi = sherbimiRepository.findById(id);

        return sherbimi.get();
    }

    public void fshijSherbimin(Long id) {
        sherbimiRepository.deleteById(id);
    }

    public Sherbimi shtoSherbimin(Sherbimi sherbimi) {
        Sherbimi sherbimiShtuar = sherbimiRepository.save(sherbimi);

        return sherbimiShtuar;
    }


    // duhet te implementohet
//    public Sherbimi perditesoSherbimin(Sherbimi sherbimi, Long id){
//        Optional<Sherbimi> sherbimiOptional
//    }
}
