package utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.github.javafaker.Faker;

public class RandomUtils {

    public static  String getRandomGender(){
        Random generatorGender = new Random();
        String[] genderArray = {"Male", "Female", "Other"};
        int randomIndexGender = generatorGender.nextInt(genderArray.length);

        return genderArray[randomIndexGender];
    }

    public static String getRandomDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        Faker faker = new Faker();
        String randomDateBirthday = sdf.format(faker.date().birthday());


        return randomDateBirthday;
    }

    public static  String getRandomSubject(){
        Random generatorSubject = new Random();
        String[] subjectArray = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
                "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        int randomIndexSubject = generatorSubject.nextInt(subjectArray.length);

        return subjectArray[randomIndexSubject];
    }

    public static  String getRandomHobbies(){
        Random generatorGender = new Random();
        String[] hobbiesArray = {"Sports", "Reading", "Music"};
        int randomIndexHobbies = generatorGender.nextInt(hobbiesArray.length);

        return hobbiesArray[randomIndexHobbies];
    }


    public  static String getRandomState(){
        Random generatorState = new Random();
        String[] stateArray = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int randomIndexState = generatorState.nextInt(stateArray.length);

        return stateArray[randomIndexState];
    }
    public static String getRandomCity(String state) {
        Random generatorState = new Random();
        String resultCity = getRandomState();
        int randomIndexCity;
        if(state == "NCR"){
            String[] cityArrayNCR = {"Delhi", "Gurgaon", "Noida"};
            randomIndexCity = generatorState.nextInt(cityArrayNCR.length);
            return cityArrayNCR[randomIndexCity];
        } else if (state == "Uttar Pradesh") {
            String[] cityArrayUttar = {"Agra", "Lucknow", "Merrut"};
            randomIndexCity = generatorState.nextInt(cityArrayUttar.length);
            return cityArrayUttar[randomIndexCity];
        }
        else if (state == "Haryana") {
            String[] cityArrayHaryana = {"Karnal", "Panipat"};
            randomIndexCity = generatorState.nextInt(cityArrayHaryana.length);
            return cityArrayHaryana[randomIndexCity];
        } else {
            String[] cityArrayRajasthan = {"Jaipur", "Jaiselmer"};
            randomIndexCity = generatorState.nextInt(cityArrayRajasthan.length);
            return cityArrayRajasthan[randomIndexCity];
        }
    }
}
