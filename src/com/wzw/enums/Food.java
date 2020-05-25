package com.wzw.enums;

public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI;
    }

    enum Dessert implements Food {
        TIRAMISU, BLACK_FOREST_CAKE, FRUIT;
    }

    enum Coffee implements Food{
        BLACK_COFFEE, DECAF_COFFEE, LATTE;
    }

    public static void main(String[] args) {
        Food food = Coffee.LATTE;
    }
}
