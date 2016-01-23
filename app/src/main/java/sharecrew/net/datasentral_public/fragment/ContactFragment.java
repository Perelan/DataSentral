package sharecrew.net.datasentral_public.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import sharecrew.net.datasentral_public.R;
import sharecrew.net.datasentral_public.activity.MainActivity;


public class ContactFragment extends Fragment {

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Kontakt oss"));
        tabLayout.addTab(tabLayout.newTab().setText("Registrer telefon"));

        viewPager = (ViewPager) v.findViewById(R.id.pager);
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
        SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

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

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + (position + 1);
        }

        /**
         * On each Fragment instantiation we are saving the reference of that Fragment in a Map
         * It will help us to retrieve the Fragment by position
         *
         * @param container
         * @param position
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            registeredFragments.put(position, fragment);
            return fragment;
        }

        /**
         * Remove the saved reference from our Map on the Fragment destroy
         *
         * @param container
         * @param position
         * @param object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            registeredFragments.remove(position);
            super.destroyItem(container, position, object);
        }


        /**
         * Get the Fragment by position
         *
         * @param position tab position of the fragment
         * @return
         */
        public Fragment getRegisteredFragment(int position) {
            return registeredFragments.get(position);
        }
    }
}