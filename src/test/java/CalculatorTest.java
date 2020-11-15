import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class CalculatorTest {

    @BeforeAll
    static void start() {
        System.out.println("Testet startas...");

    }

    @BeforeEach
    public void beforeTest() {
        System.out.println("Status: ");
    }

    @DisplayName("Plusfunktionen med hårdkodade intar")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 500, 4000})
    void add(int n) {

        System.out.println("Testar med 8888 + 1, 2, 3, 4, 5, 500, 4000");

        Calculator calculator = new Calculator();
        assertEquals(8888 + n, calculator.add(8888, n), "8888 + " + n + " = " + calculator.add(8888, n));
        System.out.println("8888 + " + n + " = " + calculator.add(8888, n));
    }
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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 500, 4000})
    @DisplayName("Minusfunktionen med hårdkodade intar")
    void subtract(int n) {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.subtract(8888, 8888), "8888 - 8888 = 0");

        System.out.println("8888 - " + n + " = " + calculator.add(8888, n));
    }

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

    @Test
    @DisplayName("Bråkfunktionen")
    void divide() {

        System.out.println("Testar 8888 / 8888");

        Calculator calculator = new Calculator();
        assertEquals(1, calculator.divide(8888, 8888), "8888 / 8888 = 1");
        System.out.println("8888 / 8888 = " + calculator.divide(8888, 8888));
    }

    @DisplayName("Bråkfunktionen med en random int")
    @RepeatedTest(5)
    void divideRandom() {

        System.out.println("Testar med 8888 / random");

        int n;
        Random r = new Random();
        int max = 8888;
        n = r.nextInt(max);

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