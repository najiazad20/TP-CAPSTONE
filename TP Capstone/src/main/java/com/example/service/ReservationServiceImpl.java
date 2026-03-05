package com.example.service;

import com.example.repository.ReservationRepository;
import javax.persistence.EntityManager;

public class ReservationServiceImpl implements ReservationService {

    private EntityManager em;
    private ReservationRepository reservationRepository;

    // Constructeur attendu par ton appel
    public ReservationServiceImpl(EntityManager em, ReservationRepository reservationRepository) {
        this.em = em;
        this.reservationRepository = reservationRepository;
    }

    // Ajoute ici les méthodes de l'interface ReservationService
}