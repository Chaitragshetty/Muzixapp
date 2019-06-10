package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.service.TrackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrackControl {

    @Autowired
    private TrackService trackService;

    @Autowired
    Environment env;

    public TrackControl(TrackService trackService)
    {
        this.trackService=trackService;
    }

    public void setTrackService(TrackService trackService)
    {
        this.trackService=trackService;
    }

    @RequestMapping(value = "track",method = RequestMethod.POST)
    public ResponseEntity<Track> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            Track track1 = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);
        }
        catch (TrackAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "track",method = RequestMethod.GET)
    public ResponseEntity<List<Track>> showAllTracks()
    {
        List<Track> track1=trackService.showAllTrack();
        return new ResponseEntity<List<Track>>(track1,HttpStatus.OK);
    }

    @RequestMapping(value = "track", method= RequestMethod.PUT)
    public ResponseEntity<String> updateTrack(@RequestBody Track track) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        Track track1=trackService.updateComment(track);
        return new ResponseEntity<String>("Successfully Updated",HttpStatus.OK);
    }

    @RequestMapping(value = "track", method= RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrack(@RequestBody Track track) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        boolean answer=trackService.deleteTrack(track);
        return new ResponseEntity<String>(env.getProperty("delmsg"), HttpStatus.OK);
    }

    @RequestMapping(value = "track/{trackName}", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String trackName) throws TrackNotFoundException
    {
        List<Track> track1=trackService.getTrackByName(trackName);
        return new ResponseEntity<List<Track>>(track1, HttpStatus.OK);
    }

    /*@Value("${trackID}")
    private String trackID;

    private String trackComments;

    @GetMapping("value")
    public String getValue()
    {
        return trackID;
    }*/
}
