package edu.gatech.streamingwars.service;

import edu.gatech.streamingwars.dao.*;
import edu.gatech.streamingwars.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShowLicenseManagementSystemImpl implements ShowLicenseManagementSystem{

    private DemographicGroupDAO demographicGroupDAO;
    private ShowDAO showDAO;
    private ShowLicenseRecordDAO showLicenseRecordDAO;
    private StreamingServiceDAO streamingServiceDAO;
    private StudioDAO studioDAO;
    private SubscriptionRecordDAO subscriptionRecordDAO;
    private WatchRecordDAO watchRecordDAO;
    private YearMonth currentYearMonth;

    @Autowired
    public ShowLicenseManagementSystemImpl(DemographicGroupDAO demographicGroupDAO, ShowDAO showDAO, ShowLicenseRecordDAO showLicenseRecordDAO, StreamingServiceDAO streamingServiceDAO, StudioDAO studioDAO, SubscriptionRecordDAO subscriptionRecordDAO, WatchRecordDAO watchRecordDAO, YearMonth yearMonth) {
        this.demographicGroupDAO = demographicGroupDAO;
        this.showDAO = showDAO;
        this.showLicenseRecordDAO = showLicenseRecordDAO;
        this.streamingServiceDAO = streamingServiceDAO;
        this.studioDAO = studioDAO;
        this.subscriptionRecordDAO = subscriptionRecordDAO;
        this.watchRecordDAO = watchRecordDAO;
        this.currentYearMonth = yearMonth;
    }

    @Override
    @Transactional
    public List<Show> displayShows() {
        return showDAO.findAll();
    }

    @Override
    @Transactional
    public List<ShowLicenseRecord> displayOffers() {
        return showLicenseRecordDAO.findAll();
    }

    private int getLicenseFee(List<ShowLicenseRecord> showLicenseRecords) {
        int res = 0;
        for (ShowLicenseRecord showLicenseRecord : showLicenseRecords) {
            res = res + showLicenseRecord.getLicenseFee();
        }
        return res;
    }

    @Override
    @Transactional
    public int getLicenseFeeByStreamingYearMonth(String streamingServiceSN, String yearMonth) {
        List<ShowLicenseRecord> showLicenseRecords = showLicenseRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, yearMonth);
        return getLicenseFee(showLicenseRecords);
    }

    @Override
    @Transactional
    public int getLicenseFeeByStudioYearMonth(String studioSN, String yearMonth) {
        List<ShowLicenseRecord> showLicenseRecords = showLicenseRecordDAO.findByStudioYearMonth(studioSN, yearMonth);
        return getLicenseFee(showLicenseRecords);
    }

    @Override
    @Transactional
    public int getLicenseFeeByStudio(String studioSN) {
        List<ShowLicenseRecord> showLicenseRecords = showLicenseRecordDAO.findByStudio(studioSN);
        return getLicenseFee(showLicenseRecords);
    }

    @Override
    @Transactional
    public int getLicenseFeeByStreamingService(String streamingServiceSN) {
        List<ShowLicenseRecord> showLicenseRecords = showLicenseRecordDAO.findByStreamingService(streamingServiceSN);
        return getLicenseFee(showLicenseRecords);
    }

    @Override
    @Transactional
    public void addStudio(Studio studio) {
        studioDAO.save(studio);
    }

    @Override
    @Transactional
    public Studio getStudio(String studioSN) {
        Studio studio = studioDAO.findById(studioSN);
        return studio;
    }

    @Override
    @Transactional
    public void addShow(Show show) {
        showDAO.save(show);
    }

    @Override
    @Transactional
    public Show getShow(String showSN, int year) {
        Show show = showDAO.findById(showSN, year);
        return show;
    }

    @Override
    @Transactional
    public void streamingServiceGetLicenseFromStudio(String streamingServiceSN, String showSN, int year, int watchPrice) {
        Show show = showDAO.findById(showSN, year);
        System.out.print(show);
        int licenseFee = show.getLicenseFee();
        String studioShortName = show.getStudioName();
//        String output = new String();
//        output += "streamingServiceSN:"+streamingServiceSN+"\n"
//                +"showSN"+"\n"
//                + year+"\n"
//                + currentYearMonth.toString() +"\n"
//                + licenseFee+"\n"
//                + watchPrice+"\n"
//                +studioShortName;
//        System.out.println(output);
        ShowLicenseRecord showLicenseRecord = new ShowLicenseRecord(streamingServiceSN, showSN, year, currentYearMonth.toString(), licenseFee, watchPrice, studioShortName);
        showLicenseRecordDAO.save(showLicenseRecord);
    }

    @Override
    @Transactional
    public void streamingServiceGetPPVLicenseFromStudio(String streamingServiceSN, String showSN, int year, int price) {
        streamingServiceGetLicenseFromStudio(streamingServiceSN, showSN, year, price);
    }

    @Override
    @Transactional
    public void streamingServiceGetMovieLicenseFromStudio(String streamingServiceSN, String showSN, int year) {
        streamingServiceGetLicenseFromStudio(streamingServiceSN, showSN, year, 0);
    }

    @Override
    @Transactional
    public boolean updateEvent(String showSN, int year, int duration, int licenseFee) {
        Show show = showDAO.findById(showSN, year);
        show.setDuration(duration);
        List<WatchRecord> records = watchRecordDAO.findByShowYearYearMonth(showSN, year, currentYearMonth.toString());
        if (records.isEmpty()) {
            show.setLicenseFee(licenseFee);
            showDAO.save(show);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean retractMovie(String streamingServiceSN, String showSN, int year) {
        List<WatchRecord> records = watchRecordDAO.findByStreamingServiceShowYearYearMonth(streamingServiceSN, showSN, year, currentYearMonth.toString());
        if (records.isEmpty()) {
            showLicenseRecordDAO.deleteById(streamingServiceSN, showSN, year, currentYearMonth.toString());
            return true;
        }
        return false;
    }
}
