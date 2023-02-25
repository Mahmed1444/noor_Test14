package com.noor.repo;

import com.noor.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITouristRepo extends CrudRepository
        <Tourist, Integer> {
    List<Tourist> findByName(String name);


}
