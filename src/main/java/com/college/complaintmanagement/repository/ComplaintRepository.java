package com.college.complaintmanagement.repository;

import com.college.complaintmanagement.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // CRUD methods auto-provided: save, findAll, findById, deleteById
}
