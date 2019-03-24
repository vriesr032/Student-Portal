package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddPortalActivity extends AppCompatActivity {

    private EditText Title;
    private EditText Url;
    List<Button> portalList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        final EditText Title = findViewById(R.id.editTextTitle);
        final EditText Url = findViewById(R.id.editTextUrl);


        initCreateButton();
    }

    private void initCreateButton() {
        Button AddButton = findViewById(R.id.AddButton);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = Title.getText().toString();
                final String url = Url.getText().toString();
                final Button button = new Button(AddPortalActivity.this);
                button.setText(title);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AddPortalActivity.this, WebActivity.class);
                        startActivity(intent);
                        WebView webView = findViewById(R.id.webView);
                        webView.loadUrl(url);
                    }
                });
                insertButton(button);
                finish();
            }
        });
    }

    private void insertButton(final Button button){
        portalList.add(button);
        Title.setText("");
        Url.setText("");
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
