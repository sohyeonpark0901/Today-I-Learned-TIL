package com.example.catalogsmicroservice.service;

import com.example.catalogsmicroservice.repository.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
