package com.college.complaintmanagement.service;

import com.college.complaintmanagement.model.Complaint;
import com.college.complaintmanagement.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repository;

    public ComplaintService(ComplaintRepository repository) {
        this.repository = repository;
    }

    // 1️⃣ Save complaint → student submits
    public Complaint saveComplaint(Complaint complaint) {
        return repository.save(complaint);
    }

    // 2️⃣ Get all complaints → auto mark "Viewed" if Application Submitted
    public List<Complaint> getAllComplaints() {
        List<Complaint> complaints = repository.findAll();
        for (Complaint c : complaints) {
            if (c.getStatus().equals("Application Submitted")) {
                c.setStatus("Viewed"); // Auto update
                repository.save(c);
            }
        }
        return complaints;
    }

    // 3️⃣ Update status → In Progress / Resolved
    public Complaint updateStatus(Long id, String status) {
        Complaint complaint = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus(status);
        return repository.save(complaint);
    }

    // 4️⃣ Delete complaint → management
    public void deleteComplaint(Long id) {
        repository.deleteById(id);
    }
}
