package com.example.access.repository;
import com.example.access.model.AccessAudit;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccessAuditRepository extends JpaRepository<AccessAudit,Long>{}