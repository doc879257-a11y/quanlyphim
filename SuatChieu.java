import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SuatChieu {
    private String MaSuatChieu;
    private LocalDateTime ThoiGianChieu;
    private Phim phim;
    private PhongChieu phongChieu;
    private int SoLuongVeCon;
    private List<String> DanhSachDatVe;
    public SuatChieu() { this.DanhSachDatVe = new ArrayList<>(); }
    public SuatChieu(String MaSuatChieu,LocalDateTime ThoiGianChieu,Phim phim,PhongChieu phongChieu,int SoLuongVeCon) {
        this.MaSuatChieu = MaSuatChieu;
        this.ThoiGianChieu = ThoiGianChieu;
        this.phim = phim;
        this.phongChieu = phongChieu;
        this.SoLuongVeCon = SoLuongVeCon;
        this.DanhSachDatVe = new ArrayList<>();
    }

    public String getMaSuatChieu() {
        return MaSuatChieu;
    }

    public void setMaSuatChieu(String maSuatChieu) {
        MaSuatChieu = maSuatChieu;
    }

    public LocalDateTime getThoiGianChieu() {
        return ThoiGianChieu;
    }

    public void setThoiGianChieu(LocalDateTime thoiGianChieu) {
        ThoiGianChieu = thoiGianChieu;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
    }

    public int getSoLuongVeCon() {
        return SoLuongVeCon;
    }

    public void setSoLuongVeCon(int soLuongVeCon) {
        SoLuongVeCon = soLuongVeCon;
    }

    public List<String> getDanhSachDatVe() {
        return DanhSachDatVe;
    }

    public void setDanhSachDatVe(List<String> danhSachDatVe) {
        DanhSachDatVe = danhSachDatVe;
    }

    public boolean datGhe(String MaGhe) {
        Ghe g = phongChieu.TimGhe(MaGhe);
        if (g == null) return false;
        if (g.isDaDat()) return false;
        g.setDaDat(true);
        DanhSachDatVe.add(MaGhe);
        SoLuongVeCon = Math.max(0, SoLuongVeCon - 1);
        return true;
    }

    public boolean HuyDatGhe(String MaGhe) {
        Ghe g = phongChieu.TimGhe(MaGhe);
        if (g == null) return false;
        if (!g.isDaDat()) return false;
        g.setDaDat(false);
        DanhSachDatVe.remove(MaGhe);
        SoLuongVeCon++;
        return true;
    }

    public void HienThiThongTinSuat() {
        System.out.println("SuatChieu: " + MaSuatChieu + " phim=" + phim.getTenPhim() + " phong=" + phongChieu.getMaPhong() + "    thoi gian=" + ThoiGianChieu);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Mã: " + MaSuatChieu +
                " | Phim: " + phim.getTenPhim() +
                " | Phòng: " + phongChieu.getMaPhong() +
                " | Thời gian: " + ThoiGianChieu.format(fmt);
    }
}
