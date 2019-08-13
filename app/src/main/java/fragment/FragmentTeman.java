package fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import adapter.ListTemanAdapter;
import com.example.myapps.R;
import com.example.myapps.TambahTeman;

import model.Teman;

import java.util.ArrayList;

import presenter.PresenterTeman;
import view.ViewTeman;

import static model.ListTeman.getListData;

//15-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTeman extends Fragment implements ViewTeman, View.OnClickListener {

        PresenterTeman presenter;
        ListTemanAdapter adapter;
        RecyclerView rvTeman;
        FloatingActionButton floatAdd;
        ArrayList<Teman> teman;

        public void showListTeman(){
            adapter.setListTeman(getListData());
        }


        public FragmentTeman() {
            // Required empty public constructor
        }

        public static FragmentTeman newInstance() {
            return new FragmentTeman();
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_teman, container, false);
            rvTeman = view.findViewById(R.id.rvTeman);
            floatAdd = view.findViewById(R.id.fabAddFriends);
            return view;
        }

        public void onActivityCreated(Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);

            teman = new ArrayList<>();
            adapter = new ListTemanAdapter(teman);

            rvTeman.setHasFixedSize(true);
            rvTeman.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTeman.setAdapter(adapter);

            presenter = new PresenterTeman(this);
            presenter.setListTeman();

            floatAdd.setOnClickListener(this);
        }

        public void onClick(View v){
            Intent a = new Intent(getContext(), TambahTeman.class);
            startActivityForResult(a, 1);
        }

        public void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode ==  1){
                if (resultCode == Activity.RESULT_OK){
                    Teman tmn = data.getParcelableExtra("newFriend");
                    teman.add(tmn);
                    adapter.setListTeman(teman);
                }
            }
        }
    }
