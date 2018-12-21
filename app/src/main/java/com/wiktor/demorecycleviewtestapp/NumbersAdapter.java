package com.wiktor.demorecycleviewtestapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// класс Adapter является вложенным внутри класса RecyclerView
// передаем в качестве параметра класс нашего NumberViewHоlder-а
public class NumbersAdapter extends RecyclerView.Adapter <NumbersAdapter.NumberViewHоlder> {

    // создать статическое поле
    private static int viewHolderCount; // здесь будет отсчитываться колличество ViewHolder-ов в списке

    private int numberItems; // Здесь хранится колличество элементов списка

    // создать конструктор
    public NumbersAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        viewHolderCount = 0;
    }


    @NonNull
    @Override
    // в этом методе создаются новые ViewHоlder-ы
    // ViewGroup viewGroup - собственно сам
    // RecyclerView из XML поставляется в качестве аргумента в метод onCreateViewHolder
    //todo В уроке вместо  ViewGroup viewGroup, int i написано ViewGroup parent, int viewType

    public NumberViewHоlder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext(); // получим контекст RecyclerView
        // найти элемент списка.
        int layoutIdForListItem = R.layout.number_list_item;// нашли XML - фаил

        // инфлэйтер
        // в данном случае контекстом будет являться наш RecyclerView
        LayoutInflater inflater = LayoutInflater.from(context);

        // Создадим новый элемент списка
        // поместить то что вернет инфлэйтер в переменную класса view
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        // обернём созданный объект во Вьюхолдер
        NumberViewHоlder viewHоlder = new NumberViewHоlder(view);

        viewHоlder.viewHolderIndex.setText("ViewHolder index" + viewHolderCount);
        viewHolderCount++;

        return viewHоlder;

    }

    @Override
    // В этом методе меняем значения созданных  ViewHоlder-ов
    public void onBindViewHolder(@NonNull NumberViewHоlder numberViewHоlder, int i) {
        numberViewHоlder.bind(i);
    }

    @Override
    // Возвращает общее колличество элементов в списке
    public int getItemCount() {
        return numberItems;
    }

    // Создать абстрактный класс, унаследовать от ViewHolder
    // ViewHolder - абстрактный класс который находится в классе RecyclerView
    class NumberViewHоlder extends RecyclerView.ViewHolder {

        // добавить поля
        TextView listItemNumberView;
        TextView viewHolderIndex;

        // реализовать конструтктор из класса ViewHolder который передает родительскому конструктору (ViewHolder), то что было передано в качестве аргуметов
        // NumberViewHоlder - это обертка для элемента списка
        // Когда создается новый элемент списка или объект (из number_list_item.xml) оборачивается во вьюхолер. чтобы потом его заново использовать


        // принимаем itemView который сгенерирован из number_list_item.xml т.е. сгенерируем java-объект и передадим в качестве аргумента во вьюхолдер
        // вьюхолдер будет оборачивать java-объект
        public NumberViewHоlder(@NonNull View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.tv_number_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);
        }

        // создать метод bind
        //  в нем в listItemNumberView будем менять текст
        // в качестве аргумента передаем (int listIndex)
        // переводим целое число в строку с помощью метода valueOf
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));

        }
    }
}
