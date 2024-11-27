public class Transaksi extends Barang { // Inheritance: Kelas Transaksi mewarisi kelas Barang
    private int jumlahBeli; // Variabel untuk menyimpan jumlah beli barang

    // Konstruktor untuk menginisialisasi objek Transaksi
    public Transaksi(String kodeBarang, String namaBarang, int hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil konstruktor parent (Barang) untuk menginisialisasi kodeBarang, namaBarang, dan hargaBarang
        this.jumlahBeli = jumlahBeli; // Menginisialisasi jumlah beli
        
    }

    // Metode untuk menghitung total harga berdasarkan jumlah beli
    public int hitungTotal() {
        return jumlahBeli * hargaBarang; // Menggunakan variabel hargaBarang dari parent class Barang
    }

    // Getter untuk jumlah beli
    public int getJumlahBeli() {
        return jumlahBeli; // Mengembalikan jumlah beli
    }


    // Metode untuk menampilkan informasi transaksi termasuk tanggal
    public void displayTransaksi() {
        
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total Harga: Rp " + hitungTotal());
    }
}