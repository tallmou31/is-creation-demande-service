package sn.esmt.mp2isi.demande.creationdemandeservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.esmt.mp2isi.demande.creationdemandeservice.model.Account;
import sn.esmt.mp2isi.demande.creationdemandeservice.repository.AccountRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AccountRepository accountRepository;

    @Autowired
    public DataInitializer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) {
        Account account1 = new Account("111111", 0.85);
        Account account2 = new Account("222222", 0.7);

        if (!accountRepository.findTopByNumeroIgnoreCase(account1.getNumero()).isPresent()) {
            accountRepository.save(account1);
        }
        if (!accountRepository.findTopByNumeroIgnoreCase(account2.getNumero()).isPresent()) {
            accountRepository.save(account2);
        }
    }
}
