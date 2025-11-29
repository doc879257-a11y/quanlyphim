import java.util.List;

public interface IQuanLySuatChieu {
    void ThemSuatChieu(SuatChieu s);
    SuatChieu TimSuatChieu(String maSuat);
    boolean XoaSuatChieu(String maSuat);
    void HienThiThongTinSuatChieu();

    List<SuatChieu> DanhSachSuatChieu();;
}
