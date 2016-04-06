package sharecrew.net.datasentral_public.fragment.order;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sharecrew.net.datasentral_public.R;

public class OrderDialogFragment extends DialogFragment {

    private String mTitle;
    private String mPrice;
    private int mIcon;

    public static OrderDialogFragment newInstance(String title, String price, int icon){
        OrderDialogFragment f = new OrderDialogFragment();

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("price", price);
        args.putInt("icon", icon);

        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle  = getArguments().getString("title");
        mPrice  = getArguments().getString("price");
        mIcon   = getArguments().getInt("icon");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_card, container, false);

        TextView title  = (TextView) v.findViewById(R.id.order_card_title);
        TextView price  = (TextView) v.findViewById(R.id.order_card_price);
        ImageView icon  = (ImageView) v.findViewById(R.id.order_card_icon);

        title.setText(mTitle);
        price.setText(mPrice);
        icon.setImageResource(getResources().getIdentifier(Integer.toString(mIcon), "drawable", "sharecrew.net.datasentral_public"));

        return v;
    }
}
