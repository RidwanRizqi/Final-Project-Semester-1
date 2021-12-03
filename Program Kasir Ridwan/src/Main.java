import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String[] daftarFilm = {
            "Silent Night",
            "Spider-Man: No Way Home",
            "The Matrix Resurrections",
            "The King's Man",
            "F9 The Fast Saga",
            "Captain Marvel",
            "Thor: The Dark World",
            "Black Widow",
            "Zack Snyder’s Justice League",
            "No Time To Die"
    };
    static int[][] stockTicket = {
            {10,10,10,10,10,10,10,10,10,10},     // tiket premium
            {10,10,10,10,10,10,10,10,10,10}};    // tiket reguler
    public static void main(String[] args) {
        boolean kondisi = true;
        String dialogKonfirmasiMenu;
        int menu;

        System.out.println("============================================");
        System.out.println("|=====  Program Kasir Bioskop Ridwan  =====|");
        System.out.println("============================================");
        System.out.println();
        while (kondisi) {
            System.out.println("============================================");
            System.out.println("|  ==============   MENU   ==============  |");
            System.out.println("|  | [1] Pembelian Tiket                |  |");
            System.out.println("|  | [2] Daftar Film Minggu Ini         |  |");
            System.out.println("|  | [3] Kursi Yang Tersedia            |  |");
            System.out.println("|  | [4] Harga Tiket                    |  |");
            System.out.println("|  | [5] Daftar Sebagai Member          |  |");
            System.out.println("|  |====================================|  |");
            System.out.println("============================================");
            System.out.print("Silahkan memilih menu diatas dengan cara memasukkan angka 1 sampai 5 : ");
            menu = input.nextInt();
            switch (menu) {
                case 1 -> pembelianTiket();
                case 2 -> daftarFilm();
                case 3 -> kursiReady();
                case 4 -> hargaTiket();
                case 5 -> daftarMember();
                default -> System.out.println("Mohon maaf input yang anda masukkan salah");
            }
            System.out.print("Apakah masih ada transaksi lain? (Ya/Tidak) : ");
            dialogKonfirmasiMenu = input.next();
            if (dialogKonfirmasiMenu.equalsIgnoreCase("Ya")) {
                kondisi = true;
            } else if (dialogKonfirmasiMenu.equalsIgnoreCase("Tidak")) {
                kondisi = false;
            } else {
                System.out.println("Masukkan yang anda masukkan salah! program akan di tutup");
                kondisi = false;
            }
            System.out.println();
        }
    }

    private static void pembelianTiket(){
        String nama, member, jenisTiket;
        int[] filmDiPesan = new int[10];
        int[][] tiketDiPesan = new int[2][10];
        float diskonMember;
        boolean kondisi = true;
        int i = 0;

        System.out.println("============================================");
        System.out.println("|============  Pembelian Tiket  ===========|");
        System.out.println("============================================");
        System.out.println();
        System.out.print("Masukkan nama anda : ");
        nama = input.next();
        System.out.print("Selamat datang " + nama + " ,apakah anda memiliki kartu member bioskop kami? (Ya/Tidak) : ");
        member = input.next();
        if (member.equalsIgnoreCase("Ya")) {
            diskonMember = 0.2f;
        } else if (member.equalsIgnoreCase("Tidak")) {
            diskonMember = 0;
        } else {
            System.out.println("Masukkan yang anda masukkan salah! silahkan mengulang proses pembelian tiket!");
            pembelianTiket();
        }
        daftarFilm();
        while (kondisi) {
            System.out.print("Masukkan film yang ingin anda tonton sesuai dengan nomor nya 1 sampai 10 : ");
            filmDiPesan[i] = input.nextInt() - 1;
            System.out.println("Tersedia " + stockTicket[0][i] + " tiket premium dan " + stockTicket[1][i] + " tiket reguler untuk film " + daftarFilm[filmDiPesan[i]]);
            System.out.println("Tiket jenis apa yang ingin anda beli ? (premium/reguler) :");
            jenisTiket = input.next();
            if (jenisTiket.equalsIgnoreCase("premium")) {
                System.out.println("Masukkan jumlah tiket premium yang ingin anda pesan untuk film " + daftarFilm[filmDiPesan[i]] + " :");
                tiketDiPesan[0][i] = input.nextInt();
            } else if (jenisTiket.equalsIgnoreCase("reguler")) {
                System.out.println("Masukkan jumlah tiket reguler yang ingin anda pesan untuk film " + daftarFilm[filmDiPesan[i]] + " :");
                tiketDiPesan[1][i] = input.nextInt();
            } else {
                System.out.println("Masukkan yang anda masukkan salah! silahkan mengulangi proses dari awal!");
                pembelianTiket();
            }
        }

    }

    private static void daftarFilm(){
        System.out.println("============================================");
        System.out.println("|========  Daftar Film Minggu Ini  ========|");
        System.out.println("============================================");
        for (int i = 0; i < daftarFilm.length; i++){
            System.out.println((i + 1) + " " + daftarFilm[i]);
        }
    }

    private static void kursiReady(){
        System.out.println("============================================");
        System.out.println("|==========  Kursi Yang Tersedia  =========|");
        System.out.println("============================================");
    }

    private static void hargaTiket(){
        System.out.println("============================================");
        System.out.println("|=====  Program Kasir Bioskop Ridwan  =====|");
        System.out.println("============================================");
        System.out.println("[1] Premium = Rp 75.000");
        System.out.println("[2] Reguler = Rp 50.000");
    }

    private static void daftarMember(){
        System.out.println("============================================");
        System.out.println("|=========  Daftar Sebagai Member  ========|");
        System.out.println("============================================");
    }
}
