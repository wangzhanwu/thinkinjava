package com.wzw.classtype;

import static com.wzw.classtype.Pets.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random random = new Random(47);

    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet() {
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public List<Pet> arraylist(int size) {
        List<Pet> list = new ArrayList<>(size);
        Collections.addAll(list, createArray(size));
        return list;
    }
}
