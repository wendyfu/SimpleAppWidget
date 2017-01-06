package example.com.simpleappwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class SimpleAppWidgetProvider extends AppWidgetProvider {

    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
        int appWidgetId, String text) {
        RemoteViews views =
            new RemoteViews(context.getPackageName(), R.layout.layout_simple_appwidget);
        views.setTextViewText(R.id.textview, text);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
