package com.dogsontherun.pocketpupv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Stelzy on 5/28/2015.
 *
 * com.dogsontherun.pocketpupv2.MyPetAdapter is a custom adpter that takes in an array of parseobjects (specifically of the
 * pet type) and allows for the customization of data retrieval and populates the custom listview
 * for MyPets
 */
public class MyPetAdapter extends ArrayAdapter<ParseObject> {

        protected Context mContext;
        protected List mPets;

        public MyPetAdapter(Context context, List pets) {
            super(context, R.layout.mypetscustomlayout, pets);
            mContext = context;
            mPets = pets;
        }

        // This method is the method that will inflate each row of the listview
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;


            if (convertView == null) { // if there is no content then populate
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.mypetscustomlayout, null);
                holder = new ViewHolder();
                holder.myPets_pic = (ImageView) convertView //always remember to call convertView or whatever you call that param
                        .findViewById(R.id.myPets_pic);
                holder.myPets_name = (TextView) convertView
                        .findViewById(R.id.myPets_name);
                holder.myPets_breed = (TextView) convertView
                        .findViewById(R.id.myPets_breed);


                convertView.setTag(holder);
            } else { // if there is previous content then it reuses the views from existing content and then appends more

                holder = (ViewHolder) convertView.getTag();

            }

            //gets position of the row
            ParseObject petObject = (ParseObject) mPets.get(position);

            // pet profile picture
            // *********************** to be done with Picasso eventually


            // pet name
            String name = petObject.getString("name");
            holder.myPets_name.setText(name);

            // pet breed
            String breed = petObject.getString("breed");
            holder.myPets_breed.setText(breed);

            return convertView;
        }
        public static class ViewHolder {
            ImageView myPets_pic;
            TextView myPets_name;
            TextView myPets_breed;
        }

}

