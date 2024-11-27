public class Barang { 
    protected String kodeBarang;  // Variabel untuk menyimpan kode barang
    protected String namaBarang;  // Variabel untuk menyimpan nama barang
    protected int hargaBarang;    // Variabel untuk menyimpan harga barang

    // Konstruktor untuk menginisialisasi objek Barang
    public Barang(String kodeBarang, String namaBarang, int hargaBarang) {
        this.kodeBarang = kodeBarang; // Menginisialisasi kode barang
        this.namaBarang = namaBarang; // Menginisialisasi nama barang
        this.hargaBarang = hargaBarang; // Menginisialisasi harga barang
    }

    // Metode untuk menampilkan informasi barang
    public void displayInfo() {
        System.out.println("Kode Barang : " + kodeBarang); // Menampilkan kode barang
        System.out.println("Nama Barang : " + namaBarang); // Menampilkan nama barang
        System.out.println("Harga Barang: Rp" + hargaBarang); // Menampilkan harga barang
    }
}
