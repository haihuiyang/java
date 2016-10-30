package com.yhh.example;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class TestLocalDate {
    private Optional<LocalDate> optional = Optional.of(LocalDate.now());

    public static void main(String[] args) {
        TestLocalDate testLocalDate = new TestLocalDate();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(testLocalDate.optional.get().toString());

        System.out.println(simpleDateFormat.format(convert(testLocalDate.optional.get())));
//        System.out.println(simpleDateFormat.format(testLocalDate.optional.get().toString()));
    }

    public static Date convert(LocalDate localDate) {
        if (isNull(localDate)) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(0))).toInstant());
    }

    private static boolean isNull(Object obj) {
        if (Objects.isNull(obj)) {
            return true;
        }
        return false;
    }
}
