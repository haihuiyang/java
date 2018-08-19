package com.yhh.example.syntactic.sugar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WithResourse {

    public void with_resourse_test() {
        try (OutputStream os = new FileOutputStream("filePath")) {
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void with_resourse_test_old() {
//        OutputStream os = null;
//        try {
//            os = new FileOutputStream("filePath");
//            os.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}
