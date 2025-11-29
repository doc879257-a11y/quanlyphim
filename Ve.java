import java.time.LocalDateTime;

public class Ve {
    private String MaVe;
    private SuatChieu suatChieu;
    private Ghe ghe;
    private double giaVe;
    private LocalDateTime ngayBan;
    private boolean daThanhToan;
    public Ve() {}

    public Ve(String MaVe, SuatChieu suatChieu, Ghe ghe, double giaVe) {
        this.MaVe = MaVe;
        this.suatChieu = suatChieu;
        this.ghe = ghe;
        this.giaVe = giaVe;
        this.ngayBan = LocalDateTime.now();
        this.daThanhToan = false;
    }

    public String getMaVe() {
        return MaVe;
    }

    public void setMaVe(String maVe) {
        MaVe = maVe;
    }

    public SuatChieu getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(SuatChieu suatChieu) {
        this.suatChieu = suatChieu;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public LocalDateTime getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(LocalDateTime ngayBan) {
        this.ngayBan = ngayBan;
    }

    public void setDaThanhToan(boolean daThanhToan) {
        this.daThanhToan = daThanhToan;
    }
    public void HienThiVe(){
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Ve{" + "MaVe='" +MaVe + '\'' + ", suatChieu=" + suatChieu.getMaSuatChieu() + ", ghe=" + ghe.getMaGhe() + ", giaVe=" + giaVe + ", ngayBan=" + ngayBan + ", daThanhToan=" + daThanhToan + '}';
    }
}
