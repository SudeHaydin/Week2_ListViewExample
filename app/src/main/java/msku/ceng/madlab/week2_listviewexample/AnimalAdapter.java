package msku.ceng.madlab.week2_listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {
    private List<Animal> animals ;
    private LayoutInflater mInflater;

    public AnimalAdapter(Activity activity, List<Animal> animal){
        this.animals = animal;
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int i) {
        return animals.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            rowView = mInflater.inflate(R.layout.listview_row, parent, false);
        }

            TextView textView = (TextView) rowView.findViewById(R.id.label);
            ImageView imgView = rowView.findViewById(R.id.pic);

            Animal animal = animals.get(i);
            textView.setText(animal.getType());
            imgView.setImageResource(animal.getPicId());

            return rowView;
        }
    }
