package com.quran.labs.odoj.util;

import com.quran.labs.odoj.R;
import com.quran.labs.odoj.common.QuranAyah;
import com.quran.labs.odoj.data.QuranInfo;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.widget.Toast;

import java.util.List;

public class ShareUtil {

  public static void copyVerses(Activity activity, List<QuranAyah> verses) {
    String text = getShareText(activity, verses);
    ClipboardManager cm = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData clip = ClipData.newPlainText(activity.getString(R.string.app_name), text);
    cm.setPrimaryClip(clip);
    Toast.makeText(activity, activity.getString(R.string.ayah_copied_popup),
        Toast.LENGTH_SHORT).show();
  }

  public static void shareVerses(Activity activity, List<QuranAyah> verses) {
    String text = getShareText(activity, verses);
    shareViaIntent(activity, text, R.string.share_ayah_text);
  }

  public static void shareViaIntent(Activity activity, String text, @StringRes int titleResId) {
    final Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_TEXT, text);
    activity.startActivity(Intent.createChooser(intent, activity.getString(titleResId)));
  }

  private static String getShareText(Activity activity, List<QuranAyah> verses) {
    final int size = verses.size();

    StringBuilder sb = new StringBuilder("(");
    for (int i = 0; i < size; i++) {
      sb.append(verses.get(i).getText());
      if (i + 1 < size) {
        sb.append(" * ");
      }
    }

    // append ) and a new line after last ayah
    sb.append(")\n");
    // append [ before sura label
    sb.append("[");

    final QuranAyah firstAyah = verses.get(0);
    sb.append(QuranInfo.getSuraName(activity, firstAyah.getSura(), true));
    sb.append(" ");
    sb.append(firstAyah.getAyah());
    if (size > 1) {
      final QuranAyah lastAyah = verses.get(size - 1);
      sb.append(" - ");
      if (firstAyah.getSura() != lastAyah.getSura()) {
        sb.append(QuranInfo.getSuraName(activity, lastAyah.getSura(), true));
        sb.append(" ");
      }
      sb.append(lastAyah.getAyah());
    }
    // close sura label and append two new lines
    sb.append("]\n\n");

    sb.append(activity.getString(R.string.via_string));
    return sb.toString();
  }
}
