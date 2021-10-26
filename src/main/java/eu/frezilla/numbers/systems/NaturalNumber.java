package eu.frezilla.numbers.systems;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

/**
 * Un {@code NaturalNumber} est un nombre appartenant à l'ensemble N des 
 * entiers naturels conformément à la définition originelle due à Richard
 * Dedekind (le zéro n'appartient pas à l'ensemble des entiers naturels).
 * 
 * @see Comparable
 * @see NumberSystems
 * @see WholeNumber
 */
@Data
public final class NaturalNumber implements Comparable<NaturalNumber>, NumberSystems<NaturalNumber> {

    @Getter(AccessLevel.PACKAGE)
    private final WholeNumber value;

    private NaturalNumber(WholeNumber value) {
        if (Sign.POSITIVE != value.getSign()) {
            throw new IllegalArgumentException("Natural number must be an interger from 1 to infinity");
        }
        this.value = value;
    }

    @Override
    public NaturalNumber add(NaturalNumber val) {
        return new NaturalNumber(this.getValue().add(val.getValue()));
    }

    @Override
    public int compareTo(NaturalNumber val) {
        return this.getValue().compareTo(val.getValue());
    }

    @Override
    public NaturalNumber divide(NaturalNumber val) {
        NaturalNumber result;
        try {
            result = new NaturalNumber(this.getValue().divide(val.getValue()));
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
    public NaturalNumber multiply(NaturalNumber val) {
        return new NaturalNumber(this.getValue().multiply(val.getValue()));
    }

    @Override
    public NaturalNumber sub(NaturalNumber val) {
        if (this.compareTo(val) > 0) {
            return new NaturalNumber(this.getValue().sub(val.getValue()));
        } else {
            return null;
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
     * Retourne un {@code NaturalNumber} à partir de la valeur {@code long}.
     *
     * @param l une valeur numérique de type {@code long}
     * @return Une instance d'un {@code NaturalNumber} qui représente {@code l}.
     */
    public static NaturalNumber valueOf(long l) {
        return new NaturalNumber(WholeNumber.valueOf(l));
    }

}
