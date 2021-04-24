package edu.gatech.streamingwars.rest;

import edu.gatech.streamingwars.dao.DemographicGroupDAO;
import edu.gatech.streamingwars.dao.UsersDAO;
import edu.gatech.streamingwars.entity.DemographicGroup;
import edu.gatech.streamingwars.entity.User;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private DemographicGroupDAO demographicGroupDAO;
    private UsersDAO usersDAO;

    @Autowired
    public TestController(DemographicGroupDAO demographicGroupDAO, UsersDAO usersDAO) {
        this.demographicGroupDAO = demographicGroupDAO;
        this.usersDAO = usersDAO;
    }

    @GetMapping("/list_demographic_group")
    public List<DemographicGroup> list() {
        return demographicGroupDAO.findAll();
    }

    @GetMapping("/list_demographic_group/{shortName}")
    public DemographicGroup findByDogId(@PathVariable String shortName) {
        DemographicGroup demographicGroup = demographicGroupDAO.findById(shortName);
        return demographicGroup;
    }

    @PostMapping(path="/users/authenticate", consumes="application/json", produces="application/json")
    public List<User> authenticate(@RequestBody User user) {
        System.out.println(user);
        return usersDAO.authenticate(user.getUsername(),user.getPassword());
    }
}
