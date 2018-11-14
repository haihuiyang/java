package com.yhh.thinking.in.java.initialization;

import java.util.concurrent.TimeUnit;

public class FinalizeTank {

    private boolean isFilled;

    public FinalizeTank(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override
    protected void finalize() {
        if (isFilled) {
            System.out.println("Error : object is being used.");
        } else {
            System.out.println("object is empty, can be clean up.");
        }
    }

    public void makeEmpty() {
        isFilled = false;
    }

    public static void main(String[] args) throws InterruptedException {
        new FinalizeTank(true);
        new FinalizeTank(true);
        new FinalizeTank(true);

        System.gc();

        FinalizeTank finalizeTank = new FinalizeTank(true);
        finalizeTank.makeEmpty();
        finalizeTank = null;

        new FinalizeTank(true);
        System.gc();

        TimeUnit.SECONDS.sleep(2);

        /*
        output:
            Error : object is being used.
            Error : object is being used.
            Error : object is being used.
            object is empty, can be clean up.
            Error : object is being used.
         or:
            object is empty, can be clean up.
            Error : object is being used.
            Error : object is being used.
            Error : object is being used.
            Error : object is being used.
         => gc()的顺序是不定的
         */
    }
}
