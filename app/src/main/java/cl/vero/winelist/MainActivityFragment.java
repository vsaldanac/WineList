package cl.vero.winelist;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.vero.winelist.adapters.WineClickListener;
import cl.vero.winelist.adapters.WinesAdapter;
import cl.vero.winelist.models.Wine;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements WineClickListener{

    private WinesAdapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.wineRv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        Wine wine1 = new Wine("Casillero del Diablo", "Merlot","8 años");
        Wine wine2 = new Wine("Château Latour", "Cabernet Sauvignon","20 años");
        Wine wine3 = new Wine("Malbec", "Cabernet Sauvignon","10 años");
        Wine wine4 = new Wine("Pinot Noir", "Cabernet Sauvignon","8 años");
        Wine wine5 = new Wine("Casillero del Diablo", "Sangiovese","9 años");
        Wine wine6 = new Wine("Gato", "Merlot","15 años");
        Wine wine7 = new Wine("Concha y Toro Don Melchor ", "Cabernet Sauvignon","12 años");
        Wine wine8 = new Wine("Château Latour", "Sangiovese","13 años");

        wine1.save();
        wine2.save();
        wine3.save();
        wine4.save();
        wine5.save();
        wine6.save();
        wine7.save();
        wine8.save();

        adapter = new WinesAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateList(Wine wine){
        adapter.update(wine);

    }

    @Override
    public void clickedId(long id) {

    }
}
