package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Show;

import java.util.List;

public interface ShowDAO {
    public List<Show> findAll();
    public Show findById(String showShortName, int year);
    public void save(Show show);
}
