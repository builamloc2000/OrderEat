package com.example.orderEat.application.service;

import com.example.orderEat.domain.entities.Status;

import java.util.List;

public interface StatusService {
    Status saveStatus(Status status);
    Status updateStatus(Status status, Integer statusId);
    void deleteStatus(Integer statusId);
    List<Status> fetchStatusList();
}
