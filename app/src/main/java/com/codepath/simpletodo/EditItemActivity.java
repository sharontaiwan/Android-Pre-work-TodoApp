package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private EditText etEditedItemText;
    private Integer itemPosInArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        etEditedItemText = (EditText) findViewById(R.id.etMultiEditText);
        String itemText = getIntent().getStringExtra("itemText");
        itemPosInArray = getIntent().getIntExtra("itemPosition", 0);

        etEditedItemText.setText(itemText);
        etEditedItemText.setSelection(itemText.length());
    }

    public void onSaveItem(View view) {
        Intent i = new Intent();
        i.putExtra("itemText", etEditedItemText.getText().toString());
        i.putExtra("itemPosition", itemPosInArray);
        setResult(RESULT_OK, i);
        this.finish();
    }
}
