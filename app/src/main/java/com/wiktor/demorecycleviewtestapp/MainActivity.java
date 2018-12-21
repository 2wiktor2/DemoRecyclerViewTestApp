package com.wiktor.demorecycleviewtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView numbersList;
    private  NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersList = findViewById(R.id.rv_numbers);

// задает то как элементы распределяются в recycleView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // Recycl-у View назначаем LayoutManager
        // Передаваая разные LayoutManager-ы можно поразному отображать элементы списка
        // Сверху\вниз , слева/направо, в виде таблицы
        numbersList.setLayoutManager(layoutManager);

        //Указать RecycleView что мы заренее знаем размер списка
        numbersList.setHasFixedSize(true);

// Создание Adapter-a
        // RecycleView обращается к адаптеру чтобы отображать список
        // Adapter обращается к источнику данных чтобы передать данные в RecycleView
        // Adapter создает ViewHolder - ы и переиспользует их
        // ViewHolder - отдельный элемент списка

        // свяжем recyclerView c Adapter-om
        numbersAdapter = new NumbersAdapter(100);
        numbersList.setAdapter(numbersAdapter);
    }
}
