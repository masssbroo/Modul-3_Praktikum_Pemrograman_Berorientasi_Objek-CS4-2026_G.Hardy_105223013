    import java.util.Scanner;

    public class KelayakanDonorDarah {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.println("=== PROGRAM CEK KELAYAKAN DONOR DARAH ===");

            System.out.print("Masukkan Usia Anda (tahun): ");
            int usia = input.nextInt();

            System.out.print("Masukkan Berat Badan Anda (kg): ");
            float beratBadan = input.nextFloat();

            System.out.print("Masukkan Kadar Hemoglobin Anda (g/dL): ");
            float hemoglobin = input.nextFloat();

            System.out.println("\n--- Hasil Evaluasi ---");

            if (usia >= 17) {
                
                if (beratBadan >= 45.0f) {
                    
                    if (hemoglobin >= 12.5f && hemoglobin <= 17.0f) {
                        System.out.println("Status: DITERIMA.");
                        System.out.println("Selamat! Anda memenuhi semua kriteria kelayakan untuk menjadi donor darah.");
                    } else {
                        System.out.println("Status: DITOLAK.");
                        System.out.println("Alasan: Kadar hemoglobin Anda (" + hemoglobin + " g/dL) di luar batas aman (12.5 - 17.0 g/dL).");
                    }
                    
                } else {
                    System.out.println("Status: DITOLAK.");
                    System.out.println("Alasan: Berat badan Anda (" + beratBadan + " kg) kurang dari batas minimal (45 kg).");
                }
                
            } else {
                System.out.println("Status: DITOLAK.");
                System.out.println("Alasan: Usia Anda (" + usia + " tahun) belum memenuhi syarat minimal (17 tahun).");
            }

            input.close();
        }
    }