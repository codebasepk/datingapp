package com.mydatingapp.ui.memberships;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import com.mydatingapp.R;
import com.mydatingapp.ui.base.SkBaseInnerActivity;
import com.mydatingapp.ui.memberships.fragments.CreditsFragment;
import com.mydatingapp.ui.memberships.fragments.MembershipsAndCreditsFragment;

/**
 * Created by jk on 3/10/15.
 */
public class CreditsActivity extends SkBaseInnerActivity {

    public CreditsActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.credits_activity);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        MembershipsAndCreditsFragment fragment = MembershipsAndCreditsFragment.getInstance(false, true, false);
        fragmentTransaction.add(R.id.fragment, fragment);
        fragmentTransaction.commit();

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        setEmulateBackButton(true);
        setTitle(R.string.credit_pack_label);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //notify parent activity about list changes
        Intent intent = new Intent(CreditsFragment.ON_ACTIVITY_RESULT);
        intent.putExtra("requestCode", requestCode);
        intent.putExtra("resultCode", resultCode);
        intent.putExtra("data", data);

        LocalBroadcastManager.getInstance(getApplication()).sendBroadcast(intent);
    }
}
