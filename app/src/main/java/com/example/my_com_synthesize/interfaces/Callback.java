package com.example.my_com_synthesize.interfaces;

public interface Callback<T> {

    void fail(String msg);

    void success(T t);
}
