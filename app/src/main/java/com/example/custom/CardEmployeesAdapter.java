package com.example.custom;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CardEmployeesAdapter extends
        RecyclerView.Adapter<CardEmployeesAdapter.ViewHolder> {
    private String[] captions; //названия услуг
    private String[] descriptions; //названия услуг
    private int[] imageIds; //картинки услуг
    private int numberEmployee;
    private CardView mainCardView;
    private Button button_call, button_letter;

    public CardEmployeesAdapter(String[] captions, String descriptions[],int[] imageIds){ //конструктор адаптера - должен содержать услуги и их фото
        this.captions = captions;
        this.descriptions = descriptions;
        this.imageIds = imageIds;
    }

    @Override
    public void onBindViewHolder(CardEmployeesAdapter.ViewHolder holder, int position){ //этот метод распределяет карточки по местам и заполняет их вьюшки
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.card_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);

        TextView name = cardView.findViewById(R.id.card_title);
        name.setText(captions[position]);

        TextView descr = cardView.findViewById(R.id.card_description);
        descr.setText(descriptions[position]);

        numberEmployee = position;
        mainCardView = cardView;

        final Intent[] intent = {null};
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_call:
                        intent[0] = new Intent(Intent.ACTION_DIAL, Uri.parse(Employee.employees[position].getPhoneNumber()));
                        mainCardView.getContext().startActivity(intent[0]);
                        break;
                    case R.id.button_letter:
                        intent[0] = new Intent(Intent.ACTION_SEND);
                        intent[0].setType("plain/text");
                        intent[0].putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{Employee.employees[position].getMail()});
                        intent[0].putExtra(android.content.Intent.EXTRA_SUBJECT, "Письмо из мобильного приложения для " + Employee.employees[position].getEmployeeName());
                        intent[0].putExtra(android.content.Intent.EXTRA_TEXT, "Привет, " + Employee.employees[position].getEmployeeName() + ", пишу тебе по поводу...");
                        mainCardView.getContext().startActivity(Intent.createChooser(intent[0], "Отправка письма..."));
                        break;
                }
            }
        };

        button_call = cardView.findViewById(R.id.button_call);
        button_letter = cardView.findViewById(R.id.button_letter);
        button_call.setOnClickListener(onClickListener);
        button_letter.setOnClickListener(onClickListener);
    }



    @Override
    public int getItemCount(){ //длина адаптера
        return captions.length;
    }

    @Override
    public CardEmployeesAdapter.ViewHolder onCreateViewHolder( //вью холдер содержит объект, строящий карточку, и ее содержимое
                                                                 ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_emloyee_image, parent, false);
        return new CardEmployeesAdapter.ViewHolder(cv);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder { //внутренний класс - наполняет карточку содержимым
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
}
