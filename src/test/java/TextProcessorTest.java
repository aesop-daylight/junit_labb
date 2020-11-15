import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    @BeforeAll
    @DisplayName("Kolla så att input inte är Null - utan att den har ett placeholdervärde.")
    static void main() {

        assertNotNull(TextProcessor.input);
        System.out.println("OK! Input är inte null. Testet fortsätter.");
    }

    @Test
    @AfterAll
    @DisplayName("Testet avslutat!")
    static void EndTest() {
        System.out.println("Alla test lyckades!");
    }

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

    @RepeatedTest(5)
    @DisplayName("Random case till små bokstäver")
    void smallRandomCaps() {

        TextProcessor testProcessor = new TextProcessor();

        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            char randomLetter = getRandomUpper();
            sBuffer.append(randomLetter);
        }

        TextProcessor.input = (sBuffer.toString());

        System.out.println("Text efter metod: ");

        String output = testProcessor.toLower();

        assertFalse(output.contains(sBuffer));

        System.out.println("\nText innan metod: " + "\n" + TextProcessor.input);
    }

    @RepeatedTest(5)
    @DisplayName("Random case till stora bokstäver")
    void bigRandomCaps() {

        TextProcessor testProcessor = new TextProcessor();

        StringBuffer sBuffer = new StringBuffer();
        for (int r = 0; r < 20; r++) {
            char randomLetter = getRandomUpper();
            sBuffer.append(randomLetter);
        }

        TextProcessor.input = (sBuffer.toString());

        System.out.println("Text efter metod: ");

        String output = testProcessor.toUpper();

        // String output = sBuffer.toString();

        assertFalse(output.contains(sBuffer));

        System.out.println("\nText innan metod: " + "\n" + TextProcessor.input);
    }
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

