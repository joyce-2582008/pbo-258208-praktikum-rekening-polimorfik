public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() { return nomor; }
    public String getPemilik() { return pemilik; }
    public int getSaldo() { return saldo; }

    // Ketentuan 1: Abstract method
    public abstract int biayaAdminBulanan();

    // Ketentuan 2: Method konkret potongBiayaAdmin
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    private String formatRupiah(int nominal) {
        return String.format("Rp%,d", nominal).replace(',', '.');
    }

    public void cetakInfo() {
        System.out.printf("%s | %-6s | %10s%n", nomor, pemilik, formatRupiah(saldo));
    }
}