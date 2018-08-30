package com.dhc.android.testdemoforwzw;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class CalenderTestView extends LinearLayout {

    private ImageView fore_iv;
    private ImageView next_iv;
    private TextView data_tv;
    private GridView gridview;
    private TextView title_tv;
    private Date selDay = new Date();

    private Calendar mCalendar = Calendar.getInstance();

    public CalenderTestView(Context context) {
        this(context, null, 0);
    }

    public CalenderTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalenderTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.calender_view, this);
        fore_iv = (ImageView) findViewById(R.id.fore_iv);
        next_iv = (ImageView) findViewById(R.id.next_iv);
        data_tv = (TextView) findViewById(R.id.data_tv);
        gridview = (GridView) findViewById(R.id.gridview);
        title_tv = (TextView) findViewById(R.id.title_tv);

        fore_iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendar.add(Calendar.MONTH, -1);
                showCalenderView();
            }
        });

        next_iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendar.add(Calendar.MONTH, 1);
                showCalenderView();
            }
        });
        showCalenderView();
    }

    /**
     * 得到选择的日期
     * @return
     */
    public Date getSelData(){
        return selDay;
    }

    public void showCalenderView() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        data_tv.setText(simpleDateFormat.format(mCalendar.getTime()));

        ArrayList<Date> dates = new ArrayList<>();
        Calendar calendar = (Calendar) mCalendar.clone();

        int month = 0;
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        month = calendar.get(Calendar.MONTH);
        int foreDays = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        calendar.add(Calendar.DAY_OF_MONTH, -foreDays);

        int maxDatesCount = 6 * 7;
        while (dates.size() < maxDatesCount) {
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        gridview.setAdapter(new CalenderAdapter(getContext(), dates, month, foreDays));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        title_tv.setText(simpleDateFormat2.format(selDay.getTime()));
    }

    private class CalenderAdapter extends BaseAdapter {

        private ArrayList<Date> dates = new ArrayList<>();
        private Context mContext;
        private int mThisMonth;
        private int mForeDays;      //前面空了几个格 用来给下面的价格赋值

        public CalenderAdapter(Context context, ArrayList<Date> dates, int thisMonth, int foreDays) {
            this.dates = dates;
            this.mContext = context;
            this.mThisMonth = thisMonth;
            this.mForeDays = foreDays;
        }


        @Override
        public int getCount() {
            return dates.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

            final Date date = dates.get(position);
            Log.e("///", "date.getMonth():" + date.getMonth() + " date.getDate():" + date.getDate() + " mThisMonth:" + mThisMonth + " mForeDays:" + mForeDays);

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.calender_text_day, parent, false);
            }
            int day = date.getDate();
            ((TextView) (convertView).findViewById(R.id.calender_day_tv)).setText(String.valueOf(day));

            boolean isThisMonth = false;
            if (date.getMonth() == mThisMonth) {
                isThisMonth = true;
            }
            if (isThisMonth) {
                ((TextView) (convertView).findViewById(R.id.calender_day_tv)).setTextColor(Color.parseColor("#000000"));
                ((TextView) (convertView).findViewById(R.id.price_tv)).setVisibility(VISIBLE);
                convertView.findViewById(R.id.ll).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selDay = date;
                        showCalenderView();
                    }
                });
            } else {
                ((TextView) (convertView).findViewById(R.id.calender_day_tv)).setTextColor(Color.TRANSPARENT);
                ((TextView) (convertView).findViewById(R.id.price_tv)).setVisibility(GONE);
                convertView.findViewById(R.id.ll).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            if (selDay.getDate() == date.getDate() && selDay.getMonth() == date.getMonth() && selDay.getYear() == date.getYear() && isThisMonth) {
                ((TextView) (convertView).findViewById(R.id.calender_day_tv)).setBackgroundResource(R.drawable.shape_orange_oval);
                ((TextView) (convertView).findViewById(R.id.calender_day_tv)).setTextColor(Color.WHITE);
            }
            return convertView;
        }
    }
}
