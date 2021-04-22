package vaibhav.tech.permissionfetcher.helper.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import vaibhav.tech.permissionfetcher.R;

//This Class is custom list view adapter for listView in MainActivity activity
public class CustomListViewAdapter extends ArrayAdapter<String> {

    Context context;
    String names_apps[];
    String package_apps[];
    Drawable icons[];

    public CustomListViewAdapter(Context context, String names_apps[], String package_apps[],Drawable icons[])
    {
        super(context, R.layout.custom_row,R.id.appPackage,package_apps);
        this.context=context;
        this.names_apps=names_apps;
        this.package_apps=package_apps;
        this.icons=icons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            Log.d("TESTING_MF","Sss");
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View eachRow = layoutInflater.inflate(R.layout.custom_row, parent, false);

            ImageView icon=eachRow.findViewById(R.id.appIcon);
            TextView appName=eachRow.findViewById(R.id.appName);
            TextView appPackage=eachRow.findViewById(R.id.appPackage);
            if(icons[position]!=null)
                icon.setImageDrawable(icons[position]);
            else
                icon.setImageResource(R.mipmap.ic_launcher);
            appName.setText(names_apps[position]);
            appPackage.setText(package_apps[position]);

            return  eachRow;

    }
}
