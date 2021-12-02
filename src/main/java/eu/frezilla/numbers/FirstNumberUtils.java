package eu.frezilla.numbers;

import eu.frezilla.numbers.systems.NaturalNumber;
import eu.frezilla.numbers.systems.Parity;
import eu.frezilla.numbers.systems.RealNumber;
import eu.frezilla.numbers.systems.WholeNumber;
import eu.frezilla.numbers.utils.Sqrt;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FirstNumberUtils {

    private static final WholeNumber ZERO = WholeNumber.valueOf(0);
    private static final NaturalNumber ONE = NaturalNumber.valueOf(1);
    private static final NaturalNumber TWO = NaturalNumber.valueOf(2);

    public static boolean isFirstNumber(NaturalNumber naturalNumber) {
        if (naturalNumber == null) {
            return false;
        } else if (naturalNumber.compareTo(ONE) == 0 || naturalNumber.compareTo(TWO) == 0) {
            return true;
        } else {
            RealNumber divider = RealNumber.valueOf(TWO);
            RealNumber realNumber = RealNumber.valueOf(naturalNumber);

            while (divider.compareTo(realNumber) < 0) {
                if (ZERO.equals(realNumber.divide(divider).getDecimalValue())) {
                    return false;
                }

                divider = divider.add(RealNumber.valueOf(ONE));
            }
        }
        return true;
    }
}
