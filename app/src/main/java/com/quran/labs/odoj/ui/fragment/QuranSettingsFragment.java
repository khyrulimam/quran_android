package com.quran.labs.odoj.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import com.quran.labs.odoj.QuranAdvancedPreferenceActivity;
import com.quran.labs.odoj.QuranApplication;
import com.quran.labs.odoj.QuranPreferenceActivity;
import com.quran.labs.odoj.R;
import com.quran.labs.odoj.data.Constants;
import com.quran.labs.odoj.model.bookmark.BookmarkImportExportModel;
import com.quran.labs.odoj.ui.AudioManagerActivity;
import com.quran.labs.odoj.ui.TranslationManagerActivity;
import com.quran.labs.odoj.util.QuranScreenInfo;

import javax.inject.Inject;

public class QuranSettingsFragment extends PreferenceFragment implements
    SharedPreferences.OnSharedPreferenceChangeListener {
  @Inject BookmarkImportExportModel bookmarkImportExportModel;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.quran_preferences);

    final Context context = getActivity();
    Context mAppContext = context.getApplicationContext();

    // field injection
    ((QuranApplication) mAppContext).getApplicationComponent().inject(this);

    // remove the tablet mode preference if it doesn't exist
    if (!QuranScreenInfo.getOrMakeInstance(context).isTablet(context)) {
      Preference tabletModePreference =
          findPreference(Constants.PREF_TABLET_ENABLED);
      PreferenceCategory category =
          (PreferenceCategory) findPreference(Constants.PREF_DISPLAY_CATEGORY);
      category.removePreference(tabletModePreference);
    }

    // handle translation manager click
    final Preference translationPref = findPreference(Constants.PREF_TRANSLATION_MANAGER);
    translationPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
      @Override
      public boolean onPreferenceClick(Preference preference) {
        startActivity(new Intent(getActivity(), TranslationManagerActivity.class));
        return true;
      }
    });

    // handle audio manager click
    final Preference audioManagerPref = findPreference(Constants.PREF_AUDIO_MANAGER);
    audioManagerPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
      @Override
      public boolean onPreferenceClick(Preference preference) {
        startActivity(new Intent(getActivity(), AudioManagerActivity.class));
        return true;
      }
    });

  }

  @Override
  public void onResume() {
    super.onResume();
    getPreferenceScreen().getSharedPreferences()
        .registerOnSharedPreferenceChangeListener(this);
  }

  @Override
  public void onPause() {
    getPreferenceScreen().getSharedPreferences()
        .unregisterOnSharedPreferenceChangeListener(this);
    super.onPause();
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
                                        String key) {
    if (key.equals(Constants.PREF_USE_ARABIC_NAMES)) {
      final Context context = getActivity();
      if (context instanceof QuranPreferenceActivity) {
        ((QuranPreferenceActivity) context).restartActivity();
      }
    }
  }

  @Override
  public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
    final String key = preference.getKey();
    if ("key_prefs_advanced".equals(key)) {
      Intent intent = new Intent(getActivity(), QuranAdvancedPreferenceActivity.class);
      startActivity(intent);
      return true;
    }

    return super.onPreferenceTreeClick(preferenceScreen, preference);
  }
}
