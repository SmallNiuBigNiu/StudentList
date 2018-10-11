package cn.gdcp.studentlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.gdcp.studentlist.Animal;
import cn.gdcp.studentlist.R;

public class MainActivity extends AppCompatActivity {

    private AnimlaAdater animlaAdater;
    private List<Animal> animalList=new ArrayList<Animal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initAnimlData();
        ListView listView=(ListView)findViewById(R.id.lv_view);
        animlaAdater=new AnimlaAdater(getApplication(),R.layout.animal,animalList);
        listView.setAdapter(animlaAdater);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal=animalList.get(i);
                Toast.makeText(getApplication(),animal.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }



    public void addStudent(View v){
        Intent intent=new Intent(getApplicationContext(),AddStudent.class);
        startActivityForResult(intent,1001);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (intent==null){
            return;
        }
            String name = intent.getStringExtra("NAME");
            int age = intent.getIntExtra("AGE", 0);
            int imageId = intent.getIntExtra("IMAGEID", R.drawable.dog1);
            Animal animal = new Animal(name, imageId, age,R.drawable.cha);
            animalList.add(animal);
            animlaAdater.notifyDataSetChanged();
    }


    public void initAnimlData(){
            Animal animal1=new Animal("李一",R.drawable.dog1,18,R.drawable.cha);
            animalList.add(animal1);
            Animal animal2=new Animal("李二",R.drawable.dog2,19,R.drawable.cha);
            animalList.add(animal2);
            Animal animal3=new Animal("李三",R.drawable.dog3,17,R.drawable.cha);
            animalList.add(animal3);
            Animal animal4=new Animal("李四",R.drawable.dog4,20,R.drawable.cha);
            animalList.add(animal4);
            Animal animal5=new Animal("李五",R.drawable.dog5,16,R.drawable.cha);
            animalList.add(animal5);
    }
    public class AnimlaAdater extends ArrayAdapter<Animal>{


        public AnimlaAdater(Context context, int resource, List<Animal> objects) {
            super(context, resource, objects);
        }

        @Override
        public int getCount() {
            return animalList.size();
        }

        @Override
        public Animal getItem(int i) {
            return animalList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convetView, ViewGroup viewGroup) {
            //获取动物实例类
            final Animal animal=getItem(i);
            View view;
            //如果视图为空，创建视图
            if(convetView==null){
                view= LayoutInflater.from(getApplication()).inflate(R.layout.animal,null);
            }else {
                view=convetView;
            }
            //获取view中的数据，一定要从view里面获取
            ImageView animalImage=(ImageView)view.findViewById(R.id.iv_image);
            TextView animalName=(TextView)view.findViewById(R.id.tv_name);
            TextView animalAge=(TextView)view.findViewById(R.id.tv_age);
            ImageView animalDelete=(ImageView)view.findViewById(R.id.iv_delete);
            //给删除功能添加一个监听器
            animalDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(getApplicationContext(),"delete",Toast.LENGTH_SHORT).show();
                    animalList.remove(animal);
                    animlaAdater.notifyDataSetChanged();
                }
            });
            //传入数据
            animalImage.setImageResource(animal.getImageId());
            animalName.setText(animal.getName());
            animalAge.setText(String.valueOf(animal.getAge()));
            animalDelete.setImageResource(R.drawable.cha);
            return view;
        }
    }
}
