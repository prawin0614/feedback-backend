package com.college.complaintmanagement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;       // Student name
    private String complaintType;     // Complaint category/type

    @Column(length = 500)
    private String description;       // Complaint description

    private String status;            // Application Submitted / Viewed / In Progress / Resolved

    private LocalDateTime createdAt;  // Submission timestamp

    // ✅ Constructor → default status + timestamp
    public Complaint() {
        this.createdAt = LocalDateTime.now();
        this.status = "Application Submitted"; // default when student submits
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getComplaintType() { return complaintType; }
    public void setComplaintType(String complaintType) { this.complaintType = complaintType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
