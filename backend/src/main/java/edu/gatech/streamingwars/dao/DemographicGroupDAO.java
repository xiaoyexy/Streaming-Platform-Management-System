package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.DemographicGroup;

import java.util.List;

public interface DemographicGroupDAO {
    public List<DemographicGroup> findAll();
    public DemographicGroup findDemographicGroupByShortName(String shortName);
    public void saveDemographicGroup(DemographicGroup demographicGroup);

}

