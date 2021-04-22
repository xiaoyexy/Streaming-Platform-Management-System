package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.StreamingService;

import java.util.List;

public interface StreamingServiceDAO {
    public List<StreamingService> findAll();
    public StreamingService findById(String streamingServiceShortName);
    public void save(StreamingService streamingService);
}
