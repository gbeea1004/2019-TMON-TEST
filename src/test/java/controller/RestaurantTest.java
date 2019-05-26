package controller;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTest {
    @Test
    public void testCase_1() {
        Restaurant restaurant = new Restaurant();
        assertThat(restaurant.open(12, 3, 2, 10)).isEqualTo(99999);
    }

    @Test
    public void testCase_2() {
        Restaurant restaurant = new Restaurant();
        assertThat(restaurant.open(30, 2, 1, 7)).isEqualTo(99999);
    }
}