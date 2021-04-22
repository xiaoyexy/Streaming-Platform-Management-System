package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Show;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class ShowDAOHibernateImpl implements ShowDAO{
    private EntityManager entityManager;

    @Autowired
    public ShowDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Show> findAll() {
        return null;
    }

    @Override
    public Show findById(String showShortName, int year) {
        return null;
    }

    @Override
    public void save(Show show) {

    }
}
