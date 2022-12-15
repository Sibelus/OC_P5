package com.safetynet.api.service;

import com.safetynet.api.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonServiceTest {

    @Test
    public void testCalculateAge_PersonBornYesterday(){
        //GIVEN
        Date birthdate = new Date();
        birthdate.setTime( System.currentTimeMillis() - (24 * 60 * 60 * 1000) );
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String birthdateAsString = sdf.format(birthdate);

        Person person = new Person();
        person.setBirthdate(birthdateAsString);

        //WHEN
        PersonService personService = new PersonService();
        int age = personService.calculateAge(person);

        //THEN
        Assertions.assertEquals(0, age);
    }

    @Test
    public void testCalculateAge_PersonBornTomorrow(){
        //GIVEN
        Date birthdate = new Date();
        birthdate.setTime( System.currentTimeMillis() + (24 * 60 * 60 * 1000) );
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String birthdateAsString = sdf.format(birthdate);

        Person person = new Person();
        person.setBirthdate(birthdateAsString);

        //WHEN
        PersonService personService = new PersonService();

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.calculateAge(person));
    }

    @Test
    public void testCalculateAge_UnknownBirthdate(){
        //GIVEN
        Person person = new Person();
        person.setBirthdate(null);

        //WHEN
        PersonService personService = new PersonService();
        //int age = personService.calculateAge(person);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.calculateAge(person));
    }

    @Test
    public void testCalculateAge_EmptyBirthdate(){
        //GIVEN
        Person person = new Person();
        person.setBirthdate("");

        //WHEN
        PersonService personService = new PersonService();
        //int age = personService.calculateAge(person);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.calculateAge(person));
    }

    @Test
    public void testCalculateAge_WrongBirthdateParsing(){
        //GIVEN
        String birthdate = "01-01-2000";
        Person person = new Person();
        person.setBirthdate(birthdate);

        //WHEN
        PersonService personService = new PersonService();

        //THEN
        Assertions.assertThrows(RuntimeException.class, () -> personService.calculateAge(person));
    }

    @Test
    public void testPersonIsAnAdult(){
        //GIVEN
        int age = 19;

        //WHEN
        PersonService personService = new PersonService();
        boolean isAnAdult = personService.isAnAdult(age);

        //THEN
        Assertions.assertTrue(isAnAdult);
    }

    @Test
    public void testPersonIsAChild(){
        //GIVEN
        int age = 18;

        //WHEN
        PersonService personService = new PersonService();
        boolean isAChild = personService.isAnAdult(age);

        //THEN
        Assertions.assertFalse(isAChild);
    }

}
