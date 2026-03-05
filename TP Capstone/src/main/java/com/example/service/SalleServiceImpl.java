package com.example.service;

import com.example.model.Salle;
import com.example.repository.SalleRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;



public class SalleServiceImpl implements SalleService {

    private SalleRepository salleRepository;
    private EntityManager em;

    public SalleServiceImpl(EntityManager em, SalleRepository salleRepository) {
        this.em = em;
        this.salleRepository = salleRepository;
    }

    @Override
    public List<Salle> findAvailableRooms(LocalDateTime start, LocalDateTime end) {
        return salleRepository.findAvailableRooms(start, end);
    }
    @Override
    public List<Salle> searchRooms(Map<String, Object> filters) {
        return salleRepository.searchRooms(filters);
    }
    @Override
    public List<Salle> getPaginatedRooms(int page, int size) {
        int offset = (page - 1) * size;
        return salleRepository.findRoomsWithPagination(offset, size);
    }
    @Override
    public long countRooms() {
        return salleRepository.countRooms(); // délégation au repository
    }




    @Override
    public void creerSalle(String batiment, int etage) {
        Salle salle = new Salle();
        salle.setBatiment(batiment);
        salle.setEtage(etage);
        salleRepository.save(salle);
    }

    @Override
    public Salle getSalle(Long id) {
        return salleRepository.findById(id);
    }
    @Override
    public int getTotalPages(int pageSize) {

        long total = salleRepository.findAll().size();

        return (int) Math.ceil((double) total / pageSize);
    }
}