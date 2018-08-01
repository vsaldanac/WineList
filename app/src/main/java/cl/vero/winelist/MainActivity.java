package cl.vero.winelist;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import cl.vero.winelist.models.Wine;

public class MainActivity extends AppCompatActivity {

    private MainActivityFragment mainActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainActivityFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(1);
                dialog.setContentView(R.layout.wine_dialog);

                Button button = dialog.findViewById(R.id.dialogBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        EditText brandInput = dialog.findViewById(R.id.brandEt);
                        EditText typeInput = dialog.findViewById(R.id.typeEt);
                        EditText yearsInput = dialog.findViewById(R.id.yearsEt);
                        String brand = brandInput.getText().toString();
                        String type = typeInput.getText().toString();
                        String years = yearsInput.getText().toString();
                        if (brand.trim().length() > 0 && type.trim().length() > 0 && years.trim().length() > 0){
                            Wine wine = new Wine();
                            wine.setBrand(brand);
                            wine.setType(type);
                            wine.setYears(years + " años");
                            wine.save();
                            mainActivityFragment.updateList(wine);
                        }

                        dialog.dismiss();

                    }
                });

                dialog.getWindow().setLayout(-1,-2);
                dialog.show();

            }
        });
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
        }

        return super.onOptionsItemSelected(item);
    }
}
