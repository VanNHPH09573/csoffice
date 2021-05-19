package com.example.cs_office.Repository;

import com.example.cs_office.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepotitory extends JpaRepository<Branch, Integer> {
    //select branch by id
    @Query("select s from Branch s where s.id = ?1")
    Optional<Branch> findBranchById(Integer id);

    //select branch by status
    @Query("select c from Branch c where c.status = ?1")
    List<Branch> findBranchByStatus(boolean status);
}
