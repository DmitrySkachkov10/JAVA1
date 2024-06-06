package org.example.service.api;

import org.example.repository.entity.LabResult;

import java.util.List;

public interface IAllLabService {
    List<LabResult> findAll();

}
