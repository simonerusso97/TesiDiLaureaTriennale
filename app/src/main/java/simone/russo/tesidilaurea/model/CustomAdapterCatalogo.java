package simone.russo.tesidilaurea.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import java.util.ArrayList;

import simone.russo.tesidilaurea.R;
import simone.russo.tesidilaurea.view.MainActivity;

public class CustomAdapterCatalogo extends BaseAdapter implements ListAdapter {
    private ArrayList<ProdottoModel> list = new ArrayList<ProdottoModel>();
    private MainActivity activity;



    public CustomAdapterCatalogo(ArrayList<ProdottoModel> list, MainActivity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }


    @Override
    public long getItemId(int pos) {
        return pos;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_adapter_main, null);
        }

        //Handle TextView and display string from your list
        TextView nomeProdotto = (TextView)view.findViewById(R.id.nomeProdotto);
        nomeProdotto.setText(list.get(position).getNome() + " " + list.get(position).getPrezzo()+" E.");

        //Handle buttons and add onClickListeners

        Button accettaBtn = (Button)view.findViewById(R.id.add_btn);
        accettaBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                //TODO: Lo gestisco qui o lo gestisco in un listener

                notifyDataSetChanged(); //CE FACE?????
            }
        });
        return view;
    }
}