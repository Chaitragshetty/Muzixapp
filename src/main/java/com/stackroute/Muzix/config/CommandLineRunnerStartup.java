//package com.stackroute.Muzix.config;
//
//import com.stackroute.Muzix.domain.Track;
//import com.stackroute.Muzix.repository.TrackRepository;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.slf4j.Logger;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CommandLineRunnerStartup implements CommandLineRunner {
//
//    public static final Logger logs = LoggerFactory.getLogger(CommandLineRunnerStartup.class);
//    private TrackRepository trackRepository;
//
//    @Autowired
//    public CommandLineRunnerStartup(TrackRepository trackRepository){
//        this.trackRepository=trackRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception{
//
//
//        logs.info("Inserting data on start");
//
//        Track track1 = new Track(7,"Coca cola","Good");
//        trackRepository.save(track1);
//        Track track2 = new Track(8,"Man mast magan","Good");
//        trackRepository.save(track2);
//
//        logs.info("data successfully inserted");
//    }
//}
