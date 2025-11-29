import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySuatChieu implements IQuanLySuatChieu{
    public static List<SuatChieu> DanhSachSuatChieu;
    
    public QuanLySuatChieu() { DanhSachSuatChieu = new ArrayList<>(); }

    @Override
    public void ThemSuatChieu(SuatChieu s) { DanhSachSuatChieu.add(s); }

    @Override
    public SuatChieu TimSuatChieu(String maSuat) {
        for (SuatChieu s : DanhSachSuatChieu) if (s.getMaSuatChieu().equals(maSuat)) return s;
        return null;
    }

    @Override
    public boolean XoaSuatChieu(String maSuat) {
        SuatChieu s = TimSuatChieu(maSuat);
        if (s != null) { DanhSachSuatChieu.remove(s); return true; }
        return false;
    }
    @Override
    public void HienThiThongTinSuatChieu() {
        if(DanhSachSuatChieu.isEmpty()) System.out.println("Danh Sach Rong");
        DanhSachSuatChieu.forEach(SuatChieu::HienThiThongTinSuat);
    }

    @Override
    public List<SuatChieu> DanhSachSuatChieu() {
        return DanhSachSuatChieu;
    }

    public void menuQuanLySuatChieu(QuanLyPhim QLP, QuanLyPhongChieu QLPC) {
        Scanner sc = new Scanner(System.in);
        IQuanLySuatChieu QLS = new QuanLySuatChieu();
        if (!QLP.getDanhSachPhim().isEmpty() && !QLPC.getDanhSachPhong().isEmpty()) {
            SuatChieu sc1 = new SuatChieu(
                    "sc001",
                    LocalDateTime.now().plusDays(1),
                    QLP.getDanhSachPhim().get(0),
                    QLPC.getDanhSachPhong().get(0),
                    QLPC.getDanhSachPhong().get(0).getSoLuongGhe()
            );
            QLS.ThemSuatChieu(sc1);
        }
        int ch;
        do {
            System.out.println("\n====== MENU QUẢN LÝ SUẤT CHIẾU ======");
            System.out.println("1. Thêm Suất Chiếu");
            System.out.println("2. Hiển thị danh sách Suất Chiếu");
            System.out.println("3. Tìm Suất Chiếu theo mã");
            System.out.println("4. Xóa Suất Chiếu theo mã");
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
                    String maSC;
                    while (true) {
                        System.out.print("Nhập mã Suất Chiếu: ");
                        maSC = sc.nextLine().trim();
                        if (maSC.isEmpty()) {
                            System.out.println("Mã không được để trống!");
                            continue;
                        }
                        if (QLS.TimSuatChieu(maSC) != null) {
                            System.out.println("Mã suất chiếu đã tồn tại!");
                            continue;
                        }
                        if (QLP.getDanhSachPhim().isEmpty()) {
                            System.out.println(" Không có phim nào. Hãy thêm phim trước!");
                            break;
                        }

                        System.out.println("\n--- Danh sách phim ---");
                        for (int i = 0; i < QLP.getDanhSachPhim().size(); i++) {
                            System.out.println((i + 1) + ". " + QLP.getDanhSachPhim().get(i).getTenPhim());
                        }

                        int chPhim;
                        while (true) {
                            System.out.print("Chọn phim: ");
                            chPhim = sc.nextInt();
                            sc.nextLine();
                            if (chPhim < 1 || chPhim > QLP.getDanhSachPhim().size()) {
                                System.out.println(" Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                            } else break;
                        }
                        Phim phim = QLP.getDanhSachPhim().get(chPhim - 1);


                        if (QLPC.getDanhSachPhong().isEmpty()) {
                            System.out.println(" Không có phòng chiếu. Hãy thêm phòng trước!");
                            break;
                        }

                        System.out.println("\n--- Danh sách phòng chiếu ---");
                        for (int i = 0; i < QLPC.getDanhSachPhong().size(); i++) {
                            System.out.println((i + 1) + ". " + QLPC.getDanhSachPhong().get(i).getTenPhong());
                        }

                        int chPhong;
                        while (true) {
                            System.out.print("Chọn phòng chiếu: ");
                            chPhong = sc.nextInt();
                            sc.nextLine();
                            if (chPhong < 1 || chPhong > QLPC.getDanhSachPhong().size()) {
                                System.out.println(" Phòng chiếu không hợp lệ! Vui lòng chọn lại.");
                            } else break;
                        }
                        PhongChieu phong = QLPC.getDanhSachPhong().get(chPhong - 1);
                        LocalDate date = null;
                        DateTimeFormatter fmtNgay = DateTimeFormatter.ofPattern("d/M/yyyy");

                        while (true) {
                            try {
                                System.out.print("Nhập ngày chiếu (dd/MM/yyyy): ");
                                String ngay = sc.nextLine();
                                date = LocalDate.parse(ngay, fmtNgay);
                                break;
                            } catch (Exception e) {
                                System.out.println(" Ngày không hợp lệ! Ví dụ đúng: 25/07/2026");
                            }
                        }
                        LocalTime time = null;
                        DateTimeFormatter fmtGio = DateTimeFormatter.ofPattern("H:mm");

                        while (true) {
                            try {
                                System.out.print("Nhập giờ (HH:mm): ");
                                String gio = sc.nextLine();
                                time = LocalTime.parse(gio, fmtGio);
                                break;
                            } catch (Exception e) {
                                System.out.println(" Giờ không hợp lệ! Ví dụ đúng: 14:30");
                            }
                        }
                        LocalDateTime tg = LocalDateTime.of(date, time);
                        QLS.ThemSuatChieu(new SuatChieu(maSC, tg, phim, phong, phong.getSoLuongGhe()));
                        System.out.println("Đã thêm Suât chiếu");break;
                    }
                }

                case 2 -> QLS.HienThiThongTinSuatChieu();

                case 3 -> {
                    System.out.print("Nhập mã Suất Chiếu cần tìm: ");
                    String maSC2 = sc.nextLine();
                    SuatChieu s = QLS.TimSuatChieu(maSC2);
                    System.out.println(s != null ? s : "Không tìm thấy!");
                }

                case 4 -> {
                    System.out.print("Nhập mã Suất Chiếu cần xóa: ");
                    String maSC3 = sc.nextLine();
                    System.out.println(QLS.XoaSuatChieu(maSC3) ? "Đã xóa!" : "Không tồn tại!");
                }

                case 0 -> {
                    System.out.println("→ Quay lại menu chính");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }

        }while (true);
    }

}
