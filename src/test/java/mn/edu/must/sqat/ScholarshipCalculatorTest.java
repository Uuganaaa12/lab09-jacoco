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

    // Heseg B: hamragdaagui salaanuud

    @Test
    void letterGrade_negative_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    void letterGrade_over100_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    @Test
    void letterGrade_75_returnsC() {
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    void letterGrade_65_returnsD() {
        assertEquals("D", calc.letterGrade(65));
    }

    @Test
    void letterGrade_50_returnsF() {
        assertEquals("F", calc.letterGrade(50));
    }

    @Test
    void gpa_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void gpa_empty_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    // C, D, F (switch-iin default) case-uud
    @Test
    void gpa_75_65_50_returns1() {
        assertEquals(1.0, calc.gpa(new double[]{75, 65, 50}), 1e-9);
    }

    // Ehnii if-iin || nohtsol bureer tusdaa test
    @Test
    void scholarship_negativeGpa_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 15, false));
    }

    @Test
    void scholarship_gpaOver4_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 15, false));
    }

    @Test
    void scholarship_negativeCredits_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false));
    }

    @Test
    void scholarship_violation_returns0() {
        assertEquals(0, calc.scholarship(3.9, 16, true));
    }

    // Golch 3.8 hursen ch kredit 15-aas dutuu
    @Test
    void scholarship_highGpaFewCredits_returns70() {
        assertEquals(70, calc.scholarship(3.9, 14, false));
    }

    // Golch 3.4 hursen ch kredit 12-oos dutuu
    @Test
    void scholarship_goodGpaFewCredits_returns50() {
        assertEquals(50, calc.scholarship(3.5, 10, false));
    }

    @Test
    void scholarship_lowGpa_returns0() {
        assertEquals(0, calc.scholarship(2.5, 15, false));
    }
}
