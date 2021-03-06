package com.eq.hrreview.filters;

import com.eq.hrreview.util.JwtUtil;
import com.eq.hrreview.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
      final String autherizationHeader=request.getHeader("Authorization");
      String username=null;
      String jwt=null;
      if(autherizationHeader!=null && autherizationHeader.startsWith("Bearer ")){
          jwt=autherizationHeader.substring(7);
          username=jwtTokenUtil.extractUsername(jwt);
      }
      if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null)
      {
          UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
          if(jwtTokenUtil.validateToken(jwt,userDetails))
          {
              UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(
                      userDetails,null,userDetails.getAuthorities());
              usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
          }
      }
    chain.doFilter(request,response);
    }
}
