package exceptions;

import passes.SchoolPass;

public class SchoolPassTripFinishedException extends Exception {

    private SchoolPass pass;

    public SchoolPassTripFinishedException(SchoolPass pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "School pass with id: " + pass.getUid() + " has no available trips";
    }

}
