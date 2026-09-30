package com.example.hotelreservationapplication.Security;

import com.example.hotelreservationapplication.service.CustomUserDetailsService;
import com.example.hotelreservationapplication.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public final JwtService jwtService;
    public final CustomUserDetailsService customUserDetailsService;
    public JwtAuthenticationFilter(JwtService jwtService,CustomUserDetailsService customUserDetailsService){
        this.jwtService=jwtService;
        this.customUserDetailsService=customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader=request.getHeader("Authorization");
        if(authHeader!=null&& authHeader.startsWith("Bearer"))
        {
            String token=authHeader.substring(7);
            String username=jwtService.extractUsername(token);
            UserDetails userDetails= customUserDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,
                    null,
                    userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request ,response);
    }
    protected boolean shouldNotFilter(HttpServletRequest request){
        String path=request.getServletPath();
        return path.startsWith("/auth/") ||
                path.startsWith("/users/") ||
                        path.startsWith("/razorpay/");
    }
}
