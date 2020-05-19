package com.wzw.classtype;

import com.wzw.classtype.Pets.*;

import java.util.List;

public class PetsUtil {
    public static PetCreator creator = new LiteralPetCreator();
    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static List<Pet> arraylist(int size) {
        return creator.arraylist(size);
    }
}
