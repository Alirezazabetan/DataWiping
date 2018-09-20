import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.in;

public class DataWiping {
    public void doDataWipe(String url) {
        //create pass 1-7 with stringbuffer
        Random rand = new Random();
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(0XF6);
        arrayList.add(0X00);
        arrayList.add(0XFF);
        arrayList.add(rand.nextInt(0x01) + (0xFF));
        arrayList.add(0X00);
        arrayList.add(0XFF);
        arrayList.add(rand.nextInt(0x01) + (0xFF));

        try {
            File file = new File(url);
            for (int j = 0; j < 7; j++) {
                RandomAccessFile rnd = new RandomAccessFile(file, "rw");
                //InputStream in = new FileInputStream(url);
                for (int i = 0; i < rnd.length(); i++) {

                    rnd.writeByte(arrayList.get(j));

                }
                rnd.close();

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not found !!");
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
