package eu.frezilla.numbers.systems;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

/**
 * Un {@code RealNumber} est un nombre appartenant à l'ensemble R des réels. Un 
 * nombre réel est un nombre qui peut être représenté par une partie entière et 
 * une liste finie ou infinie de décimales.
 * 
 * @see Comparable
 * @see NumberSystems
 */
@Data
public class RealNumber implements Comparable<RealNumber>, NumberSystems<RealNumber> {
    
    public static final int DECIMALVALUE_PRECISION = 100;

    @Getter(AccessLevel.PRIVATE)
    private final double value;

    private RealNumber(double value) {
        this.value = value;
    }

    @Override
    public RealNumber add(RealNumber val) {
        return new RealNumber(this.getValue() + val.getValue());
    }

    @Override
    public int compareTo(RealNumber val) {
        return Double.compare(this.getValue(), val.getValue());
    }

    @Override
    public RealNumber divide(RealNumber val) {
        return new RealNumber(this.getValue() / val.getValue());
    }
    
    public WholeNumber getDecimalValue() {
        return this.getDecimalValue(DECIMALVALUE_PRECISION);
    }
    
    public WholeNumber getDecimalValue(int precision) {
        int p = Math.min(precision, DECIMALVALUE_PRECISION);
        String v = Double.toString(this.getValue() % 1.0d);
        v = v.substring(2, v.length());
        v = v.substring(0, Math.min(p, v.length()));
        return WholeNumber.valueOf(Long.parseLong(v));
    }
    
    /**
     * Retourne la partie entière de la valeur courante.
     * 
     * @return {@code IntegerNumber} représentant la partie entière.
     */
    public IntegerNumber getIntegerValue() {
        return IntegerNumber.valueOf((long) (this.getValue() / 1.0d));
    }

    @Override
    public Sign getSign() {
        if (this.getValue() < 0) {
            return Sign.NEGATIVE;
        } else if (this.getValue() == 0) {
            return Sign.ZERO;
        } else {
            return Sign.POSITIVE;
        }
    }

    @Override
    public RealNumber multiply(RealNumber val) {
        return new RealNumber(this.getValue() * val.getValue());
    }

    @Override
    public RealNumber sub(RealNumber val) {
        return new RealNumber(this.getValue() - val.getValue());
    }
    
    /**
     * Retourne la valeur de l'objet en tant que {@code double}.
     *
     * @return La valeur numérique représentée par l'objet.
     */
    public double toDouble() {
        return this.getValue();
    }

    @Override
    public String toString() {
        return Double.toString(this.getValue());
    }

    /**
     * Retourne un {@code RealNumber} à partir de la valeur {@code double}.
     *
     * @param d une valeur numérique de type {@code double}
     * @return Une instance d'un {@code RealNumber} qui représente {@code d}.
     */    
    public static RealNumber valueOf(double d) {
        return new RealNumber(d);
    }
    
    /**
     * Retourne un {@code RealNumber} à partir de la valeur 
     * {@code IntegerNumber}.
     * 
     * @param integerValue une valeur numérique de type {@code IntegerNumber}
     * @return Une instance d'un {@code RealNumber} qui représente 
     * {@code integerValue}
     */
    public static RealNumber valueOf(@NonNull IntegerNumber integerValue) {
        return valueOf(integerValue.toLong());
    }
    
    /**
     * Retourne un {@code RealNumber} à partir de la valeur 
     * {@code NaturalNumber}.
     *
     * @param naturalNumber une valeur numérique de type {@code NaturalNumber}
     * @return Une instance d'un {@code RealNumber} qui représente 
     * {@code naturalNumber}.
     */       
    public static RealNumber valueOf(@NonNull NaturalNumber naturalNumber) {
        return valueOf(naturalNumber.toLong());
    }
    
    /**
     * Retourne un {@code RealNumber} à partir de la valeur 
     * {@code WholeNumber}.
     *
     * @param wholeNumber une valeur numérique de type {@code WholeNumber}
     * @return Une instance d'un {@code RealNumber} qui représente 
     * {@code wholeNumber}.
     */     
    public static RealNumber valueOf(@NonNull WholeNumber wholeNumber) {
        return valueOf(wholeNumber.toLong());
    }
    
}
