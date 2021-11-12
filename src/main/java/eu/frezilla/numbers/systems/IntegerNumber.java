package eu.frezilla.numbers.systems;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

/**
 * Un {@code IntegerNumber} est un nombre appartenant à l'ensemble Z des 
 * entiers.
 *
 * @see Comparable
 * @see NumberSystems
 */
@Data
public class IntegerNumber implements Comparable<IntegerNumber>, NumberSystems<IntegerNumber> {

    @Getter(AccessLevel.PRIVATE)
    private final long value;

    private IntegerNumber(long value) {
        this.value = value;
    }

    @Override
    public IntegerNumber add(IntegerNumber val) {
        return new IntegerNumber(this.getValue() + val.getValue());
    }

    @Override
    public int compareTo(IntegerNumber val) {
        return Long.compare(this.getValue(), val.getValue());
    }

    @Override
    public IntegerNumber divide(IntegerNumber val) {
        if (val.getValue() == 0) {
            throw new ArithmeticException();
        }
        return new IntegerNumber(this.getValue() / val.getValue());
    }

    @Override
    public Sign getSign() {
        if (value < 0) {
            return Sign.NEGATIVE;
        } else if (value > 0) {
            return Sign.POSITIVE;
        } else {
            return Sign.ZERO;
        }
    }

    @Override
    public IntegerNumber multiply(IntegerNumber val) {
        return new IntegerNumber(this.getValue() * val.getValue());
    }

    @Override
    public IntegerNumber sub(IntegerNumber val) {
        return new IntegerNumber(this.getValue() - val.getValue());
    }

    /**
     * Retourne la valeur de l'objet en tant que {@code long}.
     *
     * @return La valeur numérique représentée par l'objet.
     */
    public long toLong() {
        return this.getValue();
    }

    @Override
    public String toString() {
        return Long.toString(this.getValue());
    }

    /**
     * Retourne un objet {@code IntegerNumber} à partir de la valeur 
     * {@code long}.
     *
     * @param l une valeur numérique de type {@code long}
     * @return Une instance d'un {@code IntegerNumber} qui représente l.
     */
    public static IntegerNumber valueOf(long l) {
        return new IntegerNumber(l);
    }

    /**
     * Retourne un objet {@code IntegerNumber} à partir de la valeur
     * {@code NaturalNumber}.
     *
     * @param naturalNumber une valeur numérique de type {@code NaturalNumber}
     * @return Une instance d'un {@code IntegerNumber} qui représente
     * {@code naturalNumber}.
     */
    public static IntegerNumber valueOf(@NonNull NaturalNumber naturalNumber) {
        return valueOf(naturalNumber.getValue());
    }
    
    /**
     * Retourne un objet {@code IntegerNumber} à partir de la valeur
     * {@code WholeNumber}.
     *
     * @param wholeNumber une valeur numérique de type {@code WholeNumber}
     * @return Une instance d'un {@code IntegerNumber} qui représente
     * {@code wholelNumber}.
     */    
    public static IntegerNumber valueOf(@NonNull WholeNumber wholeNumber) {
        return wholeNumber.getValue();
    }

}
