import java.util.Scanner;

public class ValidasiPIN{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pinBenar = "987654";
        int percobaan = 0;
        int batasPercobaan = 3;
        boolean berhasilLogin = false;

        while (percobaan < batasPercobaan) {
            System.out.print("Masukkan PIN Anda: ");
            String pinInput = input.next();
            percobaan++;

            if (pinInput.equals(pinBenar)) {
                System.out.println("Login berhasil!");
                berhasilLogin = true;
                break;
            } else {
                System.out.println("PIN salah. Sisa percobaan: " + (batasPercobaan - percobaan));
            }
        }

        if (!berhasilLogin) {
            System.out.println("Akun diblokir.");
        }
        
        input.close();
    }
}