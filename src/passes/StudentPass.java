package passes;

import java.time.Year;
import java.time.YearMonth;

public class StudentPass extends MetroPass {
    private YearMonth month;

    public StudentPass(YearMonth month) {
        this.month = month;
    }

    public StudentPass() {
    }

    public YearMonth getMonth() {
        return month;
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }
}
