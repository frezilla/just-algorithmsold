package eu.frezilla.utils;

import java.util.concurrent.ThreadLocalRandom;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utilitaires pour les tests.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {
    
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    
    public static double getRandomDouble(double val1, double val2) {
        double low = Math.min(val1, val2);
        double high = Math.max(val1, val2);
        return random.nextDouble(low, high);
    }
    
    public static long getRandomLong(long val1, long val2) {
        long low = Math.min(val1, val2);
        long high = Math.max(val1, val2);
        
        return random.nextLong(low, high);
    }
}