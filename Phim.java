import java.io.Serializable;
public abstract class Phim implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String MaPhim;
    protected String TenPhim;
    protected int ThoiLuong;
    protected double Gia;
    public Phim() {}
    public Phim(String MaPhim,String TenPhim,int ThoiLuong,double Gia){
        this.MaPhim=MaPhim;
        this.TenPhim=TenPhim;
        this.ThoiLuong=ThoiLuong;
        this.Gia=Gia;
    }

    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String maPhim) {
        MaPhim = maPhim;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        ThoiLuong = thoiLuong;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }
    public void HienThiThongTin(){
        System.out.println(this.toString());
    }
    public abstract double TinhGiaVe();
    @Override
    public String toString(){
        return "Mã Phim:"+MaPhim+",Tên Phim:"+TenPhim+",Thời Lượng:"+ThoiLuong+",Gia:"+Gia;
    }
}