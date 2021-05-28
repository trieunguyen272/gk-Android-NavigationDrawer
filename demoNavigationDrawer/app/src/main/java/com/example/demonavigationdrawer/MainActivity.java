package com.example.demonavigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    ListView listview;
    ArrayList<ItemMenu> arrayList;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        actionToolBar();
        actionMenu();
    }

    private void actionMenu() {
        arrayList = new ArrayList<>();
        arrayList.add(new ItemMenu("Import", R.drawable.ic_action_import));
        arrayList.add(new ItemMenu("Gallery", R.drawable.ic_action_gallery));
        arrayList.add(new ItemMenu("Slideshow", R.drawable.ic_action_slideshow));
        arrayList.add(new ItemMenu("Tools", R.drawable.ic_action_tools));
        //khoi tao adapter
        adapter = new MenuAdapter(this, R.layout.dong_item, arrayList);
        listview.setAdapter(adapter);
    }



    private void anhXa() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        drawerlayout = (DrawerLayout) findViewById (R.id.drawerLayout);
        navigationview = (NavigationView) findViewById(R.id.navigationView);
        listview = (ListView) findViewById(R.id.listView);
    }

    private void actionToolBar() {
        setSupportActionBar(toolbar);
        // Loại bỏ tiểu đề mặc định
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Mặc định nếu bạn muốn hiện thị biểu tượng có hình mũi tên như là nút bấm quay trở lại cửa sổ trước
        toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(GravityCompat.START);
            }
            //Để mở Drawer , khi người dùng chạm vào button
        });
    }

}