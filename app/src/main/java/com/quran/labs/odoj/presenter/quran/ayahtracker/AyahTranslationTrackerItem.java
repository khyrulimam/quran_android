package com.quran.labs.odoj.presenter.quran.ayahtracker;

import android.support.annotation.NonNull;

import com.quran.labs.odoj.data.QuranInfo;
import com.quran.labs.odoj.ui.helpers.HighlightType;
import com.quran.labs.odoj.widgets.TranslationView;

public class AyahTranslationTrackerItem extends AyahTrackerItem<TranslationView> {

  public AyahTranslationTrackerItem(int page, @NonNull TranslationView ayahView) {
    super(page, ayahView);
  }

  @Override
  boolean onHighlightAyah(int page, int sura, int ayah, HighlightType type, boolean scrollToAyah) {
    if (this.page == page) {
      ayahView.highlightAyah(QuranInfo.getAyahId(sura, ayah));
      return true;
    }
    ayahView.unhighlightAyat();
    return false;
  }

  @Override
  void onUnHighlightAyah(int page, int sura, int ayah, HighlightType type) {
    if (this.page == page) {
      ayahView.unhighlightAyat();
    }
  }

  @Override
  void onUnHighlightAyahType(HighlightType type) {
    ayahView.unhighlightAyat();
  }
}
