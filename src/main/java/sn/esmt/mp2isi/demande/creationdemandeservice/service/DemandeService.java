package sn.esmt.mp2isi.demande.creationdemandeservice.service;


import sn.esmt.mp2isi.demande.creationdemandeservice.model.Demande;

public interface DemandeService {
    Demande create(String accountNumber, double montant, String dateTime);
}
