package co.ke.bsl.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private  final List<Fragment> lstFragment=new ArrayList<>();
    private  final List<String> lstTitles=new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }
    @Override
    public  CharSequence getPageTitle(int postion){
        return lstTitles.get(postion);
    }
    public void AddFragemt(Fragment fragment, String title){
        lstFragment.add(fragment);
        lstTitles.add(title);

    }
}
