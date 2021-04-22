package vaibhav.tech.permissionfetcher.helper.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import vaibhav.tech.permissionfetcher.R;

//This Class is custom list view adapter for listView in ShowPermissions activity
public class CustomListViewAdapter2 extends ArrayAdapter<String> {

    Context context;
    List<String> perms;
    public CustomListViewAdapter2(Context context,List<String> perms)
    {
        super(context, R.layout.custom_row,R.id.permission,perms);
        this.context=context;
        this.perms=perms;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View eachRow = layoutInflater.inflate(R.layout.custom_row2, parent, false);
        TextView permission=eachRow.findViewById(R.id.permission);
        permission.setText(perms.get(position));
        return  eachRow;

    }
}
