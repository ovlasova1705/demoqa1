package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxFirstForm extends TestBase{


    @Test
    void correctTest(){
        String name = "Olja";

        open("/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("mail@mail.com");
        $("[id=currentAddress]").setValue("NYC,Linkoln strasse 666");
        $("[id=permanentAddress]").setValue("Alabama, nostreet");
        $("[id=submit]").click();
        $("[id=output]").shouldHave(text(name),text("mail@mail.com"),
                text("NYC,Linkoln strasse 666"),text("Alabama, nostreet"));
    }
}
