package edu.gatech.streamingwars.rest;

import edu.gatech.streamingwars.service.ShowLicenseManagementSystem;
import edu.gatech.streamingwars.service.StreamingServiceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.gatech.streamingwars.entity.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
// @CrossOrigin(origins = "http://localhost:3000")
public class ApiController {
    private ShowLicenseManagementSystem showLicenseManagementSystem;
    private StreamingServiceSystem streamingServiceSystem;
    private YearMonth yearMonth;

    @Autowired
    public ApiController(ShowLicenseManagementSystem showLicenseManagementSystem, StreamingServiceSystem streamingServiceSystem, YearMonth yearMonth) {
        this.showLicenseManagementSystem = showLicenseManagementSystem;
        this.streamingServiceSystem = streamingServiceSystem;
        this.yearMonth = yearMonth;
    }

    @PostMapping("/test")
    public String testPost(@RequestBody HashMap<String, String> params) {
        System.out.println(params);
        System.out.println(params.get("10"));

        return "success";
    }

    @PostMapping("/create_demo")
    public void createDemo(@RequestBody HashMap<String, String> params) {
        System.out.println("/create_demo:" + params.toString());
        String shortName = params.get("shortName");
        String longName = params.get("longName");
        Integer numberOfAccounts = Integer.valueOf(params.get("numberOfAccounts"));
        DemographicGroup demographicGroup = new DemographicGroup(shortName, longName, numberOfAccounts);
        streamingServiceSystem.addDemographicGroup(demographicGroup);
    }

    @PostMapping("/create_event")
    public void createEvent(@RequestBody HashMap<String, String> params) {
        System.out.println("/create_event:" + params.toString());
        String showType = params.get("type");
        String showName = params.get("name");
        Integer yearProduced = Integer.valueOf(params.get("yearProduced"));
        Integer duration = Integer.valueOf(params.get("duration"));
        Integer licenseFee = Integer.valueOf(params.get("licenseFee"));
        String studioSN = params.get("studio");
        Show show = new Show(showName, yearProduced, duration, showType, licenseFee, studioSN);
        showLicenseManagementSystem.addShow(show);
    }


    @PostMapping("/create_studio")
    public void createStuido(@RequestBody HashMap<String, String> params) {
        System.out.println("/create_demo:" + params.toString());
        String shortName = params.get("shortName");
        String longName = params.get("longName");
        Studio studio = new Studio(shortName, longName);
        showLicenseManagementSystem.addStudio(studio);
    }

    @PostMapping("/create_streaming_service")
    public void createStudio(@RequestBody HashMap<String, String> params) {
        System.out.println("/create_streaming_service:" + params.toString());
        String shortName = params.get("shortName");
        String longName = params.get("longName");
        Integer subscriptionPrice = Integer.valueOf(params.get("subscriptionPrice"));
        StreamingService streamingService = new StreamingService(shortName, longName, subscriptionPrice);
        streamingServiceSystem.addStreamingService(streamingService);
    }

    @PostMapping("/offer_movie")
    public void offerMovie(@RequestBody HashMap<String, String> params) {
        System.out.println("/offer_movie:" + params.toString());
        String streamingServiceSN = params.get("streamingService");
        String showSN = params.get("movieName");
        Integer year = Integer.valueOf(params.get("yearProduced"));
        showLicenseManagementSystem.streamingServiceGetLicenseFromStudio(streamingServiceSN, showSN, year, 0);
    }

    @PostMapping("/offer_ppv")
    public void offerPPV(@RequestBody HashMap<String, String> params) {
        System.out.println("/offer_ppv:" + params.toString());
        String streamingServiceSN = params.get("streamingService");
        String showSN = params.get("payPerViewName");
        Integer year = Integer.valueOf(params.get("yearProduced"));
        Integer price = Integer.valueOf(params.get("viewingPrice"));
        showLicenseManagementSystem.streamingServiceGetLicenseFromStudio(streamingServiceSN, showSN, year, price);
    }

