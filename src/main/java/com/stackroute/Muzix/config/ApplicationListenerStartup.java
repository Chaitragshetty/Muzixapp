//package com.stackroute.Muzix.config;
//
//import com.stackroute.Muzix.domain.Track;
//import com.stackroute.Muzix.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//import org.jboss.logging.Logger;
//
//@Component
//public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent> {
//    private static final Logger logs = Logger.getLogger(ApplicationListenerStartup.class);
//    private TrackRepository trackRepository;
//
//    @Autowired
//    public ApplicationListenerStartup(TrackRepository trackRepository){
//        this.trackRepository=trackRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
//        logs.info("Inserting data on start");
//
//        Track track1 = new Track(1,"Soniyo","Very Good");
//        trackRepository.save(track1);
//        Track track2 = new Track(2,"Dil meri na sune","Good");
//        trackRepository.save(track2);
//
//        logs.info("data successfully inserted");
//    }
//}
