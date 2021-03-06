package sharecrew.net.datasentral_public.fragment.service;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sharecrew.net.datasentral_public.R;

public class ServiceDialogFragment extends DialogFragment {

    private String mTitle;
    private String mPrice;
    private String mDesc;
    private int mIcon;

    public static ServiceDialogFragment newInstance(String title, String desc, String price, int icon){
        ServiceDialogFragment f = new ServiceDialogFragment();

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("desc", desc);
        args.putString("price", price);
        args.putInt("icon", icon);

        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle  = getArguments().getString("title");
        mDesc   = getArguments().getString("desc");
        mPrice  = getArguments().getString("price");
        mIcon   = getArguments().getInt("icon");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.service_card, container, false);

        TextView title  = (TextView) v.findViewById(R.id.service_card_title);
        TextView price  = (TextView) v.findViewById(R.id.service_card_price);
        TextView desc   = (TextView) v.findViewById(R.id.service_card_desc);
        ImageView icon  = (ImageView) v.findViewById(R.id.service_card_icon);

        title.setText(mTitle);
        price.setText(mPrice);
        desc.setText(mDesc);
        icon.setImageResource(getResources().getIdentifier(Integer.toString(mIcon), "drawable", "sharecrew.net.datasentral_public"));

        return v;
    }
}
