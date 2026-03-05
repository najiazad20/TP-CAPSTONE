package com.example.service;

import com.example.model.Salle;
import com.example.util.PaginationResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface SalleService {
    void creerSalle(String batiment, int etage);
    Salle getSalle(Long id);
    List<Salle> findAvailableRooms(LocalDateTime start, LocalDateTime end);
    List<Salle> searchRooms(Map<String, Object> filters);
    int getTotalPages(int pageSize);
    public List<Salle> getPaginatedRooms(int page, int size) ;
    long countRooms();


}