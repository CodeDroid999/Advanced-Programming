import Lecture1_adt.*; // Import all classes from Lecture1_adt package to be used in this client code

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

/*
* Client Code for accessing the Lecture1_adt.TransactionInterface.java module
 */
public class Main {

    public static void testTransaction1() {
        Calendar d1 = new GregorianCalendar(); // d1 is an Object [Objects are Reference types]
        Lecture1_adt.Transaction1 t1 = new Lecture1_adt.Transaction1(1000, d1); // amount and d1 are arguments

        System.out.println(t1.toString());
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t1.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t1.getDate().getTime());

        // Please note that the Client Codes can access the data in the class directly through the dot operator
        // This kind of exposure is a threat to both the Representation Independence and Preservation of Invariants
    }

    /** 
     * @return a transaction of same amount as t, one month later
     * This is a PRODUCER of the class Lecture1_adt.Transaction2
     * This code will help demonstrate the Design exposures still present in Transaction2 class
     */
    public static Transaction2 makeNextPayment(Transaction2 t) {
        Calendar d = t.getDate();
        d.add(Calendar.MONTH, 1);
        return new Transaction2(t.getAmount(), d);
    }

    /*
    Testing Transaction2 class
     */
    public static void testTransaction2() {
        Calendar d1 = new GregorianCalendar();
        Lecture1_adt.Transaction2 t = new Lecture1_adt.Transaction2(1000, d1);

        Lecture1_adt.Transaction2 modified_t = makeNextPayment(t);

        System.out.println("\n\nState of the Object T1 After Client Code Tried to Change the Amount");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + modified_t.getDate().getTime());

        System.out.println("\n\nHow does T2 Look Like?????");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + modified_t.getDate().getTime());
    }

    /** 
     * @return a list of 12 monthly payments of identical amounts
     * This code will help demonstrate the Design exposures still present in Transaction3 class
     */
    public static List<Transaction3> makeYearOfPayments(int amount) throws NullPointerException {
        List<Transaction3> listOfTransaction3s = new ArrayList<>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);

        for (int i = 0; i < 12; i++) {
            listOfTransaction3s.add(new Transaction3(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction3s;
    }

    /*
    Testing Transaction3 class
     */
    public static void testTransaction3() {
        List<Transaction3> allPaymentsIn2024 = makeYearOfPayments(1000);

        for (Transaction3 t3 : allPaymentsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t3.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t3.getDate().getTime());
        }
    }

    /** 
     * @return a list of 12 monthly payments of identical amounts
     * This code shows that by judicious copying and defensive programming, we eliminate the exposure in Transaction3
     * As defined in the constructor of Transaction4 class
     */
    public static List<Transaction4> makeYearOfPaymentsFinal(int amount) throws NullPointerException {
        List<Transaction4> listOfTransaction4s = new ArrayList<>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);

        for (int i = 0; i < 12; i++) {
            listOfTransaction4s.add(new Transaction4(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction4s;
    }

    /*
    Testing Transaction4 class
     */
    public static void testTransaction4() {
        List<Transaction4> transactionsIn2024 = makeYearOfPaymentsFinal(1200);

        // Display all the 12 Transactions
        for (Transaction4 transact : transactionsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + transact.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + transact.getDate().getTime());
        }
    }

    public static void main(String[] args) {
        // This is the client code
        // Uncomment the following lines to test the class which you would like to test

        // testTransaction1();
        // testTransaction2();
        // testTransaction3();
        // testTransaction4();
    }
}
