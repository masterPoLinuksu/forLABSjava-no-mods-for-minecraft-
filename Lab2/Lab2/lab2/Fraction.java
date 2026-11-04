package lab2;

class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction f) {
        int n = numerator * f.denominator + f.numerator * denominator;
        int d = denominator * f.denominator;
        return new Fraction(n, d);
    }

    public Fraction sum(int x) {
        return sum(new Fraction(x, 1));
    }

    public Fraction minus(Fraction f) {
        int n = numerator * f.denominator - f.numerator * denominator;
        int d = denominator * f.denominator;
        return new Fraction(n, d);
    }

    public Fraction minus(int x) {
        return minus(new Fraction(x, 1));
    }

    public Fraction mult(Fraction f) {
        return new Fraction(numerator * f.numerator, denominator * f.denominator);
    }

    public Fraction mult(int x) {
        return mult(new Fraction(x, 1));
    }

    public Fraction div(Fraction f) {
        return new Fraction(numerator * f.denominator, denominator * f.numerator);
    }

    public Fraction div(int x) {
        return div(new Fraction(x, 1));
    }
}