package com.example.access.security;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
public class JwtFilter implements Filter{
public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException{
HttpServletRequest r=(HttpServletRequest)req;
String h=r.getHeader("Authorization");
if(h!=null && h.startsWith("Bearer ")){
Claims c=JwtUtil.parseToken(h.substring(7));
r.setAttribute("userId",c.get("userId"));
r.setAttribute("role",c.get("role"));
}
chain.doFilter(req,res);
}}