import java.util.Scanner;

class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyPhim qlp = new QuanLyPhim();
        QuanLyPhongChieu qlpc = new QuanLyPhongChieu();
        QuanLySuatChieu qlsc = new QuanLySuatChieu();

        int chon = 1;

        do{
            System.out.println("\n========== MENU TỔNG ==========");
            System.out.println("1. Quản lý Phim");
            System.out.println("2. Quản lý Bán Vé");
            System.out.println("3. Quản lý Suất Chiếu");
            System.out.println("4. Quản lý Phòng Chiếu");
            System.out.println("0. Thoát");
            System.out.print("Nhập Lựa Chọn: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Vui lòng nhập số (0-4), không được nhập chữ!");
            }
            switch (chon) {
                case 1-> QuanLyPhim.menuQuanLyPhim();
                case 2-> QuanLyBanVe.menuQuanLyBanVe(qlsc);
                case 3-> qlsc.menuQuanLySuatChieu(qlp,qlpc);
                case 4-> QuanLyPhongChieu.menuQuanLyPhongChieu();
                case 0-> {
                    System.out.println("→ Thoát chương trình");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (true);
    }
    }


