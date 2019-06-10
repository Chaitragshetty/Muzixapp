package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;
    private TrackServiceImpl trackServiceImpl;

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackID()))
        {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        Track track1=trackRepository.save(track);
        if(track1==null)
        {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        return track1;
    }

    @Override
    public List<Track> showAllTrack() {
        List<Track> track1=(List<Track>) trackRepository.findAll();
        return track1;
    }

    @Override
    public Track updateComment(Track track) throws TrackNotFoundException {
        if(trackRepository.existsById(track.getTrackID()))
        {
            Track track1=trackRepository.findById(track.getTrackID()).get();
            track1.setTrackComments(track.getTrackComments());
            trackRepository.save(track1);
            return track1;
        }
        else
        {
            throw new TrackNotFoundException("Track Not Found");
        }
    }

    @Override
    public boolean deleteTrack(Track track) throws TrackNotFoundException{
        if(trackRepository.existsById(track.getTrackID()))
        {
            trackRepository.deleteById(track.getTrackID());
            return true;
        }
        else {
            throw new TrackNotFoundException("Track Not Found");
        }
    }

    @Override
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
        List<Track> trackList=null;
        trackList=trackRepository.getTrackByName(trackName);
        if(trackList.equals(null))
        {
            throw new TrackNotFoundException("Track Not Found");
        }
        return trackList;
    }
}
