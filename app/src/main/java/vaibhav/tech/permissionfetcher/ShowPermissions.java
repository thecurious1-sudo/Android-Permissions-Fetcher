package vaibhav.tech.permissionfetcher;

import androidx.appcompat.app.AppCompatActivity;
import vaibhav.tech.permissionfetcher.helper.Adapters.CustomListViewAdapter;
import vaibhav.tech.permissionfetcher.helper.Adapters.CustomListViewAdapter2;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowPermissions extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_permissions);
        Intent intent = getIntent();
        String appPackage=intent.getStringExtra("package_name");
        listView=findViewById(R.id.listView2);

        List<String> granted = new ArrayList<String>();

            try {
                PackageInfo pi = getPackageManager().getPackageInfo(appPackage, PackageManager.GET_PERMISSIONS);
                for (int i = 0; i < pi.requestedPermissions.length; i++)
                {
                    if ((pi.requestedPermissionsFlags[i] & PackageInfo.REQUESTED_PERMISSION_GRANTED) != 0)
                    {
                        granted.add(pi.requestedPermissions[i]);
                    }
                }
            } catch (Exception e) {
            }

        CustomListViewAdapter2 customListViewAdapter2=new CustomListViewAdapter2(this,granted);
        listView.setAdapter(customListViewAdapter2);
    }
}