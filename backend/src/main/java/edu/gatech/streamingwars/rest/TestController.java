package edu.gatech.streamingwars.rest;

import edu.gatech.streamingwars.dao.*;
import edu.gatech.streamingwars.entity.*;
import edu.gatech.streamingwars.service.ShowLicenseManagementSystem;
import edu.gatech.streamingwars.service.StreamingServiceSystem;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private DemographicGroupDAO demographicGroupDAO;

    private UsersDAO usersDAO;
    private ShowDAO showDAO;
    private ShowLicenseRecordDAO showLicenseRecordDAO;
    private StreamingServiceDAO streamingServiceDAO;
    private StudioDAO studioDAO;
    private SubscriptionRecordDAO subscriptionRecordDAO;
    private WatchRecordDAO watchRecordDAO;
    private StreamingServiceSystem streamingServiceSystem;
    private ShowLicenseManagementSystem showLicenseManagementSystem;

    public TestController(DemographicGroupDAO demographicGroupDAO, ShowDAO showDAO, ShowLicenseRecordDAO showLicenseRecordDAO, StreamingServiceDAO streamingServiceDAO, StudioDAO studioDAO, SubscriptionRecordDAO subscriptionRecordDAO, WatchRecordDAO watchRecordDAO, StreamingServiceSystem streamingServiceSystem, ShowLicenseManagementSystem showLicenseManagementSystem,UsersDAO usersDAO) {
        this.demographicGroupDAO = demographicGroupDAO;
        this.showDAO = showDAO;
        this.showLicenseRecordDAO = showLicenseRecordDAO;
        this.streamingServiceDAO = streamingServiceDAO;
        this.studioDAO = studioDAO;
        this.subscriptionRecordDAO = subscriptionRecordDAO;
        this.watchRecordDAO = watchRecordDAO;
        this.streamingServiceSystem = streamingServiceSystem;
        this.showLicenseManagementSystem = showLicenseManagementSystem;
        this.usersDAO=usersDAO;
    }

    @GetMapping("/list_demographic_group")
    public List<DemographicGroup> listDemographicGroup() {
        return demographicGroupDAO.findAll();
    }

    @GetMapping("/list_demographic_group/{shortName}")
    public DemographicGroup findByDemographicGroupId(@PathVariable String shortName) {
        DemographicGroup demographicGroup = demographicGroupDAO.findById(shortName);
        return demographicGroup;
    }

    @PostMapping(path="/users/authenticate", consumes="application/json", produces="application/json")
    public List<User> authenticate(@RequestBody User user) {
        System.out.println(user);
        return usersDAO.authenticate(user.getUsername(),user.getPassword());}

    @GetMapping("/list_show")
    public List<Show> listShow() {
        return showDAO.findAll();
    }

    @GetMapping("/list_show/{shortName}/{strYear}")
    public Show findShowById(@PathVariable String shortName, @PathVariable String strYear) {
        Integer year = Integer.valueOf(strYear);
        return showDAO.findById(shortName, year);
    }

    @GetMapping("/list_streaming_service")
    public List<StreamingService> listStreamingService() {
        return streamingServiceDAO.findAll();
    }

    @GetMapping("/list_studio")
    public List<Studio> listStudio() {
        return studioDAO.findAll();
    }

    @GetMapping("/list_show_license_record")
    public List<ShowLicenseRecord> listShowLicenseRecord() {
        return showLicenseRecordDAO.findAll();
    }

    @GetMapping("/list_show_license_record_q1/{studioSN}")
    public List<ShowLicenseRecord> listShowLicenseRecordQ1(@PathVariable String studioSN) {
        int fee = showLicenseManagementSystem.getLicenseFeeByStudio(studioSN);
        System.out.println("studio fee:" + fee);
        return showLicenseRecordDAO.findByStudio(studioSN);
    }
    @GetMapping("/list_show_license_record_q2/{studioSN}/{yearMonth}")
    public List<ShowLicenseRecord> listShowLicenseRecordQ2(@PathVariable String studioSN, @PathVariable  String yearMonth) {
        int fee = showLicenseManagementSystem.getLicenseFeeByStudioYearMonth(studioSN, yearMonth);
        System.out.println("studio fee:" + fee);
        return showLicenseRecordDAO.findByStudioYearMonth(studioSN, yearMonth);
    }
    @GetMapping("/list_show_license_record_q3/{streamingServiceSN}/{yearMonth}")
    public List<ShowLicenseRecord> listShowLicenseRecordQ3(@PathVariable String streamingServiceSN, @PathVariable String yearMonth) {
        int fee = showLicenseManagementSystem.getLicenseFeeByStreamingYearMonth(streamingServiceSN, yearMonth);
        System.out.println("studio fee:" + fee);
        return showLicenseRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, yearMonth);
    }

    @GetMapping("/list_show_license_record_q4/{streamingServiceSN}")
    public List<ShowLicenseRecord> listShowLicenseRecordQ3(@PathVariable String streamingServiceSN) {
        int fee = showLicenseManagementSystem.getLicenseFeeByStreamingService(streamingServiceSN);
        System.out.println("studio fee:" + fee);
        return showLicenseRecordDAO.findByStreamingService(streamingServiceSN);
    }

    @GetMapping("/list_subscription_record")
    public List<SubscriptionRecord> listSubscriptionRecord() {
        return subscriptionRecordDAO.findAll();
    }

    @GetMapping("/list_watch_record")
    public List<WatchRecord> listWatchRecord() {
        return watchRecordDAO.findAll();
    }

    @GetMapping("/string")
    public String stringTest(){
        return "I am a string";
    }

    @GetMapping("/time")
    public String getTime(){
        return streamingServiceSystem.displayTime();
    }

    @GetMapping("/list_watch_test/{streamingServiceSN}/{demographicGroupSN}/{yearMonth}")
    public List<WatchRecord> getWatchRecords(@PathVariable String streamingServiceSN, @PathVariable String demographicGroupSN, @PathVariable String yearMonth) {
        System.out.println("dg:" + streamingServiceSystem.getCostsByDemographicGroup(demographicGroupSN));
        System.out.println("dg ym:" + streamingServiceSystem.getCostsByDemographicGroupYearMonth(demographicGroupSN, yearMonth));
        System.out.println("ss:" + streamingServiceSystem.getRevenuesCollectedByStreamingService(streamingServiceSN));
        System.out.println("ss ym:" + streamingServiceSystem.getRevenuesCollectedByStreamingServiceYearMonth(streamingServiceSN, yearMonth));
        List<WatchRecord> res = watchRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, yearMonth);
        res.addAll(watchRecordDAO.findByDemographicGroupYearMonth(demographicGroupSN, yearMonth));
        return res;
    }

    @GetMapping("/list_subscription_test/{streamingServiceSN}/{demographicGroupSN}/{yearMonth}")
    public List<SubscriptionRecord> getSubRecords(@PathVariable String streamingServiceSN, @PathVariable String demographicGroupSN, @PathVariable String yearMonth) {
        System.out.println("dg:" + streamingServiceSystem.getCostsByDemographicGroup(demographicGroupSN));
        System.out.println("dg ym:" + streamingServiceSystem.getCostsByDemographicGroupYearMonth(demographicGroupSN, yearMonth));
        System.out.println("ss:" + streamingServiceSystem.getRevenuesCollectedByStreamingService(streamingServiceSN));
        System.out.println("ss ym:" + streamingServiceSystem.getRevenuesCollectedByStreamingServiceYearMonth(streamingServiceSN, yearMonth));
        List<SubscriptionRecord> res = subscriptionRecordDAO.findByStreamingServiceYearMonth(streamingServiceSN, yearMonth);
        res.addAll(subscriptionRecordDAO.findByDemographicGroupYearMonth(demographicGroupSN, yearMonth));
        return res;
    }

    @GetMapping("/test_bool")
    public boolean testBool(){
        List<WatchRecord> watchRecords = watchRecordDAO.findAll();
        if (watchRecords.isEmpty()) {
            return false;
        }
        return true;
    }
}
