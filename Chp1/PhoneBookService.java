import java.util.*;
import java.io.*;


public class PhoneBookService{
    private static final int MASK = 0x1F;
    private static final int BITSPERWORD = 32;
    private static final int SHIFT = 5;
    private int size = 10000000;
    private int[] a; 
    public PhoneBookService(int size) {
        this.size = size;
        this.a = new int[size/BITSPERWORD + 1];
    }
    public PhoneBookService() {
        this.a = new int[size/BITSPERWORD+ 1];
    }
    
    private void set(int i) {
        this.a[i >>> SHIFT] |= (1 << (i >>> MASK));     
    }
    private void clear(int i) {
        this.a[i >>> SHIFT] &= ~(1 << (i >>> MASK));     
    }
    private int test(int i) {
        return this.a[i >>> SHIFT] &= (1 << (i >>> MASK));
    }
    
    public void sort(FileReader file) {
        if(file == null) throw new NullPointerException();
        String s = "";
        try{
            BufferedReader br = new BufferedReader(file);
            while((s = br.readLine()) != null) {
                int n = Integer.parseInt(s);
                set(n);
            } 
        } catch(IOException e) {
            e.printStackTrace();
        }
        try{
            PrintWriter out = new PrintWriter("sortedText.txt");
            for(int i = 0; i < size; i++) {
                if(test(i) > 0) {
                    out.println(i);
                }
            }
            out.flush();
            out.close(); 
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }     
    
}
