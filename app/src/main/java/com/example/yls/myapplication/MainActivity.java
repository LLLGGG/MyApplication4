package com.example.yls.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends AppCompatActivity {
    private Button addbtn, checkbtn,delbtn,updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "1ce1639fda493c75720da200f62d0959");
        first();
//        second();
    }

//    private void second() {
//        checkbtn = (Button) findViewById(R.id.checkbtn);
//        checkbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
//                bmobQuery.getObject("5c2d8a7bbc", new QueryListener<Person>() {
//                    @Override
//                    public void done(Person person, BmobException e) {
//
//                        if (e == null) {
//                            Toast.makeText(MainActivity.this, person.getName() + "   " + person.getAge() + "   " + person.getNumber(), Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "查询失败", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        });
//    }

    private void first() {
        addbtn = (Button) findViewById(R.id.btn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p1 = new Person();
                p1.setName("同学123");
                p1.setAge(22);
                p1.setNumber(002);
                p1.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "添加失败", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        checkbtn = (Button) findViewById(R.id.checkbtn);
        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
                bmobQuery.getObject("5c2d8a7bbc", new QueryListener<Person>() {
                    @Override
                    public void done(Person person, BmobException e) {

                        if (e == null) {
                            Toast.makeText(MainActivity.this, person.getName() + "   " + person.getAge() + "   " + person.getNumber(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "查询失败", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        updatebtn= (Button) findViewById(R.id.updatebtn);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p2 = new Person();
                p2.setName("同学三");
                p2.update("769947676d", new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null){
                            Toast.makeText(MainActivity.this,"更新成功",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"更新失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        delbtn= (Button) findViewById(R.id.delbtn);
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p3 =new Person();
                p3.setObjectId("769947676d");
                p3.delete(new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null) {
                            Toast.makeText(MainActivity.this, "删除成功删除失败", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

}



