package com.safetynet.api.service;

import com.safetynet.api.model.Person;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonService {

    public int calculateAge(Person person){
        int age = 0;
        String birthdate = person.getBirthdate();
        SimpleDateFormat sdt = new SimpleDateFormat("yyyyy/mm/dd");
        long todayMillis = System.currentTimeMillis();

        try {
            Date date = sdt.parse(birthdate);
            long dateMillis = date.getTime();
            age = (int) (todayMillis - dateMillis)/(60*60*1000);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return age;
    }

    public boolean isAnAdult(int age){
        boolean adult = false;
        if(age > 18){
            adult = true;
        }
        return adult;
    }
}
