package com.android.acadgild.fragmentlistdetails103;

/**
 * Created by Jal on 01-09-2017.
 */

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.acadgild.fragmentlistdetails103.adapter.CustomAdapter;
import com.android.acadgild.fragmentlistdetails103.apis.Data;
import com.android.acadgild.fragmentlistdetails103.bean.CustomHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




/**
 * Created by admin on 3/12/2015.
 */
public class ListDetailFragment extends ListFragment {
    boolean mDualPane;
    ArrayList<CustomHandler> model= new ArrayList<>();
    String title;
    String desc;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        View detailsFrame = null;//getActivity().findViewById(R.id.details);

        //To check dual pane is active or not
        mDualPane = detailsFrame != null
                && detailsFrame.getVisibility() == View.VISIBLE;

        Toast.makeText(getActivity(), "mDualPane " + mDualPane,
                Toast.LENGTH_LONG).show();

        //To get Key- Value pair of Image and List Items
        HashMap<Integer,String> hmap = new HashMap<Integer,String>();

        hmap.put(R.drawable.yt,"You Tube"+"\n"+"You Tube Description");
        hmap.put(R.drawable.blogger,"Blogger"+"\n"+"Blogger Description");

        //Iterate Key- Value pair of Image and List Items
        for(Map.Entry m:hmap.entrySet()){
            CustomHandler handler= new CustomHandler();
            //To separate title & description from value
            int first_index = m.getValue().toString().indexOf("\n");
            title = m.getValue().toString().substring(0,first_index);
            desc = m.getValue().toString().substring(first_index+1,m.getValue().toString().length());
            //set vaues to handler to store into model
            handler.setTitle(title);
            handler.setDetail(desc);
            handler.setImage(Integer.parseInt(m.getKey().toString()));
            model.add(handler);
        }

        //Creating adapter with list of items inside model
        CustomAdapter adapter= new CustomAdapter(getActivity(), model);
        //Set Adapter
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //showDetails(position);
    }

    /*void showDetails(int index) {

        if (mDualPane) {

            getListView().setItemChecked(index,true);

            DetailsFragment details = (DetailsFragment) getFragmentManager()
                    .findFragmentById(R.id.details);

            if (details == null || details.getShownIndex() != index) {

                details = DetailsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }*/
}
