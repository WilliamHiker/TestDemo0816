package com.dhc.android.testdemoforwzw.testpro;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.widget.Button;
import android.widget.ImageView;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;
import com.dhc.android.testdemoforwzw.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LruCatchActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView mImageView;
    @BindView(R.id.btn)
    Button mBtn;
    private LruCache<String, Bitmap> mMemoryCache;
    //1.获得虚拟机能提供的最大内存
    //注：超过该大小会抛出OutOfMemory的异常
    final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
    //2.设置LruCache缓存的大小 = 一般为当前进程可用容量的1/8
    //注：单位 = kb
    //设置准则
    //a.还剩余多少内存给你的activity或应用使用
    //b.屏幕上需要一次性显示多少张图片和多少图片在等待显示
    //c.手机的大小和密度是多少（密度越高的设备需要越大的缓存）
    //d.图片的尺寸（决定了所占用的内存大小）
    //e.图片的访问频率（频率越高的在内存中一直保存）
    //f.保存图片的质量（不同像素的在不同情况下显示）
    final int catchSize = maxMemory / 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(0, 0.75f, true);
//        map.put(0, 0);
//        map.put(1, 1);
//        map.put(2, 2);
//        map.put(3, 3);
//        map.put(4, 4);
//        map.put(5, 5);
//        map.put(6, 6);
//        map.get(1);
//        map.get(2);
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Log.e("***", entry.getKey() + ":" + entry.getValue());
//        }

        //3.重写sizeOf方法：计算缓存对象的大小（此处的缓存对象 = 图片）
        mMemoryCache = new LruCache<String, Bitmap>(catchSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return catchSize / 1024;

                //此处返回的是缓存对象的缓存大小（单位=kb），而不是item的个数
                //注：缓存的总容量和每个缓存对象的大小所用单位要一致
                //此处除1024是为了让缓存对象的大小单位=kb
            }
        };

        //4.将需缓存的图片加入到缓存
//        mMemoryCache.put(key,bitmap);
        //5.当ImageView加载图片时，会在LruCache中看有没有缓存该图片：若有，则直接获取
//        mMemoryCache.get(key);

    }

    /**
     * 分析1：加载图片
     * 加载前，先从内存缓存中读取；若无，则再从数据源中读取
     *
     * @return
     */
    public void loadBitmap(String key, ImageView image) {
        //读取图片前，先从内存缓存中加载
        Bitmap bitmap = mMemoryCache.get(key);
        if (bitmap != null) {
            mImageView.setImageBitmap(bitmap);
            //2.若无缓存，则从数据源加载（此处选择在本地加载）&添加到缓存
        } else {
            Log.e("***", "从数据源（本地）中加载：");
            //2.1 从数据源加载
            mImageView.setImageResource(R.mipmap.ic_launcher);
            //2.1添加到缓存
            //注：在添加到缓存前，需先将资源文件构造1个Bitmap对象（含设置大小）
            Resources res = getResources();
            Bitmap bm = BitmapFactory.decodeResource(res, R.drawable.ic_launcher);

            //获取图片的宽高
            int width = bm.getWidth();
            int height = bm.getHeight();

            //设置想要的大小
            int newWidth = 80;
            int newHeight = 80;

            //计算缩放比例
            float scaleWidth = ((float) newWidth) / width;
            float scaleHeight = ((float) newHeight) / height;

            //取得想要缩放的matrix参数
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            //构造成1个新的Bitmap对象
            Bitmap bitmap_s = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
            //添加到缓存
            if (mMemoryCache.get(key) == null) {
                mMemoryCache.put(key, bitmap_s);
                Log.e("***", "添加到缓存：" + (mMemoryCache.get(key)));
            }
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.aty_lru_catch;
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        loadBitmap("test",mImageView);
    }
}
