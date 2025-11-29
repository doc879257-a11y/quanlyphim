public class Ghe {
    private String MaGhe;
    private boolean DaDat;
    public Ghe(String maGhe) {
        this.MaGhe = maGhe;
        this.DaDat = false;
    }
    public Ghe(String MaGhe, boolean DaDat) {
        this.MaGhe = MaGhe;
        this.DaDat = DaDat;
    }

    public String getMaGhe() {
        return MaGhe;
    }

    public void setMaGhe(String maGhe) {
        MaGhe = maGhe;
    }

    public boolean isDaDat() {
        return DaDat;
    }

    public void setDaDat(boolean daDat) {
        DaDat = daDat;
    }
    @Override
    public String toString(){
        return "Ghế["+"Mã Ghế:"+MaGhe+"Đã Đặt:"+DaDat+"]";
    }
}
