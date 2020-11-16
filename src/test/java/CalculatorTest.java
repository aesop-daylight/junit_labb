import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class CalculatorTest {

    //Testet startas. Denna är disabled för sakens skull.
    @DisplayName ("Test startar...")
    @BeforeAll
    static void start() {
        System.out.println("Testet startas...");
    }

    //En utmatning med ordet "status" på respektivedeltest.
    //Utmatningen kompletteras av respektive test när allt körs.

    @BeforeEach
    public void beforeTest() {
        System.out.println("Status: ");
    }

    // Provar att addera några hårdkodade intar. Mest för att få prova på Parameterized test.

    @DisplayName("Plusfunktionen med hårdkodade intar")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 500, 4000})
    void add(int n) {

        System.out.println("Testar med 8888 + 1, 2, 3, 4, 5, 500, 4000");

        Calculator calculator = new Calculator();
        assertEquals(8888 + n, calculator.add(8888, n), "8888 + " + n + " = " + calculator.add(8888, n));
        System.out.println("8888 + " + n + " = " + calculator.add(8888, n));
    }

    //Provar att testa ett hårdkodat värde + ett slumpmässigt generat heltal. Maxvärde 8888.
    //Körs 5 gånger - because why not.

    @DisplayName("Plusfunktionen med en random int")
    @RepeatedTest(5)
    void addRandom() {

        System.out.println("Testar med 8888 + random");

        int n;
        Random r = new Random();
        int max = 8888;
        n = r.nextInt(max);

        Calculator calculator = new Calculator();
        assertEquals(8888 + n, calculator.add(8888, n), "8888 + " + n + " = " + calculator.add(8888, n));
        System.out.println("8888 + " + n + " = " + calculator.add(8888, n));
    }

    // Provar att subtrahera några hårdkodade intar. Mest för att få prova på Parameterized test.

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 500, 4000})
    @DisplayName("Minusfunktionen med hårdkodade intar")
    void subtract(int n) {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.subtract(8888, 8888), "8888 - 8888 = 0");

        System.out.println("8888 - " + n + " = " + calculator.add(8888, n));
    }

    //Provar att testa ett hårdkodat värde - ett slumpmässigt generat heltal. Maxvärde 8888.
    //Körs 5 gånger - because why not.

    @DisplayName("Minusfunktionen med en random int")
    @RepeatedTest(5)
    void subtractRandom() {

        System.out.println("Testar med 8888 - random");

        int n;
        Random r = new Random();
        int max = 8888;
        n = r.nextInt(max);

        Calculator calculator = new Calculator();
        assertEquals(8888 - n, calculator.subtract(8888, n), "8888 - " + n + " = " + calculator.subtract(8888, n));
        System.out.println("8888 - " + n + " = " + calculator.subtract(8888, n));
    }

    //Testar bråk funktionen med divide by Zero.
    //If-satserna i divide metoden ska fånga upp 0:or och tilldela värdet + 1.
    //I nuläget anropas varningen två gånger, eftersom den körs
    //Crude, but effective.

    @Test
    @DisplayName("Testar divide metodens divide-by-zero säkring")
    void divideByZero() {

        System.out.println("Testar 0 / 0" + "\n");

        Calculator calculator = new Calculator();
        assertEquals(1, calculator.divide(0, 0), "1 / 1 = 1");
        System.out.println("\n");
        System.out.println("\n 1 / 1 =" + calculator.divide(0,0));

        // System.out.println("1 / 1 = " + calculator.divide(0, 0));
    }

    //Testar bråk funktionen en gång med hårdkodade int.
    //Disabled för uppgiftens skull
    
    @Disabled
    @Test
    @DisplayName("Bråkfunktionen")
    void divide() {

        System.out.println("Testar 8888 / 8888");

        Calculator calculator = new Calculator();
        assertEquals(1, calculator.divide(8888, 8888), "8888 / 8888 = 1");
        System.out.println("8888 / 8888 = " + calculator.divide(8888, 8888));
    }

    //Provar att testa ett hårdkodat värde / ett slumpmässigt generat heltal. Maxvärde 8888.
    //Körs 10 gånger. Här finns också en if-sats som ger N värdet + 1 för att undvika divide by zero om 0 slumpas fram.
    //OBS. är medveten om att resultaten här kan ge matematiskt felaktiga resultat eftersom den delar heltal.
    //I själva testsyftet fungerar exemplet dock.

    @DisplayName("Bråkfunktionen med en random int")
    @RepeatedTest(10)
    void divideRandom() {

        System.out.println("Testar med 8888 / random");

        int n;
        Random r = new Random();
        int max = 8888;
        n = r.nextInt(max);

        if (n == 0) {
            n = n + 1;
        }

        Calculator calculator = new Calculator();
        assertEquals(8888 / n, calculator.divide(8888, n), "8888 / " + n + " = " + calculator.divide(8888, n));
        System.out.println("8888 / " + n + " = " + calculator.divide(8888, n));
    }

    @RepeatedTest(3)
    @DisplayName("Gångerfunktionen")
    void multiply() {
        Calculator calculator = new Calculator();
        assertEquals(78996544, calculator.multiply(8888, 8888), "8888 * 8888 = 78996544");

        System.out.println("8888 * 8888 = " + calculator.multiply(8888, 8888));
    }

    @DisplayName("Gångerfunktionen med en random int")
    @RepeatedTest(5)
    void multiplyRandom() {

        System.out.println("Testar med 8888 * random");

        int n;
        Random r = new Random();
        int max = 8888;
        n = r.nextInt(max);

        Calculator calculator = new Calculator();
        assertEquals(8888 * n, calculator.multiply(8888, n), "8888 * " + n + " = " + calculator.multiply(8888, n));
        System.out.println("8888 * " + n + " = " + calculator.multiply(8888, n));
    }

    @AfterAll
    static void end() {
        System.out.println("Test genomfört");
    }
}
