package com.example.masmenu.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class FirebaseFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain)
      throws ServletException, IOException {

    String authHeader = request.getHeader("Authorization");

    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      String token = authHeader.substring(7);

      try {
        FirebaseToken decodedToken =
            FirebaseAuth.getInstance().verifyIdToken(token);

        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(
                decodedToken.getUid(),
                null,
                Collections.emptyList()
            );

        SecurityContextHolder.getContext()
            .setAuthentication(authentication);

      } catch (FirebaseAuthException e) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return; // 🔴 corta la petición si el token es inválido
      }
    }

    filterChain.doFilter(request, response);
  }
}
