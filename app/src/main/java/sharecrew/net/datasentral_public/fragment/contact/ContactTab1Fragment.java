package sharecrew.net.datasentral_public.fragment.contact;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gregacucnik.EditTextView;

import java.util.HashMap;

import sharecrew.net.datasentral_public.HTTPostRequest;
import sharecrew.net.datasentral_public.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactTab1Fragment extends Fragment {


    public ContactTab1Fragment() {
        // Required empty public constructor
    }

    private HashMap<String, String> map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact_tab1, container, false);

        map = new HashMap<>();

        final EditText name     = (EditText) v.findViewById(R.id.name);
        final EditText email    = (EditText) v.findViewById(R.id.email);
        final EditText telefon  = (EditText) v.findViewById(R.id.phone);
        final EditText beskjed  = (EditText) v.findViewById(R.id.message);

        Button b = (Button) v.findViewById(R.id.button_tab1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean error = false;
                final String errormsg = "Vennligst fyll ut denne feltet korrekt!";

                if(name.getText().toString().isEmpty()){
                    name.setError(errormsg);
                    error = true;
                }

                if(email.getText().toString().isEmpty() || !email.getText().toString().contains("@")){
                    email.setError(errormsg);
                    error = true;
                }

                if(beskjed.getText().toString().isEmpty()){
                    beskjed.setError(errormsg);
                    error = true;
                }

                if(error)
                    return;

                map.put("name", name.getText().toString());
                map.put("email", email.getText().toString());
                map.put("phone", telefon.getText().toString());
                map.put("message", beskjed.getText().toString());

                new AsyncList(map).execute();

                Toast.makeText(getContext(), "Din melding er nå sendt!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    private class AsyncList extends AsyncTask<Void, Void, Void>{

        private HashMap<String, String> map;

        AsyncList(HashMap<String, String> map){
            this.map = map;
        }

        @Override
        protected Void doInBackground(Void... params) {
            new HTTPostRequest("/php/contact_app.php?").update_data(map);
            return null;
        }
    }
}
