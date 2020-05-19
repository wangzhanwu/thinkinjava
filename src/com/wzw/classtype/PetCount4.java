package com.wzw.classtype;
import static com.wzw.classtype.Pets.*;
import static com.wzw.util.Print.*;
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : PetsUtil.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
}
