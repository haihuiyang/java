package com.yhh.example;

public class Singleton {

    private static volatile Singleton instance;

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }


//    Map configOptions;
//    char[] configText;
//    //此变量必须定义为 volatile
//    volatile boolean initialized = false;
//
//    //假设以下代码在线程 A 中运行
//    //模拟读取配置信息, 当读取完成后将 initialized 设置为 true 以告知其他线程配置可用
//    configOptions = new HashMap();
//    configText = readConfigFile(fileName);
//    processConfigOptions(configText, configOptions);
//    initialized = true;
//
//
//
//    //假设以下代码在线程 B 中运行
//    //等待 initialized 为 true, 代表线程 A 已经把配置信息初始化完成
//    while(!initialized) {
//        sleep();
//    }
//    //使用线程 A 中初始化好的配置信息
//    doSomethingWithConfig();


}


//class T {
//    volatile boolean shutdownRequested;
//
//    public void shutDown() {
//        shutdownRequested = true;
//    }
//
//    public void doWork() {
//        while (!shutdownRequested) {
//            //do stuff
//        }
//    }
//}
