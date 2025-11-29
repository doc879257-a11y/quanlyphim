public class PhimHoatHinh extends Phim {
    private static final long serialVersionUID = 1L;
    private int DoTuoiPhuHop;
    private String TheLoai;
    public PhimHoatHinh() {}
    public PhimHoatHinh(String MaPhim,String TenPhim,int ThoiLuong,double Gia,int DoTuoiPhuHop,String TheLoai) {
        super(MaPhim,TenPhim,ThoiLuong,Gia);
        this.DoTuoiPhuHop=DoTuoiPhuHop;
        this.TheLoai=TheLoai;
    }

    public int getDoTuoiPhuHop() {
        return DoTuoiPhuHop;
    }

    public void setDoTuoiPhuHop(int doTuoiPhuHop) {
        DoTuoiPhuHop = doTuoiPhuHop;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }
    @Override
    public double TinhGiaVe(){
       return getGia()*1.3;
    }
    @Override
    public String toString(){
        return super.toString()+"Độ Tuổi Phù Hợp:"+DoTuoiPhuHop+",Thể Loại:"+TheLoai+",Giá Vé"+TinhGiaVe();
    }
}