package eu.frezilla.numbers.systems.test;

import eu.frezilla.numbers.systems.Sign;
import eu.frezilla.numbers.systems.WholeNumber;
import eu.frezilla.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WholeNumberTest {
    
    private final long randomValue1;
    private final long randomValue2;
    private final WholeNumber wholeNumber1;
    private final WholeNumber wholeNumber2;
    
    WholeNumberTest() {
        randomValue1 = TestUtils.getRandomLong(0, 1000);
        randomValue2 = TestUtils.getRandomLong(1, 1000);
        wholeNumber1 = WholeNumber.valueOf(randomValue1);
        wholeNumber2 = WholeNumber.valueOf(randomValue2);
        
    }

    @Test
    @DisplayName("Construction d'un objet non valide")
    void constructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { WholeNumber.valueOf(-1 * randomValue1 - 1); });
    }

    @Test
    @DisplayName("Comparaison d'objets")
    void compareTo() {
        Assertions.assertTrue(wholeNumber1.compareTo(wholeNumber1) == 0);
        Assertions.assertTrue(wholeNumber1.compareTo(WholeNumber.valueOf(randomValue1)) == 0);
        Assertions.assertTrue(wholeNumber1.compareTo(WholeNumber.valueOf(randomValue1 + randomValue2)) < 0);
        if (randomValue1 < randomValue2) {
            Assertions.assertTrue(wholeNumber2.compareTo(wholeNumber1) > 0);
        } else {
            Assertions.assertTrue(wholeNumber1.compareTo(wholeNumber2) > 0);
        }
        Assertions.assertThrows(NullPointerException.class, () -> { wholeNumber1.compareTo(null); });
    }

    @Test
    @DisplayName("Calcul")
    void compute() {
        long addResult = randomValue1 + randomValue2;
        long subResult = Math.max(randomValue1, randomValue2) - Math.min(randomValue1, randomValue2);
        long mulResult = randomValue1 * randomValue2;
        long divResult = randomValue1 / randomValue2;
        
        Assertions.assertTrue(wholeNumber1.add(wholeNumber2).equals(WholeNumber.valueOf(addResult)));
        if (wholeNumber1.compareTo(wholeNumber2) < 0) {
            Assertions.assertNull(wholeNumber1.sub(wholeNumber2));
            Assertions.assertTrue(wholeNumber2.sub(wholeNumber1).equals(WholeNumber.valueOf(subResult)));
        } else {
            Assertions.assertNull(wholeNumber2.sub(wholeNumber1));
            Assertions.assertTrue(wholeNumber1.sub(wholeNumber2).equals(WholeNumber.valueOf(subResult)));
        }
        Assertions.assertTrue(wholeNumber1.multiply(wholeNumber2).equals(WholeNumber.valueOf(mulResult)));
        Assertions.assertTrue(wholeNumber1.divide(wholeNumber2).equals(WholeNumber.valueOf(divResult)));
    }

    @Test
    @DisplayName("Test du signe")
    void getSign() {
        Assertions.assertEquals(Sign.ZERO, WholeNumber.valueOf(0).getSign());
        Assertions.assertEquals(Sign.POSITIVE, WholeNumber.valueOf(randomValue1 + 1).getSign());
    }

}
