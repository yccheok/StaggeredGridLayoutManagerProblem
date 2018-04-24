package noteplus.yocto.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Data> datas = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        //staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        this.recyclerView.setLayoutManager(staggeredGridLayoutManager);

        datas.add(new Data(0, "A title", "A body"));
        datas.add(new Data(1, "B title", "B body"));
        datas.add(new Data(2, "C title", "C body"));
        datas.add(new Data(3, "D title", "D body"));
        datas.add(new Data(4, "E title", "E body"));
        datas.add(new Data(5, "F title", "F body"));
        datas.add(new Data(6, "G title", "G body"));
        datas.add(new Data(7, "H title", "H body"));
        datas.add(new Data(8, "I title", "I body"));
        datas.add(new Data(9, "J title", "J body"));
        datas.add(new Data(10, "K title", "K body"));
        datas.add(new Data(11, "L title", "L body"));
        datas.add(new Data(12, "M title", "M body"));
        datas.add(new Data(13, "N title", "N body"));
        datas.add(new Data(14, "O title", "O body"));
        adapter = new Adapter(datas);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.debug: {

                Data data0 = datas.get(0);
                Data data1 = datas.get(1);

                datas.set(0, data1);
                datas.set(1, data0);

                adapter.notifyItemMoved(0, 1);

                return true;
            }
            
            case R.id.debug2:

                Data data2 = datas.get(2);
                Data data3 = datas.get(3);

                datas.set(2, data3);
                datas.set(3, data2);

                adapter.notifyItemMoved(2, 3);

                return true;

            case R.id.debug3: {
                List<Data> oldDatas = new ArrayList<>(datas);

                Data data0 = datas.get(0);
                Data data1 = datas.get(1);

                datas.set(0, data1);
                datas.set(1, data0);

                MyNoteDiffUtilCallback noteDiffUtilCallback = new MyNoteDiffUtilCallback(datas, oldDatas);
                DiffUtil.calculateDiff(noteDiffUtilCallback).dispatchUpdatesTo(adapter);

                return true;
            }
                
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class MyNoteDiffUtilCallback extends DiffUtil.Callback {
        private List<Data> newsDatas;
        private List<Data> oldDatas;


        public MyNoteDiffUtilCallback(List<Data> newsDatas, List<Data> oldDatas) {
            this.newsDatas = newsDatas;
            this.oldDatas = oldDatas;
        }

        @Override
        public int getOldListSize() {
            return oldDatas.size();
        }

        @Override
        public int getNewListSize() {
            return newsDatas.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldDatas.get(oldItemPosition).id == newsDatas.get(newItemPosition).id;
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oldDatas.get(oldItemPosition).equals(newsDatas.get(newItemPosition));
        }
    }
}
