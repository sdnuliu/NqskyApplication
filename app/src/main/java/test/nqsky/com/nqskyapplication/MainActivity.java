package test.nqsky.com.nqskyapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLlmanager;
    private NewAdapter mNewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_review);
        //创建默认的linearLayoutManager
        mLlmanager = new LinearLayoutManager(this);
//        mLlmanager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLlmanager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mNewAdapter = new NewAdapter(getDatas());
        mRecyclerView.setAdapter(mNewAdapter);

        //设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private String[] getDatas() {
        String[] datas = new String[]{"sfdsdf", "fsdfsa", "fsdfsd", "fsdfsdf", "dsfsdf", "sfdsdf",
                "fsdfsa", "fsdfsd", "fsdfsdf", "dsfsdf", "sfdsdf", "fsdfsa", "fsdfsd", "fsdfsdf",
                "dsfsdf", "sfdsdf", "fsdfsa", "fsdfsd", "fsdfsdf", "dsfsdf", "sfdsdf", "fsdfsa",
                "fsdfsd", "fsdfsdf", "dsfsdf", "sfdsdf",
                "fsdfsa", "fsdfsd", "fsdfsdf", "dsfsdf", "sfdsdf", "fsdfsa", "fsdfsd", "fsdfsdf",
                "dsfsdf", "sfdsdf", "fsdfsa", "fsdfsd", "fsdfsdf", "dsfsdf"};
        return datas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class NewAdapter extends RecyclerView.Adapter<ViewHolder> {

        private String[] datas = null;

        public NewAdapter(String[] datas) {
            this.datas = datas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            ViewHolder vh1 = new ViewHolder(view);
            return vh1;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv_show.setText(datas[position]);
        }

        @Override
        public int getItemCount() {
            return datas.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_show;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_show = (TextView) itemView.findViewById(R.id.tv_show);
        }
    }

}
