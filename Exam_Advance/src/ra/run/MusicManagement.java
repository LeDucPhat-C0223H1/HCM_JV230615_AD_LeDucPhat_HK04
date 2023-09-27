package ra.run;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

public class MusicManagement {
    private static final SingerService singerService = new SingerService();
    private static final SongService songService = new SongService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("********* Music Management *********");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice){
                case 1:
                    SingerManagement(scanner);
                    break;
                case 2:
                    SongManagement(scanner);
                    break;
                case 3:
                    SearchManagement(scanner);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1-4");
            }
        }while (true);
    }


    /*
     * SINGER-MANAGEMENT
     * */
    private static void SingerManagement(Scanner scanner) {
        boolean isExist = true;
        do {
            System.out.println("********* Singer Management ***********");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    addNewSinger(scanner);
                    System.out.println();
                    break;
                case 2:
                    displayAllSinger();
                    System.out.println();
                    break;
                case 3:
                    editSinger(scanner);
                    System.out.println();
                    break;
                case 4:
                    deleteSinger(scanner);
                    System.out.println();
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1-5");
            }
        } while (isExist);
    }

    private static void addNewSinger(Scanner scanner) {
        System.out.print("Nhập số lượng ca sĩ cần thêm: ");
        int numSinger = Integer.parseInt(scanner.nextLine());

        if (singerService.getSingerCount() + numSinger > singerService.findAll().length) {
            System.out.println("Không thể thêm nhiều ca sĩ hơn. Đã đạt 100 ca sĩ.");
            return;
        }

        for (int i = 0; i < numSinger; i++) {
            Singer singer = new Singer();
            System.out.println("Nhập thông tin cho ca sĩ " + (singerService.getSingerCount() + 1) + ":");
            singer.inputData();
            singerService.addNewSinger(singer);
            System.out.println();
        }

        System.out.println("Thêm " + numSinger + " ca sĩ thành công");
    }

    private static void displayAllSinger() {
        if (singerService.getSingerCount() == 0) {
            System.out.println("Không có ca sĩ nào trong kho lưu trữ.");
            return;
        }
        System.out.println("Danh sách ca sĩ trong kho lưu trữ:");
        for (int i = 0; i < singerService.getSingerCount(); i++) {
            System.out.println("------------------");
            singerService.findAll()[i].displayData();
        }
    }

    private static void editSinger(Scanner scanner) {
        if (singerService.getSingerCount() == 0) {
            System.out.println("không có ca sĩ trong kho lưu trữ");
            return;
        }
        System.out.print("Nhập ID ca sĩ để sửa đổi: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        boolean check = singerService.editById(singerId);
        if (check) {
            System.out.println("Ca sĩ có  id " + singerId + " đã sửa thông tin thành công.");
        } else {
            System.out.println("Không tìm thấy id ca sĩ");
        }
    }

    private static void deleteSinger(Scanner scanner) {
        if (singerService.getSingerCount() == 0) {
            System.out.println("không có ca sĩ trong kho lưu trữ");
            return;
        }

        System.out.print("Nhập id ca sĩ cần xoá: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        boolean check = singerService.deleteById(singerId);
        if (check) {
            System.out.println("Ca sĩ có  id " + singerId + " đã xoá thành công.");
        } else {
            System.out.println("Không tìm thấy id ca sĩ");
        }
    }


    /*
     * SONG-MANAGEMENT
     * */
    private static void SongManagement(Scanner scanner) {
        boolean isExist = true;
        do {
            System.out.println("********* Song Management ***********");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    addNewSong(scanner);
                    System.out.println();
                    break;
                case 2:
                    displayAllSong();
                    System.out.println();
                    break;
                case 3:
                    editSong(scanner);
                    System.out.println();
                    break;
                case 4:
                    deleteSong(scanner);
                    System.out.println();
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1-5");
            }
        } while (isExist);
    }

    private static void addNewSong(Scanner scanner) {
        System.out.print("Nhập số lượng bài hát cần thêm: ");
        int numSong = Integer.parseInt(scanner.nextLine());

        if (songService.getSongCount() + numSong > songService.findAll().length) {
            System.out.println("Không thể thêm nhiều bài hát hơn. Đã đạt 100 bài hát.");
            return;
        }

        for (int i = 0; i < numSong; i++) {
            Song song = new Song();
            System.out.println("Nhập thông tin cho bài hát " + (songService.getSongCount() + 1) + ":");
            song.inputSongId(songService.findAll(), songService.getSongCount());
            song.inputData();
            songService.addNewSong(song);
            System.out.println();
        }

        System.out.println("Thêm " + numSong + " bài hát thành công");
    }

    private static void displayAllSong() {
        if (songService.getSongCount() == 0) {
            System.out.println("Không có bài hát nào trong kho lưu trữ.");
            return;
        }
        System.out.println("Danh sách bài hát trong kho lưu trữ:");
        for (int i = 0; i < songService.getSongCount(); i++) {
            System.out.println("------------------");
            songService.findAll()[i].displayData();
        }
    }

    private static void editSong(Scanner scanner) {
        if (songService.getSongCount() == 0) {
            System.out.println("không có bì hát trong kho lưu trữ");
            return;
        }
        System.out.print("Nhập ID bài hát để sửa đổi: ");
        String songId = scanner.nextLine();

        boolean check = songService.editById(songId);
        if (check) {
            System.out.println("Bài hát  có  id " + songId + " đã sửa thông tin thành công.");
        } else {
            System.out.println("Không tìm thấy id bài hát");
        }
    }

    private static void deleteSong(Scanner scanner) {
        if (singerService.getSingerCount() == 0) {
            System.out.println("không có bài hát trong kho lưu trữ");
            return;
        }

        System.out.print("Nhập id bai hát cần xoá: ");
        String songId = scanner.nextLine();

        boolean check = songService.deleteById(songId);
        if (check) {
            System.out.println("Bài hát có  id " + songId + " đã xoá thành công.");
        } else {
            System.out.println("Không tìm thấy id bài hát");
        }
    }


    /*
     * SEARCH-MANAGEMENT
     * */
    private static void SearchManagement(Scanner scanner) {
        boolean isExist = true;
        do {
            System.out.println("********* Search Management ***********");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    SearchSongByNameOrGenre(scanner);
                    System.out.println();
                    break;
                case 2:
                    SearchSingerByNameOrGenre(scanner);
                    System.out.println();
                    break;
                case 3:
//                    editSong(scanner);
                    System.out.println();
                    break;
                case 4:
//                    deleteSong(scanner);
                    System.out.println();
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1-5");
            }
        } while (isExist);
    }

    private static void SearchSongByNameOrGenre(Scanner scanner){
        if (songService.getSongCount() == 0) {
            System.out.println("Không có bài hát trong kho lưu trữ để tìm kiếm");
        }else {
            System.out.print("Nhập truy vấn tìm kiếm (tên hoặc mô tả): ");
            String query = scanner.nextLine();

            boolean found = false;
            Song[] arrSongSearch = new Song[songService.getSongCount()];
            int index = 0;
            for (int i = 0; i < songService.getSongCount(); i++) {
                if(songService.findAll()[i].getSongName().contains(query) || songService.findAll()[i].getDescriptions().contains(query)){
                    arrSongSearch[index] = songService.findAll()[i];
                    index++;
                    found = true;
                }
            }

            if (found) {
                System.out.println("Kết quả tìm kiếm:\n");
                for (int i = 0; i < arrSongSearch.length; i++) {
                    if(arrSongSearch[i]!=null){
                        arrSongSearch[i].displayData();
                    }
                }
            }else {
                System.out.println("Không có tên hay thể loại phù hợp với truy vấn tìm kiếm.");
            }
        }
    }

    private static void SearchSingerByNameOrGenre(Scanner scanner){
        if (singerService.getSingerCount() == 0) {
            System.out.println("Không có ca sĩ trong kho lưu trữ để tìm kiếm ");
        }else {
            System.out.print("Nhập truy vấn tìm kiếm (tên hoặc mô tả): ");
            String query = scanner.nextLine();

            boolean found = false;
            Singer[] arrSingerSearch = new Singer[singerService.getSingerCount()];
            int index = 0;
            for (int i = 0; i < singerService.getSingerCount(); i++) {
                if(singerService.findAll()[i].getSingerName().contains(query) || singerService.findAll()[i].getGenre().contains(query)){
                    arrSingerSearch[index] = singerService.findAll()[i];
                    index++;
                    found = true;
                }
            }

            if (found) {
                System.out.println("Kết quả tìm kiếm:\n");
                for (int i = 0; i < arrSingerSearch.length; i++) {
                    if(arrSingerSearch[i]!=null){
                        arrSingerSearch[i].displayData();
                    }
                }
            }else {
                System.out.println("Không có tên hay thể loại phù hợp với truy vấn tìm kiếm.");
            }
        }
    }
}
