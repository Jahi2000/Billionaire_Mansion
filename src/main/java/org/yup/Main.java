package org.yup;

import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class Main {

    //This method only outputs the entries which were only deposits.
    public static void display_Deposits() throws IOException {
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList <transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ( ( theLine = theFileFromTheHDD.readLine() ) != null  ) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0],linePieces[1],linePieces[2],linePieces[3],linePieces[4]);
            list.add(T);
        }
        //this loop prints out the data in loop in a descending order by index numbers
        for(int l = list.size() - 1; l < list.size() && l > 0; l--){
            transaction P = list.get(l);
            char sym = P.getAmount().charAt(1);
            if(!(sym == '-')) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }
    }



    //This method only outputs the entries which were debits
    public static void display_Payments() throws IOException {
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList <transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ( ( theLine = theFileFromTheHDD.readLine() ) != null  ) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0],linePieces[1],linePieces[2],linePieces[3],linePieces[4]);
            list.add(T);
        }
        //this loop prints out the data in loop in a descending order by index numbers
        for(int l = list.size() - 1; l < list.size() && l > 0; l--){
            transaction P = list.get(l);
            char sym = P.getAmount().charAt(1);
            if(sym == '-') {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
            }
    }



    //this method display's all the ledger entries starting with the most recent.
    public static void display_ALLLedger () throws IOException {
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList <transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ( ( theLine = theFileFromTheHDD.readLine() ) != null  ) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0],linePieces[1],linePieces[2],linePieces[3],linePieces[4]);
            list.add(T);
        }
        //this loop prints out the data in loop in a descending order by index numbers
        for(int l = list.size() - 1; l < list.size() && l > 0; l--){
            transaction P = list.get(l);
            System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
        }
    }
    public static void Ledger() {

        //Sys.out.print  //Would you like to display ledger entries ?

        /* if yes {
           call method display_ALLLedger
    }
*/





    }

    public static void MakePayment() throws IOException {
       BufferedWriter theFile = new BufferedWriter(new FileWriter("transaction.csv",true));
       Scanner scan = new Scanner(System.in);

       Date today = new Date();
       SimpleDateFormat ahora = new SimpleDateFormat("Y-MM-dd");
       String myday = ahora.format(today);

       Date time = new Date();
       SimpleDateFormat domingo = new SimpleDateFormat("hh:mm:ss a");
       String now = domingo.format(time);


       System.out.println("You have choosen to make a Payment\n");
       System.out.println("Please enter a description of the item");
       String description = scan.nextLine();
       System.out.println("Please enter the vendor of the item");
       String vendor = scan.nextLine();
       System.out.println("Please enter the Amount of the item");
       String amount = scan.nextLine();
       transaction trans = new transaction(myday, now, description, vendor, amount);
       String word = String.format(" %s |  %s | %s | %s | %s\n", trans.getDate(), trans.getTime(), trans.getDescription(), trans.getVendor(), trans.getAmount());
       theFile.write(word);

       theFile.close();

   }



    public static void AddDeposit() throws IOException {

        BufferedWriter theFile = new BufferedWriter(new FileWriter("transaction.csv",true));
        Scanner scan = new Scanner(System.in);

        Date today = new Date();
        SimpleDateFormat ahora = new SimpleDateFormat("Y-MM-dd");
        String myday = ahora.format(today);

        Date time = new Date();
        SimpleDateFormat domingo = new SimpleDateFormat("hh:mm:ss a");
        String now = domingo.format(time);


        System.out.println("You have choosen to make a Deposit\n");
        System.out.println("Please enter a description of the item");
        String description = scan.nextLine();
        System.out.println("Please enter the vendor of the item");
        String vendor = scan.nextLine();
        System.out.println("Please enter the Amount of the item");
        String amount = scan.nextLine();
        transaction trans = new transaction(myday, now, description, vendor, amount);
        String word = String.format(" %s |  %s | %s | %s | %s\n", trans.getDate(), trans.getTime(), trans.getDescription(), trans.getVendor(), trans.getAmount());
        theFile.write(word);

        theFile.close();
    }


    public static void main(String[] args) throws IOException {



     display_Deposits();



        //BufferedWriter theFile = new BufferedWriter(new FileWriter("transaction.csv",true));
        //Scanner scan = new Scanner(System.in);

       /* Date today = new Date();
        SimpleDateFormat ahora = new SimpleDateFormat("Y-MM-dd");
        String myday = ahora.format(today);


        Date time = new Date();
        SimpleDateFormat domingo = new SimpleDateFormat("hh:mm:ss a");
        String now = domingo.format(time);



        System.out.println("Please enter a description of the item");
        String description = scan.nextLine();
        System.out.println("Please enter the vendor of the item");
        String vendor = scan.nextLine();
        System.out.println("Please enter the Amount of the item");
        String amount = scan.nextLine();

        transaction trans = new transaction(myday,now,description,vendor,amount);
        String word = String.format(" %s |  %s | %s | %s | %s\n", trans.getDate(),trans.getTime() ,trans.getDescription(),trans.getVendor(),trans.getAmount());
        theFile.write(word);

        theFile.close();

*/

    }
}