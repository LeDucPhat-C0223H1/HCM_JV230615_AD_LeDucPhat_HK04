package ra.model;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private int age;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
    }

    public Song(String songId, String songName, String descriptions, Singer singer, int age, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.age = age;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputSongId(Song[] arrSong, int songCount) {
        Scanner scanner = new Scanner(System.in);
        /*Mã bài hát*/
        System.out.println("- Nhập mã bài hát:");
        boolean isExist;
        do {
            isExist = true;
            this.songId = scanner.nextLine();
            if (this.songId.isEmpty()) {
                System.err.println("Mã bài hát không được để trống. Vui lòng điền mã bài hát:");
            } else {
                boolean checkFormatSongId = Pattern.matches("^[S]\\w{3}$", this.songId);

                if (checkFormatSongId) {
                    boolean checkEquals = false;
                    for (int i = 0; i < songCount; i++) {
                        if (arrSong[i].getSongId().equals(this.songId)) {
                            checkEquals = true;
                            break;
                        }
                    }
                    if (checkEquals) {
                        System.out.println("Mã bài hát này đã tồn tại!");
                    } else {
                        isExist = false;
                    }
                } else {
                    System.err.println("Mã bài hát có 4 ký tự và bắt đầu bằng kí tự S");
                }
            }
        } while (isExist);
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        /*Tên bài hát*/
        System.out.println("- Nhập tên bài hát:");
        this.songName = scanner.nextLine();
        while (this.songName.isEmpty()) {
            System.err.println("Tên bài hát không được để trống. Vui lòng điền tên bài hát:");
            this.songName = scanner.nextLine();
        }

        /*Mô tả bài hát*/
        System.out.println("- Nhập mô tả:");
        this.descriptions = scanner.nextLine();
        if (this.descriptions.isEmpty()) {
            this.descriptions = "";
        }

        /*Ca sĩ*/


        /*Ngươì sáng tác*/
        System.out.println("- Nhập người sáng tác:");
        this.songWriter = scanner.nextLine();
        while (this.songWriter.isEmpty()) {
            System.err.println("NGười sáng tác không được để trống. Vui lòng điền người sáng tác:");
            this.songWriter = scanner.nextLine();
        }

        /*Ngày tạo*/
        this.createdDate = new Date();

        /*Trạng thái*/
        System.out.println("- Nhập trạng thái (true - Đang phát hành ; false - Ngưng phát hành)");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    public void displayData() {
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả bài hát: " + descriptions);
        System.out.println("Ca sĩ: " + singer);
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Nhập trạng thái: " + (songStatus ? "Nam" : "Nữ"));
    }
}


