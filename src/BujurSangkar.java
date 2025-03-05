public class BujurSangkar extends BangunDatar {
    private final double sisi;

    public BujurSangkar(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double luas() {
        return sisi * sisi;
    }

    @Override
    public double keliling() {
        return 4 * sisi;
    }
}
