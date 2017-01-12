package com.quran.labs.odoj.component.activity;

import com.quran.labs.odoj.component.fragment.QuranPageComponent;
import com.quran.labs.odoj.di.ActivityScope;
import com.quran.labs.odoj.module.activity.PagerActivityModule;
import com.quran.labs.odoj.ui.PagerActivity;
import com.quran.labs.odoj.ui.fragment.AyahTranslationFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = PagerActivityModule.class)
public interface PagerActivityComponent {
  // subcomponents
  QuranPageComponent.Builder quranPageComponentBuilder();

  void inject(PagerActivity pagerActivity);
  void inject(AyahTranslationFragment ayahTranslationFragment);

  @Subcomponent.Builder interface Builder {
    Builder withPagerActivityModule(PagerActivityModule pagerModule);
    PagerActivityComponent build();
  }
}
