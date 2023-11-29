package exceptions;

import passes.StudentPass;

import java.time.YearMonth;

public class StudentPassOverdueException extends PassWithTermException {
    private StudentPass pass;

    public StudentPassOverdueException(StudentPass pass) {
        this.pass = pass;
    }

    @Override
    public int calculateTermOfOverdue() {
        return (YearMonth.now().getMonth().minus(pass.getMonth().getMonthValue())).getValue();
    }

    @Override
    public String toString() {
        return "Student pass was overdue " + calculateTermOfOverdue() + " month ago";
    }
}
