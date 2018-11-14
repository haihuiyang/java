package com.yhh.example.exception;

class MyIllegalArgumentExceptions extends IllegalArgumentException {

    private String field;

    public MyIllegalArgumentExceptions(String field) {
        this.field = field;
    }

    public MyIllegalArgumentExceptions(String field, String message) {
        super(message);
        this.field = field;
    }

    @Override
    public String toString() {
        return "field is " + field +
                "; message is " + getMessage();
    }
}
