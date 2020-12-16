
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Name: Hoa Dục Lâm
 * Class: 1TĐ19
 * ID student: 1901060022
 * Email: hoa.lam201@gmail.com
 */
/**
 *
 * @author DELL
 */
public class Assignment2 {

    final private int ID;
    final private String Name;
    final private double Price;
    final private int Quan;

    Assignment2(BufferedReader in) throws IOException {
        System.out.print("Input product ID: ");
        this.ID = Integer.parseInt(in.readLine());
        System.out.print("Input product name: ");
        this.Name = in.readLine();
        System.out.print("Input product price: ");
        this.Price = Double.parseDouble(in.readLine());
        System.out.print("Input product quantity:");
        this.Quan = Integer.parseInt(in.readLine());
    }

    Assignment2(String a) {
        String[] string = a.split(", ");
        this.ID = Integer.parseInt(string[0]);
        this.Name = string[1];
        this.Price = Double.parseDouble(string[2]);
        this.Quan = Integer.parseInt(string[3]);
    }

    public int getid() {
        return ID;
    }

    public String getname() {
        return Name;
    }

    public double getprice() {
        return Price;
    }

    public int getquan() {
        return Quan;
    }

    public void view() {
        System.out.println(ID + "\t" + Name + "\t\t" + Price + "\t\t" + Quan);
    }

    public static int readfile(Assignment2[] prosArr, int total) {
        try {
            File f = new File("pros.txt");
            if (f.exists()) {
                Scanner filescan = new Scanner(f);
                int i = 0;
                while (filescan.hasNextLine()) {
                    prosArr[i++] = new Assignment2(filescan.nextLine());
                }
                total = i;
                System.out.println("Read successfully");
                System.out.println();
                filescan.close();
            } else {
                System.out.println("The file doesn't exist");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return total;
    }

    private static void writefile(Assignment2[] prosArr, int total) {
        try {
            BufferedWriter writefile = new BufferedWriter(new FileWriter("pros.txt"));
            for (int i = 0; i < total; ++i) {
                writefile.write(prosArr[i].getid() + ", " + prosArr[i].getname() + ", " + prosArr[i].getprice() + ", " + prosArr[i].getquan() + "\n");
            }
            writefile.close();
            System.out.println("Write successfully");
            System.out.println();
            writefile.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private static int input(Assignment2[] pros, BufferedReader input, int total) throws IOException {
        int newadd;
        System.out.print("The total is: ");
        newadd = Integer.parseInt(input.readLine());
        for (int i = total; i < total + newadd; ++i) {
            pros[i] = new Assignment2(input);
        }
        total += newadd;
        return total;
    }

    private static void search(Assignment2[] pros, BufferedReader input, int totalproduct) throws IOException {
        System.out.print("Input product name: ");
        boolean ck = false;
        String Name = input.readLine();
        for (int i = 0; i < totalproduct; ++i) {
            if (pros[i].getname().equals(Name)) {
                ck = true;
                pros[i].view();
                break;
            }
            if (!ck) {
                System.out.println("Can't find the product");
            }
            System.out.println();
        }
    }

    private static int delete(Assignment2[] pros, BufferedReader input, int total) throws IOException {
        System.out.print("Input product ID: ");
        int ID;
        boolean find = false;
        ID = Integer.parseInt(input.readLine());
        for (int i = 0; i < total; ++i) {
            if (pros[i].getid() == ID) {
                --total;
                find = true;
                if (total - i >= 0) {
                    System.arraycopy(pros, i + 1, pros, i, total - i);
                }
                System.out.println("The product has been deleted");
                break;
            }
        }
        if (!find) {
            System.out.println("Can't find the product");
        }
        System.out.println();
        return total;
    }

    private static void showall(Assignment2[] pros, int total) {
        for (int i = 0; i < total; ++i) {
            pros[i].view();
        }
        System.out.println();
    }

    private static void edit(Assignment2[] pros, BufferedReader input, int total) throws IOException {
        System.out.println("Input product ID: ");
        int ID = Integer.parseInt(input.readLine());
        for (int i = 0; i < total; ++i) {
            if (pros[i].getid() == ID) {
                pros[i] = new Assignment2(input);
                System.out.println("The product is edited!");
                break;
            }
        }
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        Assignment2[] prosArr = new Assignment2[30];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //Declare variable
        int w = 0;
        int total = 0;

        do {
            System.out.println("[1] Add products");
            System.out.println("[2] Display products");
            System.out.println("[3] Delete a product");
            System.out.println("[4] Edit the product");
            System.out.println("[5] Search for products by name");
            System.out.println("[6] Save products to text file");
            System.out.println("[7] Load products from the saved file");
            System.out.println("[8] Exit the program");
            System.out.print("Choose an option: ");   //Display the menu

            try {  // use try ... catch to detect and handle the error
                w = Integer.parseInt(input.readLine());
                System.out.println();
                switch (w) {
                    case 1:
                        total = input(prosArr, input, total);
                        break;
                    case 2:
                        showall(prosArr, total);
                        break;
                    case 3:
                        total = delete(prosArr, input, total);
                        break;
                    case 4:
                        edit(prosArr, input, total);
                        break;
                    case 5:
                        search(prosArr, input, total);
                        break;
                    case 6:
                        writefile(prosArr, total);
                        break;
                    case 7:
                        total = readfile(prosArr, total);
                        break;
                    default:
                        System.out.println("Invalid input");
                        System.out.println("User must input again");
                        break;
                    case 8:
                        System.out.println("Goodbye!");
                }
            } catch (InputMismatchException | NumberFormatException | IOException ex) {
                System.out.println("Invalid input");
                ex.printStackTrace();
            }
        } while (w != 8);
        input.close();
    }
}
