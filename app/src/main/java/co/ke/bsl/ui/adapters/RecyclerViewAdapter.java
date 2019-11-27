package co.ke.bsl.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.ke.bsl.R;
import co.ke.bsl.ui.activities.MyData;
import co.ke.bsl.ui.activities.NoticesActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<MyData> mData;
    Activity myNoticesActivity;

    public RecyclerViewAdapter(Context mContext, List<MyData> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.notices_list,parent,false);
        final MyViewHolder vHolder= new MyViewHolder(v);
        vHolder.notices_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Toast.makeText(mContext,"clicked"+String.valueOf(mData.get(vHolder.getAdapterPosition()).getNotice()),Toast.LENGTH_LONG).show();
                Intent intent= new Intent(mContext, NoticesActivity.class);

                intent.putExtra("notices",mData.get(vHolder.getAdapterPosition()).getNotice());
                intent.putExtra("messages",mData.get(vHolder.getAdapterPosition()).getMessage());
                mContext.startActivity(intent);
            }
        });


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_notice.setText(mData.get(position).getNotice());
        holder.tv_message.setText(mData.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_notice;
        private TextView tv_message;
        private LinearLayout notices_items;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_notice= (TextView) itemView.findViewById(R.id.textView);
            tv_message=(TextView) itemView.findViewById(R.id.textView1);
            notices_items=(LinearLayout) itemView.findViewById(R.id.notices_layuot);
        }
    }
}
