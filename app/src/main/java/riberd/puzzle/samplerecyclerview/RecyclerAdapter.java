package riberd.puzzle.samplerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Riberd on 2016/12/20.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {
    private Context context;
    private List<String> nameList;
    private onItemClickListener listener;

    public RecyclerAdapter(Context context, List<String> nameList) {
        this.context = context;
        this.nameList = nameList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        String number = nameList.get(position);
        holder.textView.setText(number);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, nameList.get(holder.getAdapterPosition()));
            }
        });
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public interface onItemClickListener {
        void onClick(View view, String name);
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout linearLayout;
        final TextView textView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
