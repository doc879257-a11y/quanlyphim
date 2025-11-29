import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyPhongChieu implements IQuanLyPhongChieu {
    private static List<PhongChieu> DanhSachPhong;

    public QuanLyPhongChieu() { DanhSachPhong = new ArrayList<>(); }

    @Override
    public void ThemPhong(PhongChieu p) { DanhSachPhong.add(p); }

    @Override
    public PhongChieu TimPhong(String maPhong) {
        for (PhongChieu p : DanhSachPhong) if (p.getMaPhong().equals(maPhong)) return p;
        return null;
    }

    @Override
    public boolean XoaPhong(String maPhong) {
        PhongChieu p = TimPhong(maPhong);
        if (p != null) { DanhSachPhong.remove(p); return true; }
        return false;
    }
    @Override
    public void HienThiPhongChieu() {
        if(DanhSachPhong.isEmpty()) System.out.println("Danh Sach Rong");
        DanhSachPhong.forEach(PhongChieu::HienThiThongTinPhongChieu);
    }

    public List<PhongChieu> getDanhSachPhong() {
        return DanhSachPhong;
    }

    public void setDanhSachPhong(List<PhongChieu> danhSachPhong) {
        DanhSachPhong = danhSachPhong;
    }
    static void menuQuanLyPhongChieu() {
        Scanner sc = new Scanner(System.in);
        IQuanLyPhongChieu QLPC = new QuanLyPhongChieu();
        PhongChieu P1 = new PhongChieu("p001", "Phòng 1", 50);
        QLPC.ThemPhong(P1);

        int ch;
        do {
            System.out.println("\n====== MENU QUẢN LÝ PHÒNG CHIẾU ======");
            System.out.println("1. Thêm Phòng Chiếu");
            System.out.println("2. Hiển thị danh sách Phòng Chiếu");
            System.out.println("3. Tìm Phòng Chiếu theo mã");
            System.out.println("4. Xóa Phòng Chiếu theo mã");
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
                    String maPhong;
                    while (true) {
                        System.out.print("Nhập mã phòng: ");
                        maPhong = sc.nextLine().trim();
                        if (maPhong.isEmpty()) {
                            System.out.println("Mã phòng không được để trống!");
                            continue;
                        }
                        boolean tonTai = false;
                        for (PhongChieu pc : DanhSachPhong) {
                            if (pc.getMaPhong().equalsIgnoreCase(maPhong)) {
                                tonTai = true;
                                break;
                            }
                        }
                        if (tonTai) {
                            System.out.println("Mã phòng đã tồn tại! Nhập mã khác.");
                            continue;
                        }
                        break;
                    }
                    String tenPhong;
                    do {
                        System.out.print("Nhập tên phòng: ");
                        tenPhong = sc.nextLine().trim();
                        if (tenPhong.isEmpty())
                            System.out.println("Tên phòng không được rỗng!");
                    } while (tenPhong.isEmpty());
                    int soLuongGhe;
                    do {
                        System.out.print("Nhập số lượng ghế: ");
                        soLuongGhe = sc.nextInt();
                        if (soLuongGhe <= 0)
                            System.out.println("Số lượng ghế phải lớn hơn 0!");
                    } while (soLuongGhe <= 0);
                    sc.nextLine();
                    QLPC.ThemPhong(new PhongChieu(maPhong, tenPhong, soLuongGhe));
                    System.out.println("Đã thêm phòng chiếu!");

                }
                case 2 -> QLPC.HienThiPhongChieu();
                case 3 -> {
                    System.out.print("Nhập mã cần tìm: ");
                    String maPhong = sc.nextLine();
                    PhongChieu pc = QLPC.TimPhong(maPhong);
                    System.out.println(pc != null ? pc : "Không tìm thấy!");
                }
                case 4 -> {
                    System.out.print("Nhập mã cần xóa: ");
                    String maPhong = sc.nextLine();
                    System.out.println(QLPC.XoaPhong(maPhong) ? "Đã xóa!" : "Không tồn tại!");
                }
                case 0 ->{
                    System.out.println("→ Quay lại menu chính");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (true);
    }

}

