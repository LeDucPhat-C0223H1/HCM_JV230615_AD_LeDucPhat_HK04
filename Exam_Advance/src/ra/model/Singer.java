package ra.model;

import java.util.Scanner;

public class Singer {
    private static int nextSingerId = 1;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
        this.singerId = nextSingerId++;
    }

    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        /*Tên ca sĩ*/
        System.out.println("- Nhập tên ca sĩ:");
        this.singerName = scanner.nextLine();
        while (this.singerName.isEmpty()) {
            System.err.println("Tên ca sĩ không được để trống. Vui lòng điền tên ca sĩ:");
            this.singerName = scanner.nextLine();
        }

        /*Tuổi*/
        System.out.println("- Nhập tuổi:");
        this.age = Integer.parseInt(scanner.nextLine());
        while (this.age < 0) {
            System.err.println("Tuổi phải lớn hơn 0. Vui lòng nhập tuổi:");
            this.age = Integer.parseInt(scanner.nextLine());
        }

        /*Quốc tịch*/
        System.out.println("- Nhập quốc tịch:");
        this.nationality = scanner.nextLine();
        while (this.nationality.isEmpty()) {
            System.err.println("Quốc tịch không được để trống. Vui lòng điền quốc tịch:");
            this.nationality = scanner.nextLine();
        }

        /*Giới tính*/
        System.out.println("- Nhập giới tính (true - Nam ; false - Nữ)");
        this.gender = Boolean.parseBoolean(scanner.nextLine());

        /*Thể loại*/
        System.out.println("- Nhập thể loại nhạc:");
        this.genre = scanner.nextLine();
        while (this.genre.isEmpty()) {
            System.err.println("Thể loại nhạc không được để trống. Vui lòng điền thể loại nhạc:");
            this.genre = scanner.nextLine();
        }
    }

    public void displayData() {
        System.out.println("Mã ca sĩ: " + singerId);
        System.out.println("Tên ca sĩ: " + singerName);
        System.out.println("Tuổi: " + age);
        System.out.println("Quốc tịch: " + nationality);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Thể loại: " + genre);
    }
}


