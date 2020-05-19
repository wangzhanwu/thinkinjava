package com.wzw.classtype;

import java.util.ArrayList;
import java.util.List;

import static com.wzw.classtype.Pets.*;
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
      "com.wzw.classtype.Pets$Mutt",
      "com.wzw.classtype.Pets$Pug",
      "com.wzw.classtype.Pets$EgyptianMau",
      "com.wzw.classtype.Pets$Manx",
      "com.wzw.classtype.Pets$Cymrix",
      "com.wzw.classtype.Pets$Rat",
      "com.wzw.classtype.Pets$Mouse",
      "com.wzw.classtype.Pets$Hamster",
    };

    private static void loader() {
        try{
            for (String name : typeNames) {
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        ForNameCreator creator = new ForNameCreator();
        System.out.println(creator.arraylist(20));
    }
}
