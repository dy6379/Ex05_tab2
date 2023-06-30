package com.busanit.ex05_tab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "첫번째 탭 선택됨",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
                        return true;
                    case R.id.tab2:
                            Toast.makeText(getApplicationContext(),"두번째 탭 선택됨",Toast.LENGTH_SHORT).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
                            return true;
                    case R.id.tab3:
                                Toast.makeText(getApplicationContext(),"세번째 탭 선택됨",Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
                }
                return false;
            }
        });

    }
}