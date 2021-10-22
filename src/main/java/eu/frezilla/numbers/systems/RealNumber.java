package eu.frezilla.numbers.systems;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class RealNumber implements Comparable<RealNumber>, NumberSystems<RealNumber> {

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

    @Override
    public String toString() {
        return Double.toString(this.getValue());
    }

    public static RealNumber valueOf(double d) {
        return new RealNumber(d);
    }
    
    public static RealNumber valueOf(@NonNull NaturalNumber naturalNumber) {
        return valueOf(naturalNumber.toLong());
    }
    
    public static RealNumber valueOf(@NonNull WholeNumber wholeNumber) {
        return valueOf(wholeNumber.toLong());
    }
    
}
