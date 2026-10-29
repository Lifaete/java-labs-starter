package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NoDiscountTest {
    @Test
    void returnsOriginalPrice() {
        DiscountPolicy discount = new NoDiscount();
        assertEquals(100.0, discount.apply(100.0), 0.000001);
    }

    @Test
    void rejectsNegativePrice() {
        DiscountPolicy discount = new NoDiscount();
        assertThrows(IllegalArgumentException.class, () -> discount.apply(-1));
    }
}
