package com.quran.labs.odoj.component.application;

import com.quran.labs.odoj.QuranImportActivity;
import com.quran.labs.odoj.component.activity.PagerActivityComponent;
import com.quran.labs.odoj.module.application.ApplicationModule;
import com.quran.labs.odoj.module.application.DatabaseModule;
import com.quran.labs.odoj.module.application.NetworkModule;
import com.quran.labs.odoj.service.QuranDownloadService;
import com.quran.labs.odoj.ui.QuranActivity;
import com.quran.labs.odoj.ui.TranslationManagerActivity;
import com.quran.labs.odoj.ui.fragment.AddTagDialog;
import com.quran.labs.odoj.ui.fragment.BookmarksFragment;
import com.quran.labs.odoj.ui.fragment.QuranAdvancedSettingsFragment;
import com.quran.labs.odoj.ui.fragment.QuranSettingsFragment;
import com.quran.labs.odoj.ui.fragment.TagBookmarkDialog;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DatabaseModule.class, NetworkModule.class } )
public interface ApplicationComponent {
  // subcomponents
  PagerActivityComponent.Builder pagerActivityComponentBuilder();

  // services
  void inject(QuranDownloadService quranDownloadService);

  // activities
  void inject(QuranActivity quranActivity);
  void inject(QuranImportActivity quranImportActivity);

  // fragments
  void inject(BookmarksFragment bookmarksFragment);
  void inject(QuranSettingsFragment fragment);
  void inject(TranslationManagerActivity translationManagerActivity);
  void inject(QuranAdvancedSettingsFragment quranAdvancedSettingsFragment);

  // dialogs
  void inject(TagBookmarkDialog tagBookmarkDialog);
  void inject(AddTagDialog addTagDialog);
}
