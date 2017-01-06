package example.com.simpleappwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConfigurationActivity extends AppCompatActivity {

    int appWidgetId;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        // Find the widget id from the intent.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        setupOnClickListener(R.id.button_submit);
    }

    private void setupOnClickListener(int btnSubmitId) {
        findViewById(btnSubmitId).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                EditText timestampEditText = (EditText) findViewById(R.id.timestamp_format);
                String inputFormat = timestampEditText.getText().toString();

                Context context = ConfigurationActivity.this;

                // Get an instance of the AppWidgetManager by calling
                // getInstance(Context):
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                // Update the App Widget layout
                SimpleAppWidgetProvider.updateAppWidget(context, appWidgetManager, appWidgetId,
                    inputFormat);

                // Create the return Intent, set it with the
                // Activity result, and finish the Activity
                Intent resultValue = new Intent();
                resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
                setResult(RESULT_OK, resultValue);
                finish();
            }
        });
    }
}
