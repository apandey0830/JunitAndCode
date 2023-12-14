package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FooBarClass {

    public String FooBar(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        List<String> result = processInput(input);
        return printOutput(result);
    }

    private List<String> processInput(String input) {
        String[] values = input.split(",");
        Map<String, Integer> countMap = new HashMap<>();

        return Stream.of(values)
                .map(String::trim)
                .map(trimmedValue -> {
                    int count = countMap.getOrDefault(trimmedValue, 0);
                    countMap.put(trimmedValue, count + 1);
                    return count > 0 ? trimmedValue + "-copy" : trimmedValue;
                })
                .collect(Collectors.toList());
    }

    private String printOutput(List<String> result) {
        String output = result
                .stream()
                .map(this::applyDivisibilityRules)
                .collect(Collectors.joining(","));

        System.out.println(output);
        return output;
    }


    private String applyDivisibilityRules(String value) {
        int intValue=0;
        try {

            String[] parts = value.split("-");

            if (!parts[0].isEmpty()) {
                intValue = Integer.parseInt(parts[0].trim());
            }

            // If there is a negative sign, adjusting the intValue
            if (parts.length >= 2 && parts[0].isEmpty()) {
                intValue = Integer.parseInt(parts[1].trim());
            }

            if (intValue % 3 == 0 && intValue % 5 == 0) {
                return value.contains("-copy") ? "foobar-copy" : "foobar";
            }

            if (intValue % 3 == 0) {
                return value.contains("-copy") ? "foo-copy" : "foo";
            }

            if (intValue % 5 == 0) {
                return value.contains("-copy") ? "bar-copy" : "bar";
            }

            return value;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "\n This input value is not an expected integer: " + value + " \n";
        }
    }


}

