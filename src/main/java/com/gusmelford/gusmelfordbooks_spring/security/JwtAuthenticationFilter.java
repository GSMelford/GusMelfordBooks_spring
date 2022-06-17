package com.gusmelford.gusmelfordbooks_spring.security;

import com.gusmelford.gusmelfordbooks_spring.services.MyUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private MyUserDetailsService userDetailsService;
    private JwtTokenManager jwtTokenManager;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        String header = request.getHeader("Authorization");
        String email = null;
        String authToken = null;

        if (header != null && header.startsWith("Bearer")) {
            authToken = header.replace("Bearer","");
            try {
                email = jwtTokenManager.getEmailFromToken(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("An error occurred while fetching Username from Token", e);
            } catch (ExpiredJwtException e) {
                logger.warn("The token has expired", e);
            } catch(SignatureException e){
                logger.error("Authentication Failed. Username or Password not valid.");
            }
        } else {
            logger.warn("Couldn't find bearer string, header will be ignored");
        }

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        if (email != null && authentication == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            if (jwtTokenManager.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken =
                        jwtTokenManager.getAuthenticationToken(authToken, userDetails);
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info("Authenticated user with email " + email + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        chain.doFilter(request, response);
    }
}
