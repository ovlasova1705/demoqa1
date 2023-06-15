package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {

    //public final static  String FIRST_NAME = "John", LAST_NAME = "Boom";
    Faker faker = new Faker();
    //Faker faker = new Faker(new Locale("en-US"));
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = getRandomGender();
    String subject = getRandomSubject();
    String hobbies = getRandomHobbies();
    String userNumber = String.valueOf(faker.number().randomNumber(10, true));
    String dateBirthday = getRandomDate();
    String currentAddress = faker.address().streetAddress();
    String stateValue = getRandomState(); // "NCR";
    String cityValue = getRandomCity(stateValue); //"Delhi";
    String fileName = "img/image.png";

    String space = " ";
    String[] subStrDate = dateBirthday.split(space);
    String checkDateBirthday = subStrDate[0] + "," + subStrDate[1]+"," + subStrDate[2];



}
