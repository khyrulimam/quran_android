package com.quran.labs.odoj.ui.util;

import android.view.MotionEvent;

import com.quran.labs.odoj.ui.helpers.AyahSelectedListener;

public interface PageController {
  boolean handleTouchEvent(MotionEvent event, AyahSelectedListener.EventType eventType, int page);
  void handleRetryClicked();
  void onScrollChanged(int x, int y, int oldx, int oldy);
}
