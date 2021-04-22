package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.DemographicGroup;

import java.util.List;

public interface DemographicGroupDAO {
    public List<DemographicGroup> findAll();
    public DemographicGroup findById(String shortName);
    public void save(DemographicGroup demographicGroup);

}

