package com.solvd.ebay.utils;


public class PriceUtils {
    public static Double extractPriceAsDouble(String priceString) {
        String cleaned = priceString.replaceAll("[^0-9.]", "");
        return Double.parseDouble(cleaned);
    }
    
    public static Double[] extractPriceRange(String priceRange) {
        if (!priceRange.contains("to")) {
            Double price = extractPriceAsDouble(priceRange);
            return new Double[]{price, price};
        }
        String[] prices = priceRange.split("to");
        Double minPrice = extractPriceAsDouble(prices[0]);
        Double maxPrice = extractPriceAsDouble(prices[1]);
        return new Double[]{minPrice, maxPrice};
    }
}
