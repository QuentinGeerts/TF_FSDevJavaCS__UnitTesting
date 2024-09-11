package be.bstorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MathematicTest {

    Mathematic mathematic;

    @BeforeEach
    void setUp ( ) {
        mathematic = new Mathematic ( );
    }

    @AfterEach
    void tearDown ( ) {
        mathematic = null;
    }

    @Test
    void shouldReturn4_When2Plus2 ( ) {
        /*
         * Règle des 3x "A"
         * - Arrange (mise en place du contexte)
         * - Action (exécution de la méthode à tester)
         * - Assert (comparaison du résultat obtenu au résultat attendu)
         */

        // Arrange
        int a = 2;
        int b = 2;
        int expected = 4;

        // Action
        int actual = mathematic.add ( a, b );

        // Assert
        assertEquals ( expected, actual );
        // assertNotEquals (  );
        // assertNull (  );
        // assertNotNull (  );
        // assertTrue (  );
        // assertFalse (  );
        // assertThrows (  )
        // assertDoesNotThrow (  );
    }

    @Test
    void shouldReturn12_When5Plus7 ( ) {
        // Arrange
        int a = 5;
        int b = 7;
        int expected = 12;

        // Action
        int actual = mathematic.add ( a, b );

        // Assert
        assertEquals ( expected, actual );
    }

    @ParameterizedTest
    @CsvSource ({ "5,2,7", "3,5,8", "1,-1,0" })
    void shouldReturnExceptedValue_WhenValuePlusValue ( int a, int b, int expected ) {
        // Action
        int actual = mathematic.add ( a, b );

        // Assert
        assertEquals ( expected, actual );
    }

    @Test
    void shouldThrowRuntimeException_WhenValueGreaterThanMaxValue ( ) {
        // Arrange
        int a = Integer.MAX_VALUE;
        int b = 10;

        // Action & Assert
        assertThrows ( RuntimeException.class, ( ) -> mathematic.add ( a, b ) );
    }

    @Test
    void shoudReturn5_When10DividedBy2 ( ) {
        // Arrange
        double a = 10;
        double b = 2;
        double expected = 5;

        // Action
        double actual = mathematic.division ( a, b );

        // Assert
        assertEquals ( expected, actual );
    }

    @Test
    void shoudThrowDividedByZeroException_WhenDividedBy0 ( ) {
        // Arrange
        double a = 10;
        double b = 0;

        String expected = "Cannot divide by zero";

        // Action & Assert
        DividedByZeroException actualException = assertThrows ( DividedByZeroException.class,
                ( ) -> mathematic.division ( a, b ) );

        assertEquals ( expected, actualException.getMessage ( ) );
    }

}