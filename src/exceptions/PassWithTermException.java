package exceptions;

import java.time.YearMonth;

public abstract class PassWithTermException extends Exception {
    public abstract int calculateTermOfOverdue();
}
