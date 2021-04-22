package vaibhav.tech.permissionfetcher;

import androidx.appcompat.app.AppCompatActivity;
import vaibhav.tech.permissionfetcher.helper.Adapters.CustomListViewAdapter;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
//    private String test_Names[]={"Facebook","Google","Whatsapp"};
//    private String test_packages[]={"com.android.facebook","com.google.google","com.android.whatsapp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);


        final PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        int n=packages.size();
        String app_names[]=new String[n];
        String app_packages[]=new String[n];
        Drawable icons[]=new Drawable[n];
        for(int i=0;i<n;i++)
        {
            ApplicationInfo applicationInfo=packages.get(i);
            app_names[i]=applicationInfo.loadLabel(getPackageManager()).toString();
            app_packages[i]=applicationInfo.packageName;
            try {
                icons[i]=this.getPackageManager().getApplicationIcon(app_packages[i]);
            } catch (PackageManager.NameNotFoundException e) {
                icons[i]=null;
            }
        }

        CustomListViewAdapter customListViewAdapter=new CustomListViewAdapter(this,app_names,app_packages,icons);
        listView.setAdapter(customListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(MainActivity.this, ""+app_names[position], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),ShowPermissions.class);
                intent.putExtra("package_name",app_packages[position]);
                startActivity(intent);
            }
        });

    }
}