package com.anadeainc.exampledagger.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

import com.anadeainc.exampledagger.R;

public class DialogCommon extends AppCompatDialogFragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";

    private String title;
    private String message;

    public static DialogCommon newInstance(String title, String message) {

        DialogCommon errorDialog = new DialogCommon();

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        errorDialog.setArguments(args);

        return errorDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString(ARG_TITLE);
        message = getArguments().getString(ARG_MESSAGE);
    }

    @NonNull
    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog
                .Builder(getActivity(), R.style.AppCompatAlertDialogStyle)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null);

        return dialogBuilder.create();
    }
}
