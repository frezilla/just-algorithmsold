package eu.frezilla.numbers.systems;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

/**
 * Un {@code WholeNumber} est un nombre appartenant à l'ensemble N des entiers
 * naturels.
 *
 * <p>
 * Un {@code WholeNumber} autorise la valeur zéro contrairement à un
 * {@code NaturalNumber} .</p>
 *
 * @see Comparable
 * @see NaturalNumber
 * @see NumberSystems
 */
@Data
public final class WholeNumber implements Comparable<WholeNumber>, NumberSystems<WholeNumber> {

    @Getter(AccessLevel.PRIVATE)
    private final long value;

    private WholeNumber(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Whole number must be an interger from 0 to infinity");
        }
        this.value = value;
    }

    @Override
    public WholeNumber add(WholeNumber val) {
        return new WholeNumber(this.getValue() + val.getValue());
    }

    @Override
    public int compareTo(WholeNumber val) {
        return Long.compare(this.getValue(), val.getValue());
    }

    @Override
    public WholeNumber divide(WholeNumber val) {
        return new WholeNumber(this.getValue() / val.getValue());
    }
    
    @Override
    public Sign getSign() {
        if (this.getValue() < 0) {
            throw new RuntimeException("Negative value is not allowed for WholeNumber");
        } else if (this.getValue() == 0) {
            return Sign.ZERO;
        } else {
            return Sign.POSITIVE;
        }
    }

    @Override
    public WholeNumber multiply(WholeNumber val) {
        return new WholeNumber(this.getValue() * val.getValue());

    }

    @Override
    public WholeNumber sub(WholeNumber val) {
        if (this.compareTo(val) < 0) {
            return null;
        } else {
            return new WholeNumber(this.getValue() - val.getValue());
        }
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
     * Retourne un objet {@code WholeNumber} à partir de la valeur {@code long}.
     *
     * @param l une valeur numérique de type {@code long}
     * @return Une instance d'un {@code WholeNumber} qui représente l.
     */
    public static WholeNumber valueOf(long l) {
        return new WholeNumber(l);
    }

    /**
     * Retourne un objet {@code WholeNumber} à partir de la valeur
     * {@code NaturalNumber}.
     *
     * @param naturalNumber une valeur numérique de type {@code NaturalNumber}
     * @return Une instance d'un {@code WholeNumber} qui représente
     * {@code naturalNumber}.
     */
    public static WholeNumber valueOf(@NonNull NaturalNumber naturalNumber) {
        return naturalNumber.getValue();
    }

}
