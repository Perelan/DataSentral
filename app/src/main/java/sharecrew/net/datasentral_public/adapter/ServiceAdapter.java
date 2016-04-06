package sharecrew.net.datasentral_public.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sharecrew.net.datasentral_public.R;
import sharecrew.net.datasentral_public.ServiceObject;
import sharecrew.net.datasentral_public.fragment.service.ServiceDialogFragment;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{
    private final String TAG = "******* Service Adapter";
    private ArrayList<ServiceObject> mDataset;
    private Context mContext;
    private Resources mResources;

    public ServiceAdapter(ArrayList<ServiceObject> mDataset, Context mContext, Resources mResources) {
        this.mDataset   = mDataset;
        this.mContext   = mContext;
        this.mResources = mResources;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_box, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mDataset.get(position).getTitle());
        holder.icon.setImageResource(mResources.getIdentifier(Integer.toString(mDataset.get(position).getIcon()), "drawable", "net.sharecrew.datasentral_public"));
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
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView icon;

        public ViewHolder(View v) {
            super(v);
            title   = (TextView) v.findViewById(R.id.service_box_title);
            icon    = (ImageView) v.findViewById(R.id.service_box_icon);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            FragmentActivity activity = (FragmentActivity)(mContext);
            FragmentManager fm = activity.getSupportFragmentManager();

            String title = mDataset.get(this.getAdapterPosition()).getTitle();
            String desc  = mDataset.get(this.getAdapterPosition()).getDesc();
            String price = "PRIS " + mDataset.get(this.getAdapterPosition()).getPrice() + ",- NOK";
            int icon  = mDataset.get(this.getAdapterPosition()).getIcon();

            ServiceDialogFragment alertDialog = ServiceDialogFragment.newInstance(title, desc, price, icon);
            alertDialog.show(fm, "display_service");
        }
    }
}

