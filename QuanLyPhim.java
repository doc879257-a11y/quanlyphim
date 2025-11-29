import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyPhim implements IQuanLyPhim,IReadWrite{
    private static List<Phim> DanhSachPhim;

    public QuanLyPhim() {
        DanhSachPhim = new ArrayList<>();
        ReadData();
    }

    @Override
    public void ThemPhim(Phim p) {
        DanhSachPhim.add(p);
        WriteData();
    }
    @Override
    public boolean XoaPhim(String maPhim) {
        Phim p = TimPhim(maPhim);
        if (p != null) {
            DanhSachPhim.remove(p);
            WriteData();
            return true;
        }
        return false;
    }


    @Override
    public Phim TimPhim(String maPhim) {
        for (Phim p : DanhSachPhim)
            if (p.getMaPhim().equalsIgnoreCase(maPhim))
                return p;
        return null;
    }
    @Override
    public void ReadData() {
        File f = new File("phim.dat");
        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            DanhSachPhim = (List<Phim>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
    @Override
    public void WriteData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("phim.dat"))) {
            oos.writeObject(DanhSachPhim);
        } catch (Exception e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
    @Override
    public void HienThiDanhSach() {
        if (DanhSachPhim.isEmpty()) {
            System.out.println("Danh sách phim rỗng.");
            return;
        }
        DanhSachPhim.forEach(Phim::HienThiThongTin);
    }

    public List<Phim> getDanhSachPhim() {
        return DanhSachPhim;
    }

    public void setDanhSachPhim(List<Phim> danhSachPhim) {
        DanhSachPhim = danhSachPhim;
    }

    static void menuQuanLyPhim() {
        Scanner sc = new Scanner(System.in);
        IQuanLyPhim QLP=new QuanLyPhim();
        int ch ;
        do {
            System.out.println("\n====== MENU QUẢN LÝ PHIM ======");
            System.out.println("1. Thêm phim Hoạt Hình.");
            System.out.println("2. Thêm phim Hành Động.");
            System.out.println("3. Hiển thị danh sách phim.");
            System.out.println("4. Tìm phim theo mã.");
            System.out.println("5. Xoá phim theo mã.");
            System.out.println("0. Quay lại");
            System.out.print("Nhập Lựa Chọn: ");
            try {
                ch = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Vui lòng nhập số (0-4), không được nhập chữ!");
                continue;
            }
            switch (ch) {
                case 1->{
                    String maPhim;

                    while (true) {
                        System.out.print("Nhập mã phim: ");
                        maPhim = sc.nextLine().trim();
                        if (maPhim.isEmpty()) {
                            System.out.println(" Mã phim không được để trống!");
                            continue;
                        }
                        boolean tonTai = false;
                        for (Phim phim : DanhSachPhim) {
                            if (phim.getMaPhim().equalsIgnoreCase(maPhim)) {
                                tonTai = true;
                                break;
                            }
                        }

                        if (tonTai) {
                            System.out.println(" Mã phim đã tồn tại! Nhập mã khác.");
                            continue;
                        }
                        break;
                    }


                    String tenPhim;
                    do{
                        System.out.print("Nhập Tên Phim:");
                        tenPhim = sc.nextLine();
                        if(tenPhim.isEmpty())
                            System.out.println("Tên Phim không được rỗng.");
                    }
                    while(tenPhim.isEmpty());
                    int ThoiLuong;
                    do {
                        System.out.print("Nhập thời lượng(phút): ");
                        ThoiLuong = sc.nextInt();
                        if (ThoiLuong <= 0) System.out.println(" Thời lượng phải lớn hơn 0!");
                    } while (ThoiLuong <= 0);sc.nextLine();
                    double Gia;
                    do {
                        System.out.print("Nhập giá cơ bản: ");
                        Gia = sc.nextDouble();
                        if (Gia <= 0) System.out.println(" Giá cơ bản phải lớn hơn 0!");
                    } while (Gia <= 0);sc.nextLine();
                    int DoTuoiPhuHop;
                    do {
                        System.out.print("Nhập độ tuổi phù hợp: ");
                        DoTuoiPhuHop = sc.nextInt();
                        if (DoTuoiPhuHop <= 0) System.out.println("Độ tuổi phù hợp phải lớn hơn 0!");
                    } while (DoTuoiPhuHop <= 0);
                    sc.nextLine();
                    String TheLoai;
                    do{
                        System.out.print("Nhập Thể Loại:");
                        TheLoai = sc.nextLine();
                        if(TheLoai==null)
                            System.out.println("Thể Loại không được rỗng.");
                    }
                    while(TheLoai==null);
                    QLP.ThemPhim(new PhimHoatHinh(maPhim,tenPhim,ThoiLuong,Gia,DoTuoiPhuHop,TheLoai));
                    System.out.println("Đã thêm phim hoạt hình vao danh sách phim.");
                }
                case 2->{
                    String maPhim;

                    while (true) {
                        System.out.print("Nhập mã phim: ");
                        maPhim = sc.nextLine().trim();
                        if (maPhim.isEmpty()) {
                            System.out.println(" Mã phim không được để trống!");
                            continue;
                        }
                        boolean tonTai = false;
                        for (Phim phim : DanhSachPhim) {
                            if (phim.getMaPhim().equalsIgnoreCase(maPhim)) {
                                tonTai = true;
                                break;
                            }
                        }

                        if (tonTai) {
                            System.out.println(" Mã phim đã tồn tại! Nhập mã khác.");
                            continue;
                        }
                        break;
                    }
                    String tenPhim;
                    do{
                        System.out.print("Nhập Tên Phim:");
                        tenPhim = sc.nextLine();
                        if(tenPhim.isEmpty())
                            System.out.println("Tên Phim không được rỗng.");
                    }
                    while(tenPhim.isEmpty());
                    int ThoiLuong;
                    do {
                        System.out.print("Nhập thời lượng: ");
                        ThoiLuong = sc.nextInt();
                        if (ThoiLuong <= 0) System.out.println(" Thời lượng phải lớn hơn 0!");
                    } while (ThoiLuong <= 0);
                    double Gia;
                    do {
                        System.out.print("Nhập giá cơ bản: ");
                        Gia = sc.nextDouble();
                        if (Gia <= 0) System.out.println(" Giá cơ bản phải lớn hơn 0!");
                    } while (Gia <= 0);
                    int Gioihantuoi;
                    do{
                        System.out.print("Nhập độ tuổi giới hạn:");
                        Gioihantuoi = sc.nextInt();
                        if(Gioihantuoi<=0)
                            System.out.println("Độ tuổi phải lớn hơn 0");
                    }while (Gioihantuoi<=0);
                    boolean Hot;
                    int chon;
                    while (true) {
                        try {
                            System.out.print("Phim Hot? (1 = Có, 0 = Không): ");
                            chon = sc.nextInt();
                            if (chon == 1) {
                                Hot = true;
                                break;
                            } else if (chon == 0) {
                                Hot = false;
                                break;
                            } else {
                                System.out.println(" Chỉ được nhập 1 hoặc 0!");
                            }
                        } catch (Exception e) {
                            System.out.println(" Phải nhập SỐ 1 hoặc 0!");
                            sc.nextLine();
                        }
                    }
                    QLP.ThemPhim(new PhimHanhDong(maPhim,tenPhim,ThoiLuong,Gia,Gioihantuoi,Hot));
                    System.out.println("Đã thêm phim hành động vào danh sách phim");
                }
                case 3->QLP.HienThiDanhSach();
                case 4->{
                    System.out.print("Nhập mã cần tìm: ");
                    String maPhim = sc.nextLine();
                    Phim phim = QLP.TimPhim(maPhim);
                    System.out.println(phim != null ? phim : "Không tìm thấy!");
                }
                case 5->{
                    System.out.print("Nhập mã cần xóa: ");
                    String maPhim = sc.nextLine();
                    System.out.println(QLP.XoaPhim(maPhim) ? "Đã xóa!" : "Không tồn tại!");
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
