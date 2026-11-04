package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    ScholarshipCalculator calc = new ScholarshipCalculator();

    // Heseg A: zowhon hewiin ursgal

    @Test
    void letterGrade_95_returnsA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void letterGrade_85_returnsB() {
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    void gpa_95and85_returns3_5() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 1e-9);
    }

    @Test
    void scholarship_highGpaFullCredits_returns100() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarship_goodGpaEnoughCredits_returns70() {
        assertEquals(70, calc.scholarship(3.5, 12, false));
    }
}
