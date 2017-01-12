package com.quran.labs.odoj.component.fragment;

import com.quran.labs.odoj.di.QuranPageScope;
import com.quran.labs.odoj.module.fragment.QuranPageModule;
import com.quran.labs.odoj.ui.fragment.QuranPageFragment;
import com.quran.labs.odoj.ui.fragment.TabletFragment;
import com.quran.labs.odoj.ui.fragment.TranslationFragment;

import dagger.Subcomponent;

@QuranPageScope
@Subcomponent(modules = QuranPageModule.class)
public interface QuranPageComponent {
  void inject(QuranPageFragment quranPageFragment);
  void inject(TabletFragment tabletFragment);
  void inject(TranslationFragment translationFragment);

  @Subcomponent.Builder interface Builder {
    Builder withQuranPageModule(QuranPageModule quranPageModule);
    QuranPageComponent build();
  }
}
