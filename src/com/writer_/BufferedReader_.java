package com.writer_;

public class BufferedReader_ extends Reader_{
    private Reader_ reader_;//属性是Reader_类型

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
//    //想多次读取文件，让方法更灵活
//    public void readFiles(int num){
//        for (int i = 0; i < num; i++) {
//            reader_.readFile();
//        }
//
//    }
//
//    //批量处理字符串
//    public void readStrings(int num){
//        for (int i = 0; i < num; i++) {
//            reader_.readString();
//
//        }
//    }


    @Override
    public void read() {
        reader_.read();
    }
}
