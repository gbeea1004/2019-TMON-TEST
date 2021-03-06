package controller;

import domain.Cleaners;
import domain.Cooks;
import domain.MeasureTime;
import domain.Tables;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTest {

    private Restaurant restaurant(int measureTime, int countOfCook, int cookProficiency, int countOfCleaner, int cleanerProficiency, int countOfTable) {
        return new Restaurant(new MeasureTime(measureTime), new Cooks(countOfCook, cookProficiency), new Cleaners(countOfCleaner, cleanerProficiency), new Tables(countOfTable));
    }

    @Test
    public void testCase_1() {
        Restaurant restaurant = restaurant(1, 1, 0, 1, 0, 1);
        assertThat(restaurant.open()).isEqualTo(3);
    }

    @Test
    public void testCase_2() {
        Restaurant restaurant = restaurant(1, 2, 0, 2, 0, 2);
        assertThat(restaurant.open()).isEqualTo(6);
    }
}