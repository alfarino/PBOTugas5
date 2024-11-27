public class DaftarBarang extends Barang { // Inheritance: Kelas DaftarBarang mewarisi kelas Barang
    // Konstruktor untuk menginisialisasi objek DaftarBarang
    public DaftarBarang(String kodeBarang, String namaBarang, int hargaBarang) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil konstruktor parent (Barang) untuk menginisialisasi kodeBarang, namaBarang, dan hargaBarang
    }

    // Metode untuk mendapatkan daftar barang yang tersedia
    public static DaftarBarang[] getBarangList() {
        return new DaftarBarang[]{
            new DaftarBarang("L001", "Laptop Acer", 7000000),
            new DaftarBarang("L002", "Laptop Asus", 8000000),
            new DaftarBarang("L003", "Laptop HP", 7500000),
            new DaftarBarang("L004", "Laptop Lenovo", 7200000),
            new DaftarBarang("L005", "Laptop Dell", 8500000),
            new DaftarBarang("L006", "Laptop Apple", 15000000)
        };
    }

    // Metode untuk validasi barang berdasarkan kode barang
    public static DaftarBarang validasiBarang(String kodeBarang) throws IllegalArgumentException { 
        for (DaftarBarang barang : getBarangList()) {
            if (barang.kodeBarang.equalsIgnoreCase(kodeBarang)) { // Menggunakan metode string equalsIgnoreCase untuk membandingkan kode barang
                return barang; // Mengembalikan barang jika ditemukan
            }
        }
        throw new IllegalArgumentException("Kode barang tidak ditemukan di toko!"); // Melempar exception jika barang tidak ditemukan
    }
    
    // Metode untuk menampilkan daftar barang
    public static void tampilkanDaftarBarang() {
        System.out.println("\nDaftar Barang:");
        for (DaftarBarang barang : getBarangList()) {
            barang.displayInfo(); // Menampilkan informasi barang menggunakan metode displayInfo() dari kelas Barang
            System.out.println("----------------------------");
        }
    }
}
