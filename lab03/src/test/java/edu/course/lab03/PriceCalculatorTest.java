package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {
    @Test
    void allowsReplacingDiscountPolicy() {
        DiscountPolicy noDiscount = new NoDiscount();
        DiscountPolicy percentDiscount = new PercentDiscount(20);

        PriceCalculator withoutDiscount = new PriceCalculator(noDiscount);
        PriceCalculator withDiscount = new PriceCalculator(percentDiscount);

        assertEquals(100.0, withoutDiscount.calculate(100.0), 0.000001);
        assertEquals(80.0, withDiscount.calculate(100.0), 0.000001);
    }
}
