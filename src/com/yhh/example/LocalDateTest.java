package com.yhh.example;

import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;

public class LocalDateTest {

    @Test
    public void testFormat() {
        LocalDate now = LocalDate.now();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        PrintUtils.println("before format : " + now);
        PrintUtils.println("after format : " + simpleDateFormat.format(convertLocalDateToDate(now)));

        /*
        result:
            before format : 2017-08-20
            after format : 08/20/2017
         */
    }

    private Date convertLocalDateToDate(LocalDate localDate) {
        if (isNull(localDate)) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(0))).toInstant());
    }

    private boolean isNull(Object obj) {
        if (Objects.isNull(obj)) {
            return true;
        }
        return false;
    }
}
