package com.keshav.Springboot_learning.Filter;

import com.keshav.Springboot_learning.Service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private JWTService jwtService;
    private UserDetailsService userDetailsService;

    public JWTAuthenticationFilter(JWTService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. Authorization header se token lo
        String authHeader = request.getHeader("Authorization");

        // 2. Header nahi hai ya Bearer token nahi hai
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. "Bearer " remove karke actual JWT nikalo
        String token = authHeader.substring(7);

        // 4. JWT se username nikalo
        String username = jwtService.extractUsername(token);

        // 5. Agar username mila aur user already authenticated nahi hai
        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            // 6. Database se user load karo
            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            // 7. JWT valid hai?
            if (jwtService.isTokenValid(token, userDetails)) {

                // 8. Spring Security authentication object banao
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                // 9. Request ki details set karo
                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                // 10. Current request ko authenticated mark karo
                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authentication);
            }
        }

        // 11. Request ko next filter/controller tak bhejo
        filterChain.doFilter(request, response);
    }


}
