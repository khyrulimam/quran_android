package com.quran.labs.odoj.model.bookmark;

import com.quran.labs.odoj.dao.Tag;
import com.quran.labs.odoj.ui.helpers.QuranRow;

import java.util.List;
import java.util.Map;

public class BookmarkResult {

  public final List<QuranRow> rows;
  public final Map<Long, Tag> tagMap;

  public BookmarkResult(List<QuranRow> rows, Map<Long, Tag> tagMap) {
    this.rows = rows;
    this.tagMap = tagMap;
  }
}
