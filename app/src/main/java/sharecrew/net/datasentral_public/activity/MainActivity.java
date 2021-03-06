package sharecrew.net.datasentral_public.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import sharecrew.net.datasentral_public.R;
import sharecrew.net.datasentral_public.fragment.CouponFragment;
import sharecrew.net.datasentral_public.fragment.contact.ContactFragment;
import sharecrew.net.datasentral_public.fragment.order.OrderFragment;
import sharecrew.net.datasentral_public.fragment.service.ServiceFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceFragment.OnFragmentInteractionListener {

    private final String TAG = "*** MAINACTIVITY";
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Hjem");
        setSupportActionBar(toolbar);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                int stackHeight = getSupportFragmentManager().getBackStackEntryCount();
                if (stackHeight > 0) { // if we have something on the stack (doesn't include the current shown fragment)
                    getSupportActionBar().setHomeButtonEnabled(true);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                } else {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    getSupportActionBar().setHomeButtonEnabled(false);
                }
            }
        });

        ViewGroup service   = (ViewGroup) findViewById(R.id.tile1);
        ViewGroup register  = (ViewGroup) findViewById(R.id.tile2);
        ViewGroup status    = (ViewGroup) findViewById(R.id.tile3);
        ViewGroup voucher   = (ViewGroup) findViewById(R.id.tile4);
        ViewGroup about     = (ViewGroup) findViewById(R.id.tile5);
        ViewGroup contact   = (ViewGroup) findViewById(R.id.tile6);

        service.setOnClickListener(this);
        register.setOnClickListener(this);
        status.setOnClickListener(this);
        voucher.setOnClickListener(this);
        about.setOnClickListener(this);
        contact.setOnClickListener(this);
    }

    @Override
     public void onClick(View v) {

        Fragment fragment = null;

        switch (v.getId()){
            case R.id.tile1:
                Log.v(TAG, "Button Clicked: Service");
                fragment = new ServiceFragment();
                break;
            case R.id.tile2:
                Log.v(TAG, "Button Clicked: Register");
                fragment = new OrderFragment();
                break;
            case R.id.tile3:
                Log.v(TAG, "Button Clicked: Status");
                break;
            case R.id.tile4:
                Log.v(TAG, "Button Clicked: Voucher");
                fragment = new CouponFragment();
                break;
            case R.id.tile5:
                Log.v(TAG, "Button Clicked: About");
                break;
            case R.id.tile6:
                Log.v(TAG, "Button Clicked: Contact");
                fragment = new ContactFragment();
                break;
        }

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.slide_out_right);
        ft.replace(R.id.fragment, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        toolbar.setTitle("Hjem");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == android.R.id.home) {
            toolbar.setTitle("Hjem");
            getSupportFragmentManager().popBackStack();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
