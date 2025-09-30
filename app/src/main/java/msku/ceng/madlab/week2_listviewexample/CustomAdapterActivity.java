package msku.ceng.madlab.week2_listviewexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterActivity extends AppCompatActivity {
    final List<Animal> animals = new ArrayList<Animal>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        animals.add(new Animal("Dog", R.mipmap.dog_picture));
        animals.add(new Animal("Cat", R.mipmap.cat_image));
        animals.add(new Animal("butterfly", R.mipmap.butterfly_image));
        animals.add(new Animal("bird", R.mipmap.bird_image));

        final ListView listView =(ListView) findViewById(R.id.listview);
        AnimalAdapter animalAdapter = new AnimalAdapter(this, animals);
        listView.setAdapter(animalAdapter);
    }
}