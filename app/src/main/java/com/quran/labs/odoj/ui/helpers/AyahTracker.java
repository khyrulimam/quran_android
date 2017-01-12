package com.quran.labs.odoj.ui.helpers;

import com.quran.labs.odoj.widgets.AyahToolBar;

import java.util.Set;

public interface AyahTracker {
  void highlightAyah(int sura, int ayah, HighlightType type, boolean scrollToAyah);
  void highlightAyat(int page, Set<String> ayahKeys, HighlightType type);
  void unHighlightAyah(int sura, int ayah, HighlightType type);
  void unHighlightAyahs(HighlightType type);
  AyahToolBar.AyahToolBarPosition getToolBarPosition(int sura, int ayah,
      int toolBarWidth, int toolBarHeight);
}
