package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.WatchRecord;

import java.util.List;

public interface WatchRecordDAO {
    public List<WatchRecord> findAll();
    public WatchRecord findById(String demographicGroupShortName, String showShortName, Integer showYear);
    public void save(WatchRecord subscriptionRecord);
}
