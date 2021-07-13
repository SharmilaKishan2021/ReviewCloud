package com.eq.hrreview;

//import com.eq.hrreview.dao.UserResponseModel;

import com.eq.hrreview.models.AuthenticationRequest;
import com.eq.hrreview.models.User;
import com.eq.hrreview.services.MyUserDetails;
import com.eq.hrreview.services.MyUser;
import com.eq.hrreview.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//import com.eq.hrreview.services.MyUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloResource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetails userDetails;
    @Autowired
    private MyUser userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello world";
    }
    @GetMapping("/helloworld")
    public String hellotest()
    {
        return "hello world testing security";
    }


    @RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public ResponseEntity<Map> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
          System.out.println(authenticationRequest.getPassword());
        String authPass=userDetailsService.md5Password(authenticationRequest.getPassword());
        System.out.println(authPass);
        MyUserDetails userDetails= (MyUserDetails) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        System.out.println(userDetails);
        try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authPass));
      }
      catch (BadCredentialsException e)
      {
        throw new Exception("Incorrect Username or Password",e);
      }


        final String jwt=jwtTokenUtil.generateToken(userDetails);
        Map data=new HashMap();
        data.put("token",jwt);
        data.put("payload",userDetails.getUser());
        System.out.println(data);
       return ResponseEntity.ok(data);
         }
    @RequestMapping(value="/saveupdateuser",method = RequestMethod.POST)
    public ResponseEntity<Map> saveUpdateUser(@RequestBody User user) throws Exception {

        User userDetailsData= userDetailsService.saveUserDetails(user);

        Map data=new HashMap();
        data.put("payload",user);

        return ResponseEntity.ok(data);
    }

}
