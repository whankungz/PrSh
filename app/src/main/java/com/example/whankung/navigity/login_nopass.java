package com.example.whankung.navigity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.View.GONE;

/**
 * Created by Whankung on 16/2/2560.
 */

public class login_nopass extends DialogFragment {

    EditText edtuserid, edtpass;


    TextView login, skip, head, regis;
    ProgressBar progressBar;
    private Dialog dialog;

    public onSubmitAlertDialogListener mListener;
    public interface onSubmitAlertDialogListener {
        void setOnSubmitAlertDialogListener();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog= new Dialog(getActivity());
        dialog.setContentView(R.layout.nav_header_main);

        progressBar = (ProgressBar) dialog.findViewById(R.id.progressBar);
        progressBar.setVisibility(GONE);
        edtuserid = (EditText) dialog.findViewById(R.id.user);
        edtpass = (EditText) dialog.findViewById(R.id.password);
        login = (TextView) dialog.findViewById(R.id.textView);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setOnSubmitAlertDialogListener();
                dialog.dismiss();
            }
        });
        return dialog;
    }



}
