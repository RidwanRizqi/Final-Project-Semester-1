
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
    static int[] daftarKursi = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    static String[] riwayatPembeli = new String[100];
    static String[][] riwayatFilm = new String[20][100];
    static int[][] riwayatTiket = new int[2][100];
    static int[][] riwayatKursi = new int[20][100];
    static float[] riwayatTotal = new float[100];
    static String[] daftarDiskonMember = new String[100];
    static String[] nomorMember = {"mem01", "mem02", "mem03", "mem04"};
    static String[][] jam = new String[20][100];
    static String[][] tanggal = new String[20][100];
    static int nomorUrut = 0;
    static int i = 0;
    static int totalTiketDipesan = 0;

    public static void main(String[] args) {

            System.out.println("============================================");
            System.out.println("|  ========   Selamat datang   ==========  |");
            System.out.println("|  |            Di Bioskop              |  |");
            System.out.println("|  |              Ridwan                |  |");
            System.out.println("|  |====================================|  |");
            System.out.println("============================================");
            System.out.println();
            menu();
        }


    private static void menu() {
        int menu;
        String konfirmasi;
        boolean kondisi = true;
        while (kondisi) {
            System.out.println("============================================");
            System.out.println("|  ==============   MENU   ==============  |");
            System.out.println("|  | [1] Masuk Sebagai Pelanggan        |  |");
            System.out.println("|  | [2] Masuk Sebagai Pegawai          |  |");
            System.out.println("|  |====================================|  |");
            System.out.println("============================================");
            System.out.print("Silahkan memilih menu diatas dengan cara memasukkan angka 1/2 : ");
            menu = input.nextInt();
            System.out.println();
            switch (menu) {
                case 1 -> pelanggan();
                case 2 -> pegawai();
                default -> System.out.println("Masukkan yang anda masukkan salah!");
            }
            System.out.println("Apakah masih ada keperluan lain? (Ya/Tidak) : ");
            konfirmasi = input.next();
            if (konfirmasi.equalsIgnoreCase("Ya")) {
                kondisi = true;
            } else if (konfirmasi.equalsIgnoreCase("Tidak")) {
                kondisi = false;
            } else {
                System.out.println("Inputan yang anda masukkan salah! Program akan ditutup");
                kondisi = false;
            }
        }
    }
    private static void pelanggan() {
        boolean kondisi = true;
        String dialogKonfirmasiMenu;
        int menu;

        while (kondisi) {
            System.out.println("============================================");
            System.out.println("|  ==============   MENU   ==============  |");
            System.out.println("|  | [1] Pembelian Tiket                |  |");
            System.out.println("|  | [2] Daftar Film Minggu Ini         |  |");
            System.out.println("|  | [3] Kursi Yang Tersedia            |  |");
            System.out.println("|  | [4] Harga Tiket                    |  |");
            System.out.println("|  | [5] Daftar Sebagai Member          |  |");
            System.out.println("|  | [6] Kembali ke Menu Sebelumnya     |  |");
            System.out.println("|  |====================================|  |");
            System.out.println("============================================");
            System.out.print("Silahkan memilih menu diatas dengan cara memasukkan angka 1 sampai 6 : ");
            menu = input.nextInt();
            System.out.println();
            switch (menu) {
                case 1 -> pembelianTiket();
                case 2 -> daftarFilm();
                case 3 -> kursiReady();
                case 4 -> hargaTiket();
                case 5 -> daftarMember();
                case 6 -> menu();
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

    private static void pegawai() {
        int menu;
        System.out.println("============================================");
        System.out.println("|  ==============   MENU   ==============  |");
        System.out.println("|  | [1] Update Stock Tiket             |  |");
        System.out.println("|  | [2] Update Kursi Kosong            |  |");
        System.out.println("|  | [3] Update Film                    |  |");
        System.out.println("|  | [4] Riwayat Transaksi              |  |");
        System.out.println("|  | [5] Daftar Nomor Unik Member       |  |");
        System.out.println("|  | [6] Kembali ke Menu Sebelumnya     |  |");
        System.out.println("|  |====================================|  |");
        System.out.println("============================================");
        System.out.print("Silahkan memilih menu diatas dengan cara memasukkan angka 1 sampai 6 : ");
        menu = input.nextInt();
        System.out.println();
        switch (menu) {
            case 1 -> updateStockTiket();
            case 2 -> updateKursi();
            case 3 -> updateFilm();
            case 4 -> cetakRiwayat();
            case 5 -> daftarNomorMember();
            case 6 -> menu();
            default -> System.out.println("Mohon maaf input yang anda masukkan salah");
        }
    }

    private static void updateStockTiket() {
        daftarFilm();
        int[] index = new int[2];
        int value;
        System.out.print("Stock tiket film apa yang ingin diperbarui ? (masukkan angka 0 sampai 10) :");
        index[0] = input.nextInt();
        System.out.print("Tiket premium atau reguler ? (0 untuk premium/ 1 untuk reguler) :");
        index[1] = input.nextInt();
        System.out.print("Masukkan nilai yang ingin anda ganti : ");
        value = input.nextInt();
        stockTicket[index[1]][index[0] - 1] = value;
        daftarFilm();
    }

    private static void updateKursi() {
        kursiReady();
        for (int i = 0; i < daftarKursi.length; i++) {
            daftarKursi[i] = (i + 1);
        }
        kursiReady();
        System.out.println("Jumlah kursi sudah ready semua ");
    }

    private static void updateFilm() {
        daftarFilm();
        int index;
        String judulFilm;
        System.out.print("Pilih film yang ingin diganti : (angka 1 sampai 10) : ");
        index = input.nextInt() - 1;
        System.out.print("Masukkan judul film yang baru : ");
        judulFilm = input.next();
        daftarFilm[index] = judulFilm;
        daftarFilm();
    }

    private static void daftarNomorMember() {

    }

    private static void pembelianTiket(){
        String nama, member, jenisTiket, konfirmasiPesanLagi;
        int tanggalDiPesan, jamDiPesan;
        int[] filmDiPesan = new int[10];
        int[][] tiketDiPesan = new int[2][10];
        int[][] kursiDiPesan = new int[20][20];
        float diskonMember = 0, total = 0;
        boolean kondisi = true;
        int[] counter = new  int[20];
        float totalAkhir;

        System.out.println("============================================");
        System.out.println("|============  Pembelian Tiket  ===========|");
        System.out.println("============================================");
        System.out.print("Masukkan nama anda : ");
        nama = input.next();
        System.out.print("Selamat datang " + nama + " ,apakah anda memiliki kartu member bioskop kami? (Ya/Tidak) : ");
        member = input.next();
        if (member.equalsIgnoreCase("Ya")) {
            diskonMember = 0.2f;
            daftarDiskonMember[nomorUrut] = "20%";
        } else if (member.equalsIgnoreCase("Tidak")) {
            diskonMember = 0;
            daftarDiskonMember[nomorUrut] = "0%";
        } else {
            System.out.println("Masukkan yang anda masukkan salah! silahkan mengulang proses pembelian tiket!");
            pembelianTiket();
        }
        System.out.println();



        while (kondisi) {
            daftarTanggal();
            System.out.print("Masukkan tanggal untuk menonton film (masukkan angka 1 sampai 7) : ");
            tanggalDiPesan = input.nextInt();
            switch (tanggalDiPesan) {
                case 1 -> tanggal[i][nomorUrut] = "01-06-2021";
                case 2 -> tanggal[i][nomorUrut] = "02-06-2021";
                case 3 -> tanggal[i][nomorUrut] = "03-06-2021";
                case 4 -> tanggal[i][nomorUrut] = "04-06-2021";
                case 5 -> tanggal[i][nomorUrut] = "05-06-2021";
                case 6 -> tanggal[i][nomorUrut] = "06-06-2021";
                case 7 -> tanggal[i][nomorUrut] = "07-06-2021";
                default -> {
                    System.out.println("Masukkan yang anda masukkan salah! silahkan ulangi!");
                    pembelianTiket();
                }
            }

            daftarJam();
            System.out.print("Masukkan jam untuk menonton film (masukkan angka 1 sampai 3) : ");
            jamDiPesan = input.nextInt();
            switch (jamDiPesan) {
                case 1 -> jam[i][nomorUrut] = "09.00";
                case 2 -> jam[i][nomorUrut] = "12.00";
                case 3 -> jam[i][nomorUrut] = "15.00";
                default -> {
                    System.out.println("Masukkan yang anda masukkan salah! silahkan ulangi!");
                    pembelianTiket();
                }
            }
            System.out.println();
            daftarFilm();
            System.out.print("Masukkan film yang ingin anda tonton sesuai dengan nomor nya 1 sampai 10 : ");
            filmDiPesan[i] = input.nextInt() - 1;

            hargaTiket();
            System.out.println("Tiket jenis apa yang ingin anda beli ? (premium/reguler) :");
            jenisTiket = input.next();

            if (jenisTiket.equalsIgnoreCase("premium")) {
                System.out.println("Masukkan jumlah tiket premium yang ingin anda pesan untuk film " + daftarFilm[filmDiPesan[i]] + " :");
                tiketDiPesan[0][i] = input.nextInt();
                stockTicket[0][i] -=  tiketDiPesan[0][i];
            } else if (jenisTiket.equalsIgnoreCase("reguler")) {
                System.out.println("Masukkan jumlah tiket reguler yang ingin anda pesan untuk film " + daftarFilm[filmDiPesan[i]] + " :");
                tiketDiPesan[1][i] = input.nextInt();
                stockTicket[1][i] -= tiketDiPesan[1][i];
            } else {
                System.out.println("Masukkan yang anda masukkan salah! silahkan mengulangi proses dari awal!");
                pembelianTiket();
            }

            counter[i] = tiketDiPesan[0][i] + tiketDiPesan[1][i];
            totalTiketDipesan += tiketDiPesan[0][i] + tiketDiPesan[1][i];

            kursiReady();
            System.out.println("Di atas adalah daftar kursi kita yang ready ");
            for (int j = 0; j < counter[i]; j++) {
                System.out.println("Silahkan masukkan nomor kursi untuk memesan kursis tiket ke " + (j+1) + " : ");
                kursiDiPesan[i][j] = input.nextInt();
                for (int k = 0; k < daftarKursi.length; k++) {
                    if (daftarKursi[k] == kursiDiPesan[i][j]) {
                        daftarKursi[k] = 0;
                    }
                }
                riwayatKursi[j][nomorUrut] = kursiDiPesan[i][j]; // ini masih ngebug
            }

            System.out.println("Apakah anda ingin memesan tiket lagi ? (Ya/Tidak) :");
            konfirmasiPesanLagi = input.next();
            if (konfirmasiPesanLagi.equalsIgnoreCase("Ya")) {
                i++;
            } else if (konfirmasiPesanLagi.equalsIgnoreCase("Tidak")) {
                kondisi = false;
            } else {
                System.out.println("Inputan yang anda masukkan salah silahkan mengulang dari awal !");
            }
        }
        for (int j = 0; j < (i + 1); j++) {
            total += (tiketDiPesan[0][j] * 75_000);
            total += (tiketDiPesan[1][j] * 50_000);
        }
        riwayatTotal[nomorUrut] = total;
        System.out.println();
        System.out.println("Berikut adalah rincian pembayaran yang harus dibayarkan : ");
        System.out.println("=========================================================");
        System.out.println("Nama : " + nama);

        for (int j = 0; j < (i + 1); j++){
            System.out.println("Judul Film : " + daftarFilm[filmDiPesan[j]]);
            System.out.println("Jam : " + jam[j][nomorUrut]);
            System.out.println("Tanggal : " + tanggal[j][nomorUrut]);
            if (tiketDiPesan[0][j] != 0) {
                System.out.println(tiketDiPesan[0][j] + " tiket premium");
                riwayatTiket[0][nomorUrut] += tiketDiPesan[0][j];
            }
            if (tiketDiPesan[1][j] != 0) {
                System.out.println(tiketDiPesan[1][j] + " tiket reguler");
                riwayatTiket[1][nomorUrut] += tiketDiPesan[1][j];
            }
            System.out.print("Nomor kursi : ");
            for (int k = 0; k < counter[i]; k++) {
                if (kursiDiPesan[j][k] != 0) {
                    System.out.print(kursiDiPesan[j][k] + ", ");
                }
            }
            System.out.println();
            System.out.println("=========================================================");
        }
        totalAkhir = total - (total * diskonMember);
        System.out.println("Diskon member sebesar " + diskonMember);
        System.out.println("Diskon = " + total * diskonMember);
        System.out.println("=========================================================");
        System.out.println("Total : " + totalAkhir);
        System.out.println("=========================================================");
        pembayaran(totalAkhir);
        // rekap
        riwayatPembeli[nomorUrut] = nama;
        for (int j = 0; j < (i + 1); j++) {
            riwayatFilm[j][nomorUrut] = daftarFilm[filmDiPesan[j]];
        }
        nomorUrut++;
    }

    private static void daftarJam() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("|========  Daftar Jam Tayang Film  ========|");
        System.out.println("============================================");
        System.out.println("| [1] 09.00                                |");
        System.out.println("| [2] 12.00                                |");
        System.out.println("| [3] 15.00                                |");
        System.out.println("============================================");
    }

    private static void daftarTanggal() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("|======  Daftar Tanggal Tayang Film  ======|");
        System.out.println("============================================");
        System.out.println("| [1] 01-06-2021                           |");
        System.out.println("| [2] 02-06-2021                           |");
        System.out.println("| [3] 03-06-2021                           |");
        System.out.println("| [4] 04-06-2021                           |");
        System.out.println("| [5] 05-06-2021                           |");
        System.out.println("| [6] 06-06-2021                           |");
        System.out.println("| [7] 07-06-2021                           |");
        System.out.println("============================================");
    }

    private static void daftarFilm(){
        System.out.println();
        System.out.println("============================================");
        System.out.println("|========  Daftar Film Minggu Ini  ========|");
        System.out.println("============================================");
        for (int i = 0; i < daftarFilm.length; i++){
            System.out.println("[" + (i + 1) + "]" + " " + daftarFilm[i]);
            System.out.println("    Stock tiket premium = " + stockTicket[0][i]);
            System.out.println("    Stock tiket reguler = " + stockTicket[1][i]);
        }
    }

    private static void kursiReady(){
        System.out.println();
        System.out.println("============================================");
        System.out.println("|==========  Kursi Yang Tersedia  =========|");
        System.out.println("============================================");
        for (int i = 0; i < daftarKursi.length; i++) {
            if (i%4 == 0 && i != 0) {
                System.out.println();
            }
            if (daftarKursi[i] != 0) {
                System.out.print(daftarKursi[i] + "\t");
            }
        }
        System.out.println();
    }

    private static void hargaTiket(){
        System.out.println();
        System.out.println("============================================");
        System.out.println("|=============  Harga Tiket   ==============|");
        System.out.println("============================================");
        System.out.println("Premium = Rp 75.000");
        System.out.println("Reguler = Rp 50.000");
        System.out.println();
    }

    private static void daftarMember(){
        System.out.println("============================================");
        System.out.println("|=========  Daftar Sebagai Member  ========|");
        System.out.println("============================================");
        System.out.print("Masukkan Nama Anda : ");
        String  nama = input.next();


    }

    private static void cetakRiwayat() {
        System.out.println("============================================");
        System.out.println("============  Riwayat Transaksi  ===========");
        System.out.println("============================================");
        System.out.println("============================================");
        for (int j = 0; j < nomorUrut; j++) {
            System.out.println("========  Transaksi ke " + (j+1) + "  ========");
            System.out.println("Nama : " + riwayatPembeli[j]);
            for (int k = 0; k < tanggal.length; k++) {
                if (tanggal[k][j] != null && jam[k][j] != null) {
                    System.out.println("Tanggal : " + tanggal[k][j]);
                    System.out.println("Jam : " + jam[k][j]);
                }
                if (riwayatFilm[k][j] != null) {
                    System.out.println("Judul Film :");
                    System.out.println(riwayatFilm[k][j]);
                    System.out.println();
                }
            }
            System.out.println("Tiket : ");
            System.out.println(riwayatTiket[0][j] + " tiket premium");
            System.out.println(riwayatTiket[1][j] + " tiket reguler");
            System.out.println("Nomor kursi : ");
            for (int k = 0; k < totalTiketDipesan; k++) {
                if (riwayatKursi[k][j] != 0) {
                    System.out.print(riwayatKursi[k][j] + ", ");
                }
            }
            System.out.println();
            System.out.println("Diskon member : " + daftarDiskonMember[j]);
            System.out.println("Total : " + riwayatTotal[j]);
            System.out.println("============================================");
            System.out.println();
        }
    }

    private static void pembayaran(float total) {
        int uang;
        System.out.print("Masukkan nominal uang anda : Rp.");
        uang = input.nextInt();
        if (total - uang == 0) {
            System.out.println("Kembalian = Rp.0");
            System.out.println("==========Terimakasih atas kunjungannya==========");
        } else if (total - uang > 0) {
            System.out.println("Uang anda masih kurang sebesar Rp." + (total - uang));
            System.out.println("Silahkan mengulangi pembayaran");
            pembayaran(total);
        } else  {
            System.out.println("Kembalian = Rp." + (uang - total));
            System.out.println("==========Terimakasih atas kunjungannya==========");
        }
    }
}
