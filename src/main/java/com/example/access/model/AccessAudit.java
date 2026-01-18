package com.example.access.model;
import jakarta.persistence.*;
import java.time.OffsetDateTime;
@Entity
@Table(name="access_audit")
public class AccessAudit{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String userId;
private String role;
private String action;
private String decision;
private String reason;
private OffsetDateTime timestamp;
public Long getId(){return id;}
public String getUserId(){return userId;}
public String getRole(){return role;}
public String getAction(){return action;}
public String getDecision(){return decision;}
public String getReason(){return reason;}
public OffsetDateTime getTimestamp(){return timestamp;}
public void setId(Long id){this.id=id;}
public void setUserId(String userId){this.userId=userId;}
public void setRole(String role){this.role=role;}
public void setAction(String action){this.action=action;}
public void setDecision(String decision){this.decision=decision;}
public void setReason(String reason){this.reason=reason;}
public void setTimestamp(OffsetDateTime timestamp){this.timestamp=timestamp;}
}