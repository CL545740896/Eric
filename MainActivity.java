package com.example.eric.multiitemtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.freelib.multiitem.adapter.BaseItemAdapter;
import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.listener.OnItemClickListener;
import com.freelib.multiitem.listener.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 *  RecycleView的使用方法
 *  需要的工具：
 *  主布局中添加RecycleView控件
 *  创建一个Item_的布局
 *  创建一个Item类，类中的属性为Item所需要的属性
 *  创建适配器，为RecycleView设置适配器
 *  创建数据源List<>list
 *  添加数据源list.add(内容)
 *  最后添加数据源到适配器中  adapter.setDataItems(list);
 *
 *  使用：
 *  1、recyclerView.setLayoutManager(new LinearLayoutManager(this)); 设置RecycleView收当前布局管理
 *  2、adapter = new BaseItemAdapter(); //初始化adapter（适配器）
 *  3、adapter.register(Item类名.class, new ItemManager类); //为更多数据源注册ViewHolderManager管理类
    4、recyclerView.setAdapter(adapter); //为RecyclerView设置适配器
    5、list = new ArrayList<>(); //创建数据源
       list.add(0,new ImageTextBean(R.drawable.user, "Jack" ,"今晚去哪里吃饭？")); //添加数据源
       adapter.setDataItems(list); //添加数据源到适配器中！
 *
 */



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button addButton;
    Button delButton;
    RecyclerView recyclerView;
    List<Object> list;
    BaseItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        addButton= (Button) findViewById(R.id.btn_add);
        delButton= (Button) findViewById(R.id.btn_del);
        addButton.setOnClickListener(this);
        delButton.setOnClickListener(this);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //初始化adapter
        adapter = new BaseItemAdapter();
        //为更多数据源注册ViewHolderManager管理类
        adapter.register(ImageTextBean.class, new ImageAndTextManager());
        recyclerView.setAdapter(adapter);

       //组装数据源list
        list = new ArrayList<>();
        list.add(0,new ImageTextBean(R.drawable.user, "Jack" ,"今晚去哪里吃饭？"));
         //为adapter注册数据源list
        adapter.setDataItems(list);
        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            protected void onItemLongClick(BaseViewHolder baseViewHolder) {
                int position=baseViewHolder.getItemPosition()-1;
                baseViewHolder.getItemData();

                Log.d("Position:",""+position);
                Log.d("Name:",""+ baseViewHolder.getItemData());
                Log.d("List:",""+list.get(position));

            }
        });

    }


    @Override
    public void onClick(View v) {
        /**
         *
         * 尾部添加法：
         *int index=adapter.getItemCount();
         * 获取适配器的Item个数，然后在List中添加数据时定位在index
         * 适配器更新数据:adapter.notifyItemInserted(index);
         *
         * 头部添加法：
         * int index=adapter.getItemCount()-1;
         * 获取适配器的Item个数，然后在List中添加数据时定位在index
         * 适配器更新数据:adapter.notifyItemInserted(index);
         */
        switch (v.getId())
        {
            case R.id.btn_add:
                int index=adapter.getItemCount();
                list.add(index,new ImageTextBean(R.drawable.user, "Jack" ,"添加出来的！"));
                adapter.notifyItemInserted(index);
                break;
            case  R.id.btn_del:
                /**
                 * int index1=adapter.getItemCount();
                 * 头部删除：
                 *  list.remove(0);
                 *  adapter.notifyItemRemoved(0);
                 *  尾部删除：
                 *  int index1=adapter.getItemCount()-1;
                 *  list.remove(index1);
                 *  adapter.notifyItemRemoved(index1);
                 */
                  int index1=adapter.getItemCount()-1;
                  list.remove(index1);
                  adapter.notifyItemRemoved(index1);
                break;



        }
    }
}
