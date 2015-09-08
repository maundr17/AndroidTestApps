package com.maundr17.alertdialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button dialogButton;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogButton = (Button) findViewById(R.id.dialogButton);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show our alert dialog
                dialog = new AlertDialog.Builder(MainActivity.this);

                // set title
                dialog.setTitle(getResources().getString(R.string.dialog_title));

                // set message
                dialog.setMessage(getResources().getString(R.string.dialog_message));

                // set Icon
                dialog.setIcon(android.R.drawable.btn_star);

                // set cancelable
                dialog.setCancelable(false);

                //set positive button
                dialog.setPositiveButton(getResources().getString(R.string.positive_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Exit our Activity
                                MainActivity.this.finish();
                            }
                        });

                dialog.setNegativeButton(getResources().getString(R.string.negative_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // cancel the dialog
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });

    }

}
