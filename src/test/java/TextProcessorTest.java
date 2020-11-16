import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {


    //Att skapa en ny instans av TextProcessor längre kan strula om String input inte har ett värde.
    //En passande tillämpning av assertNotNull hamnar därför här.

    @Test
    @BeforeAll
    @DisplayName("Kolla så att input inte är Null - utan att den har ett placeholdervärde.")
    static void main() {

        assertNotNull(TextProcessor.input);
        System.out.println("OK! Input är inte null. Testet fortsätter.");
    }

    //Slutet gott allting gott.

    @Test
    @AfterAll
    @DisplayName("Testet avslutat!")
    static void EndTest() {
        System.out.println("Alla test lyckades!");
    }

    //Följande metod testas bara en gång.
    //Det finns bara ett hårdkodat Strängvärde att omvandla och prova.
    //Testet är bara att kolla ett förväntat strängvärde exempel.

    @Test
    @DisplayName("Konvertering till STORA BOKSTÄVER")
    void toUpper() {

        TextProcessor testProcessor = new TextProcessor();

        TextProcessor.input = "den här texten ska vara i stora bokstäver";

        System.out.println("Text efter metod: ");

        String output = testProcessor.toUpper();

        assertEquals("DEN HÄR TEXTEN SKA VARA I STORA BOKSTÄVER", "" + output, "Text efter metod:" + output);

        System.out.println("\nText innan metod: " + "\n" + TextProcessor.input);

    }

    //Följande metod testas bara en gång.
    //Det finns bara ett hårdkodat Strängvärde att omvandla och prova.
    //Testet är bara att kolla ett förväntat strängvärde exempel.

    @Test
    @DisplayName("Konvertering till små bokstäver")
    void toLower() {

        TextProcessor testProcessor = new TextProcessor();

        TextProcessor.input = "DEN HÄR TEXTEN SKA VARA I SMÅ BOKSTÄVER";

        System.out.println("Text efter metod: " + TextProcessor.input);

        String output = testProcessor.toLower();

        assertEquals("den här texten ska vara i små bokstäver", "" + output, "Text efter metod:" + output);

        System.out.println("\nText innan metod: " + "\n" + TextProcessor.input);

    }

    //Följande metod testas bara en gång.
    //Det finns bara ett hårdkodat Strängvärde att omvandla och prova.
    //Testet är bara att kolla ett förväntat strängvärde exempel.

    @Test
    @DisplayName("Visa texten baklänges")
    void reverse() {

        TextProcessor testProcessor = new TextProcessor();

        TextProcessor.input = "Den här texten ska vara baklänges";

        System.out.println("Text efter metod: ");

        String output = testProcessor.reverse();

        assertEquals("segnälkab arav aks netxet räh neD", "" + output, "Text efter metod:" + output);

        System.out.println("\nText innan metod: " + "\n" + TextProcessor.input);

    }

    //Den här metoden matar ut en slumpmässig sträng med blandade gemener och versaler.
    //Testet går ut på att kolla så att den utmatade strängen inte är likadan som den inmatade.
    //Körs som ett repeterat test för att prova felera olika randomsträngar.

    @RepeatedTest(5)
    @DisplayName("Random case till små bokstäver")
    void smallRandomCaps() {

        TextProcessor testProcessor = new TextProcessor();

        StringBuffer randomBuffer = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            char randomLetter = getRandomUpper();
            randomBuffer.append(randomLetter);
        }

        TextProcessor.input = (randomBuffer.toString());

        System.out.println("Text efter metod: ");

        String output = testProcessor.toLower();

        assertFalse(output.contains(randomBuffer));

        System.out.println("\nText innan metod: " + "\n" + TextProcessor.input);
    }

    //Den här metoden matar ut en slumpmässig sträng med blandade gemener och versaler.
    //Testet går ut på att kolla så att den utmatade strängen inte är likadan som den inmatade.
    //Körs som ett repeterat test för att prova felera olika randomsträngar.
    //Fick ta till lite läsning på diverse forum-exempel för detta. Lärde mig inte detta helt från Scratch.

    @RepeatedTest(5)
    @DisplayName("Random case till stora bokstäver")
    void bigRandomCaps() {

        TextProcessor testProcessor = new TextProcessor();

        StringBuffer randomBuffer = new StringBuffer();
        for (int r = 0; r < 25; r++) {
            char randomLetter = getRandomUpper();
            randomBuffer.append(randomLetter);
        }

        TextProcessor.input = (randomBuffer.toString());

        System.out.println("Text efter metod: ");

        String output = testProcessor.toUpper();

        // String output = randomBuffer.toString();

        assertFalse(output.contains(randomBuffer));

        System.out.println("\nText innan metod: " + "\n" + TextProcessor.input);
    }

    //En metod för två ovanstående test som slumpmässigt växlar mellan två switch-cases.
    //Math.random sköter valet av switch-läget.
    //Ena caset matar ut en stor bokstav, den andra en liten.

        char getRandomUpper() {

            switch ((int) (Math.random() * 2)) {
                case 0:
                    return (char) (Math.random() * 26 + 'A');

                case 1:
                    return (char) (Math.random() * 26 + 'a');
            }
                return 0;
        }

}
