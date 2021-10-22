package eu.frezilla.numbers.utils;

import eu.frezilla.numbers.systems.RealNumber;
import eu.frezilla.numbers.systems.Sign;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * La classe {@code Sqrt}  propose des méthodes d'extraction de racine carrée, 
 * c'est-à-dire de résolution de l'équation <i>x^2=a</i>, avec <i>a</i> positif.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Sqrt {
    
    private final static RealNumber TWO = RealNumber.valueOf(2.0d);
    
    /**
     * Calcul de la racine carrée selon la méthode de Héron (ou méthode 
     * babylonienne).
     * 
     * @param number Nombre réel pour lequel il faut calculer la racine carrée
     * @param precision Précision du calcul
     * @return La racine carré du nombre.
     * @throws IllegalArgumentException Si {@code number}  n'est pas positif
     */
    public static RealNumber heron(@NonNull RealNumber number, @NonNull RealNumber precision) {
        if (Sign.POSITIVE != number.getSign()) {
            throw new IllegalArgumentException("number value must be positive");
        }
        RealNumber n = number;
        RealNumber u = number;
        while (u.sub(heronSqrt(n, u)).compareTo(precision) > 0) {
            u = heronSqrt(n, u);
        }
        return u;
    }
    
    private static RealNumber heronSqrt(@NonNull RealNumber number, @NonNull RealNumber u) {
        return number.divide(u).add(u).divide(TWO);
    }
}
