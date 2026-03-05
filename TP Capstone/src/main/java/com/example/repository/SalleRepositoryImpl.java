package com.example.repository;

import com.example.model.Salle;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class SalleRepositoryImpl implements SalleRepository {

    private EntityManager em;

    public SalleRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Salle salle) {
        em.getTransaction().begin();
        em.persist(salle);
        em.getTransaction().commit();
    }
    @Override
    public List<Salle> findRoomsWithPagination(int offset, int limit) {
        TypedQuery<Salle> query = em.createQuery("SELECT s FROM Salle s", Salle.class);
        query.setFirstResult(offset);  // point de départ
        query.setMaxResults(limit);    // nombre de résultats
        return query.getResultList();
    }

    @Override
    public Salle findById(long id) {
        return em.find(Salle.class, id);
    }
    @Override
    public List<Salle> findAvailableRooms(LocalDateTime start, LocalDateTime end) {

        return em.createQuery(
                        "SELECT s FROM Salle s WHERE s.id NOT IN (" +
                                "SELECT r.salle.id FROM Reservation r " +
                                "WHERE r.dateDebut < :end AND r.dateFin > :start" +
                                ")", Salle.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
    }

    @Override
    public List<Salle> findAll() {
        return em.createQuery("FROM Salle", Salle.class).getResultList();
    }
    @Override
    public List<Salle> searchRooms(Map<String, Object> filters) {

        StringBuilder jpql = new StringBuilder("SELECT s FROM Salle s WHERE 1=1");

        if (filters.containsKey("capacite")) {
            jpql.append(" AND s.capacite >= :capacite");
        }

        javax.persistence.TypedQuery<Salle> query =
                em.createQuery(jpql.toString(), Salle.class);

        if (filters.containsKey("capacite")) {
            query.setParameter("capacite", filters.get("capacite"));
        }

        return query.getResultList();
    }
    @Override
    public long countRooms() {
        // JPQL pour compter les salles
        return em.createQuery("SELECT COUNT(s) FROM Salle s", Long.class)
                .getSingleResult();
    }
}