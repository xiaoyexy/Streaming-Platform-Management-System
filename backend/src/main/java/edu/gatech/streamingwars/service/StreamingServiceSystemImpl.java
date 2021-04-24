package edu.gatech.streamingwars.service;

import edu.gatech.streamingwars.dao.*;
import edu.gatech.streamingwars.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StreamingServiceSystemImpl implements StreamingServiceSystem{
    private YearMonth currentYearMonth;
    private DemographicGroupDAO demographicGroupDAO;
    private ShowDAO showDAO;
    private ShowLicenseRecordDAO showLicenseRecordDAO;
    private StreamingServiceDAO streamingServiceDAO;
    private StudioDAO studioDAO;
    private SubscriptionRecordDAO subscriptionRecordDAO;
    private WatchRecordDAO watchRecordDAO;
    private YearMonth yearMonth;

    @Autowired
    public StreamingServiceSystemImpl(YearMonth currentYearMonth, DemographicGroupDAO demographicGroupDAO, ShowDAO showDAO, ShowLicenseRecordDAO showLicenseRecordDAO, StreamingServiceDAO streamingServiceDAO, StudioDAO studioDAO, SubscriptionRecordDAO subscriptionRecordDAO, WatchRecordDAO watchRecordDAO, YearMonth yearMonth) {
        this.currentYearMonth = currentYearMonth;
        this.demographicGroupDAO = demographicGroupDAO;
        this.showDAO = showDAO;
        this.showLicenseRecordDAO = showLicenseRecordDAO;
        this.streamingServiceDAO = streamingServiceDAO;
        this.studioDAO = studioDAO;
        this.subscriptionRecordDAO = subscriptionRecordDAO;
        this.watchRecordDAO = watchRecordDAO;
        this.yearMonth = yearMonth;
    }

    @Override
    public void nextMonth() {
        currentYearMonth.nextMonth();
    }

    @Override
    public String displayTime() {
        return currentYearMonth.display();
    }

    @Override
    @Transactional
    public void addStreamingService(StreamingService streamingService) {
        streamingServiceDAO.save(streamingService);
    }

    @Override
    @Transactional
    public void addDemographicGroup(DemographicGroup demographicGroup) {
        demographicGroupDAO.save(demographicGroup);
    }

    @Override
    @Transactional
    public StreamingService getStreamingService(String streamingServiceSN) {
        return streamingServiceDAO.findById(streamingServiceSN);
    }

    @Override
    @Transactional
    public DemographicGroup getDemographicGroup(String demographicGroupSN) {
        return demographicGroupDAO.findById(demographicGroupSN);
    }

    @Override
    @Transactional
    public void demographicGroupSubscribeStreamingService(String demographicGroupSN, String streamingServiceSN, int percentage) {
        SubscriptionRecord subscriptionRecord = subscriptionRecordDAO.findById(demographicGroupSN, streamingServiceSN, currentYearMonth.toString());
        int subscriptionFee = streamingServiceDAO.findById(streamingServiceSN).getSubscribeFee();
        int numberOfAccount = demographicGroupDAO.findById(demographicGroupSN).getNumberOfAccount();
        if (subscriptionRecord == null) {
            subscriptionRecord = new SubscriptionRecord(demographicGroupSN, streamingServiceSN, currentYearMonth.toString(), percentage, subscriptionFee, numberOfAccount);
        }
        subscriptionRecord.setPercentage(Math.max(percentage, subscriptionRecord.getPercentage()));
        subscriptionRecordDAO.save(subscriptionRecord);
    }

    @Override
    @Transactional
    public void demographicGroupWatchShow(String demographicGroupSN, int percentage, String streamingServiceSN, String showSN, int year) {
        Show show = showDAO.findById(showSN, year);
        if (show.getShowType().equals("movie")) {
            demographicGroupSubscribeStreamingService(demographicGroupSN, streamingServiceSN, percentage);
        }
        WatchRecord watchRecord = watchRecordDAO.findById(demographicGroupSN, showSN, year);
        int watchPrice = showLicenseRecordDAO.findById(streamingServiceSN, showSN, year, currentYearMonth.toString()).getWatchPrice();
        int numberOfAccount = demographicGroupDAO.findById(demographicGroupSN).getNumberOfAccount();
        if (watchRecord == null) {
            watchRecord = new WatchRecord(percentage, demographicGroupSN, showSN, year, streamingServiceSN, currentYearMonth.toString(), watchPrice, numberOfAccount);
        }
        watchRecord.setPercentageOfAccount(Math.max(watchRecord.getPercentageOfAccount(), percentage));
        watchRecordDAO.save(watchRecord);
    }

    @Transactional
    public int getSumOfSubscriptionFee(List<SubscriptionRecord> subscriptionRecords) {
        int res = 0;
        for (SubscriptionRecord subscriptionRecord : subscriptionRecords) {
            int subscriptionFee = subscriptionRecord.getSubscriptionFee();
            int percentage = subscriptionRecord.getPercentage();
            int numOfAccount = subscriptionRecord.getDemongraphicGroupNumOfAccount();
            res = res + subscriptionFee * percentage * numOfAccount / 100;
        }
        return res;
    }

    @Transactional
    public int getSumOfWatchFee(List<WatchRecord> watchRecords) {
        int res = 0;
        for (WatchRecord watchRecord : watchRecords) {
            System.out.println(watchRecord);
            int watchFee = watchRecord.getWatchPrice();
            int percentage = watchRecord.getPercentageOfAccount();
            int numOfAccount = watchRecord.getDemongraphicGroupNumOfAccount();
            res = res + watchFee * percentage * numOfAccount / 100;
//            System.out.printf("res:%d, watchFee:%d, percentage:%d, numOfAccount:%d, mult:%d \n", res, watchFee, percentage, numOfAccount, watchFee * percentage * numOfAccount);
        }
        return res;
    }

    @Override
    @Transactional
    public int getCostsByDemographicGroupYearMonth(String demographicGroupSN, String yearMonth) {
        List<WatchRecord> watchRecords = watchRecordDAO.findByDemographicGroupYearMonth(demographicGroupSN, yearMonth);
        List<SubscriptionRecord> subscriptionRecords = subscriptionRecordDAO.findByDemographicGroupYearMonth(demographicGroupSN, yearMonth);
        int watchFee = getSumOfWatchFee(watchRecords);
        int subscriptionFee = getSumOfSubscriptionFee(subscriptionRecords);
        return watchFee + subscriptionFee;
    }

    @Override
    @Transactional
    public int getCostsByDemographicGroup(String demographicGroupSN) {
        List<WatchRecord> watchRecords = watchRecordDAO.findByDemographicGroup(demographicGroupSN);
        List<SubscriptionRecord> subscriptionRecords = subscriptionRecordDAO.findByDemographicGroup(demographicGroupSN);
        int watchFee = getSumOfWatchFee(watchRecords);
        int subscriptionFee = getSumOfSubscriptionFee(subscriptionRecords);
        return watchFee + subscriptionFee;
    }

    @Override
    @Transactional
    public int getRevenuesCollectedByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth) {
        List<WatchRecord> watchRecords = watchRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, yearMonth);
        List<SubscriptionRecord> subscriptionRecords = subscriptionRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, yearMonth);
        int watchFee = getSumOfWatchFee(watchRecords);
        int subscriptionFee = getSumOfSubscriptionFee(subscriptionRecords);
        return watchFee + subscriptionFee;
    }

    @Override
    @Transactional
    public int getRevenuesCollectedByStreamingService(String streamingServiceSN) {
        List<WatchRecord> watchRecords = watchRecordDAO.findByStreamingService(streamingServiceSN);
        List<SubscriptionRecord> subscriptionRecords = subscriptionRecordDAO.findByStreamingService(streamingServiceSN);
        int watchFee = getSumOfWatchFee(watchRecords);
        int subscriptionFee = getSumOfSubscriptionFee(subscriptionRecords);
        return watchFee + subscriptionFee;
    }

    @Override
    @Transactional
    public boolean updateDemo(String demographicGroupSN, String demographicGroupLN, int numOfAccounts) {
        List<WatchRecord> watchRecordList = watchRecordDAO.findByDemographicGroupYearMonth(demographicGroupSN, currentYearMonth.toString());
        List<SubscriptionRecord> subscriptionRecords = subscriptionRecordDAO.findByDemographicGroupYearMonth(demographicGroupSN, currentYearMonth.toString());
        DemographicGroup demographicGroup = demographicGroupDAO.findById(demographicGroupSN);
        demographicGroup.setLongName(demographicGroupLN);
        if (watchRecordList.isEmpty() && subscriptionRecords.isEmpty()) {
            demographicGroup.setNumberOfAccount(numOfAccounts);
            demographicGroupDAO.save(demographicGroup);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateStream(String streamingServiceSN, String streamingServiceLN, int subscriptionFee) {
        StreamingService streamingService = streamingServiceDAO.findById(streamingServiceSN);
        streamingService.setLongName(streamingServiceLN);
        List<WatchRecord> watchRecordList = watchRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, currentYearMonth.toString());
        List<SubscriptionRecord> subscriptionRecords = subscriptionRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, currentYearMonth.toString());
        if (watchRecordList.isEmpty() && subscriptionRecords.isEmpty()) {
            streamingService.setSubscribeFee(subscriptionFee);
            streamingServiceDAO.save(streamingService);
            return true;
        }
        return false;
    }
}
