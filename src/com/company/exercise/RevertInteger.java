package com.company.exercise;

import java.math.BigDecimal;

public class RevertInteger {

    public int reverse(int x) {
        BigDecimal max = new BigDecimal(Integer.MAX_VALUE);
        BigDecimal min = new BigDecimal(Integer.MIN_VALUE);

        String raw =  String.valueOf(x);
        BigDecimal newVal;
        if (raw.charAt(0) == '-') {
            String reversed = new StringBuilder(raw.substring(1)).reverse().toString();
            newVal = new BigDecimal(reversed).negate();
        } else {
            String reversed = new StringBuilder(raw).reverse().toString();
            newVal = new BigDecimal(reversed);
        }

        if (newVal.compareTo(max) > 0 || newVal.compareTo(min) < 0) {
            return 0;
        } else {
            return newVal.intValue();
        }
    }
}
