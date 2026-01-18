package com.example.access.repository;
import com.example.access.model.AccessPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface AccessPolicyRepository extends JpaRepository<AccessPolicy,Long>{
Optional<AccessPolicy> findByRoleAndAction(String role,String action);
}