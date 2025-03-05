public class Segitiga extends BangunDatar {
    private final double sisiA;
    private final double sisiB;
    private final double sisiC;

    public Segitiga(double sisiA, double sisiB, double sisiC) {
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }

    @Override
    public double luas() {
        // Rumus Heron: L = √[s(s - a)(s - b)(s - c)], di mana s = (a + b + c) / 2
        double s = (sisiA + sisiB + sisiC) / 2.0;
        return Math.sqrt(s * (s - sisiA) * (s - sisiB) * (s - sisiC));
    }

    @Override
    public double keliling() {
        return sisiA + sisiB + sisiC;
    }
}

