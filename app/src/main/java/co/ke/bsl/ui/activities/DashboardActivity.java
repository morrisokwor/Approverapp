package co.ke.bsl.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import co.ke.bsl.R;
import co.ke.bsl.ui.adapters.RecyclerViewAdapter;
import co.ke.bsl.ui.adapters.TabAdapter;
import co.ke.bsl.ui.adapters.ViewPagerAdapter;
import co.ke.bsl.ui.fragments.NoticesFragment;
import co.ke.bsl.ui.fragments.WorkflowFragment;


public class DashboardActivity extends AppCompatActivity {
Toolbar toolbar;
TabLayout tabLayout;
TabItem item,item1;
BadgeDrawable badge;
ViewPager viewPager;
ViewPagerAdapter adapter;
TabAdapter tabAdapter;
RecyclerViewAdapter recyclerViewAdapter;



final int[] ICONS = new int[]{
            R.drawable.ic_notifications_active_black_24dp,
            R.drawable.ic_done_all_black_24dp
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


//        ToolBar Effects
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("DashBoard");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(toolbar);
//     TabItem Effects
       item=(TabItem) findViewById(R.id.tabItem);
       item1=(TabItem) findViewById(R.id.tabItem1);

//     TabLayout effects
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.getTabAt(0).setIcon(ICONS[0]);
        tabLayout.getTabAt(1).setIcon(ICONS[1]);
//       Badges
        badge = tabLayout.getTabAt(0).getOrCreateBadge();
        badge.setVisible(true);
        badge.setNumber(10);
        badge = tabLayout.getTabAt(1).getOrCreateBadge();
        badge.setVisible(true);
        badge.setNumber(12);

      adapter=new ViewPagerAdapter(getSupportFragmentManager());
      adapter.AddFragemt(new NoticesFragment(),"Notices");
      adapter.AddFragemt(new WorkflowFragment(),"Workflow Activities");
      viewPager=(ViewPager) findViewById(R.id.viewpager);
      viewPager.setAdapter(adapter);
      tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuitems, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        if(item.getItemId()==R.id.action_logout) {

            intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
