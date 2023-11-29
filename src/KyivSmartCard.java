import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class KyivSmartCard {
    public static int COUNT_OF_SCHOOL_TRIP_PER_MONTH = 50;
    public static int FARE = 8;
    private static ArrayList<MetroPass> internalCardStorage = new ArrayList<>();
    private static int countOfPermissions;
    private static int countOfProhibitions;
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
        throw new InputMismatchException();
    }
    public static void addPermission() {
        countOfPermissions++;
    }
    public static void addProhibition() {
        countOfProhibitions++;
    }
    public static int getCountOfPermissions() {
        return countOfPermissions;
    }
    public static int getCountOfProhibitions() {
        return countOfProhibitions;
    }
    public static int getTotalCountOfOverdueAndEmptyPass() {
        return countOfPermissions + countOfProhibitions;
    }
    public static void addFounds(RegularPass regularPass, int income) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() + income);
    }
    public static void subtractFare(RegularPass regularPass) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() - FARE);
    }

}
