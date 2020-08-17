import java.io.*;

public class Encode{
  public static void main(String ... args){
    if (args.length < 2) {
       System.out.println("Please provide input and output files");
       System.exit(0);
    }
    String fName = args[0];
    String f2Name = args[1];
    try{
      File f = new File(args[0]);
      FileInputStream f1 = new FileInputStream(fName);
      FileOutputStream f2 = new FileOutputStream(f2Name);
      int length;
      while ((length = f1.read()) != -1) {
                f2.write(length ^ 0x60);
      }
      f1.close();
      f2.close();
      f.delete();
    }
    catch(IOException e){
        e.printStackTrace();
    }
  }
}
