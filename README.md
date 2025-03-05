# Penjelasan Kode Praktikum Inheritance

## Deskripsi
Proyek ini merupakan implementasi praktikum mengenai konsep inheritance dalam Pemrograman Berorientasi Objek (PBO) menggunakan bahasa Java. Kode ini mengilustrasikan bagaimana membuat sebuah kelas induk (superclass) dan kelas turunan (subclass) untuk menghitung luas dan keliling dari berbagai bangun datar, seperti bujur sangkar, persegi panjang, dan segitiga.

## Struktur Kode

### 1. Superclass: BangunDatar

Superclass ini mendefinisikan dua metode (tanpa implementasi) yang wajib diimplementasikan oleh setiap subclass. Dengan mendefinisikan `BangunDatar` sebagai kelas abstrak, kita memastikan bahwa setiap kelas turunan memberikan logika perhitungan luas dan keliling yang sesuai.

```java
public abstract class BangunDatar {
    public abstract double luas();
    public abstract double keliling();
}
```

- **Deskripsi:**  
  Kelas `BangunDatar` berfungsi sebagai kelas induk yang menyediakan atribut dan metode dasar untuk perhitungan.  
- **Fungsi:**  
  - Menyediakan dua metode, `luas()` dan `keliling()`, yang mengembalikan nilai dari atribut `luas` dan `keliling`.
  - Pada contoh ini, kelas `BangunDatar` juga memuat method `main()` untuk menjalankan program interaktif.
- **Catatan:**  
  Meskipun kode ini menggunakan pendekatan kelas konkrit, metode ini bisa dikembangkan dengan membuatnya sebagai abstract class untuk memaksa implementasi perhitungan pada setiap subclass.

---

### 2. Kelas Turunan (Subclass)
Proyek ini memiliki beberapa kelas turunan yang meng-extend `BangunDatar` dan mengimplementasikan perhitungan spesifik sesuai dengan jenis bangun datar.

---

#### a. BujurSangkar
Kelas ini menghitung luas dan keliling bujur sangkar dengan rumus:
- **Luas:** sisi × sisi  
- **Keliling:** 4 × sisi

```java
public class BujurSangkar extends BangunDatar {
    private double sisi;

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
```
- **Deskripsi:**  
  Kelas ini menghitung luas dan keliling dari bujur sangkar.
- **Logika Perhitungan:**  
  - **Luas:** sisi × sisi  
  - **Keliling:** 4 × sisi

---

#### b. PersegiPanjang
Kelas ini menghitung luas dan keliling persegi panjang dengan rumus:
- **Luas:** panjang × lebar  
- **Keliling:** 2 × (panjang + lebar)

```java
public class PersegiPanjang extends BangunDatar {
    private double panjang;
    private double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double luas() {
        return panjang * lebar;
    }

    @Override
    public double keliling() {
        return 2 * (panjang + lebar);
    }
}
```

- **Deskripsi:**  
  Kelas ini menghitung luas dan keliling dari persegi panjang.
- **Logika Perhitungan:**  
  - **Luas:** panjang × lebar  
  - **Keliling:** 2 × (panjang + lebar)

---

#### c. Segitiga
Kelas ini menggunakan Heron’s Formula untuk menghitung luas segitiga dengan tiga sisi:
- **Luas:** √[s(s - a)(s - b)(s - c)]  
  dengan _s_ = (a + b + c) / 2  
- **Keliling:** a + b + c

```java
public class Segitiga extends BangunDatar {
    private double sisiA;
    private double sisiB;
    private double sisiC;

    public Segitiga(double sisiA, double sisiB, double sisiC) {
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }

    @Override
    public double luas() {
        double s = (sisiA + sisiB + sisiC) / 2.0;
        return Math.sqrt(s * (s - sisiA) * (s - sisiB) * (s - sisiC));
    }

    @Override
    public double keliling() {
        return sisiA + sisiB + sisiC;
    }
}
```
- **Deskripsi:**  
  Kelas ini menangani perhitungan untuk segitiga dengan beberapa metode:
  - **Segitiga Siku-siku:** Menggunakan alas dan tinggi.
  - **Segitiga dengan tiga sisi:** Menggunakan Heron’s Formula, yaitu:
    - Hitung setengah keliling: _s = (a + b + c) / 2_
    - **Luas:** √[s(s - a)(s - b)(s - c)]
  - **Segitiga dengan dua sisi dan sudut:** Menggunakan dua sisi dan sudut di antara kedua sisi (dalam derajat) untuk menghitung luas dan keliling (logika perhitungan spesifik diimplementasikan sesuai kebutuhan).

---

### 3. Program Utama (Main)

Program utama menggunakan kelas `Scanner` untuk meminta input dari pengguna. Berdasarkan pilihan yang dimasukkan, program akan menginstansiasi objek dari subclass yang relevan dan menampilkan hasil perhitungan luas dan keliling.

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("Silahkan Pilih Bangun Datar:");
        System.out.println("1. Bujur Sangkar");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Segitiga");
        System.out.println("=====================================");
        System.out.print("Silahkan masukkan pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan sisi: ");
                double sisi = input.nextDouble();
                BujurSangkar bs = new BujurSangkar(sisi);
                System.out.println("Luas: " + bs.luas());
                System.out.println("Keliling: " + bs.keliling());
                break;
            case 2:
                System.out.print("Masukkan panjang: ");
                double panjang = input.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lebar = input.nextDouble();
                PersegiPanjang pp = new PersegiPanjang(panjang, lebar);
                System.out.println("Luas: " + pp.luas());
                System.out.println("Keliling: " + pp.keliling());
                break;
            case 3:
                System.out.print("Masukkan sisi A: ");
                double a = input.nextDouble();
                System.out.print("Masukkan sisi B: ");
                double b = input.nextDouble();
                System.out.print("Masukkan sisi C: ");
                double c = input.nextDouble();
                Segitiga segitiga = new Segitiga(a, b, c);
                System.out.println("Luas: " + segitiga.luas());
                System.out.println("Keliling: " + segitiga.keliling());
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
        input.close();
    }
}
```

## Alur Program
1. **Menu Interaktif:**  
   Saat program dijalankan, pengguna akan disajikan menu untuk memilih jenis bangun datar:
   - Bujur Sangkar
   - Persegi Panjang
   - Segitiga
2. **Input Data:**  
   Berdasarkan pilihan:
   - **Bujur Sangkar:** Program meminta nilai sisi.
   - **Persegi Panjang:** Program meminta nilai panjang dan lebar.
   - **Segitiga:** Terdapat sub-menu untuk memilih tipe segitiga dan memasukkan nilai-nilai yang sesuai.
3. **Perhitungan:**  
   Setelah input diterima, program membuat objek dari kelas turunan yang relevan dan memanggil metode `luas()` dan `keliling()` untuk menghitung hasil.
4. **Output:**  
   Hasil perhitungan (luas dan keliling) ditampilkan ke layar.

## Kesimpulan
Kode ini merupakan contoh penerapan inheritance dan polimorfisme dalam Java, di mana:
- **Inheritance** memungkinkan pembagian kode umum ke dalam superclass (`BangunDatar`).
- **Polimorfisme** terlihat saat metode `luas()` dan `keliling()` di-override oleh masing-masing subclass agar sesuai dengan perhitungan bangun datar yang spesifik.
- **Interaksi Pengguna** diimplementasikan melalui penggunaan kelas `Scanner` untuk membaca input, sehingga program dapat berjalan secara dinamis dan interaktif.
