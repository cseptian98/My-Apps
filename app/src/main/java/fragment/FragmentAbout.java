package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapps.R;

import adapter.InfoAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAbout extends Fragment {

    TabLayout tabTentang;
    TabItem tabInfo;
    TabItem tabAuth;
    ViewPager viewPager;
    InfoAdapter pageAdapter;

    public FragmentAbout() {
        // Required empty public constructor
    }

    public static FragmentAbout newInstance(){
        return new FragmentAbout();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        setHasOptionsMenu(true);

        viewPager = view.findViewById(R.id.viewPager);
        tabInfo = view.findViewById(R.id.tabInfo);
        tabAuth = view.findViewById(R.id.tabAuthor);
        tabTentang = view.findViewById(R.id.tabTentang);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pageAdapter = new InfoAdapter(getFragmentManager(), 2);
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabTentang));
    }
}
