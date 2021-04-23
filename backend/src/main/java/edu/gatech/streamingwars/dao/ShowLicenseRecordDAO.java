package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.ShowLicenseRecord;
import edu.gatech.streamingwars.entity.SubscriptionRecord;

import java.util.List;

public interface ShowLicenseRecordDAO {
    public List<ShowLicenseRecord> findAll();
    public ShowLicenseRecord findById(String streamingServiceShortName, String showShortName, Integer showYear, String yearMonth);
    public void save(ShowLicenseRecord showLicenseRecord);
    public List<ShowLicenseRecord> findByStudio(String studioSN);
    public List<ShowLicenseRecord> findByStudioYearMonth(String studioSN, String yearMonth);
    public List<ShowLicenseRecord> findByStreamingServiceYearMonth(String streamingServiceSN, String yearMonth);
    public List<ShowLicenseRecord> findByStreamingService(String streamingServiceSN);
    public void deleteById(String streamingServiceShortName, String showShortName, Integer showYear, String yearMonth);
}
