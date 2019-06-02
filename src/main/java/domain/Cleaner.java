package domain;

public class Cleaner extends Person {
    private static final int CLEANING_TIME = 3;

    Cleaner(int proficiency) {
        super(CLEANING_TIME, proficiency);
    }
}
