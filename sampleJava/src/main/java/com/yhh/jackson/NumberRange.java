package com.yhh.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@Getter
@ToString
public class NumberRange implements Serializable {
    private final Double start;
    private final Double end;

    @JsonCreator
    @ConstructorProperties({"start", "end"})
    public NumberRange(Double start, Double end) {
        this.start = start;
        this.end = end;
    }
}
