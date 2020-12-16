import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class SanPham implements Serializable {
    static Scanner input = new Scanner(System.in);
    private int ID;
    private String Ten;
    private double Gia;
    private int SoLuong;
    private static ArrayList<SanPham> DanhSachSP = new ArrayList<>();

    public SanPham (int ID, String Ten, double Gia, int SoLuong) {
        this.ID = ID;
        this.Ten = Ten;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
    }

    public int getID() {
        return ID;
    }

    public String getTen() {
        return Ten;
    }

    public double getGia() {
        return Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public static void HienThiList () {
        System.out.println("Please choose one feature listed below: \n" +
                "1. Add products \n" +
                "2. Display products \n" +
                "3. Delete a product \n" +
                "4. Edit a product \n" +
                "5. Search for products \n" +
                "6. Sort products by price \n" +
                "7. Save products to text file \n" +
                "8. Load products from the saved file \n" +
                "9. Exit program. \n");
    }

    public static int RandomID () {
        int min = 10, max = 1000;
        int ID;
        ID = (int) (Math.random()*(max - min + 1) + min);
        return ID;
    }

    public static void ThemSP () {
        System.out.print("Please enter number product that you want to add: ");
        int num = input.nextInt();
        input.nextLine();

        for (int i=1; i<=num; i++) {
            System.out.println();
            System.out.println("Product " + i + ":");

            System.out.print("Name Product:  ");
            String Ten = input.nextLine();

            System.out.print("Price:  ");
            double Gia = Double.parseDouble(input.nextLine());

            System.out.print("Quantity:  ");
            int SoLuong = Integer.parseInt(input.nextLine());

            SanPham sp = new SanPham(RandomID(), Ten, Gia, SoLuong);
            DanhSachSP.add(sp);
        }
    }

    public static void HienThiSP () {

        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (SanPham sp : DanhSachSP) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }

    }

    public static void XoaSP () {
        System.out.print("Please enter product ID: ");
        System.out.println();
        int inputID = input.nextInt();
        for (SanPham sp : DanhSachSP) {
            if (sp.getID() == inputID) {
                DanhSachSP.remove(sp);
                break;
            }
        }
    }

    public static void Edit () {
        System.out.print("Please enter product ID: ");
        int inputID = input.nextInt();
        input.nextLine();

        for (SanPham sp : DanhSachSP) {
            if (sp.getID() == inputID) {
                System.out.print("New name: ");
                String TenMoi = input.nextLine();

                System.out.print("New price: ");
                double GiaMoi = input.nextDouble();

                System.out.print("New quantity: ");
                int SoLuongMoi = input.nextInt();

                sp.setTen(TenMoi);
                sp.setGia(GiaMoi);
                sp.setSoLuong(SoLuongMoi);
                break;
            }
        }
    }

    public static void TimKiemSP () {
        System.out.print("Please enter key name: ");
        String keyName = input.nextLine();

        ArrayList<SanPham> dsTimKiemSP = new ArrayList<>();
        for (SanPham sp : DanhSachSP) {
            if (sp.getTen().contains(keyName)) {
                dsTimKiemSP.add(sp);
            }
        }

        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (SanPham sp : dsTimKiemSP) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }
    }

    public static void SapXepTheoGia () {

        ArrayList<SanPham> DanhSachSapXep = new ArrayList<>(DanhSachSP);

        SanPham temp;
        for (int i=0; i< DanhSachSapXep.size() - 1; i++) {
            for (int j=i+1; j< DanhSachSapXep.size(); j++) {
                if (DanhSachSapXep.get(i).getGia() > DanhSachSapXep.get(j).getGia()) {
                    temp = DanhSachSapXep.get(i);
                    DanhSachSapXep.set(i, DanhSachSapXep.get(j));
                    DanhSachSapXep.set(j, temp);
                }
            }
        }

        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (SanPham sp : DanhSachSapXep) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }
    }

    public static void LuuSanPham () throws Exception {
        File f = new File("C://Users//vieta//Desktop//PR1//products.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(DanhSachSP);
    }

    public static void LoadSanPham () throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://Users//vieta//Desktop//PR1//products.txt"));
        ArrayList<SanPham> danhSach;

        danhSach = (ArrayList<SanPham>) ois.readObject();


        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (SanPham sp : danhSach) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }
    }
}

public class A2 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int choice = 0;
        do {
            SanPham.HienThiList();
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: SanPham.ThemSP();
                break;

                case 2: SanPham.HienThiSP();
                break;

                case 3: SanPham.XoaSP();
                break;

                case 4: SanPham.Edit();
                break;

                case 5: SanPham.TimKiemSP();
                break;

                case 6: SanPham.SapXepTheoGia();
                break;

                case 7: SanPham.LuuSanPham();
                break;

                case 8: SanPham.LoadSanPham();
                break;

                case 9: System.out.println("Exiting Program...");
                break;

                default: System.out.println("Invalid choice, please try again");


            }
        }
        while (choice !=9);
        System.exit(0);
    }
}
