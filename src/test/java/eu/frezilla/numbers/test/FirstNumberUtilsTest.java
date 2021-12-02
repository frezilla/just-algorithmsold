package eu.frezilla.numbers.test;

import eu.frezilla.numbers.FirstNumberUtils;
import eu.frezilla.numbers.systems.NaturalNumber;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstNumberUtilsTest {
    
    @Test
    @DisplayName("Construction d'un objet non valide")
    public void isFirstNumber() {
        Assertions.assertFalse(FirstNumberUtils.isFirstNumber(null));
        
        Set<Integer> firstNumbers = new TreeSet<>();
        
        firstNumbers.add(1);
        firstNumbers.add(2);
        firstNumbers.add(3);
        firstNumbers.add(5);
        firstNumbers.add(7);
        firstNumbers.add(11);
        firstNumbers.add(13);
        firstNumbers.add(17);
        firstNumbers.add(19);
        firstNumbers.add(23);
        firstNumbers.add(29);
        firstNumbers.add(31);
        firstNumbers.add(37);
        firstNumbers.add(41);
        firstNumbers.add(43);
        firstNumbers.add(47);
        firstNumbers.add(53);
        firstNumbers.add(59);
        firstNumbers.add(61);
        firstNumbers.add(67);
        firstNumbers.add(71);
        firstNumbers.add(73);
        firstNumbers.add(79);
        firstNumbers.add(83);
        firstNumbers.add(89);
        firstNumbers.add(97);
        
        for (int i = 1; i < 100; i++) {
            if (firstNumbers.contains(i)) {
                Assertions.assertTrue(FirstNumberUtils.isFirstNumber(NaturalNumber.valueOf(i)), String.format("%d should be a first number", i));
            } else {
                Assertions.assertFalse(FirstNumberUtils.isFirstNumber(NaturalNumber.valueOf(i)), String.format("%d should not be a first number", i));
            }
        }
    }
    
}
