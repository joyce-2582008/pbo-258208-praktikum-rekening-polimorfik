public class Tabungan extends Rekening implements BerBunga {
    private double sukuBunga;

    public Tabungan(String nomor, String pemilik, int saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    @Override
    public int biayaAdminBulanan() {
        if (getSaldo() >= 1000000) {
            return 0;
        } else {
            return 5000;
        }
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (getSaldo() * (sukuBunga / 100.0));
        saldo += bunga;
        return bunga;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.printf("      Tabungan, bunga %.1f%% per bulan%n", sukuBunga);
    }
}