package edu.auburn.comp3710.assignment3note;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int numberOflist;
    Button  btnSave;

    EditText txtId, txtContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtId = findViewById(R.id.txtID);
        txtContent = findViewById(R.id.txtContent);


        btnSave = findViewById(R.id.btnSave);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOflist++;
                NoteModel note = new NoteModel();
                note.id = txtId.getText().toString();
                note.content = note.id;





                SharedPreferences pref = getPreferences(0);
                SharedPreferences.Editor editor = pref.edit();

                String json = note.toJson();
                Log.i("note.json", json);
                note.fromJson(json);


                editor.putString(note.id, json);
                editor.commit();
                txtId.setText((note.id));
                txtContent.setText(txtContent.getText().toString() + numberOflist + ". " + note.content + "\n");



            }
        });

    }
}
