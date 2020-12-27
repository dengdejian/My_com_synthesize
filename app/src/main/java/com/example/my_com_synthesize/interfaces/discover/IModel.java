package com.example.my_com_synthesize.interfaces.discover;

import io.reactivex.disposables.Disposable;

public interface IModel {
    void addDisposable(Disposable disposable);

    void clear();
}
