package com.example.numbertoword;

import java.util.List;

public class NumberToWordConverter {

    private static final List<String> ONE_TO_NINE = List.of(
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    );

    private static final List<String> TEN_TO_NINETEEN = List.of(
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    );
    private static final List<String> TENS = List.of(
            "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"

    );

    private static final String ZERO = "zero";
    private static final String HUNDRED = "hundred";
    private static final String THOUSAND = "thousand";
    private static final String MILLION = "million";

    public static String convert(int number) {
        if (number == 0) return ZERO;
        else if (number < 10) return ONE_TO_NINE.get(number - 1);
        else if (number < 20) return TEN_TO_NINETEEN.get(number - 10);
        else if (number < 100) {
            return number % 10 == 0
                ? TENS.get((number / 10) - 1)
                : String.join(" ", TENS.get((number / 10) - 1), ONE_TO_NINE.get((number % 10) - 1));}
        else if (number < 1_000) return String.join(" ", ONE_TO_NINE.get((number / 100) - 1), HUNDRED, convert(number % 100));
        else if (number < 1_000_000) return String.join(" ", convert(number / 1_000), THOUSAND, convert(number % 1_000));
        else if (number < 1_000_000_000) return String.join(" ", convert(number / 1_000_000), MILLION, convert(number % 1_000_000));

        return "";
    }
}