package com.wzw.enums;

public enum MoneyEnum {
    ONE_YUAN, FIVE_YUAN, TEN_YUAN, TWENTY_YUAN, FIFTY_YUAN, ONE_HUNDRED_YUAN;

}
class Test {
    public static void main(String[] args) {
        for (MoneyEnum me : MoneyEnum.values()) {
            System.out.println(me.toString() + ", " + me.ordinal());
        }
    }
}
