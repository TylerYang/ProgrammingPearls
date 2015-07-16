import java.io.*;

public class Solution {
    public static void main(String[] args) {
        PhoneBookService pbs = new PhoneBookService();
        try {
            FileReader fr = new FileReader("phone.txt");
            pbs.sort(fr);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
