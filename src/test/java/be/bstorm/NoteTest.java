package be.bstorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NoteTest {

    Note note;

    @BeforeEach
    void setUp ( ) {
        note = new Note ( );
    }

    @AfterEach
    void tearDown ( ) {
        note = null;
    }

    @Test
    void shouldThrowIllegalArgumentException_WhenNegativeValue ( ) {
        // Arrage
        int result = -5;
        String expected = "Year result must be between 0 and 100";

        // Action & Assert
        IllegalArgumentException actualException = assertThrows ( IllegalArgumentException.class,
                ( ) -> note.getLetterNote ( result ) );

        assertEquals ( expected, actualException.getMessage ( ) );
    }

    @Test
    void shouldThrowIllegalArguementException_WhenValueGreaterThanOneHundred ( ) {
        IllegalArgumentException actualException = assertThrows ( IllegalArgumentException.class,
                ( ) -> note.getLetterNote ( 101 ) );

        assertEquals ( "Year result must be between 0 and 100", actualException.getMessage ( ) );
    }

    @ParameterizedTest
    @CsvSource({"0,F", "49,F", "50,E", "59,E", "60,D", "69,D", "70,C", "79,C", "80,B", "89,B", "90,A", "100,A"})
    void shouldReturnF_WhenValueBetwen0And49(int result, char expected) {

        // Action
        char actual = note.getLetterNote ( result );

        // Assert
        assertEquals ( expected, actual );
        assertEquals ( expected, note.getLetterNote ( result ) );
    }
}