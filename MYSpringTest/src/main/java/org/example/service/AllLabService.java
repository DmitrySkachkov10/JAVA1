package org.example.service;

import org.example.repository.api.IAllLabRepository;
import org.example.repository.entity.LabResult;
import org.example.service.api.IAllLabService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllLabService implements IAllLabService {

    private final IAllLabRepository allLabRepository;

    public AllLabService(IAllLabRepository allLabRepository) {
        this.allLabRepository = allLabRepository;
    }

    @Override
    public List<LabResult> findAll() {
        return allLabRepository.findAll();
    }
}
