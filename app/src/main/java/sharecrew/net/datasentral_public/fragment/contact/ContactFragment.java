package sharecrew.net.datasentral_public.fragment.contact;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sharecrew.net.datasentral_public.R;


public class ContactFragment extends Fragment {

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_contact, container, false);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Kontakt oss"));
        tabLayout.addTab(tabLayout.newTab().setText("Kontakt meg"));



        viewPager = (ViewPager) v.findViewById(R.id.pager);
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 1){
                    Snackbar.make(v.findViewById(R.id.main_layout), "Fyll in navn og telefon, og vi kontakter deg!", Snackbar.LENGTH_LONG)
                            .setAction("Forkast", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                }
                            })
                            .setActionTextColor(Color.RED)
                            .show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch(i){
                case 0:
                    return new ContactTab1Fragment();
                case 1:
                    return new ContactTab2Fragment();
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
