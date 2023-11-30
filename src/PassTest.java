import exceptions.RegularPassNotEnoughMoneyException;
import exceptions.SchoolPassOverdueException;
import exceptions.SchoolPassTripFinishedException;
import exceptions.StudentPassOverdueException;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

/**
 * The PassTest class is a Java program designed to test the functionality of the Turnstile class
 * using a SchoolPass object. It demonstrates the creation of a KyivSmartCard, setting its properties,
 * and then attempting to validate entry permissions through a turnstile multiple times.
 */
public class PassTest {
    public static void main(String[] args) {
        Turnstile turnstile = new Turnstile();
        var pass = KyivSmartCard.createPass(PassType.REGULAR_PASS);
        RegularPass regularPass = (RegularPass) pass;
        regularPass.setAmountOfMoney(12);
        try {
            turnstile.validateEntryPermission(regularPass);
            System.out.println(KyivSmartCard.getCountOfPermissions());
            turnstile.validateEntryPermission(regularPass);
        } catch (SchoolPassOverdueException | StudentPassOverdueException | SchoolPassTripFinishedException |
                 RegularPassNotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}
