package com.exemple.profedam.aboutrobots2017;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class RobotActivity extends AppCompatActivity implements View.OnClickListener {

    private int numeroVeces = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);
        /* Busco el button en el formulario y lo inicializo
           al objeto btnNoTocar */

        Button btnNoTocar = (Button) findViewById(R.id.btnNoTocar);
        btnNoTocar.setOnClickListener(this);

        ImageButton btnSalir = (ImageButton) findViewById(R.id.imageButtonSalir);
        btnSalir.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /* Método que se ejecuta cuando algún botón vigilado
     por esta clase es pulsado */

    @Override

    public void onClick(View v) {

        if (v.getId()==R.id.btnNoTocar) {
            Button btnNoTocar = (Button) v;
            TextView cajaTexto = (TextView) findViewById(R.id.textView);
            ImageView imageRob = (ImageView) findViewById(R.id.imageView);
            numeroVeces++;
            if (numeroVeces == 1) {
                btnNoTocar.setText("¡Que no me toques!!!");
                cajaTexto.setText("Parece ser que los humanos no son muy inteligentes");
                imageRob.setImageResource(R.mipmap.robot_enfadado);
            }

            if (numeroVeces == 2) {
                btnNoTocar.setVisibility(View.INVISIBLE);
                cajaTexto.setText("Te lo advertí!");
                imageRob.setImageResource(R.mipmap.robot_fumando);
            }
        }
        if (v.getId() == R.id.imageButtonSalir) {
            finish();

        }


    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Robot Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
