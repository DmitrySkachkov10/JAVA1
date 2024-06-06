package org.example.repository.api;

import org.example.repository.entity.LabResult;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAllLabRepository extends ListCrudRepository<LabResult, Integer> {

}
