import java.util.ArrayList;

public class PhongChieu {
    private String MaPhong;
    private String TenPhong;
    private int SoLuongGhe;
    private ArrayList<Ghe> DanhSachGhe;
    public PhongChieu() {this.DanhSachGhe=new ArrayList<>();}
    public PhongChieu(String MaPhong, String TenPhong, int SoLuongGhe){
        this.MaPhong=MaPhong;
        this.TenPhong=TenPhong;
        this.SoLuongGhe=SoLuongGhe;
        this.DanhSachGhe=new ArrayList<>();
        for (int i = 1; i <= SoLuongGhe; i++) {
           DanhSachGhe.add(new Ghe("G" + i));
        }
    }
    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }

    public int getSoLuongGhe() {
        return SoLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        SoLuongGhe = soLuongGhe;
    }

    public ArrayList<Ghe> getDanhSachGhe() {
        return DanhSachGhe;
    }

    public void setDanhSachGhe(ArrayList<Ghe> danhSachGhe) {
        DanhSachGhe = danhSachGhe;
    }
    public Ghe TimGhe(String MaGhe) {
        if (MaGhe == null) return null;
        for (Ghe g : DanhSachGhe) {
            if (MaGhe.equalsIgnoreCase(g.getMaGhe())) {
                return g;
            }
        }
        return null;
    }
    public void HienThiThongTinPhongChieu() {
        System.out.println("Phong: " + MaPhong + " - " + TenPhong + " - soGhe=" + SoLuongGhe);
    }
    public void HienThiGheTrong() {
        System.out.print("Ghế trống: ");
        boolean found = false;
        for (Ghe g : DanhSachGhe) {
            if (!g.isDaDat()) {
                System.out.print(g.getMaGhe() + " ");
                found = true;
            }
        }
        if (!found) System.out.print("Không còn ghế trống");
        System.out.println();
    }
    @Override
    public String toString() {
        return "PhongChieu{" + "maPhong='" + MaPhong + '\'' + ", tenPhong='" + TenPhong + '\'' + ", soLuongGhe=" + SoLuongGhe + '}';
    }
}
