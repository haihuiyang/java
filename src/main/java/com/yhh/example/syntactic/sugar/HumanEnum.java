package com.yhh.example.syntactic.sugar;

public enum HumanEnum {
    MAN, WOMAN
}


// 反编译出来大概是这样子的:
//public final class HumanEnum extends Enum<HumanEnum> {
//
//    public static final HumanEnum MAN;
//    public static final HumanEnum HUMAN;
//
//    private static final HumanEnum $VALUES[];
//
//    static {
//        MAN = new HumanEnum("MAN", 0);
//        HUMAN = new HumanEnum("HUMAN", 1);
//        $VALUES = (new HumanEnum[]{
//                MAN, HUMAN
//        });
//    }
//
//    private HumanEnum(String name, int original) {
//        super(name, original);
//    }
//
//    public static HumanEnum[] values() {
//        return (HumanEnum[]) $VALUES.clone();
//    }
//
//    public static HumanEnum valueOf(String name) {
//        return (HumanEnum) Enum.valueOf(HumanEnum.class, name);
//    }
//}