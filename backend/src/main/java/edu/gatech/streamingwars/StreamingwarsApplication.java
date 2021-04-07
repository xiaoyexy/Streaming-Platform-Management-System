package edu.gatech.streamingwars;

import java.util.Random;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class StreamingwarsApplication {

    // NOTE: autowired is a special annotation provided by the spring framework 
    // for enable dependency injection
    @Autowired
    private RandomNumberRepository repository;

	public static void main(String[] args) {
	    SpringApplication.run(StreamingwarsApplication.class, args);
	}

    @GetMapping("/random")
    public RandomNumber random() {
        Random rand = new Random();
        RandomNumber num = new RandomNumber(rand.nextInt());
        repository.save(num);
        return num;
    }

    @GetMapping("/list")
    public List<RandomNumber> list() {
        return repository.findAll();
    }
}
