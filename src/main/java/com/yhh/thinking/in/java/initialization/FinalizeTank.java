package com.yhh.thinking.in.java.initialization;

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

    public static void main(String[] args) {
        new FinalizeTank(true);
        new FinalizeTank(true);
        new FinalizeTank(true);

        System.gc();

        FinalizeTank finalizeTank = new FinalizeTank(true);
        finalizeTank.makeEmpty();
        finalizeTank = null;

        new FinalizeTank(true);
        System.gc();
    }
}
