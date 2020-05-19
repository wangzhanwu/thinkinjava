package com.wzw.classtype;

import java.util.HashMap;

import static com.wzw.classtype.Pets.*;
import static com.wzw.util.Print.*;
public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator petCreator) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : petCreator.arraylist(10)) {
            printnb(pet.getClass().getSimpleName()+" ");
            if (pet instanceof Pet) {
                petCounter.count("Pet");
            }
            if (pet instanceof Dog) {
                petCounter.count("Dog");
            }
            if(pet instanceof Mutt) {
                petCounter.count("Mutt");
            }
            if (pet instanceof Pug) {
                petCounter.count("Pug");
            }
            if(pet instanceof Cat) {
                petCounter.count("Cat");
            }
            if (pet instanceof Manx) {
                petCounter.count("Manx");
            }
            if (pet instanceof EgyptianMau) {
                petCounter.count("EgyptianMau");
            }
            if (pet instanceof Cymrix) {
                petCounter.count("Cymrix");
            }
            if (pet instanceof Rodent) {
                petCounter.count("Rodent");
            }
            if (pet instanceof Rat) {
                petCounter.count("Rat");
            }
            if (pet instanceof Mouse) {
                petCounter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                petCounter.count("Hamster");
            }
        }
        print();
        print(petCounter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
