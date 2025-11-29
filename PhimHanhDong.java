public class PhimHanhDong extends Phim {
    private static final long serialVersionUID = 1L;
    private int GioiHanTuoi;
    private boolean Hot;
    public PhimHanhDong(){}
    public PhimHanhDong(String MaPhim,String TenPhim,int ThoiLuong,double Gia,int GioiHanTuoi,boolean Hot){
        super(MaPhim,TenPhim,ThoiLuong,Gia);
        this.GioiHanTuoi = GioiHanTuoi;
        this.Hot=Hot;
    }

    public int getGioiHanTuoi() {
        return GioiHanTuoi;
    }

    public void setGioiHanTuoi(int gioiHanTuoi) {
        GioiHanTuoi = gioiHanTuoi;
    }

    public boolean isHot() {
        return Hot;
    }

    public void setHot(boolean hot) {
        Hot = hot;
    }
    public double TinhGiaVe(){
        return getGia()*(Hot? 1.5:1);
    }
    @Override
    public String toString(){
        return super.toString()+",Giới Hạn Tuổi:"+GioiHanTuoi+",Hot:"+(Hot?"Có":"Không")+"Giá Vé"+TinhGiaVe();
    }
}
