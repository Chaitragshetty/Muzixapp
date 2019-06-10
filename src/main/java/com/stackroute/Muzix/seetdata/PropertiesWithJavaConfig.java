/*
package com.stackroute.Muzix.config;

import com.stackroute.Muzix.domain.Track;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class PropertiesWithJavaConfig {

    @Value("${trackID}")
    private int trackID;

    @Value("${trackName}")
    private String trackName;

    @Value("${trackComments}")
    private String trackComments;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public Track dataSource() {
        Track dataSource = new Track();
        dataSource.setTrackID(trackID);
        dataSource.setTrackName(trackName);
        dataSource.setTrackComments(trackComments);
        return dataSource;
    }
}
*/



package com.stackroute.Muzix.seetdata;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;

@Component
@PropertySource("classpath:application.properties")
public class PropertiesWithJavaConfig implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(PropertiesWithJavaConfig.class);
    private TrackRepository trackRepository;

    @Autowired
    public PropertiesWithJavaConfig(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Value("${trackID}")
    private int trackID;

    @Value("${trackName}")
    private String trackName;

    @Value("${trackComments}")
    private String trackComments;

    @Autowired
    Environment env;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        logs.info("Inserting data on start");

        Track track1 = new Track(trackID,trackName,trackComments);
        trackRepository.save(track1);

        Track track2 = new Track(Integer.parseInt(env.getProperty("trackID1")),env.getProperty("trackName1"),env.getProperty("trackComments1"));
        trackRepository.save(track2);

        logs.info("data successfully inserted");
    }
}
