package com.quran.labs.odoj.presenter;

public interface Presenter<T> {
  void bind(T what);
  void unbind(T what);
}
