package com.example.repository;

import com.example.model.Salle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface SalleRepository {
    void save(Salle salle);
    Salle findById(long id);
    List<Salle> findAll();
    List<Salle> findAvailableRooms(LocalDateTime start, LocalDateTime end);
    List<Salle> searchRooms(Map<String, Object> filters);
    List<Salle> findRoomsWithPagination(int offset, int limit);
    long countRooms();
}