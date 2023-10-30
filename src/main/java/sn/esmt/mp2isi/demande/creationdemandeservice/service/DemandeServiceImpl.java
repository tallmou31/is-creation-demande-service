package sn.esmt.mp2isi.demande.creationdemandeservice.service;

import org.springframework.stereotype.Service;
import sn.esmt.mp2isi.demande.creationdemandeservice.model.Account;
import sn.esmt.mp2isi.demande.creationdemandeservice.model.Demande;
import sn.esmt.mp2isi.demande.creationdemandeservice.model.Status;
import sn.esmt.mp2isi.demande.creationdemandeservice.repository.AccountRepository;
import sn.esmt.mp2isi.demande.creationdemandeservice.repository.DemandeRepository;

import java.util.Optional;


@Service
public class DemandeServiceImpl implements DemandeService {

    private final DemandeRepository demandeRepository;

    private final AccountRepository accountRepository;

    public DemandeServiceImpl(DemandeRepository demandeRepository, AccountRepository accountRepository) {
        this.demandeRepository = demandeRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Demande create(String accountNumber, double montant, String dateTime) {
        Optional<Account> optionalAccount = accountRepository.findTopByNumeroIgnoreCase(accountNumber);
        if(!optionalAccount.isPresent()) {
            return null;
        }
        Demande demande = new Demande();
        demande.setAccountNumber(accountNumber);
        demande.setMontant(montant);
        demande.setDateTime(dateTime);
        demande.setStatus(Status.TRAITEMENT_EN_COURS);

        return demandeRepository.save(demande);
    }
}
