package org.example.service;

import org.example.model.City;

import java.util.List;

public interface Service {
    List<? extends City> getList();
}
