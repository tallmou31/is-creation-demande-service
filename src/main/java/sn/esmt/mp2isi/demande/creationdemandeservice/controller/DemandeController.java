package sn.esmt.mp2isi.demande.creationdemandeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.esmt.mp2isi.demande.creationdemandeservice.model.Demande;
import sn.esmt.mp2isi.demande.creationdemandeservice.service.DemandeService;


@RestController
@RequestMapping("/api/demande")
public class DemandeController {
    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> create (@RequestBody DemandeRequest dto) {
        Demande demande = demandeService.create(dto.getNumero(), dto.getMontant(), dto.getDateTime());
        if(demande != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper(HttpStatus.CREATED.value(), "Request succefully created"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper(HttpStatus.NOT_FOUND.value(), "Request with this number is not found in database"));
        }
    }
}
