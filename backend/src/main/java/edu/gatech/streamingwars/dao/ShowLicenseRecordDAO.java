package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.ShowLicenseRecord;
import edu.gatech.streamingwars.entity.SubscriptionRecord;

import java.util.List;

public interface ShowLicenseRecordDAO {
    public List<ShowLicenseRecord> findAll();
    public ShowLicenseRecord findById(String streamingServiceShortName, String showShortName, String yearMonth);
    public void save(ShowLicenseRecord showLicenseRecord);

}
