package Assignment02;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Bangsanpham implements Serializable {
    static Scanner input = new Scanner(System.in);
    private int IDsanpham;
    private String tensanpham;
    private double giasanpham;
    private int soLuongsanpham;
    private static ArrayList<Bangsanpham> dssp = new ArrayList<>();

    public Bangsanpham (int IDsanpham, String tensanpham, double giasanpham, int soLuongsanpham) {
        this.IDsanpham = IDsanpham;
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.soLuongsanpham = soLuongsanpham;
    }

    public int getID() {
        return IDsanpham;
    }

    public String getTen() {
        return tensanpham;
    }

    public double getGia() {
        return giasanpham;
    }

    public int getSoLuong() {
        return soLuongsanpham;
    }

    public void setID(int IDsanpham) {
        this.IDsanpham = IDsanpham;
    }

    public void setGia(double giasanpham) {
        this.giasanpham = giasanpham;
    }

    public void setSoLuong(int soLuongsanpham) {
        this.soLuongsanpham = soLuongsanpham;
    }

    public void setTen(String tensString) {
        this.tensanpham = tensanpham;
    }

    public static void Menusp () {
        System.out.println("Choose one feature listed below: \n" +
                "1. Add products \n" +
                "2. Display products \n" +
                "3. Delete a product \n" +
                "4. Edit a product \n" +
                "5. Search for products by name \n" +
                "6. Sort products by price \n" +
                "7. Save products to text file \n" +
                "8. Load products from the saved file \n" +
                "        \n");
    }

    public static int randomID () {
        int min = 100, max = 1000;
        int IDsanpham;
        IDsanpham = (int) (Math.random()*(max - min + 1) + min);
        return IDsanpham;
    }

    public static void themsp () {
        System.out.print("Enter the number of product you want to add: ");
        int num = input.nextInt();
        input.nextLine();

        for (int n=1; n<=num; n++) {
            System.out.println("Product " + n + ":");

            System.out.print("Enter Name:  ");
            String tensanpham = input.nextLine();

            System.out.print("Enter Price:  ");
            double giasanpham = Double.parseDouble(input.nextLine());

            System.out.print("Enter Quantity:  ");
            int soLuongsanpham = Integer.parseInt(input.nextLine());
            Bangsanpham sp = new Bangsanpham(randomID(), tensanpham, giasanpham, soLuongsanpham);
            dssp.add(sp);
        }
    }

    public static void hienThisp () {
        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Bangsanpham sp : dssp) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }

    }

    public static void xoasp () {
        System.out.print("Enter product ID: ");
        int inputID = input.nextInt();
        for (Bangsanpham sp : dssp) {
            if (sp.getID() == inputID) {
                dssp.remove(sp);
                break;
            }
        }
    }

    public static void editsp () {
        System.out.print("Enter product ID: ");
        int inputID = input.nextInt();
        input.nextLine();

        for (Bangsanpham sp : dssp) {
            if (sp.getID() == inputID) {
                System.out.print("Enter new name: ");
                String tenmoi = input.nextLine();

                System.out.print("Enter new price: ");
                double giamoi = input.nextDouble();

                System.out.print("Enter new quantity: ");
                int soLuongmoi = input.nextInt();

                sp.setTen(tenmoi);
                sp.setGia(giamoi);
                sp.setSoLuong(soLuongmoi);
                break;
            }
        }
    }

    public static void timKiemsp () {
        System.out.print("Enter key name: ");
        String keyName = input.nextLine();

        ArrayList<Bangsanpham> dsTimKiem = new ArrayList<>();
        for (Bangsanpham sp : dssp) {
            if (sp.getTen().contains(keyName)) {
                dsTimKiem.add(sp);
            }
        }

        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Bangsanpham sp : dsTimKiem) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }
    }

    public static void sapXepTheoGia () {

        ArrayList<Bangsanpham> danhSachSapXep = new ArrayList<>(dssp);

        Bangsanpham temp;
        for (int c=0; c< danhSachSapXep.size() - 1; c++) {
            for (int p=c+1; p< danhSachSapXep.size(); p++) {
                if (danhSachSapXep.get(c).getGia() > danhSachSapXep.get(p).getGia()) {
                    temp = danhSachSapXep.get(c);
                    danhSachSapXep.set(c, danhSachSapXep.get(p));
                    danhSachSapXep.set(c, temp);
                }
            }
        }

        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Bangsanpham sp : danhSachSapXep) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }
    }

    public static void luuSanPham () throws Exception {
        File f = new File("src/assignment02/Product s.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dssp);
    }

    public static void loadSanPham () throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/assignment02/Product s.txt"));
        ArrayList<Bangsanpham> danhSach;

        danhSach = (ArrayList<Bangsanpham>) ois.readObject();


        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Bangsanpham sp : danhSach) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            System.out.println();
        }
    }
}

public class assignment02 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int choice = 0;
        do {
            Bangsanpham.Menusp();
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: Bangsanpham.themsp();
                break;
                case 2: Bangsanpham.hienThisp();
                break;
                case 3: Bangsanpham.xoasp();
                break;
                case 4: Bangsanpham.editsp();
                break;
                case 5: Bangsanpham.timKiemsp();
                break;
                case 6: Bangsanpham.sapXepTheoGia();
                break;
                case 7: Bangsanpham.luuSanPham();
                break;
                case 8: Bangsanpham.loadSanPham();
                break;
                case 9: System.out.println("Good bye!!");
                break;
                default: System.out.println("Invalid choice !!");
            }
            }
            while (choice !=9);
            System.exit(0);
    }
}





