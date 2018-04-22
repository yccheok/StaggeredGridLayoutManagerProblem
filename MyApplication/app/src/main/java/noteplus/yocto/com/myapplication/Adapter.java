package noteplus.yocto.com.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Data> datas;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public final TextView titleTextView;
        public final TextView bodyTextView;
        public ViewHolder(View view) {
            super(view);

            titleTextView = view.findViewById(R.id.title_text_view);
            bodyTextView = view.findViewById(R.id.body_text_view);
        }
    }

    public Adapter(List<Data> datas) {
        this.datas = datas;

        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return datas.get(position).id;
    }

    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(datas.get(position).title);
        holder.bodyTextView.setText(datas.get(position).body);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
