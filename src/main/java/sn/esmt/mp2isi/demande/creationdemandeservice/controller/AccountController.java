package sn.esmt.mp2isi.demande.creationdemandeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.esmt.mp2isi.demande.creationdemandeservice.model.Account;
import sn.esmt.mp2isi.demande.creationdemandeservice.repository.AccountRepository;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountRepository accountRepository;


    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PutMapping
    public ResponseEntity<Account> update(@RequestBody Account account) {
        return ResponseEntity.ok(accountRepository.save(account));
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountRepository.save(account));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Account> getByNumero(@PathVariable String numero) {
        Account account = accountRepository.findTopByNumeroIgnoreCase(numero).orElse(null);
        if(account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }
}
