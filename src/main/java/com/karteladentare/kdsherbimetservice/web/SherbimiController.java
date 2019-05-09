package com.karteladentare.kdsherbimetservice.web;

import com.karteladentare.kdsherbimetservice.domain.Sherbimi;
import com.karteladentare.kdsherbimetservice.service.SherbimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/api/sherbimet-service")
public class SherbimiController {

    @Autowired
    private SherbimiService sherbimiService;

    @GetMapping("/sherbimet")
    public ResponseEntity<Iterable<Sherbimi>> ktheSherbimet() {
        return ResponseEntity.ok(sherbimiService.ktheTeGjithaSherbimet());
    }

    @PostMapping("/sherbimet")
    public  ResponseEntity<Object> krijoSherbimin(@RequestBody Sherbimi sherbimi) {
        Sherbimi sherbimiKrijuar = sherbimiService.shtoSherbimin(sherbimi);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sherbimiKrijuar.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
