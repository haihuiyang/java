package com.yhh.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class NumberRangeTest {

    @Test
    public void name() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        NumberRange numberRange = mapper.readValue("{\"start\":0.1,\"end\":0.2}", NumberRange.class);
        System.out.println(numberRange);
    }
}
