import java.io.*;


public class Main {
    public static void main(String[] args) {
            int[] data = new int[1024 * 1024 * 10];
            String fName  = args[0];
            String f1Name = args[1];
        
            long startTime = System.currentTimeMillis();
            try (FileInputStream fis = new FileInputStream(fName);
                                 BufferedInputStream bis = new BufferedInputStream(fis)) {
                        
                        int b, counter = 0;
                        while ((b = bis.read()) != -1) {
                                        data[counter++] = b;
                                    }
                    } catch (IOException ex) {
                                ex.printStackTrace();
                            }
            
            try (FileOutputStream fos = new FileOutputStream(f1Name);
                                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                
                        for (int binaryInt : data)
                            bos.write(binaryInt ^ 0x60);
                        
                    } catch (IOException ex) {
                                ex.printStackTrace();
                            }
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime));
        }
}

