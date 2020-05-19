package com.wzw.classtype;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.wzw.classtype.Pets.*;
import static com.wzw.util.Print.*;
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {

        public PetCounter() {
            super(initMap(LiteralPetCreator.allTypes, 0));
        }

        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue()+1);
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size());
            sb.append("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                sb.append(pair.getKey().getSimpleName());
                sb.append("=");
                sb.append(pair.getValue());
                sb.append(", ");
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append("}");
            return sb.toString();
        }

        private static Map<Class<? extends Pet>, Integer> initMap(List<Class<? extends Pet>> allTypes, int initialValue) {
            Map<Class<? extends Pet>, Integer> map = new LinkedHashMap<>(allTypes.size());
            for (Class<? extends Pet> clazz : allTypes) {
                map.put(clazz, initialValue);
            }
            return map;
        }
    }

    public static void main(String[] args) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : PetsUtil.arraylist(20)) {
            printnb(pet.getClass().getSimpleName()+" ");
            petCounter.count(pet);
        }
        print();
        printnb(petCounter);
    }
}
