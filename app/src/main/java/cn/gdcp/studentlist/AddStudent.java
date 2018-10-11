package cn.gdcp.studentlist;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddStudent extends AppCompatActivity {
    private EditText et_name;
    private EditText et_age;
    private RadioButton rb_btn1;
    private RadioButton rb_btn2;
    private RadioButton rb_btn3;
    private RadioButton rb_btn4;
    private RadioButton rb_btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        setTitle("添加学生");
        et_name=(EditText)findViewById(R.id.et_name);
        et_age=(EditText)findViewById(R.id.et_age);
    }
    public void add(View v){
        String name=et_name.getText().toString().trim();
        int age= Integer.parseInt(et_age.getText().toString().trim());
        int imageId=R.drawable.dog1;
        rb_btn1=(RadioButton)findViewById(R.id.ab_btn1);
        rb_btn2=(RadioButton)findViewById(R.id.ab_btn2);
        rb_btn3=(RadioButton)findViewById(R.id.ab_btn3);
        rb_btn4=(RadioButton)findViewById(R.id.ab_btn4);
        rb_btn5=(RadioButton)findViewById(R.id.ab_btn5);
        if(rb_btn1.isChecked()){
            imageId=R.drawable.dog1;
        }else if(rb_btn2.isChecked()){
            imageId=R.drawable.dog2;
        }else if(rb_btn3.isChecked()){
            imageId=R.drawable.dog3;
        }else if(rb_btn4.isChecked()){
            imageId=R.drawable.dog4;
        }else if(rb_btn5.isChecked()){
            imageId=R.drawable.dog5;
        }
        Intent intent=new Intent();
        intent.putExtra("NAME",name);
        intent.putExtra("AGE",age);
        intent.putExtra("IMAGEID",imageId);
        setResult(2001,intent);
        finish();
    }
}
