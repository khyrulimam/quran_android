package com.quran.labs.odoj.module.activity;

import com.quran.labs.odoj.di.ActivityScope;
import com.quran.labs.odoj.ui.PagerActivity;
import com.quran.labs.odoj.ui.helpers.AyahSelectedListener;
import com.quran.labs.odoj.util.QuranScreenInfo;
import com.quran.labs.odoj.util.QuranUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class PagerActivityModule {
  private final PagerActivity pagerActivity;

  public PagerActivityModule(PagerActivity pagerActivity) {
    this.pagerActivity = pagerActivity;
  }

  @Provides
  AyahSelectedListener provideAyahSelectedListener() {
    return this.pagerActivity;
  }

  @Provides
  @ActivityScope
  String provideImageWidth(QuranScreenInfo screenInfo) {
    return QuranUtils.isDualPages(pagerActivity, screenInfo) ?
        screenInfo.getTabletWidthParam() : screenInfo.getWidthParam();
  }
}
