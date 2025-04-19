import java.util.*;

public class DownloadManager {
    static class DownloadThread extends Thread {
        String fileName;

        DownloadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Downloading " + fileName + " - " + (i * 20) + "%");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ignored) {}
            }
            System.out.println(fileName + " download complete.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first file name: ");
        String file1 = sc.nextLine();
        System.out.print("Enter second file name: ");
        String file2 = sc.nextLine();
        System.out.print("Enter third file name: ");
        String file3 = sc.nextLine();

        new DownloadThread(file1).start();
        new DownloadThread(file2).start();
        new DownloadThread(file3).start();
    }
}