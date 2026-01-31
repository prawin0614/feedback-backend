package com.college.complaintmanagement.controller;

import com.college.complaintmanagement.model.Complaint;
import com.college.complaintmanagement.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "http://localhost:3000") // React frontend
public class ComplaintController {

     private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    // 1️⃣ Student creates complaint
    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return service.saveComplaint(complaint);
    }

    // 2️⃣ Management views complaints → auto mark Viewed
    @GetMapping
    public List<Complaint> getAll() {
        return service.getAllComplaints();
    }

    // 3️⃣ Update status → In Progress / Resolved
    @PutMapping("/{id}/status")
    public Complaint updateStatus(@PathVariable Long id,
                                  @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    // 4️⃣ Delete complaint → management
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteComplaint(id);
    }
}
