package domain;

public class Cook extends Person {
    private static final int COOKING_TIME = 4;

    Cook(int proficiency) {
        super(COOKING_TIME, proficiency);
    }
}
