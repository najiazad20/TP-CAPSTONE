package com.example.repository;

import com.example.model.Reservation;
import java.util.List;

public interface ReservationRepository {
    void save(Reservation reservation);
    Reservation findById(long id);
    List<Reservation> findAll();
    // autres méthodes...
}