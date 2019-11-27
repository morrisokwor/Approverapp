package co.ke.bsl.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import co.ke.bsl.R;

public class WorkflowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_workflow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Workflow Action");
        getSupportActionBar().setIcon(R.drawable.ic_done_all_black_24dp);
    }
}
