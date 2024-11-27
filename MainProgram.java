import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class MainProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Metode try-with-resources untuk menangani sumber daya (Scanner) secara otomatis
            while (true) { // Loop utama untuk melayani pelanggan baru
                // Login
                System.out.println("Login");
                System.out.print("Username: ");
                String username = scanner.nextLine(); // Menggunakan metode string untuk membaca input
                System.out.print("Password: ");
                String password = scanner.nextLine(); // Menggunakan metode string untuk membaca input

                // Membuat kode captcha acak
                String captcha = generateCaptcha(6); // Memanggil metode untuk membuat captcha
                System.out.println("Captcha: " + captcha);
                System.out.print("Masukkan captcha: ");
                String captchaInput = scanner.nextLine(); // Metode string untuk membaca input

                if (!captcha.equals(captchaInput)) { // Metode string: equals untuk membandingkan string
                    System.out.println("Captcha salah. Program ditutup.");
                    return;
                }

                // Autentikasi pengguna (inheritance: memanfaatkan metode dari kelas Akun, parent class-nya bisa berupa abstract class atau interface)
                Akun kasir = Akun.autentikasi(username, password);
                if (kasir == null) { // Exception handling logika sederhana
                    System.out.println("Login gagal. Program ditutup.");
                    return;
                }

                System.out.println("Login berhasil. Selamat datang, " + kasir.getNamaKasir() + "!"); // Metode string untuk mencetak nama
                DaftarBarang.tampilkanDaftarBarang(); // Menampilkan barang dari DaftarBarang (class child dari Barang, contoh inheritance)

                System.out.println();
                String noFaktur = "";
                while (true) { // Loop untuk validasi input faktur
                    try {
                        System.out.print("Masukkan No Faktur: ");
                        noFaktur = scanner.nextLine(); // Metode string untuk membaca input

                        if (noFaktur.isEmpty()) { // Metode string: isEmpty memeriksa apakah string kosong
                            throw new IllegalArgumentException("No Faktur tidak boleh kosong."); // Exception handling
                        }
                        break;
                    } catch (IllegalArgumentException e) { // Exception handling
                        System.out.println("Kesalahan: " + e.getMessage()); // Menampilkan pesan dari exception
                    }
                }

                List<Transaksi> daftarTransaksi = new ArrayList<>(); // Membuat daftar transaksi
                String pilihan = "";

                do {
                    String kodeBarang = "";
                    while (true) { // Loop untuk validasi input barang
                        try {
                            System.out.print("\nMasukkan Kode Barang: ");
                            kodeBarang = scanner.nextLine(); // Metode string untuk membaca input

                            DaftarBarang barangValid = DaftarBarang.validasiBarang(kodeBarang); // Validasi barang (inheritance, validasi di kelas child)
                            barangValid.displayInfo(); // Menampilkan info barang, memanfaatkan metode child class

                            System.out.print("\nJumlah Barang: ");
                            int jumlahBeli = Integer.parseInt(scanner.nextLine()); // Metode string untuk parsing input menjadi integer
                            if (jumlahBeli <= 0) {
                                System.out.println("Jumlah beli harus lebih dari 0!");
                                continue; // Kembali ke input jumlah jika invalid
                            }

                            // Menambahkan transaksi ke daftar
                            daftarTransaksi.add(new Transaksi(barangValid.kodeBarang, barangValid.namaBarang, barangValid.hargaBarang, jumlahBeli));
                            break;

                        } catch (IllegalArgumentException e) { // Exception handling
                            System.out.println("Kesalahan: " + e.getMessage());
                        }
                    }

                    System.out.print("Ada pesanan lain? (Y/N): ");
                    pilihan = scanner.nextLine().trim().toUpperCase(); // Metode string: trim dan toUpperCase untuk membersihkan input dan mengubah ke huruf besar
                } while (pilihan.equals("Y")); // Metode string: equals untuk membandingkan input dengan "Y"

                if (daftarTransaksi.isEmpty()) {
                    System.out.println("Tidak ada transaksi yang diproses.");
                    continue; // Kembali ke awal loop utama
                }

                // Membuat faktur transaksi
                Faktur faktur = new Faktur(noFaktur, kasir); // Faktur memanfaatkan class Transaksi dan Akun, contoh penggunaan inheritance
                faktur.cetakFaktur(daftarTransaksi); // Memanggil metode cetak faktur

                System.out.print("\nLanjut dengan pelanggan baru? (Y/N): ");
                String lanjut = scanner.nextLine().trim().toUpperCase(); // Metode string: trim dan toUpperCase
                if (!lanjut.equals("Y")) {
                    System.out.println("Program selesai. Terima kasih.");
                    break; // Keluar dari loop utama dan mengakhiri program
                }
            }
        } catch (Exception e) { // Exception handling global
            System.out.println("Kesalahan tak terduga: " + e.getMessage());
        }
    }

    // Metode untuk menghasilkan captcha acak
    private static String generateCaptcha(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz"; // Metode string: menggunakan karakter acak
        Random random = new Random(); // Membuat objek random
        StringBuilder captcha = new StringBuilder(); // Menggunakan StringBuilder untuk efisiensi
        for (int i = 0; i < length; i++) {
            captcha.append(chars.charAt(random.nextInt(chars.length()))); // Mengambil karakter acak
        }
        return captcha.toString(); // Mengembalikan captcha sebagai string
    }
}
