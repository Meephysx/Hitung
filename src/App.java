import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Input Bujur Sangkar
        try (Scanner input = new Scanner(System.in)) {
            // Input untuk Bujur Sangkar
            System.out.print("Masukkan sisi untuk Bujur Sangkar: ");
            double sisi = input.nextDouble();
            BujurSangkar bujurSangkar = new BujurSangkar(sisi);
            System.out.println("Bujur Sangkar: Luas = " + bujurSangkar.luas() +
                    ", Keliling = " + bujurSangkar.keliling());
            System.out.println();
            
            // Input untuk Persegi Panjang
            System.out.print("Masukkan panjang untuk Persegi Panjang: ");
            double panjang = input.nextDouble();
            System.out.print("Masukkan lebar untuk Persegi Panjang: ");
            double lebar = input.nextDouble();
            PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
            System.out.println("Persegi Panjang: Luas = " + persegiPanjang.luas() +
                    ", Keliling = " + persegiPanjang.keliling());
            System.out.println();
            
            // Input Segitiga (menggunakan Heron's Formula)
            System.out.print("Masukkan sisi A segitiga: ");
            double sisiA = input.nextDouble();
            System.out.print("Masukkan sisi B segitiga: ");
            double sisiB = input.nextDouble();
            System.out.print("Masukkan sisi C segitiga: ");
            double sisiC = input.nextDouble();
            Segitiga segitiga = new Segitiga(sisiA, sisiB, sisiC);
            System.out.println("Segitiga: Luas = " + segitiga.luas() +
                    ", Keliling = " + segitiga.keliling());
        }
    }
}
