package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

public class ItemCardAdapter extends PagerAdapter {

    Context context ;
    List<Item_card> itemCardList;

    public ItemCardAdapter(Context context, List<Item_card> itemCardListList){
        this.context = context;
        this.itemCardList =itemCardListList;
    }

    @Override
    public int getCount() {
        return itemCardList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);

        PhotoView card_image = (PhotoView) view.findViewById(R.id.card_image);
        TextView card_title = (TextView)view.findViewById(R.id.card_title);
        TextView card_description= (TextView)view.findViewById(R.id.card_description);

        //set data
        card_image.setImageResource(itemCardList.get(position).getImage());
        card_title.setText(itemCardList.get(position).getName());
        card_description.setText(itemCardList.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+itemCardList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);
        return view;

    }
}
