package com.dhc.android.testdemoforwzw.testpro.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.okgo.model.HttpParams;
import com.dhc.android.testdemoforwzw.AnimTestAty2;
import com.dhc.android.testdemoforwzw.AnimTestAty3;
import com.dhc.android.testdemoforwzw.CardViewAty;
import com.dhc.android.testdemoforwzw.CircularRevealAty;
import com.dhc.android.testdemoforwzw.ClockTestAty;
import com.dhc.android.testdemoforwzw.ColorMatrixAty;
import com.dhc.android.testdemoforwzw.ColorMatrixAty2;
import com.dhc.android.testdemoforwzw.CommonTabAty;
import com.dhc.android.testdemoforwzw.CustomBannerAty;
import com.dhc.android.testdemoforwzw.DragViewAty;
import com.dhc.android.testdemoforwzw.MaterialDesignAty;
import com.dhc.android.testdemoforwzw.MaterialDesignAty2;
import com.dhc.android.testdemoforwzw.OverrideViewAty;
import com.dhc.android.testdemoforwzw.PermissinsDispatchederActivity;
import com.dhc.android.testdemoforwzw.PropertyValuesHolderAty;
import com.dhc.android.testdemoforwzw.R;
import com.dhc.android.testdemoforwzw.SurfaceViewAty;
import com.dhc.android.testdemoforwzw.SurfaceViewAty2;
import com.dhc.android.testdemoforwzw.TabLayoutAty;
import com.dhc.android.testdemoforwzw.TestAnimAty;
import com.dhc.android.testdemoforwzw.TestDemoForJavaAty;
import com.dhc.android.testdemoforwzw.ToolbarAty;
import com.dhc.android.testdemoforwzw.Transition1Aty;
import com.dhc.android.testdemoforwzw.ZhiHuSelPicAty;
import com.dhc.android.testdemoforwzw.model.IndexModel;
import com.dhc.android.testdemoforwzw.testpro.iosfgt.IOSDialogFragment;
import com.dhc.android.base.api.ApiListener;
import com.dhc.android.base.api.ApiTool;
import com.dhc.android.base.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private List<String> mList = new ArrayList<>();
    TestAdapter mTestAdapter;

    IOSDialogFragment mIOSDialogFragment = new IOSDialogFragment();

    @Override
    public void initData(Bundle savedInstanceState) {
        for (int i = 0; i < 50; i++) {
            mList.add("第" + i + "个测试item");
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mTestAdapter = new TestAdapter(R.layout.listitem_test_basequick, mList);
        mRecyclerView.setAdapter(mTestAdapter);
        mTestAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mTestAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), OverrideViewAty.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getActivity(), DragViewAty.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(getActivity(), ColorMatrixAty.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(getActivity(), ColorMatrixAty2.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(getActivity(), ClockTestAty.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(getActivity(), SurfaceViewAty.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(getActivity(), SurfaceViewAty2.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(getActivity(), MaterialDesignAty.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(getActivity(), CardViewAty.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(getActivity(), Transition1Aty.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(getActivity(), MaterialDesignAty2.class);
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(getActivity(), CircularRevealAty.class);
                    startActivity(intent);
                } else if (position == 12) {
                    Intent intent = new Intent(getActivity(), ToolbarAty.class);
                    startActivity(intent);
                } else if (position == 13) {
                    Intent intent = new Intent(getActivity(), PermissinsDispatchederActivity.class);
                    startActivity(intent);
                } else if (position == 14) {
                    Intent intent = new Intent(getActivity(), TestAnimAty.class);
                    startActivity(intent);
                } else if (position == 15) {
                    Intent intent = new Intent(getActivity(), AnimTestAty2.class);
                    startActivity(intent);
                } else if (position == 16) {
                    Intent intent = new Intent(getActivity(), AnimTestAty3.class);
                    startActivity(intent);
                } else if (position == 17) {
                    Intent intent = new Intent(getActivity(), PropertyValuesHolderAty.class);
                    startActivity(intent);
                } else if (position == 18) {
                    Intent intent = new Intent(getActivity(), ZhiHuSelPicAty.class);
                    startActivity(intent);
                } else if (position == 19) {
                    Intent intent = new Intent(getActivity(), TestDemoForJavaAty.class);
                    startActivity(intent);
                } else if (position == 20) {
                    Intent intent = new Intent(getActivity(), CustomBannerAty.class);
                    startActivity(intent);
                }else if (position == 21){
                    Intent intent = new Intent(getActivity(), TabLayoutAty.class);
                    startActivity(intent);
                }else if (position == 22){
                    Intent intent = new Intent(getActivity(), CommonTabAty.class);
                    startActivity(intent);
                }
            }
        });

        View headView = new View(getActivity());
        headView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        headView.setBackgroundColor(Color.parseColor("#00FFFF"));
        mTestAdapter.addHeaderView(headView);

        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                mIOSDialogFragment.show(fragmentTransaction, null);
            }
        });

        View footView = new View(getActivity());
        footView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        footView.setBackgroundColor(Color.parseColor("#00FFFF"));
        mTestAdapter.addFooterView(footView);

        footView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index("2917", "119", "37", "1", "1", new onIndexFinsiehd() {
                    @Override
                    public void index(IndexModel bean) {
                        Toast.makeText(context, "hahaah", Toast.LENGTH_SHORT).show();
                        Log.e("***", bean.toString());
                    }
                });
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fgt_btn2;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public class TestAdapter extends BaseQuickAdapter<String, TestAdapter.ViewHolder> {
        public TestAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(ViewHolder helper, String item) {
            helper.mTextView.setText(item);
        }

        public class ViewHolder extends BaseViewHolder {
            TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mTextView = view.findViewById(R.id.tv);
            }
        }
    }

    //接口测试
    private interface onIndexFinsiehd {
        void index(IndexModel bean);
    }

    private void index(String region_id, String lat, String lng, String p, String member_id, final onIndexFinsiehd finsiehd) {
        HttpParams params = new HttpParams();
        params.put("region_id", region_id);
        params.put("lat", lat);
        params.put("lng", lng);
        params.put("p", p);
        params.put("member_id", member_id);
        ApiTool<IndexModel> apiTool = new ApiTool<>();
        apiTool.postApi(getActivity(),"Index/index", params, new ApiListener<IndexModel>() {
            @Override
            public void onComplete(IndexModel bean, Call call, Response response) {
                finsiehd.index(bean);
                Log.e("***","----------------哈哈哈------------------");
            }
        });
    }

}
