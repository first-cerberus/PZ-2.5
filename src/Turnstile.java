import exceptions.RegularPassNotEnoughMoneyException;
import exceptions.SchoolPassOverdueException;
import exceptions.SchoolPassTripFinishedException;
import exceptions.StudentPassOverdueException;
import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

/** In this class implemented logic of entry permission
 *   @throws SchoolPassOverdueException         If a SchoolPass is overdue.
 *   @throws SchoolPassTripFinishedException    If a SchoolPass has no remaining trips.
 *   @throws StudentPassOverdueException        If a StudentPass is overdue.
 *   @throws RegularPassNotEnoughMoneyException If a RegularPass doesn't have enough money for the fare.
 */
public class Turnstile {
    public void validateEntryPermission(MetroPass pass) throws SchoolPassOverdueException, SchoolPassTripFinishedException,
            StudentPassOverdueException, RegularPassNotEnoughMoneyException {
        if (pass instanceof SchoolPass sp) {
            if (sp.getMonth().isBefore(YearMonth.now())) {
                KyivSmartCard.addProhibition();
                throw new SchoolPassOverdueException((SchoolPass) pass);
            } else if (((SchoolPass) pass).getCountOfTrip() == 0) {
                KyivSmartCard.addProhibition();
                throw new SchoolPassTripFinishedException((SchoolPass) pass);
            } else {
                ((SchoolPass) pass).setCountOfTrip(((SchoolPass) pass).getCountOfTrip() - 1);
                KyivSmartCard.addPermission();
            }
        } else if (pass instanceof StudentPass) {
            if (((StudentPass) pass).getMonth().isBefore(YearMonth.now())) {
                KyivSmartCard.addProhibition();
                throw new StudentPassOverdueException((StudentPass) pass);
            } else {
                KyivSmartCard.addPermission();
            }
        } else if (pass instanceof RegularPass) {
            if (((RegularPass) pass).getAmountOfMoney() < KyivSmartCard.FARE) {
                KyivSmartCard.addProhibition();
                throw new RegularPassNotEnoughMoneyException((RegularPass) pass);
            } else {
                KyivSmartCard.addPermission();
                KyivSmartCard.subtractFare((RegularPass) pass);
            }
        }
    }
}
