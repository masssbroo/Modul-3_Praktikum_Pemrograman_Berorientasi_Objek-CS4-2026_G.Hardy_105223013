import java.util.Scanner;

public class SimulasiATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double saldo = 500000;
        int pilihan;

        System.out.println("=== Selamat Datang di Simulasi ATM ===");
        do {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("-> Saldo Anda saat ini: Rp " + saldo);
                    break;
                    
                case 2:
                    System.out.print("-> Masukkan jumlah setor tunai: Rp ");
                    double setor = input.nextDouble();
                    if (setor > 0) {
                        saldo += setor;
                        System.out.println("Setor tunai berhasil! Saldo Anda sekarang: Rp " + saldo);
                    } else {
                        System.out.println("Jumlah setor tidak valid.");
                    }
                    break;
                    
                case 3:
                    System.out.print("-> Masukkan jumlah tarik tunai: Rp ");
                    double tarik = input.nextDouble();
                    if ((saldo - tarik) < 50000) {
                        System.out.println("Peringatan: Penarikan dibatalkan! Sisa saldo minimal setelah penarikan adalah Rp 50.000.");
                    } else if (tarik <= 0) {
                        System.out.println("Jumlah penarikan tidak valid.");
                    } else {
                        saldo -= tarik;
                        System.out.println("Tarik tunai berhasil! Sisa saldo Anda: Rp " + saldo);
                    }
                    break;
                    
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan ATM kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            
        } while (pilihan != 4);
        input.close();
    }
}