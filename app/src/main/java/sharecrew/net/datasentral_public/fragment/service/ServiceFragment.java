package sharecrew.net.datasentral_public.fragment.service;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sharecrew.net.datasentral_public.R;
import sharecrew.net.datasentral_public.ServiceObject;
import sharecrew.net.datasentral_public.Utilities;
import sharecrew.net.datasentral_public.adapter.ServiceAdapter;

public class ServiceFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecView;
    private ArrayList<ServiceObject> mList;
    private ServiceAdapter mAdapter;
    private ActionBar mActionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setTitle("Tjenester");

        mList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_service_list, container, false);

        mRecView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecView.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        mRecView.setLayoutManager(glm);

        mList = Utilities.fill_object_list();

        mAdapter = new ServiceAdapter(mList, getActivity(), getResources());
        mRecView.setAdapter(mAdapter);

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
