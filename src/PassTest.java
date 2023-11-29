import exceptions.RegularPassNotEnoughMoneyException;
import exceptions.SchoolPassOverdueException;
import exceptions.SchoolPassTripFinishedException;
import exceptions.StudentPassOverdueException;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

public class PassTest {
    public static void main(String[] args) {
        Turnstile turnstile = new Turnstile();
        var pass = KyivSmartCard.createPass(PassType.SCHOOL_PASS);
        SchoolPass schoolPass = (SchoolPass) pass;
        schoolPass.setMonth(YearMonth.of(2023,11));
        try {
            for (int i = 0; i < 51; i++) {
                turnstile.validateEntryPermission(schoolPass);
            }

        } catch (SchoolPassOverdueException | StudentPassOverdueException | SchoolPassTripFinishedException |
                 RegularPassNotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}
