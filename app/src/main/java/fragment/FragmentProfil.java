package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapps.R;

//15-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfil extends Fragment {


    public FragmentProfil() {
        // Required empty public constructor
    }

    public static FragmentProfil newInstance() {
        return new FragmentProfil();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }
}
