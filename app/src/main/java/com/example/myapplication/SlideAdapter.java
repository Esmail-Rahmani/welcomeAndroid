package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {
        Context context;
        LayoutInflater inflater;


        // list of titles
        public String[] lst_title = {
                "COSMONAUT",
                "SATELITE",
                "GALAXY",
                "ROCKET"
        }   ;
        // list of descriptions
        public String[] lst_description = {
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
        };


        public SlideAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return lst_title.length;
        }


    @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view==(LinearLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.slide,container,false);
            LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
            ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
            TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
            TextView description = (TextView) view.findViewById(R.id.txtdescription);
            txttitle.setText(lst_title[position]);
            description.setText(lst_description[position]);
            LinearLayout l1= view.findViewById(R.id.welcome1);
            container.addView(l1);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }
    }