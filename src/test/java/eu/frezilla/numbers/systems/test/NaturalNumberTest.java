package eu.frezilla.numbers.systems.test;

import eu.frezilla.numbers.systems.NaturalNumber;
import eu.frezilla.numbers.systems.Sign;
import eu.frezilla.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NaturalNumberTest {
    
    private final NaturalNumber naturalNumber1;
    private final NaturalNumber naturalNumber2;
    private final long randomValue1;
    private final long randomValue2;
    
    NaturalNumberTest() {
        randomValue1 = TestUtils.getRandomLong(1, 100);
        randomValue2 = TestUtils.getRandomLong(2, 100);
        naturalNumber1 = NaturalNumber.valueOf(randomValue1);
        naturalNumber2 = NaturalNumber.valueOf(randomValue2);
    }

    @Test
    @DisplayName("Construction d'un objet non valide")
    void constructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { NaturalNumber.valueOf(-1 * randomValue1); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { NaturalNumber.valueOf(0); });
    }

    @Test
    @DisplayName("Comparaison d'objet")
    void compareTo() {
        Assertions.assertEquals(0, naturalNumber1.compareTo(naturalNumber1));
        Assertions.assertEquals(0, naturalNumber1.compareTo(NaturalNumber.valueOf(randomValue1)));
        Assertions.assertTrue(naturalNumber1.compareTo(NaturalNumber.valueOf(randomValue1 + randomValue2)) < 0);
        if (randomValue1 < randomValue2) {
            Assertions.assertTrue(naturalNumber2.compareTo(naturalNumber1) > 0);
        } else {
            Assertions.assertTrue(naturalNumber1.compareTo(naturalNumber2) > 0);
        }
        Assertions.assertThrows(NullPointerException.class, () -> { naturalNumber1.compareTo(null); });
    }

    @Test
    @DisplayName("Calcul")
    void compute() {
        long addResult = randomValue1 + randomValue2;
        long subResult = Math.max(randomValue1, randomValue2) - Math.min(randomValue1, randomValue2);
        long mulResult = randomValue1 * randomValue2;
        long divResult = Math.max(randomValue1, randomValue2) / Math.min(randomValue1, randomValue2);
        Assertions.assertEquals(naturalNumber1.add(naturalNumber2), NaturalNumber.valueOf(addResult));
        if (naturalNumber1.compareTo(naturalNumber2) < 0) {
            Assertions.assertNull(naturalNumber1.sub(naturalNumber2));
            Assertions.assertEquals(naturalNumber2.sub(naturalNumber1), NaturalNumber.valueOf(subResult));
        } else if (naturalNumber1.compareTo(naturalNumber2) == 0) {
            Assertions.assertNull(naturalNumber1.sub(naturalNumber2));
        } else {
            Assertions.assertNull(naturalNumber2.sub(naturalNumber1));
            Assertions.assertEquals(naturalNumber1.sub(naturalNumber2), NaturalNumber.valueOf(subResult));
        }
        Assertions.assertTrue(naturalNumber1.multiply(naturalNumber2).equals(NaturalNumber.valueOf(mulResult)));
        if (naturalNumber1.compareTo(naturalNumber2) < 0) {
            Assertions.assertEquals(naturalNumber2.divide(naturalNumber1), NaturalNumber.valueOf(divResult));
            Assertions.assertNull(naturalNumber1.divide(naturalNumber2));
        } else {
            Assertions.assertEquals(naturalNumber1.divide(naturalNumber2), NaturalNumber.valueOf(divResult));
            Assertions.assertNull(naturalNumber2.divide(naturalNumber1));
        }
            
    }
    
    @Test
    @DisplayName("Test d'égalité")
    void equals() {
        NaturalNumber natural1 = NaturalNumber.valueOf(randomValue1);
        NaturalNumber natural2 = NaturalNumber.valueOf(randomValue1);
        
        Assertions.assertTrue(naturalNumber1.equals(naturalNumber1), "Equals must be reflexive");
        Assertions.assertTrue(naturalNumber1.equals(natural1) && natural1.equals(naturalNumber1), "Equals must be symmetric");
        Assertions.assertTrue(naturalNumber1.equals(natural1) && natural1.equals(natural2) && natural2.equals(naturalNumber1), "Equals must be transitive");
        Assertions.assertFalse(naturalNumber1.equals(null));
        Assertions.assertTrue(naturalNumber1.equals(natural1));
        Assertions.assertFalse(naturalNumber1.equals(NaturalNumber.valueOf(randomValue1 + 1)));
        Assertions.assertFalse(natural1.equals(new String()));
        
    }

    @Test
    @DisplayName("Test du signe")
    void getSign() {
        Assertions.assertEquals(Sign.POSITIVE, NaturalNumber.valueOf(randomValue1).getSign());
    }
    
    @Test
    @DisplayName("Test de conversion")
    void to() {
        Assertions.assertEquals(randomValue1, naturalNumber1.toLong());
        Assertions.assertEquals(Long.toString(randomValue2), naturalNumber2.toString());
    }

}
