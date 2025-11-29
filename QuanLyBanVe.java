import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyBanVe implements IVe{
    private List<Ve> DanhSachVe;
    private QuanLySuatChieu QLSuat;

    public QuanLyBanVe() {
        this.QLSuat = QLSuat;
        this.DanhSachVe = new ArrayList<>();
    }
    @Override
    public Ve DatVe(SuatChieu suatChieu, String MaGhe) {
        if (suatChieu == null) return null;
        boolean ok = suatChieu.datGhe(MaGhe);
        if (!ok) return null;
        Ghe g = suatChieu.getPhongChieu().TimGhe(MaGhe);
        String MaVe = "V" + (DanhSachVe.size() + 1);
        double GiaVe = suatChieu.getPhim().TinhGiaVe();
        Ve v = new Ve(MaVe, suatChieu,g, GiaVe);
        DanhSachVe.add(v);
        return v;
    }

    @Override
    public boolean HuyVe(String MaVe) {
        Ve v = TimVe(MaVe);
        if (v == null) return false;
        boolean ok = v.getSuatChieu().HuyDatGhe(v.getGhe().getMaGhe());
        if (!ok) return false;
        DanhSachVe.remove(v);
        return true;
    }

    @Override
    public Ve TimVe(String MaVe) {
        for (Ve v : DanhSachVe) if (v.getMaVe().equals(MaVe)) return v;
        return null;
    }
    @Override
    public void HienThiDanhSachVe() {
        if(DanhSachVe.isEmpty()) System.out.println ("Danh Sách Vé Rỗng");
        DanhSachVe.forEach(Ve::HienThiVe);
    }

    public List<Ve> getDanhSachVe() { return DanhSachVe; }
    static void menuQuanLyBanVe(QuanLySuatChieu QLSC) {
        Scanner sc = new Scanner(System.in);
        IVe QLBV=new QuanLyBanVe();
        int ch;

        do {
            System.out.println("\n====== MENU QUẢN LÝ BÁN VÉ ======");
            System.out.println("1. Đặt vé");
            System.out.println("2. Hủy vé");
            System.out.println("3. Tìm vé theo mã");
            System.out.println("4. Danh sách vé đã bán");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn: ");


            try {
                ch = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Vui lòng nhập số (0-4), không được nhập chữ!");
                continue;
            }

            switch (ch) {
                case 1 -> {
                    if (QLSC.DanhSachSuatChieu().isEmpty()) {
                        System.out.println(" Chưa có suất chiếu nào! Hãy thêm suất chiếu trước.");
                        break;
                    }

                    System.out.println("\n--- Danh sách Suất Chiếu ---");
                    int index = 1;
                    for (SuatChieu scObj : QLSC.DanhSachSuatChieu()) {
                        System.out.println(index++ + ". " + scObj);
                    }

                    System.out.print("Chọn suất chiếu (nhập mã ví dụ sc001): ");
                    String maSC = sc.nextLine();

                    SuatChieu suatchieu = QLSC.TimSuatChieu(maSC);

                    if (suatchieu == null) {
                        System.out.println(" Không có suất chiếu này!");
                        break;
                    }

                    System.out.println("\n--- Danh sách ghế còn trống ---");
                    suatchieu.getPhongChieu().HienThiGheTrong();

                    System.out.print("Nhập mã ghế muốn đặt: ");
                    String maGhe = sc.nextLine();

                    Ve v = QLBV.DatVe(suatchieu, maGhe);
                    if (v == null) {
                        System.out.println(" Đặt vé thất bại! Ghế không tồn tại hoặc đã được đặt.");
                    } else {
                        System.out.println("✔ Đặt vé thành công!");
                        v.HienThiVe();
                    }
                }
                case 2 -> {
                    System.out.print("Nhập mã vé cần hủy: ");
                    String maVe = sc.nextLine();
                    boolean ok = QLBV.HuyVe(maVe);
                    if (ok) System.out.println("✔ Hủy vé thành công!");
                    else System.out.println(" Hủy vé thất bại. Mã vé không tồn tại hoặc ghế chưa được đặt.");
                }
                case 3 -> {
                    System.out.print("Nhập mã vé: ");
                    String maVe = sc.nextLine();
                    Ve v = QLBV.TimVe(maVe);
                    if (v == null) System.out.println(" Không tìm thấy vé!");
                    else v.HienThiVe();
                }
                case 4 -> QLBV.HienThiDanhSachVe();
                case 0 -> {
                    System.out.println("→ Quay lại menu chính");
                    return;
                }
                default -> System.out.println(" Lựa chọn không hợp lệ!");
            }

        } while (true);
    }

}
