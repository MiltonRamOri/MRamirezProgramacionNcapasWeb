package com.digis01.MRamirezProgramacionNcapasWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MRamirezProgramacionNcapasWebApplication implements CommandLineRunner {

    private static Logger LOG =
            LoggerFactory.getLogger(MRamirezProgramacionNcapasWebApplication.class);
    
    
    public static void main(String[] args) {
        SpringApplication.run(MRamirezProgramacionNcapasWebApplication.class, args);

       
    }

    @Override
    public void run(String... args) throws Exception {
         LOG.warn("peligro");
    }

}
