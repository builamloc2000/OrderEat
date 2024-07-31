package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.StatusService;
import com.example.orderEat.domain.entities.Status;
import com.example.orderEat.infrastructure.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status updateStatus(Status status, Integer statusId) {
        return null;
    }

    @Override
    public List<Status> fetchStatusList() {
        return (List<Status>) statusRepository.findAll();
    }

    @Override
    public void deleteStatus(Integer statusId) {
        statusRepository.deleteById(statusId);
    }
}
