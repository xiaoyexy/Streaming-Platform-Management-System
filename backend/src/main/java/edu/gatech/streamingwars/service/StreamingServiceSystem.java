package edu.gatech.streamingwars.service;

import edu.gatech.streamingwars.entity.DemographicGroup;
import edu.gatech.streamingwars.entity.StreamingService;

public interface StreamingServiceSystem {
    public void addStreamingService(StreamingService streamingService);
    public void addDemographicGroup(DemographicGroup demographicGroup);
    public StreamingService getStreamingService(String streamingServiceSN);
    public DemographicGroup getDemographicGroup(String demographicGroupSN);
    public void demographicGroupSubscribeStreamingService(
            String demographicGroupSN,
            String streamingServiceSN,
            int percentage
    );
    public void demographicGroupWatchShow(
            String demographicGroupSN,
            int percentage,
            String streamingServiceSN,
            String showSN,
            int year
    );
    public int getCostsByDemographicGroupYearMonth(String demographicGroupSN, String yearMonth);
    public int getCostsByDemographicGroup(String demographicGroupSN);
    public int getRevenuesCollectedByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth);
    public int getRevenuesCollectedByStreamingService(String streamingServiceSN);
    public String displayTime();
    public void nextMonth();

    public boolean updateDemo(String demographicGroupSN, String demographicGroupLN, int numOfAccounts);
    public boolean updateStream(String streamingServiceSN, String streamingServiceLN, int subscriptionFee);


}
