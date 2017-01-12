package com.quran.labs.odoj.dao;

public class RecentPage {
  public final int page;
  public final long timestamp;

  public RecentPage(int page, long timestamp) {
    this.page = page;
    this.timestamp = timestamp;
  }
}
