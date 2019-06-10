package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> showAllTrack();
    public Track updateComment(Track track) throws TrackNotFoundException;
    public boolean deleteTrack(Track track) throws TrackNotFoundException;
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;
}
