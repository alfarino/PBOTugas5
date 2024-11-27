public class Akun {
    private String username;    // Variabel untuk menyimpan username
    private String password;    // Variabel untuk menyimpan password
    private String namaKasir;   // Variabel untuk menyimpan nama kasir

    // Konstruktor untuk menginisialisasi objek Akun
    public Akun(String username, String password, String namaKasir) {
        this.username = username;
        this.password = password;
        this.namaKasir = namaKasir;
    }

    // Getter untuk nama kasir
    public String getNamaKasir() {
        return namaKasir; // Menggunakan metode string untuk mengembalikan nama kasir
    }

    // Metode statis untuk autentikasi, mengembalikan objek Akun jika username dan password cocok
    public static Akun autentikasi(String username, String password) {
        // Daftar akun yang tersedia
        Akun[] akunList = {
            new Akun("alfa", "rino", "Kasir Alfa"),
            new Akun("alfa", "rizto", "Kasir Rizto"),
            new Akun("alfa", "rani", "Kasir Rani")
        };

        // Pencocokan username dan password dengan akun dalam daftar
        for (Akun akun : akunList) {
            // Menggunakan metode string untuk membandingkan username dan password
            if (akun.username.equals(username) && akun.password.equals(password)) {
                return akun; // Mengembalikan objek Akun jika autentikasi berhasil
            }
        }

        // Jika autentikasi gagal, mengembalikan null
        return null;
    }
}
