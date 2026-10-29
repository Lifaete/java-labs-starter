package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PercentDiscountTest {
    @Test
    void appliesTwentyPercentDiscount() {
        DiscountPolicy discount = new PercentDiscount(20);
        assertEquals(80.0, discount.apply(100.0), 0.000001);
    }

    @Test
    void rejectsNegativePercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-1));
    }

    @Test
    void rejectsPercentAboveOneHundred() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(101));
    }

    @Test
    void rejectsNegativePrice() {
        PercentDiscount discount = new PercentDiscount(20);
        assertThrows(IllegalArgumentException.class, () -> discount.apply(-1));
    }
}
