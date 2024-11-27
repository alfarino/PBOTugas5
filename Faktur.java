import java.util.Date; // Untuk menggunakan Date
import java.util.List; // Untuk menggunakan List
import java.text.SimpleDateFormat; // Untuk memformat tanggal

public class Faktur {
    private String noFaktur;
    private Akun kasir;
    private Date tanggalFaktur; // Variabel untuk mencatat tanggal transaksi

    // Konstruktor untuk menginisialisasi objek Faktur
    public Faktur(String noFaktur, Akun kasir) {
        this.noFaktur = noFaktur;
        this.kasir = kasir;
        this.tanggalFaktur = new Date(); // Menginisialisasi tanggal transaksi dengan waktu sekarang
    }

    // Metode untuk mencetak faktur
    public void cetakFaktur(List<Transaksi> daftarTransaksi) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Format tanggal yang diinginkan
        System.out.println("Faktur No: " + noFaktur);
        System.out.println("Kasir: " + kasir.getNamaKasir());
        System.out.println("Tanggal Transaksi: " + sdf.format(tanggalFaktur)); // Menampilkan tanggal transaksi dalam format terstruktur
        System.out.println("-----------------------------------");

        // Menampilkan daftar transaksi
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.displayTransaksi(); // Menampilkan informasi setiap transaksi
            System.out.println("-----------------------------------");
        }

        // Menampilkan total harga transaksi
        int total = daftarTransaksi.stream().mapToInt(Transaksi::hitungTotal).sum();
        System.out.println("Total: Rp " + total);
    }

    // Getter untuk tanggal transaksi
    public Date getTanggalFaktur() {
        return tanggalFaktur;
    }
}
