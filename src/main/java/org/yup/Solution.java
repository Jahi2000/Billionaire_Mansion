package org.yup;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Comparator.comparing;

public class Solution {
/*
    // This method displays the previous month of the current month to the user.
    public static void previousMonth() throws IOException {
        Scanner scan = new Scanner(System.in);
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);

        }

       /* Date today = new Date();
        SimpleDateFormat domingo = new SimpleDateFormat("Y-MM");
        String now = domingo.format(today);
        int num = Integer.parseInt(now.substring(5,7));
        num--;
        String var = String.format("0%s",num);
        SimpleDateFormat domingo1 = new SimpleDateFormat("Y");
        String ahora = domingo1.format(today);
        //System.out.print(ahora);


        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
           // if (var.equals(P.getDate().substring(6,8).trim()) && ahora.equals(P.getDate().substring(0,5).trim())) {
              System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }

*/


    //This method allows the user's to get a report of the monthtodate transactions
    public static void monthtodate() throws IOException {

        Scanner scan = new Scanner(System.in);
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String[] linePieces;
            linePieces = theLine.split("\\|");
            //System.out.println(linePieces[2]);
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);


        }

        Date today = new Date();
        SimpleDateFormat domingo = new SimpleDateFormat("Y-MM");
        String now = domingo.format(today);

        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            if (now.equalsIgnoreCase(P.getDate().substring(0, 8).trim())) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }

        }

    }

    //  This method allows the user to search for a transaction by inserting the vendor's name
    public static void VenName() throws IOException {
        Scanner scan = new Scanner(System.in);
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);

        }

        System.out.println("Please enter the name of the vendor");
        String vendor = scan.nextLine();


        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            String ven = P.getVendor();
            if (vendor.equalsIgnoreCase(P.getVendor().trim())) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }

    }

    //This method only outputs the entries which were only deposits.
    public static void display_Deposits() throws IOException {
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);
        }
        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            char sym = P.getAmount().charAt(1);
            if (!(sym == '-')) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }
    }


    //This method only outputs the entries which were debits
    public static void display_Payments() throws IOException {
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);
        }
        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            char sym = P.getAmount().charAt(1);
            if (sym == '-') {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }
    }


    //this method display's all the ledger entries starting with the most recent.
    public static void display_ALLLedger() throws IOException {
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);
        }
        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
        }
    }
    //public static void Ledger() {

    //Sys.out.print  //Would you like to display ledger entries ?

        /* if yes {
           call method display_ALLLedger
    }
*/


    //  }

    public static void MakePayment() throws IOException {
        BufferedWriter theFile = new BufferedWriter(new FileWriter("transaction.csv", true));
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

        BufferedWriter theFile = new BufferedWriter(new FileWriter("transaction.csv", true));
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

        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String[] linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);
        }
        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());


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
}
