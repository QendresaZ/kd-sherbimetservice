package com.karteladentare.kdsherbimetservice.web;

import com.karteladentare.kdsherbimetservice.domain.Sherbimi;
import com.karteladentare.kdsherbimetservice.exceptions.SherbimiNotFoundException;
import com.karteladentare.kdsherbimetservice.service.SherbimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin // me mujt me bo request nga ip/server tjeter per angularjs osht
@RequestMapping(value = "v1/sherbimet", produces = "application/json")
public class SherbimiController {

    @Autowired
    private SherbimiService sherbimiService;

    @GetMapping
    public ResponseEntity<Iterable<Sherbimi>> ktheSherbimet() {
        return ResponseEntity.ok(sherbimiService.ktheTeGjithaSherbimet());
    }

    @GetMapping("/{id}")
    public Sherbimi ktheSherbimin(@PathVariable("id") Long id) {
        try {
            return sherbimiService.ktheSherbimin(id);
        } catch (SherbimiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sherbimi krijoSherbimin(@RequestBody Sherbimi sherbimi) {
        Sherbimi sherbimiKrijuar = sherbimiService.shtoSherbimin(sherbimi);

        return sherbimiKrijuar;
    }

    @PutMapping(path = "/{id}")
    public Sherbimi perditesoSherbimin(@PathVariable("id") Long id,
                                       @RequestBody Sherbimi sherbimi) {
        try {
            sherbimi.setId(id);
            return sherbimiService.perditesoSherbimin(sherbimi);
        } catch (SherbimiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> fshijeSherbimin(@PathVariable("id") Long id){
        sherbimiService.fshijSherbimin(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
