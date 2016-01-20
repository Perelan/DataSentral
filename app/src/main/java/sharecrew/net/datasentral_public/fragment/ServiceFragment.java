package sharecrew.net.datasentral_public.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sharecrew.net.datasentral_public.R;
import sharecrew.net.datasentral_public.adapter.ServiceAdapter;

public class ServiceFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecView;
    private ArrayList<String> mList;
    private ServiceAdapter mAdapter;
    private ActionBar mActionBar;

    public static ServiceFragment newInstance(String param1, String param2) {
        ServiceFragment fragment = new ServiceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public ServiceFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setIcon(R.drawable.suitcase_small);
        mActionBar.setTitle(" Tjenester");

        mList = new ArrayList<>();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_service, container, false);

        mRecView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecView.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        mRecView.setLayoutManager(glm);

        mList.add("Timepris");
        mList.add("Helgepris");
        mList.add("Fjern Virus");
        mList.add("Reinstallasjon");
        mList.add("Trådløst Nettverk");
        mList.add("Web Utvikling");
        mList.add("App Utvikling");
        mList.add("Oppsett av Printer");
        mList.add("Opplæring");
        mList.add("PC Sjekk");
        mList.add("Fjernhjelp");
        mList.add("Firma Avtale");
        mList.add("Gammel Til Ny");
        mList.add("Låne Utstyr");
        mList.add("Data Håndtering");

        mAdapter = new ServiceAdapter(mList);
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
        mActionBar.setIcon(R.drawable.home);
        mActionBar.setTitle(" Hjem");
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
