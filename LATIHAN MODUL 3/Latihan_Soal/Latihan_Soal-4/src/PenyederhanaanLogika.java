public class PenyederhanaanLogika {
    public static void main(String[] args) {
        double nilaiUjian = 80;
        double persentaseAbsensi = 85;

        String status = (nilaiUjian >= 75 && persentaseAbsensi > 80) ? "Lulus" : "Tidak Lulus";
        System.out.println("Nilai Ujian Akhir: " + nilaiUjian);
        System.out.println("Persentase Absensi: " + persentaseAbsensi + "%");
        System.out.println("Status: " + status);
    }
}