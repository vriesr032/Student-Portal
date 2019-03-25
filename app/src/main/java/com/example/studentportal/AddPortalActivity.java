package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddPortalActivity extends AppCompatActivity {

    private EditText Title;
    private EditText Url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        Title = findViewById(R.id.editTextTitle);
        Url = findViewById(R.id.editTextUrl);


        initCreateButton();
    }

    private void initCreateButton() {
        Button AddButton = findViewById(R.id.AddButton);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = Title.getText().toString();
                final String url = Url.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("title", title);
                intent.putExtra("url", url);
                setResult(Activity.RESULT_OK, intent);
                Title.setText("");
                Url.setText("");
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_portal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_back) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
