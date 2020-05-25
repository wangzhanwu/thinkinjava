package com.wzw.enums;

import com.wzw.util.Enums;

public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    private Meal2(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

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

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, LATTE;
        }
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Meal2 meal2 : Meal2.values()) {
                Food food = meal2.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
