import java.util.Scanner;
public class KioskSoundFest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stockVIP = 5;
        int stockFestival = 25;
        int stockTribune = 35;
        
        final int hargaVIP = 1500000;
        final int hargaFestival = 800000;
        final int hargaTribune = 500000;
        
        final int minUsiaVIP = 18;
        final int minUsiaFestival = 15;
        final int minUsiaTribune = 0;

        while (true) {
            System.out.println("\n=============================================");
            System.out.println("  KIOSK TIKET UNIVERSITAS PERTAMINA SOUNDFEST 2026  ");
            System.out.println("=============================================");
            System.out.println("Sisa Stok Tiket: VIP (" + stockVIP + "), Festival (" + stockFestival + "), Tribune (" + stockTribune + ")");
            System.out.println("1.VIP       - Rp 1.500.000");
            System.out.println("2.Festival  - Rp 800.000");
            System.out.println("3.Tribune   - Rp 500.000");
            System.out.println("4.Matikan Mesin");
            System.out.print("Pilih menu (1-4): ");
            
            int pilihan = scanner.nextInt();
            
            if (pilihan == 4) {
                System.out.println("Mematikan mesin Kiosk... Sampai jumpa!");
                break;
            }
            
            if (pilihan < 1 || pilihan > 4) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue;
            }

            System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
            int jumlahTiket = scanner.nextInt();

            int stokSaatIni = 0;
            int hargaSaatIni = 0;
            int minUsiaSaatIni = 0;
            String namaKategori = "";

            if (pilihan == 1) {
                stokSaatIni = stockVIP; hargaSaatIni = hargaVIP; minUsiaSaatIni = minUsiaVIP; namaKategori = "VIP";
            } else if (pilihan == 2) {
                stokSaatIni = stockFestival; hargaSaatIni = hargaFestival; minUsiaSaatIni = minUsiaFestival; namaKategori = "Festival";
            } else if (pilihan == 3) {
                stokSaatIni = stockTribune; hargaSaatIni = hargaTribune; minUsiaSaatIni = minUsiaTribune; namaKategori = "Tribune";
            }

            if (jumlahTiket > stokSaatIni) {
                System.out.println("\n[ERROR] Maaf, stok tidak mencukupi. Sisa stok " + namaKategori + " hanya " + stokSaatIni + ".");
                continue;
            }

            int tiketBerhasil = 0;
            int totalTagihan = 0;
            boolean batalDarurat = false;

            System.out.println("\n--- Pengisian Data Usia ---");
            for (int i = 1; i <= jumlahTiket; i++) {
                int usia = 0;
                
                while (true) {
                    System.out.print("Masukkan usia untuk Tiket ke-" + i + " (ketik -1 untuk batal): ");
                    usia = scanner.nextInt();

                    if (usia == -1) {
                        batalDarurat = true;
                        break; 
                    }

                    if (usia <= 0 || usia > 100) {
                        System.out.println("Usia tidak logis. Silakan masukkan kembali.");
                    } else {
                        break;
                    }
                }

                if (batalDarurat) {
                    System.out.println("\n[BATAL DARURAT] Proses dihentikan paksa. Kembali ke Menu Utama.");
                    break;
                }

                if (usia >= minUsiaSaatIni) {
                    System.out.println("Verifikasi sukses untuk Tiket ke-" + i + ".");
                    tiketBerhasil++;
                    totalTagihan += hargaSaatIni;
                    
                    if (pilihan == 1) stockVIP--;
                    else if (pilihan == 2) stockFestival--;
                    else if (pilihan == 3) stockTribune--;
                    
                } else {
                    System.out.println("[GAGAL] Tiket ke-" + i + " ditolak. Syarat usia " + namaKategori + " minimal " + minUsiaSaatIni + " tahun.");
                }
            }

            if (!batalDarurat || tiketBerhasil > 0) {
                System.out.println("\n--- NOTA AKHIR ---");
                System.out.println("Dari " + jumlahTiket + " tiket yang coba dibeli, hanya " + tiketBerhasil + " tiket " + namaKategori + " yang berhasil diproses");
                System.out.println("Total tagihan: Rp " + totalTagihan);
            }
        }
        scanner.close();
    }
}