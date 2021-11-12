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

    @Getter(AccessLevel.PACKAGE)
    private final IntegerNumber value;

    private WholeNumber(IntegerNumber value) {
        if (Sign.POSITIVE != value.getSign() && Sign.ZERO != value.getSign()) {
            throw new IllegalArgumentException("Whole number must be an interger from 0 to infinity");
        }
        this.value = value;
    }

    @Override
    public WholeNumber add(WholeNumber val) {
        return new WholeNumber(this.getValue().add(val.getValue()));
    }

    @Override
    public int compareTo(WholeNumber val) {
        return this.getValue().compareTo(val.getValue());
    }

    @Override
    public WholeNumber divide(WholeNumber val) {
        WholeNumber result;
        try {
            result = new WholeNumber(this.getValue().divide(val.getValue()));
        } catch (IllegalArgumentException e) {
            result = null;
        }
        return result;
    }
    
    @Override
    public Sign getSign() {
        return this.getValue().getSign();
    }

    @Override
    public WholeNumber multiply(WholeNumber val) {
        return new WholeNumber(this.getValue().multiply(val.getValue()));

    }

    @Override
    public WholeNumber sub(WholeNumber val) {
        if (this.compareTo(val) < 0) {
            return null;
        } else {
            return new WholeNumber(this.getValue().sub(val.getValue()));
        }
    }

    /**
     * Retourne la valeur de l'objet en tant que {@code long}.
     *
     * @return La valeur numérique représentée par l'objet.
     */
    public long toLong() {
        return this.getValue().toLong();
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }

    /**
     * Retourne un objet {@code WholeNumber} à partir de la valeur {@code long}.
     *
     * @param l une valeur numérique de type {@code long}
     * @return Une instance d'un {@code WholeNumber} qui représente l.
     */
    public static WholeNumber valueOf(long l) {
        return new WholeNumber(IntegerNumber.valueOf(l));
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
