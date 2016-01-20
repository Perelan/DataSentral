package sharecrew.net.datasentral_public.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import sharecrew.net.datasentral_public.R;


public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{
    private final String TAG = "******* List Adapter";
    private ArrayList<String> mDataset;

    public ServiceAdapter(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_box, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.suspect_name.setText(mDataset.get(position).getReported_name());
        holder.title.setText(mDataset.get(position));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    /**
     * This class fetches placement of the containers and assign the rightful view to each one of them.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View v) {
            super(v);

            title = (TextView) v.findViewById(R.id.title);
        }
    }
}

