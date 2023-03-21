package com.example.championship;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.up.R;

import java.util.List;

//Пользовательский адаптер для отображения списка фотографий в пользовательском интерфейсе.
public class GalleryAdapter extends BaseAdapter {
    private List<Photo> mPhotos;
    private LayoutInflater mInflater;
    private Context mContext;

    public GalleryAdapter(Context context, List<Photo> photos) {
        mPhotos = photos;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    //Возвращает количество элементов в списке фотографий
    @Override
    public int getCount() {
        return mPhotos.size();
    }

    //возвращает объект Photo по указанному position (индексу элемента) в списке фотографий
    @Override
    public Object getItem(int position) {
        return mPhotos.get(position);
    }

    //возвращает идентификатор элемента по указанной позиции (индексу элемента) в списке
    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.gallery_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView timeTextView = convertView.findViewById(R.id.time);
        Button button = convertView.findViewById(R.id.add_btn);

        Photo photo = mPhotos.get(position);
            imageView.setImageBitmap(photo.image);
            timeTextView.setText(photo.timestamp);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, PhotoActivity.class);
                    intent.putExtra("image_id", position);
                    mContext.startActivity(intent);
                }
            });


        return convertView;
    }
}
