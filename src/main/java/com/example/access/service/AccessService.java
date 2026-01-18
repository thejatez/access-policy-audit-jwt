package com.example.access.service;
import com.example.access.model.AccessAudit;
import com.example.access.model.AccessPolicy;
import com.example.access.repository.AccessAuditRepository;
import com.example.access.repository.AccessPolicyRepository;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
@Service
public class AccessService{
private final AccessPolicyRepository p;
private final AccessAuditRepository a;
public AccessService(AccessPolicyRepository p,AccessAuditRepository a){this.p=p;this.a=a;}
public boolean checkAccess(String userId,String role,String action){
boolean allowed=p.findByRoleAndAction(role,action).map(AccessPolicy::isAllowed).orElse(false);
AccessAudit au=new AccessAudit();
au.setUserId(userId);
au.setRole(role);
au.setAction(action);
au.setDecision(allowed?"ALLOWED":"DENIED");
au.setReason(allowed?"Policy matched":"No matching policy");
au.setTimestamp(OffsetDateTime.now());
a.save(au);
return allowed;
}}