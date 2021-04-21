package edu.gatech.streamingwars.rest;

import edu.gatech.streamingwars.dao.DemographicGroupDAO;
import edu.gatech.streamingwars.entity.DemographicGroup;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private DemographicGroupDAO demographicGroupDAO;

    @Autowired
    public TestController(DemographicGroupDAO demographicGroupDAO) {
        this.demographicGroupDAO = demographicGroupDAO;
    }

    @GetMapping("/list_demographic_group")
    public List<DemographicGroup> list() {
        return demographicGroupDAO.findAll();
    }

    @GetMapping("/list_demographic_group/{shortName}")
    public DemographicGroup findByDogId(@PathVariable String shortName) {
        DemographicGroup demographicGroup = demographicGroupDAO.findDemographicGroupByShortName(shortName);
        return demographicGroup;
    }
}
