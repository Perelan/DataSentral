package sharecrew.net.datasentral_public.fragment.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sharecrew.net.datasentral_public.R;
import sharecrew.net.datasentral_public.ServiceObject;
import sharecrew.net.datasentral_public.Utilities;
import sharecrew.net.datasentral_public.adapter.OrderAdapter;


public class OrderFragment extends Fragment {

    private RecyclerView mRecView;
    private ArrayList<ServiceObject> mList;
    private OrderAdapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_service_list, container, false);

        mRecView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecView.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        mRecView.setLayoutManager(glm);

        mList = Utilities.fill_object_list();   // Fill the list with given objects.

        mAdapter = new OrderAdapter(mList, getActivity(), getResources());
        mRecView.setAdapter(mAdapter);

        return rootView;
    }

}
