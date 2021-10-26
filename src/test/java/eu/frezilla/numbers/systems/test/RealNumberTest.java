package eu.frezilla.numbers.systems.test;

import eu.frezilla.numbers.systems.RealNumber;
import eu.frezilla.numbers.systems.Sign;
import eu.frezilla.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealNumberTest {
    
    private final double randomValue1;
    private final double randomValue2;
    private final RealNumber realNumber1;
    private final RealNumber realNumber2;

    RealNumberTest() {
        randomValue1 = TestUtils.getRandomDouble(-1000, 1000);
        randomValue2 = TestUtils.getRandomDouble(-1000, 1000);
        realNumber1 = RealNumber.valueOf(randomValue1);
        realNumber2 = RealNumber.valueOf(randomValue2);
    }

    @Test
    @DisplayName("Comparaison d'objets")
    void compareTo() {
        Assertions.assertTrue(realNumber1.compareTo(realNumber1) == 0);
        Assertions.assertTrue(realNumber1.compareTo(RealNumber.valueOf(randomValue1)) == 0);
        Assertions.assertTrue(realNumber1.compareTo(RealNumber.valueOf(randomValue1 + Math.abs(randomValue2))) < 0);
        Assertions.assertTrue(realNumber1.compareTo(RealNumber.valueOf(randomValue1 - Math.abs(randomValue2))) > 0);
        Assertions.assertThrows(NullPointerException.class, () -> {
            realNumber1.compareTo(null);
        });
    }

    @Test
    @DisplayName("Calcul")
    void compute() {
        double addResult = randomValue1 + randomValue2;
        double subResult = randomValue1 - randomValue2;
        double mulResult = randomValue1 * randomValue2;
        double divResult = randomValue1 / randomValue2;
        
        Assertions.assertTrue(realNumber1.add(realNumber2).equals(RealNumber.valueOf(addResult)));
        Assertions.assertTrue(realNumber1.sub(realNumber2).equals(RealNumber.valueOf(subResult)));
        Assertions.assertTrue(realNumber1.multiply(realNumber2).equals(RealNumber.valueOf(mulResult)));
        Assertions.assertTrue(realNumber1.divide(realNumber2).equals(RealNumber.valueOf(divResult)));
    }

    @Test
    @DisplayName("Test du signe")
    void getSign() {
        Assertions.assertEquals(Sign.NEGATIVE, RealNumber.valueOf(-1.0d * Math.abs(randomValue1) - 1.0d).getSign());
        Assertions.assertEquals(Sign.ZERO, RealNumber.valueOf(0.0d).getSign());
        Assertions.assertEquals(Sign.POSITIVE, RealNumber.valueOf(Math.abs(randomValue1) + 1.0).getSign());
    }

}
