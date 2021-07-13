package com.eq.hrreview.controller;

//import com.eq.hrreview.dao.UserRepository;
import com.eq.hrreview.models.User;
import com.eq.hrreview.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @GetMapping(path="/all")
    public List<User> findAll()
    {
       return (List<User>) userJpaRepository.findAll();
    }

    @GetMapping(path="/{name}")
    public User findByName(@PathVariable final String email)
    {
        return userJpaRepository.findByEmail(email);
    }
    @PostMapping(path="/add") // Map ONLY POST Requests
    public User add(@RequestBody final User user)
    {
        userJpaRepository.save(user);
        return userJpaRepository.findByEmail(user.getEmail());
    }
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setFname(name);
        n.setEmail(email);
        userJpaRepository.save(n);
        return "Saved";
    }

  /*  @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }*/
}
