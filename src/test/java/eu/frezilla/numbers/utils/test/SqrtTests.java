package eu.frezilla.numbers.utils.test;

import eu.frezilla.numbers.systems.RealNumber;
import eu.frezilla.numbers.utils.Sqrt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SqrtTests {
    
    @Test
    @DisplayName("Calcul de la racine carré via l'algorithme de Héron d'Alexandrie")
    public void heron() {
        RealNumber realNumber = RealNumber.valueOf(2.0d);
        Assertions.assertTrue(Sqrt.heron(realNumber, RealNumber.valueOf(1.0d)).compareTo(RealNumber.valueOf(2.0d)) == 0);
        Assertions.assertTrue(Sqrt.heron(realNumber, RealNumber.valueOf(0.1d)).compareTo(RealNumber.valueOf(1.5d)) == 0);
        Assertions.assertTrue(Sqrt.heron(realNumber, RealNumber.valueOf(0.000000000000001d)).compareTo(RealNumber.valueOf(1.414213562373095d)) == 0);
    }
}
