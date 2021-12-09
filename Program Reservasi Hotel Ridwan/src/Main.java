import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String[] jenisKamarHotel = {
            "Standard Room",
            "Deluxe Room",
            "Suite Room" ,
            "President Room"

    };
    static int[] hargaKamarHotel = {
            200_000,
            250_000,
            300_000,
            350_000
    };
    static int[] counterRiwayat = new int[100];
    static String[] riwayatPemesan = new String[100];
    static String[][] riwayatJenisKamar = new String[40][100];
    static int[][] riwayatNomorKamar = new int[40][100];
    static int[][] riwayatLamaMenginap = new int[40][100];
    static String[] riwayatDiskonMember = new String[100];
    static String[] riwayatTanggal = new String[100];
    static int[][] riwayatHarga = new int[40][100];
    static float[] riwayatTotal = new float[100];
    static int nomorUrut;
    static int[] counter = {0};
    static int[][] kamarReady = {
            {1,2,3,4,5,6,7,8,9,10},
            {1,2,3,4,5,6,7,8,9,10},
            {1,2,3,4,5,6,7,8,9,10},
            {1,2,3,4,5,6,7,8,9,10},
    };


    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("=============  Selamat datang  =============");
        System.out.println("|| |      _____   Di Hotel   _____      | ||");
        System.out.println("|| | _____|___|    Ridwan    |___|_____ | ||");
        System.out.println("|| | |    |   |              |   |    | | ||");
        System.out.println("|| | |____|___|==============|___|____| | ||");
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
            System.out.println("|| ==============   MENU   ============== ||");
            System.out.println("|| | [1] Masuk Sebagai Pelanggan        | ||");
            System.out.println("|| | [2] Masuk Sebagai Pegawai          | ||");
            System.out.println("|| |====================================| ||");
            System.out.println("============================================");
            System.out.print("Silahkan memilih menu diatas dengan cara memasukkan angka 1/2 : ");
            menu = input.nextInt();
            System.out.println();
            switch (menu) {
                case 1 -> pembeli();
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

    private static void pembeli () {
        boolean kondisi = true;
        String dialogKonfirmasiMenu;
        int menu;

        while (kondisi) {
            System.out.println("============================================");
            System.out.println("|| ==============   MENU   ============== ||");
            System.out.println("|| | [1] Pemesanan Tiket Hotel          | ||");
            System.out.println("|| | [2] Daftar Jenis Kamar Hotel       | ||");
            System.out.println("|| | [3] Nomor Kamar Yang Tersedia      | ||");
            System.out.println("|| | [4] Kembali ke Menu Sebelumnya     | ||");
            System.out.println("|| |====================================| ||");
            System.out.println("============================================");
            System.out.print("Silahkan memilih menu diatas dengan cara memasukkan angka 1 sampai 4 : ");
            menu = input.nextInt();
            System.out.println();
            switch (menu) {
                case 1 -> pemesananTiket();
                case 2 -> daftarJenisKamar();
                case 3 -> daftarKamarReady();
                case 4 -> menu();
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

    private static void pemesananTiket() {
        String nama, member;
        boolean kondisi = true;
        int[] jenisKamardiPesan = new int[40];
        int[] nomorKamardiPesan = new int[40];
        int[] lamaMenginap = new int[40];
        String konfirmasiPesanLagi, tanggal;
        float diskonMember = 0, total = 0;

        System.out.println("============================================");
        System.out.println("|============  Pemesanan Tiket  ===========|");
        System.out.println("============================================");
        System.out.print("Masukkan nama : ");
        nama = input.next();
        riwayatPemesan[nomorUrut] = nama;
        System.out.print("Masukkan tanggal (contoh 12-06-2021) : ");
        tanggal = input.next();
        riwayatTanggal[nomorUrut] = tanggal;
        System.out.print("Selamat datang " + nama + " ,apakah anda memiliki kartu member hotel kami? (Ya/Tidak) : ");
        member = input.next();
        if (member.equalsIgnoreCase("Ya")) {
            diskonMember = 0.2f;
            riwayatDiskonMember[nomorUrut] = "20%";
        } else if (member.equalsIgnoreCase("Tidak")) {
            diskonMember = 0;
            riwayatDiskonMember[nomorUrut] = "0%";
        } else {
            System.out.println("Masukkan yang anda masukkan salah! silahkan mengulang proses pembelian tiket!");
            pemesananTiket();
        }

        while (kondisi) {
            System.out.println();
            daftarJenisKamar();
            System.out.println();
            System.out.println("Diatas adalah daftar jenis dan harga kamar kami");
            System.out.println("Silahkan memilih jenis kamar yang anda inginkan dengan mamasukkan angka 1 sampai 4");
            jenisKamardiPesan[counter[0]] = input.nextInt() -1;
            riwayatJenisKamar[counter[0]][nomorUrut] = jenisKamarHotel[jenisKamardiPesan[counter[0]]];
            System.out.println("Kamar ready jenis " + jenisKamarHotel[jenisKamardiPesan[counter[0]]]);
            for (int i = 0; i < kamarReady[jenisKamardiPesan[counter[0]]].length; i++) {
                if (kamarReady[jenisKamardiPesan[counter[0]]][i] != 0) {
                    System.out.print("[" + kamarReady[jenisKamardiPesan[counter[0]]][i] + "] ");
                }
            }
            System.out.println();
            System.out.println("Diatas adalah daftar kamar yang ready silahkan masukkan angka nomor kamar : ");
            nomorKamardiPesan[counter[0]] = input.nextInt();
            if (nomorKamardiPesan[counter[0]] == kamarReady[jenisKamardiPesan[counter[0]]][nomorKamardiPesan[counter[0]] - 1]) {
                kamarReady[jenisKamardiPesan[counter[0]]][nomorKamardiPesan[counter[0]] - 1] = 0;
            } else if (nomorKamardiPesan[counter[0]] != kamarReady[jenisKamardiPesan[counter[0]]][nomorKamardiPesan[counter[0]] - 1]) {
                System.out.println("Kamar yang anda pesan tidak tersedia! Program akan di tutup!");
                System.exit(0);
            }

            riwayatNomorKamar[counter[0]][nomorUrut] = nomorKamardiPesan[counter[0]];

            System.out.println("Anda ingin menginap berapa hari ? (misal 2 hari masukkan angka 2) : ");
            lamaMenginap[counter[0]] = input.nextInt();
            riwayatLamaMenginap[counter[0]][nomorUrut] = lamaMenginap[counter[0]];
            riwayatHarga[counter[0]][nomorUrut] = (hargaKamarHotel[jenisKamardiPesan[counter[0]]] * lamaMenginap[counter[0]]);
            System.out.println("Apakah anda ingin memesan tiket lagi ? (Ya/Tidak) :");
            konfirmasiPesanLagi = input.next();
            if (konfirmasiPesanLagi.equalsIgnoreCase("Ya")) {
                counter[0]++;
                counterRiwayat[nomorUrut]++;
            } else if (konfirmasiPesanLagi.equalsIgnoreCase("Tidak")) {
                kondisi = false;
            } else {
                System.out.println("Inputan yang anda masukkan salah program akan di tutup !");
                System.exit(0);
            }

        }


        System.out.println();
        System.out.println("Berikut adalah tagihan anda : ");
        System.out.println("Nama : " + nama);
        System.out.println("Tanggal : " + tanggal);
        System.out.println("=======================");
        for (int i = 0; i < (counter[0] + 1); i++) {
            System.out.println("Jenis Kamar : " + jenisKamarHotel[jenisKamardiPesan[i]]);
            System.out.println("Nomor Kamar : " + nomorKamardiPesan[i]);
            System.out.println("Lama Menginap : " + lamaMenginap[i] + " hari");
            System.out.println("Harga : Rp." + riwayatHarga[i][nomorUrut]);
            System.out.println("=======================");
            total += riwayatHarga[i][nomorUrut];
        }
        System.out.println("Diskon Member : " + riwayatDiskonMember[nomorUrut]);
        System.out.println("Total : Rp." + (total - (total * diskonMember)));
        pembayaran((total - (total * diskonMember)));
        riwayatTotal[nomorUrut] = (total - (total * diskonMember));
        nomorUrut++;
        counter[0] = 0;
    }

    private static void daftarJenisKamar() {
        System.out.println("Jenis Kamar Dan Harga");
        System.out.println("============================================");
        System.out.println("| [1] Standard Room    = Rp." + hargaKamarHotel[0] + "/hari");
        System.out.println("| [2] Deluxe Room      = Rp." + hargaKamarHotel[1] + "/hari");
        System.out.println("| [3] Suite Room       = Rp." + hargaKamarHotel[2] + "/hari");
        System.out.println("| [4] President Room   = Rp." + hargaKamarHotel[3] + "/hari");
        System.out.println("============================================");
    }

    private static void daftarKamarReady() {
        for (int i = 0; i < kamarReady.length; i++) {
            System.out.println("Kamar ready jenis [" + (i+1) + "] " + jenisKamarHotel[i] + ":");
            for (int j = 0; j < kamarReady[0].length; j++) {
                if (kamarReady[i][j] != 0) {
                    System.out.print("[" + kamarReady[i][j] + "] ");
                }
            }
            System.out.println();
        }
    }

    private static void pembayaran(float total) {
        int uang;
        int menu;
        System.out.println();
        System.out.println("=====  Jenis Pembayaran  =====");
        System.out.println("| [1] Tunai                  |");
        System.out.println("| [2] Transfer               |");
        System.out.println("==============================");
        System.out.println("Masukkan jenis pembayaran (1 atau 2) : ");
        menu = input.nextInt();
        switch (menu) {
            case 1 -> {
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

            case 2 -> {
                System.out.println("Nominal yang harus anda bayarkan : " + total);
                System.out.println("Masukkan Nominal Uang Anda : ");
                uang = input.nextInt();
                if (total - uang == 0) {
                    System.out.println("==========  Terimakasih atas kunjungannya  ==========");
                } else  {
                    System.out.println("==========  Nominal yang anda masukkan tidak sesuai  ==========");
                    pembayaran(total);
                }
            }

            default -> {
                System.out.println("Masukkan yang anda masukkan salah!");
                pembayaran(total);
            }
        }


    }

    private static void pegawai() {
        int menu;
        System.out.println("============================================");
        System.out.println("|  ==============   MENU   ==============  |");
        System.out.println("|  | [1] Update Harga Kamar Hotel       |  |");
        System.out.println("|  | [2] Update Nomor Kamar Hotel       |  |");
        System.out.println("|  | [3] Riwayat Transaksi              |  |");
        System.out.println("|  | [4] Kembali ke Menu Sebelumnya     |  |");
        System.out.println("|  |====================================|  |");
        System.out.println("============================================");
        System.out.print("Silahkan memilih menu diatas dengan cara memasukkan angka 1 sampai 4 : ");
        menu = input.nextInt();
        System.out.println();
        switch (menu) {
            case 1 -> updateHargaKamar();
            case 2 -> updateNomorKamar();
            case 3 -> riwayatTransaksi();
            case 4 -> menu();
            default -> System.out.println("Mohon maaf input yang anda masukkan salah");
        }
    }

    private static void updateHargaKamar() {
        int key;
        System.out.println("============================================");
        System.out.println("============  Update Harga Kamar  ==========");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println();
        daftarJenisKamar();
        System.out.print("Kamar jenis apa yang ingin diganti harganya ? (masukkan angka 1 sampai 4) : ");
        key = input.nextInt() - 1;
        System.out.print("Masukkan Harga Baru : ");
        hargaKamarHotel[key] = input.nextInt();
        System.out.println("Berikut adalah data harga kamar setelah di update");
        daftarJenisKamar();
    }

    private static void updateNomorKamar() {
        int key1, key2;
        System.out.println("============================================");
        System.out.println("============  Update Nomor Kamar  ==========");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println();
        daftarKamarReady();
        System.out.println("Kamar jenis apa yang ingin di update? (masukkan angka 1 sampai 4) : ");
        key1 = input.nextInt() - 1;
        System.out.println("Kamar nomor berapa yang sudah ready kembali? (masukkan angka 1 sampai 10) : ");
        key2 = input.nextInt() - 1;
        kamarReady[key1][key2] = (key2 + 1);
        daftarKamarReady();

    }

    private static void riwayatTransaksi() {
        System.out.println("============================================");
        System.out.println("============  Riwayat Transaksi  ===========");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println();
        for (int i = 0; i < nomorUrut; i++) {
            System.out.println("============================================");
            System.out.println("|============  Transaksi ke " + (i+1) + "  ============|");
            System.out.println("============================================");
            System.out.println("Nama          : " + riwayatPemesan[i]);
            System.out.println("Tanggal       : " + riwayatTanggal[i]);
            for (int j = 0; j < counterRiwayat[i] + 1; j++) {
                System.out.println("Jenis Kamar   : " + riwayatJenisKamar[j][i]);
                System.out.println("Nomor Kamar   : " + riwayatNomorKamar[j][i]);
                System.out.println("Lama Menginap : " + riwayatLamaMenginap[j][i] + " hari");
                System.out.println("Harga         : Rp." + riwayatHarga[j][i]);
                System.out.println("============================================");
            }
            System.out.println("Diskon Member : " + riwayatDiskonMember[i]);
            System.out.println("Total         : Rp." + riwayatTotal[i]);
            System.out.println();
        }
    }


}
