package com.stackroute.Muzix.repository;


import com.stackroute.Muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackID(4);
        track.setTrackName("Fourth");
        track.setTrackComments("Good Song");
    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }

    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getTrackID()).get();
        Assert.assertEquals(4,fetchUser.getTrackID());
    }

    @Test
    public void testSaveTrackFailure(){
        Track testUser = new Track(5,"Fifth","Gud");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getTrackID()).get();
        Assert.assertNotSame(testUser,track);
    }

    @Test
    public void testGetAllTrack(){
        Track u = new Track(6,"Sixth","Bad");
        Track u1 = new Track(7,"Seventh","Gud");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = (List<Track>) trackRepository.findAll();
        Assert.assertEquals("Sixth",list.get(0).getTrackName());

    }
}