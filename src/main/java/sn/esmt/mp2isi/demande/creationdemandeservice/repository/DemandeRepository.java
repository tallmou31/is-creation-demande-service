package sn.esmt.mp2isi.demande.creationdemandeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esmt.mp2isi.demande.creationdemandeservice.model.Demande;

import java.util.Optional;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
}
