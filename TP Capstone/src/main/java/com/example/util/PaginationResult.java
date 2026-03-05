package com.example.util;

import java.util.List;

// Déclarez la classe comme générique avec <T>
public class PaginationResult<T> {

    private List<T> items;
    private long totalItems;
    private int currentPage;
    private int pageSize;

    public PaginationResult(List<T> items, long totalItems, int currentPage, int pageSize) {
        this.items = items;
        this.totalItems = totalItems;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    // Getters et setters
    public int getTotalPages() {
        // Nombre total de pages = totalItems / pageSize, arrondi vers le haut
        return (int) Math.ceil((double) totalItems / pageSize);
    }

    public boolean hasNext() {
        return currentPage < getTotalPages();
    }

    public boolean hasPrevious() {
        return currentPage > 1;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}