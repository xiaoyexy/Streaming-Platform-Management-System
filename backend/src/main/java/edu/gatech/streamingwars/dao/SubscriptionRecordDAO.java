package edu.gatech.streamingwars.dao;



import edu.gatech.streamingwars.entity.SubscriptionRecord;

import java.util.List;

public interface SubscriptionRecordDAO {
    public List<SubscriptionRecord> findAll();
    public SubscriptionRecord findById(String demographicGroupShortName, String streamingServiceShortName, String yearMonth);
    public void save(SubscriptionRecord subscriptionRecord);
    public List<SubscriptionRecord> findByDemographicGroup(String demographicGroupSN);
    public List<SubscriptionRecord> findByDemographicGroupYearMonth(String demographicGroupSN, String yearMonth);
    public List<SubscriptionRecord> findByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth);
    public List<SubscriptionRecord> findByStreamingService(String streamingServiceSN);
}
