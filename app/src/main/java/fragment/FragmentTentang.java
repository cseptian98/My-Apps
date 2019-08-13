package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapps.R;

//17-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTentang extends Fragment {

    public FragmentTentang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_tentang, container, false);
    }

}
