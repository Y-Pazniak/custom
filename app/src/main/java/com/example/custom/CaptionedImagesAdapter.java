package com.example.custom;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter extends
        RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{
    private String[] captions; //названия услуг
    private int[] imageIds; //картинки услуг

    public CaptionedImagesAdapter(String[] captions, int[] imageIds){ //конструктор адаптера - должен содержать услуги и их фото
        this.captions = captions;
        this.imageIds = imageIds;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){ //этот метод распределяет карточки по местам и заполняет их вьюшки
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.card_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);

        TextView textView = cardView.findViewById(R.id.card_text);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.getContext(), ServiceDetailActivity.class);
                intent.putExtra(ServiceDetailActivity.SERVICE_ID, position);
                cardView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){ //длина адаптера
        return captions.length;
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder( //вью холдер содержит объект, строящий карточку, и ее содержимое
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder { //внутренний класс - наполняет карточку содержимым
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
}
