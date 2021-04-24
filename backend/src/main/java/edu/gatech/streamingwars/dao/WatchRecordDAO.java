package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.WatchRecord;

import java.util.List;

public interface WatchRecordDAO {
    public List<WatchRecord> findAll();
    public WatchRecord findById(String demographicGroupShortName, String showShortName, Integer showYear);
    public void save(WatchRecord watchRecord);
    public List<WatchRecord> findByDemographicGroup(String demographicGroupSN);
    public List<WatchRecord> findByDemographicGroupYearMonth(String demographicGroupSN, String yearMonth);
    public List<WatchRecord> findByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth);
    public List<WatchRecord> findByStreamingService(String streamingServiceSN);
    public List<WatchRecord> findByShowYearYearMonth(String showSN, int showYear, String yearMonth);
    public List<WatchRecord> findByStreamingServiceShowYearYearMonth(String streamingServiceSN, String showSN, int showYear, String yearMonth);
}