    @PostMapping("/watch_event")
    public void watchEvent(@RequestBody HashMap<String, String> params) {
        System.out.println("/watch_event:" + params.toString());
        String demographicGroupSN = params.get("demographicGroup");
        Integer percentage = Integer.valueOf(params.get("percentage"));
        String streamingServiceSN = params.get("streamingService");
        Integer year = Integer.valueOf(params.get("yearProduced"));
        String showSN = params.get("eventName");
        streamingServiceSystem.demographicGroupWatchShow(demographicGroupSN, percentage, streamingServiceSN, showSN, year);
    }

    @GetMapping("/next_month")
    public void nextMonth() {
        System.out.println("/next_month");
        streamingServiceSystem.nextMonth();
        System.out.println(streamingServiceSystem.displayTime());
    }

    @PostMapping("display_demo")
    public String displayDemo(@RequestBody HashMap<String, String> params) {
        String res = new String();
        String demographicGroupSN = params.get("shortName");
        DemographicGroup demographicGroup = streamingServiceSystem.getDemographicGroup(demographicGroupSN);
        res += demographicGroup.toString();
        res += "\n";
        int currentPeriod = streamingServiceSystem.getCostsByDemographicGroupYearMonth(demographicGroupSN, yearMonth.toString());
        int total = streamingServiceSystem.getCostsByDemographicGroup(demographicGroupSN);
        int previousPeriod = streamingServiceSystem.getCostsByDemographicGroupYearMonth(demographicGroupSN, yearMonth.getPrevYearMonth().toString());

        res += "currentPeriod:" + currentPeriod + "\n"
                + "perviousPeriod:" + previousPeriod + "\n"
                + "total:" + total;
        return res;
    }

    @PostMapping("display_stream")
    public String displayStream(@RequestBody HashMap<String, String> params) {
        String res = new String();
        String streamingServiceSN = params.get("shortName");
        StreamingService streamingService = streamingServiceSystem.getStreamingService(streamingServiceSN);
        res += streamingService.toString();
        res += "\n";
        int licenseFee = showLicenseManagementSystem.getLicenseFeeByStreamingService(streamingServiceSN);
        int currentPeriod = streamingServiceSystem.getRevenuesCollectedByStreamingServiceYearMonth(streamingServiceSN, yearMonth.toString());
        int previousPeriod = streamingServiceSystem.getRevenuesCollectedByStreamingServiceYearMonth(streamingServiceSN, yearMonth.getPrevYearMonth().toString());
        int total = streamingServiceSystem.getRevenuesCollectedByStreamingService(streamingServiceSN);
        res += "currentPeriod:" + currentPeriod + "\n"
                + "perviousPeriod:" + previousPeriod + "\n"
                + "total:" + total + "\n"
                + "licenseFee:" + licenseFee;
        return res;
    }

    @PostMapping("display_studio")
    public String displayStudio(@RequestBody HashMap<String, String> params) {
        String res = new String();
        String studioSN = params.get("shortName");
        Studio studio = showLicenseManagementSystem.getStudio(studioSN);
        res += studio.toString();
        res += "\n";
        int currentPeriod = showLicenseManagementSystem.getLicenseFeeByStudioYearMonth(studioSN, yearMonth.toString());
        int previousPeriod = showLicenseManagementSystem.getLicenseFeeByStudioYearMonth(studioSN, yearMonth.getPrevYearMonth().toString());
        int total = showLicenseManagementSystem.getLicenseFeeByStudio(studioSN);
        res += "currentPeriod:" + currentPeriod + "\n"
                + "perviousPeriod:" + previousPeriod + "\n"
                + "total:" + total;
        return res;
    }

    @GetMapping("display_events")
    public List<Show> displayEvents() {
        return showLicenseManagementSystem.displayShows();
    }

    @GetMapping("display_offers")
    public List<ShowLicenseRecord> displayOffers(){
        return showLicenseManagementSystem.displayOffers();
    }


    @PostMapping("/update_demo")
    public boolean updateDemo(@RequestBody HashMap<String, String> params) {
        System.out.println("/update_demo:" + params.toString());
        String shortName = params.get("shortName");
        String longName = params.get("longName");
        Integer numberOfAccounts = Integer.valueOf(params.get("numberOfAccounts"));
        return streamingServiceSystem.updateDemo(shortName, longName, numberOfAccounts);
    }


}
