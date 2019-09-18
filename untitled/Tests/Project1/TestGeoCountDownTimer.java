package Project1;

import java.io.*;
import java.util.Scanner;
public class TestGeoCountDownTimer {

    public void sampleReadData(){
        int year;
        int month;
        int day;

        try{
            // open the data file
            Scanner fileReader = new Scanner(new File("/testit"));
            Scanner lineReader;

            // read several int for year, month, and day
            year= fileReader.nextInt();
            month = fileReader.nextInt();
            day = fileReader.nextInt();
            System.out.println (year + " " + month+ " "+ day);
        }

        // could not find file
        catch(FileNotFoundException error) {
            System.out.println("File not found ");
        }

        // problem reading the fil
        catch(IOException error){
            System.out.println("Oops!  Something went wrong.");
        }
    }

    public void sampleWriteData () {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("/testit")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "ANCHORAGE";
        out.println(s + " " +  "256000");
        out.close();

    }

    public static void main(String[] args) {

        GeoCountDownTimer f = new GeoCountDownTimer();
        f.sampleWriteData();
        f.sampleReadData();

    }

}
