import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * In this class implemented smart card system used for managing various types of passes. It provides methods for creating passes,
 * tracking permissions and prohibitions, and managing financial transactions for RegularPass.
 *
 * @author Riza Seliamiiev
 * @version 1
 * @since 30.11.2023
 */
public class KyivSmartCard {
    /** Count of trip has given by school */
    public static int COUNT_OF_SCHOOL_TRIP_PER_MONTH = 50;
    /** Fare in metro for regular pass */
    public static int FARE = 8;
    /** List of cards of Kyiv metro */
    private static ArrayList<MetroPass> internalCardStorage = new ArrayList<>();
    /** Count of permissions in case enter was allowed */
    private static int countOfPermissions;
    /** Count of permissions in case enter wasn`t allowed */
    private static int countOfProhibitions;
    /** This method create a card and add to the list of cards */
    public static MetroPass createPass(PassType passType) {
        switch (passType) {
            case SCHOOL_PASS -> {
                SchoolPass schoolPass = new SchoolPass(COUNT_OF_SCHOOL_TRIP_PER_MONTH);
                internalCardStorage.add(schoolPass);
                return schoolPass;
            }
            case REGULAR_PASS -> {
                RegularPass regularPass = new RegularPass();
                internalCardStorage.add(regularPass);
                return regularPass;
            }
            case STUDENT_PASS -> {
                StudentPass studentPass =  new StudentPass();
                internalCardStorage.add(studentPass);
                return studentPass;
            }
        }
        return null;
    }
    /** Count a valid permission */
    public static void addPermission() {
        countOfPermissions++;
    }
    /** Count an invalid permission */
    public static void addProhibition() {
        countOfProhibitions++;
    }
    /** Get of count of permission */
    public static int getCountOfPermissions() {
        return countOfPermissions;
    }
    /** Get of count of prohibitions */
    public static int getCountOfProhibitions() {
        return countOfProhibitions;
    }
    /** Get total count of overdue and empty pass */
    public static int getTotalCountOfOverdueAndEmptyPass() {
        return countOfPermissions + countOfProhibitions;
    }
    /** Add money on card */
    public static void addFounds(RegularPass regularPass, int income) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() + income);
    }
    /** Delete money from card */
    public static void subtractFare(RegularPass regularPass) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() - FARE);
    }

}
