package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.Studio;
import java.util.List;

public interface StudioDAO {
    public List<Studio> findAll();
    public Studio findById(String studioShortName);
    public void save(Studio studio);
}
