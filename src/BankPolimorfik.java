public class BankPolimorfik {
    public static void main(String[] args) {
        // Ketentuan 8: Uji coba instansiasi abstract class
        // Rekening r = new Rekening("999", "Eko", 0);
        // Pesan error: java: Rekening is abstract; cannot be instantiated

        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        System.out.println("========== REKENING AWAL ===========");
        for (Rekening r : semua) {
            r.cetakInfo();
        }

        System.out.println("\n========== AKHIR BULAN ============");
        for (Rekening r : semua) {
            int admin = r.potongBiayaAdmin();
            System.out.printf("%s biaya admin  : Rp%,d%n", r.getNomor(), admin);
        }

        for (BerBunga b : berbunga) {
            int bng = b.tambahBunga();
            System.out.printf("%s bunga        : Rp%,d%n", b.getNomor(), bng);
        }

        System.out.println("\n========== REKENING AKHIR =========");
        int totalDana = 0;
        for (Rekening r : semua) {
            r.cetakInfo();
            totalDana += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        String formatTotal = String.format("Rp%,d", totalDana).replace(',', '.');
        System.out.println("Total dana bank : " + formatTotal);
    }
}