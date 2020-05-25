package com.wzw.enums;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.EnumSet;

public class CarWash {
    public enum Cycle {
        UNDERBODY {
            void action(){
                System.out.println("Spraying the underbody");
            }
        },
        WEELWASH{
            void action() {
                System.out.println("Washing the wheels");
            }
        },
        PREWASH{
            void action() {
                System.out.println("Loosing the dirt");
            }
        },
        BASIC{
            void action() {
                System.out.println("The basic wash");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> set = EnumSet.of(Cycle.BASIC, Cycle.PREWASH);
    public void add(Cycle cycle) {
        set.add(cycle);
    }

    public String toString() {
        return set.toString();
    }

    public void washCar() {
        for (Cycle cycle : set) {
            cycle.action();
        }
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);
        carWash.washCar();
    }

}
