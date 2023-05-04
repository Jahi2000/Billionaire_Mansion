package org.yup;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

import static java.util.Comparator.comparing;

public class Main {

    //This method displays the Ledger report from the previous year
    public static void pYear() throws IOException {

        //This line reads in the CSV File
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

        Date today = new Date();                                             //This line captures the date
        SimpleDateFormat domingo = new SimpleDateFormat("Y");        //This line formats the date
        String now = domingo.format(today);                                //This line stores the date in a String data type
        int num = Integer.parseInt(now.substring(0, 4));                  //This line converts the substring of the year digits to an integer
        num--;                                                           //This line subtracts the digit by one
        String var = String.format("%s", num);                          //The new value of the digit is converted back to an String.



        //this loop prints out the data in loop in a descending order by index numbers
       for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            if (var.equals(P.getDate().substring(0, 4).trim())) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }
       System.out.println();
       theFileFromTheHDD.close();
       theFileWeWantToWorkWith.close();                           // Closing the BufferReader
    }


    //This method displays the Ledger report from YeartoDate
    public static void year_toDate() throws IOException {

        //This line reads in the CSV File
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

        Date today = new Date();                                              //This line captures the date
        SimpleDateFormat domingo = new SimpleDateFormat("Y");         //This line formats the date
        String now = domingo.format(today);                                 //This line stores the date in a String data type

        //this loop prints out the data in loop in a descending order by index numbers
        for(int l = list.size() - 1; l < list.size() && l > 0; l--){
            transaction P = list.get(l);
            String ven = P.getVendor();
            if(now.equalsIgnoreCase(P.getDate().substring(0,4).trim())) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }
        System.out.println();
        theFileFromTheHDD.close();
        theFileWeWantToWorkWith.close();                                   // Closing the BufferReader

    }




    // This method displays the previous month of the current month to the user.
    public static void previousMonth() throws IOException {

        //This line reads in the CSV File
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

        Date today = new Date();                                                        //This line captures the date
        SimpleDateFormat domingo = new SimpleDateFormat("Y-MM");                //This line formats the date
        String now = domingo.format(today);                                           //This line stores the date in a String data type
        int num = Integer.parseInt(now.substring(5, 7));                             //This line converts the substring of the month digits to an integer
        num--;                                                                      //This line subtracts the digit by one
        String var = String.format("0%s", num);                                    //The new value of the digit is converted back to an String.
        SimpleDateFormat domingo1 = new SimpleDateFormat("Y");             //This line formats the current Year
        String ahora = domingo1.format(today);                                   //This line stores the date in a String data type



        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
            if (var.equals(P.getDate().substring(5, 7).trim()) && ahora.equals(P.getDate().substring(0, 4).trim())) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }
        System.out.println();
        theFileFromTheHDD.close();
        theFileWeWantToWorkWith.close();                // Closing the BufferReader
    }




    //This method allows the user's to get a report of the monthtodate transactions
    public static void monthtodate() throws IOException {

        //This line reads in the CSV File
        FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
        BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
        String theLine;
        ArrayList<transaction> list = new ArrayList<>();

        // This loop reads the csv file by each line and stores it in an array
        while ((theLine = theFileFromTheHDD.readLine()) != null) {
            String [] linePieces;
            linePieces = theLine.split("\\|");
            transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
            list.add(T);


        }

        Date today = new Date();                                                        //This line captures the current date
        SimpleDateFormat domingo = new SimpleDateFormat("Y-MM");                //This line formats the current date
        String now = domingo.format(today);

        //this loop prints out the data in loop in a descending order by index numbers
        for (int l = list.size() - 1; l < list.size() && l > 0; l--) {
            transaction P = list.get(l);
          if (now.equalsIgnoreCase(P.getDate().substring(0,7).trim())) {
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate().trim(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }

        }
        System.out.println();
        theFileFromTheHDD.close();
        theFileWeWantToWorkWith.close();                        // Closing the BufferReader
    }


    //  This method allows the user to search for a transaction by inserting the vendor's name
    public static void VenName() throws IOException {
        Scanner scan = new Scanner (System.in);

        //This line reads in the CSV File
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

        System.out.println("Please enter the name of the vendor");
        String vendor = scan.nextLine();

        //this loop prints out the data in loop in a descending order by index numbers
        for(int l = list.size() - 1; l < list.size() && l > 0; l--){
            transaction P = list.get(l);
            String ven = P.getVendor();
            if(vendor.equalsIgnoreCase(P.getVendor().trim())) {
               System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
            if(!vendor.equalsIgnoreCase(P.getVendor().trim())){              // This is a constraint which checks if vendor was found.
                System.out.println("Vendor was not found");
                break;
            }
        }
        System.out.println();
        theFileFromTheHDD.close();
        theFileWeWantToWorkWith.close();                              // Closing the BufferReader
    }



    //This method only outputs the entries which were only deposits.
    public static void display_Deposits() throws IOException {

        //This line reads in the CSV File
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
            if(!(sym == '-')) {                                                //This line gets all the positive values
               System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
        }
        System.out.println();
        theFileFromTheHDD.close();
        theFileWeWantToWorkWith.close();    // Closing the BufferReader
    }



    //This method only outputs the entries which were debits
    public static void display_Payments() throws IOException {

        //This line reads in the CSV File
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
            if(sym == '-') {                                             //This line checks for all the negative values
                System.out.printf("%s | %s | %s | %s | %s |\n", P.getDate(), P.getTime(), P.getDescription(), P.getVendor(), P.getAmount());
            }
            }
        System.out.println();
        theFileFromTheHDD.close();
        theFileWeWantToWorkWith.close(); // Closing the BufferReader
    }



    //this method display's all the ledger entries starting with the most recent.
    public static void display_ALLLedger () throws IOException {

        //This line reads in the CSV File
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
        System.out.println();
        theFileFromTheHDD.close();
        theFileWeWantToWorkWith.close(); // Closing the BufferReader
    }

    // This method allows the user to make a payment
    public static void MakePayment() throws IOException {

        //This line reads in the CSV File
        BufferedWriter theFile = new BufferedWriter(new FileWriter("transaction.csv",true));
       Scanner scan = new Scanner(System.in);

       Date today = new Date();//This line captures the current date
       SimpleDateFormat ahora = new SimpleDateFormat("Y-MM-dd");// This line formats the current date
       String myday = ahora.format(today); // This line stores the date into a String datatype.

       Date time = new Date(); //This line captures the current time
       SimpleDateFormat domingo = new SimpleDateFormat("hh:mm:ss a"); //This line formats the current time
       String now = domingo.format(time); //This line stores the date into a String datatype.

       System.out.println("          PAYMENT");
       System.out.println("You have choosen to make a Payment\n");
       System.out.println("Please enter a description of the item");
       String description = scan.nextLine();
       System.out.println("Please enter the vendor of the item");
       String vendor = scan.nextLine();
       System.out.println("Please enter the Amount of the item");
       int amount = scan.nextInt();
       while(amount > 0){                    // This is a constraint only allowing the user to enter a valid amount
           System.out.println("Please  enter a valid amount");
           amount = scan.nextInt();
       }
       String realamount = String.format("%d",amount);       //This converts the integer to a String.
       transaction trans = new transaction(myday, now, description, vendor, realamount);
       String word = String.format("%s |  %s | %s | %s | %s\n", trans.getDate(), trans.getTime(), trans.getDescription(), trans.getVendor(), trans.getAmount());
       theFile.write(word);

       theFile.close();

   }


    //this method adds a deposit to the CSV file
    public static void AddDeposit() throws IOException {

        // This line reads in the CSV file.
        BufferedWriter theFile = new BufferedWriter(new FileWriter("transaction.csv",true));
        Scanner scan = new Scanner(System.in);

        Date today = new Date(); //This line captures the current date
        SimpleDateFormat ahora = new SimpleDateFormat("Y-MM-dd"); // This line formats the current date
        String myday = ahora.format(today); // This line stores the date into a String datatype.

        Date time = new Date(); //This line captures the current time
        SimpleDateFormat domingo = new SimpleDateFormat("hh:mm:ss a"); //This line formats the current time
        String now = domingo.format(time); //This line stores the date into a String datatype.

        System.out.println("YOU HAVE CHOOSEN TO MAKE DEPOSIT !\n");
        System.out.println("        DEPOSIT");
        System.out.println("Please enter a description of the item");
        String description = scan.nextLine();
        System.out.println("Please enter the vendor of the item");
        String vendor = scan.nextLine();
        System.out.println("Please enter the Amount of the item");
        String amount = scan.nextLine();
        transaction trans = new transaction(myday, now, description, vendor, amount); // Creating a constructor
        String word = String.format("%s |  %s | %s | %s | %s\n", trans.getDate(), trans.getTime(), trans.getDescription(), trans.getVendor(), trans.getAmount());
        theFile.write(word);

        theFile.close();
    }


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String var = "|*_-|-_*|*_-|-_*|*_-|-_*|*_-|-_*|*_-|-_*|*_-|-_*|*_-|-_*|*_-|-_*|\n";

        while(true){
            System.out.println();
            System.out.print(var);
            System.out.println("[-WELCOME TO BILLIONAIRE MANSION-]\n");           // Menu Screen
            System.out.println(" -> Press D to make an Deposit");
            System.out.println(" -> Press P to make an Payment");
            System.out.println(" -> Press L to view the Ledger Screen");
            System.out.println(" -> Press E to exit");
            System.out.println(var);
            String choice = scan.nextLine();                               // Getting User input


            if(choice.equalsIgnoreCase("D")){
                AddDeposit();
                System.out.println("YOU JUST MADE A DEPOSIT");
            }
            else if (choice.equalsIgnoreCase("P")) {
                MakePayment();
                System.out.println("THANK YOU FOR THIS PAYMENT");
            }
            else if (choice.equalsIgnoreCase("L")) {
               while (true) {                                                    //Loop that iterates the Ledger Screen
                   System.out.print(var);
                   System.out.println("WELCOME TO THE LEDGER SCREEN\n");
                   System.out.println("PRESS A TO DISPLAY ALL ENTRIES");
                   System.out.println("PRESS D TO DISPLAY ALL DEPOSITS");
                   System.out.println("PRESS P TO DISPLAY ALL PAYMENTS");
                   System.out.println("PRESS R TO DISPLAY THE REPORT SCREEN");
                   System.out.println("PRESS H TO RETURN TO THE HOME SCREEN");
                   System.out.println(var);
                   String Lchoice = scan.nextLine();
                   if (Lchoice.equalsIgnoreCase("A")) {
                       display_ALLLedger();
                   } else if (Lchoice.equalsIgnoreCase("D")) {
                       display_Deposits();
                   } else if (Lchoice.equalsIgnoreCase("P")) {
                       display_Payments();
                   } else if (Lchoice.equalsIgnoreCase("R")) {
                         while(true){                                             //Loop that iterates the Ledger Screen
                             System.out.print(var);
                             System.out.println("WELCOME TO THE REPORT PAGE\n");
                             System.out.println("PRESS A TO DISPLAY CURRENT MONTH REPORTS");
                             System.out.println("PRESS D TO DISPLAY PREVIOUS MONTH REPORTS");
                             System.out.println("PRESS P TO DISPLAY CURRENT YEAR REPORTS");
                             System.out.println("PRESS Y TO DISPLAY PREVIOUS YEAR REPORTS");
                             System.out.println("PRESS V TO SEARCH FOR REPORT BY VENDOR NAME");
                             System.out.println("PRESS L TO RETURN TO THE LEDGER SCREEN");
                             System.out.print(var);
                             String Rchoice = scan.nextLine();
                             if(Rchoice.equalsIgnoreCase("A")){
                                   monthtodate();
                             }
                             else if(Rchoice.equalsIgnoreCase("D")){
                                   previousMonth();
                             }
                             else if(Rchoice.equalsIgnoreCase("P")){
                                  year_toDate();
                             }
                             else if(Rchoice.equalsIgnoreCase("V")){
                                 VenName();
                             }
                             else if (Rchoice.equalsIgnoreCase("Y")) {
                                  pYear();
                             }
                             else if (Rchoice.equalsIgnoreCase("L")) {
                                 break;
                             }

                         }
                   } else if (Lchoice.equalsIgnoreCase("H")) {
                          break;
                   }
               }
            }
            else if (choice.equalsIgnoreCase("E")) {
                break;
            }
            else{                                                                 // This is an error message prompting the user to enter the correct choice.
                System.out.println("PLEASE ENTER ONE OF THE CHOICES ABOVE");
            }


        }

        System.out.print("THANK YOU ! HAVE A WONDERFUL DAY");



    }
}




/* To be Continued/Fixed
//This method allows the user to do a custom search
public static void CustomSearch() throws IOException {         // Complete the custom search algorithm
    Scanner scan = new Scanner(System.in);

    FileReader theFileWeWantToWorkWith = new FileReader("transaction.csv");
    BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
    String theLine;
    ArrayList<transaction> list = new ArrayList<>();
    ArrayList<transaction> plist = new ArrayList<>();

    // This loop reads the csv file by each line and stores it in an array
    while ((theLine = theFileFromTheHDD.readLine()) != null) {
        String[] linePieces = theLine.split("\\|");
        transaction T = new transaction(linePieces[0], linePieces[1], linePieces[2], linePieces[3], linePieces[4]);
        list.add(T);


            Algorithm to solve this code would consist of
            methods for each filter category. A method that takes an arraylist and filters it then
            returns the filtered array list. Then repeat the same process for each filter category. The
            output for each method should go into the parameter for the next method.


    }
      }

      */