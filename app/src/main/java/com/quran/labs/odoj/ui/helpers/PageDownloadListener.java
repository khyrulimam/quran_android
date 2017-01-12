package com.quran.labs.odoj.ui.helpers;

import android.graphics.drawable.BitmapDrawable;

import com.quran.labs.odoj.common.Response;

public interface PageDownloadListener {
  void onLoadImageResponse(BitmapDrawable drawable, Response response);
}
