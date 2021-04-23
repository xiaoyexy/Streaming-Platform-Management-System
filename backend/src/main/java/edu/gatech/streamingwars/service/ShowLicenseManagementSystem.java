package edu.gatech.streamingwars.service;

import edu.gatech.streamingwars.entity.Show;
import edu.gatech.streamingwars.entity.ShowLicenseRecord;
import edu.gatech.streamingwars.entity.StreamingService;
import edu.gatech.streamingwars.entity.Studio;

import java.util.HashMap;
import java.util.List;

public interface ShowLicenseManagementSystem {
    public List<Show> displayShows();
    public List<ShowLicenseRecord> displayOffers();

    public int getLicenseFeeByStreamingYearMonth(String streamingServiceSN, String yearMonth);
    public int getLicenseFeeByStudioYearMonth(String studioSN, String yearMonth);
    public int getLicenseFeeByStudio(String studioSN);
    public int getLicenseFeeByStreamingService(String streamingServiceSN);

    public void addStudio(Studio studio);
    public Studio getStudio(String studioSN);

    public void addShow(Show show);
    public Show getShow(String showSN, int year);

    public void streamingServiceGetLicenseFromStudio(String streamingServiceSN, String showSN, int year, int price);
    public void streamingServiceGetPPVLicenseFromStudio(String streamingServiceSN, String showSN, int year, int price);
    public void streamingServiceGetMovieLicenseFromStudio(String streamingServiceSN, String showSN, int year);

    public boolean updateEvent(String showSN, int year, int duration, int licenseFee);
    public boolean retractMovie(String streamingServiceSN, String showSN, int year);
}
