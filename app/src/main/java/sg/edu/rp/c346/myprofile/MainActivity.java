package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rbGender;
    CheckBox ckbLike;

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strName);
        prefEdit.commit();

        String strgpa = etGPA.getText().toString();
        Float strGPA = Float.parseFloat(strgpa);
        SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit2 = prefs2.edit();
        prefEdit2.putFloat("gpa",strGPA);
        prefEdit2.commit();

        int gender = rbGender.getCheckedRadioButtonId();
        SharedPreferences prefs3 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit3 = prefs3.edit();
        prefEdit3.putInt("gender",gender);
        prefEdit3.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strName = prefs.getString("name","John");

        etName.setText(strName);


        SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(this);
        Float strgpa = prefs2.getFloat("gpa", 0);

        etGPA.setText(strgpa.toString());

        SharedPreferences prefs3 = PreferenceManager.getDefaultSharedPreferences(this);
        int gender = prefs3.getInt("gender", 0);
        rbGender.check(gender);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=(EditText)findViewById(R.id.editTextName);
        etGPA=(EditText)findViewById(R.id.editTextGPA);
        rbGender=(RadioGroup) findViewById(R.id.RadioGroupGender);
        ckbLike=(CheckBox) findViewById(R.id.checkBoxLikeProgramming);
    }
}
