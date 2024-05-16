package koperasi;

import java.util.Scanner;

public class Main {
    private static Employee currentEmployee;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keluar = false;

        while (!keluar) {
            System.out.println("====================[Koperasi Karyawan]====================");
            System.out.println("Pilihan Program : ");
            System.out.println("1. Login");
            System.out.println("2. Belanja");
            System.out.println("3. Lihat Detail Belanja");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda\t: ");
            int pilih = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilih) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    if (currentEmployee == null){
                        System.out.println("Silahkan login terlebih dahulu.");
                        System.out.println();
                    }else {
                        belanja(scanner);
                    }
                    break;
                case 3:
                    if (currentEmployee == null){
                        System.out.println("Silahkan login terlebih dahulu.");
                        System.out.println();

                    }else {
                        lihatDetailBelanja();
                    }
                    break;
                case 4:
                    keluar = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
    }

    scanner.close();
    }

    private static void login(Scanner scanner){
        System.out.print("Masukkan nama Anda : ");
        String name = scanner.nextLine();
        System.out.print("Masukkan nomor registrasi pegawai(maks 10 digit) : ");
        int registrationNumber = scanner.nextInt();
        System.out.print("Masukkan jumlah gaji per bulan(maks 10 digit) : ");
        int salaryPerMonth = scanner.nextInt();
        scanner.nextLine();

        currentEmployee = new Employee(registrationNumber, name, salaryPerMonth);
        System.out.println("USERINFO: Successfully logged in!");
        System.out.println();
    
    }

    private static void belanja(Scanner scanner){
        boolean selesaiBelanja = false;

        while (!selesaiBelanja){
            System.out.println();
            System.out.println("====================[Koperasi Karyawan]====================");
            System.out.println("Daftar Produk : ");
            System.out.println("1. Air Mineral\t\t -- Rp 4,500.00");
            System.out.println("2. Tinta Spidol\t\t -- Rp 30,500.00");
            System.out.println("3. Buku Tulis\t\t -- Rp 5,000.00");
            System.out.println("4. Kabel Data\t\t -- Rp 30,000.00");
            System.out.println("5. Mouse Gaming\t\t -- Rp 800,000.00");
            System.out.println("6. Sandal Jepit\t\t -- Rp 790,000.00");
            System.out.println("7. Gaming Headset\t -- Rp 800,000.00");
            System.out.println("8. Keyboard laptop\t -- Rp 1,700,000.00");
            System.out.println("9. Selesai Belanja");
            System.out.print("Masukkan pilihan produk: ");
            int productpilih = scanner.nextInt();

            switch (productpilih) {
                case 1:
                    currentEmployee.addInvoice(new Invoice("Air Mineral", 1, 4500));
                    break;
                    case 2:
                    currentEmployee.addInvoice(new Invoice("Tinta Spidol", 1, 2500));
                    break;
                case 3:
                    currentEmployee.addInvoice(new Invoice("Buku Tulis", 1, 5000));
                    break;
                case 4:
                    currentEmployee.addInvoice(new Invoice("Kabel Data", 1, 30000));
                    break;
                case 5:
                    currentEmployee.addInvoice(new Invoice("Mouse Gaming", 1, 800000));
                    break;
                case 6:
                    currentEmployee.addInvoice(new Invoice("Sandal Jepit", 1, 790000));
                    break;
                case 7:
                    currentEmployee.addInvoice(new Invoice("Gaming Headset", 1, 800000));
                    break;
                case 8:
                    currentEmployee.addInvoice(new Invoice("Keyboard laptop", 1, 1700000));
                    break;
                case 9:
                    selesaiBelanja = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void lihatDetailBelanja(){
        System.out.println("====================[EMPLOYEE STATS]====================\n");
        System.out.println("Nama\t\t\t : " + currentEmployee.getName());
        System.out.println("Registration Number\t : " + currentEmployee.getRegistrationNumber());
        System.out.println("Gaji Awal\t\t : Rp " + String.format("%,d", currentEmployee.getSalaryPerMonth()));
        System.out.println();
        System.out.println("Detail Belanja : ");
        for (Invoice invoice : currentEmployee.getInvoices()) {
            System.out.println(invoice);
        }
        System.out.println("===========================================================");
        System.out.println("Total Belanja\t\t\tRp " + String.format("%,d", (int) currentEmployee.getTotalInvoicesAmount()));
        System.out.println("Gaji Akhir\t: Rp " + String.format("%,d", (int) currentEmployee.getPayableAmount()));
        System.out.println();
    }
}

