package org.yup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void Ledger(){
        
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