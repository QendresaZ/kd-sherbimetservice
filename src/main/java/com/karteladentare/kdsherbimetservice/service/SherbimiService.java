package com.karteladentare.kdsherbimetservice.service;

import com.karteladentare.kdsherbimetservice.domain.Sherbimi;
import com.karteladentare.kdsherbimetservice.exceptions.SherbimiNotFoundException;
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

    public Sherbimi ktheSherbimin(Long id)
            throws SherbimiNotFoundException{
        Optional<Sherbimi> pacientiOptional = sherbimiRepository.findById(id);
        if (pacientiOptional.isPresent()) {
            return pacientiOptional.get();
        } else {
            throw new SherbimiNotFoundException("Sherbimi nuk egziston");
        }
    }

    public void fshijSherbimin(Long id) {

        sherbimiRepository.deleteById(id);
    }

    public Sherbimi shtoSherbimin(Sherbimi sherbimi) {

        Sherbimi sherbimiShtuar = sherbimiRepository.save(sherbimi);

        return sherbimiShtuar;
    }



      public Sherbimi perditesoSherbimin(Sherbimi sherbimi)
            throws SherbimiNotFoundException {
          Optional<Sherbimi> sherbimiOptional = sherbimiRepository.findById(sherbimi.getId());
          if (sherbimiOptional.isPresent()) {
              return sherbimiRepository.save(sherbimi);
          } else {
              throw new SherbimiNotFoundException("Sherbimi nuk egziston");
          }
    }
}
