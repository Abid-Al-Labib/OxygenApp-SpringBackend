package com.oxygen.oxygenApp.repository;

import com.oxygen.oxygenApp.entities.Booth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoothRepository extends JpaRepository<Booth, Integer> {

    Optional<Booth> findBoothByName(String name);
    void deleteBoothByName(String name);
    List<Booth> findBoothsByType(String type);

}
