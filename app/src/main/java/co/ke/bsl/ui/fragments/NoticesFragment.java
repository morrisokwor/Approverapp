package co.ke.bsl.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.ke.bsl.R;
import co.ke.bsl.ui.activities.MyData;
import co.ke.bsl.ui.adapters.RecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticesFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerView;
    private List<MyData> lstnotices;

    public NoticesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.fragment_notices, container, false);
        myrecyclerView=(RecyclerView) v.findViewById(R.id.noticesRecycler);
        RecyclerViewAdapter recycleAdapter= new RecyclerViewAdapter(getContext(),lstnotices);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recycleAdapter);
        return v;
    }
 @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

     super.onCreate(savedInstanceState);

     lstnotices=new ArrayList<>();


     for(int i=0; i<=10;i++){

         MyData lstnotice = new MyData(
                 "Notice "+i,
                 "Please Approve"
         );
         lstnotices.add(lstnotice) ;
     }


 }
}
