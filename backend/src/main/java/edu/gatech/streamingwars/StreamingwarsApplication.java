package edu.gatech.streamingwars;

import java.util.Random;
import java.util.List;

import edu.gatech.streamingwars.dao.DemographicGroupDAO;
import edu.gatech.streamingwars.entity.DemographicGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@ComponentScan({"edu.gatech.streamingwars"})
// @CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StreamingwarsApplication {

    // NOTE: autowired is a special annotation provided by the spring framework 
    // for enable dependency injection
    public static void main(String[] args) {
        SpringApplication.run(StreamingwarsApplication.class, args);
    }

//    @GetMapping("/random")
//    public RandomNumber random() {
//        Random rand = new Random();
//        RandomNumber num = new RandomNumber(rand.nextInt());
////        repository.save(num);
////        RandomNumber num_1 = new RandomNumber(rand.nextInt());
////        repository.save(num_1);
//        return num;
//    }

//    @GetMapping("/list_demographic_group")
//    public List<DemographicGroup> list() {
//        return demographicGroupDAO.findAll();
//    }

}
