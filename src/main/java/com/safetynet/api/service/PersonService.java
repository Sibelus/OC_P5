package com.safetynet.api.service;

import com.safetynet.api.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class PersonService {

    private static final Logger logger = LogManager.getLogger(PersonService.class);

    public int calculateAge(Person person){
        int age;
        String birthdate = person.getBirthdate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        long todayMillis = System.currentTimeMillis();

        if(birthdate == null || birthdate.equals("")){
            logger.error("Birthdate provided is null or empty");
            throw new IllegalArgumentException("Birthdate provided is incorrect: " + birthdate);
        }

        try {
            Date parseBirthdate = sdf.parse(birthdate);
            long birthdateMillis = parseBirthdate.getTime();

            if(birthdateMillis > todayMillis){
                logger.error("Birthdate provided is in the future");
                throw new IllegalArgumentException("Birthdate can't be ulterior of today: " + birthdate);
            }

            long durationMillis = todayMillis - birthdateMillis;
            TimeUnit time = TimeUnit.DAYS;
            long ageInDays = time.convert(durationMillis, TimeUnit.MILLISECONDS);
            age = (int) ageInDays/365;
            logger.debug("Person was born {} and her age is {}", parseBirthdate, age);
        } catch (ParseException e) {
            logger.error("Error parsing age", e);
            throw new RuntimeException(e);
        }
        return age;
    }

    public boolean isAnAdult(int age){
        boolean adult = false;
        if(age > 18){
            adult = true;
            logger.debug("This person is an adult");
        } else {
            logger.debug("This person is a child");
        }
        return adult;
    }
}
