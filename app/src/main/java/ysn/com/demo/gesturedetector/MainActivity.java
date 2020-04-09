package ysn.com.demo.gesturedetector;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ysn.com.demo.gesturedetector.listener.OnSlideRightToLeftListener;

public class MainActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView jackTextView = findViewById(R.id.main_activity_jack);
        jackTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LogUtils.d("onLongClick");
                return false;
            }
        });

        final View btn = findViewById(R.id.main_activity_btn);
        gestureDetector = new GestureDetector(this, new JackGestureListener()
                .setOnSlideRightToLeftListener(new OnSlideRightToLeftListener() {
                    @Override
                    public void onSlideRightToLeft(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) btn.getLayoutParams();
                        params.rightMargin += distanceX;
                        btn.setLayoutParams(params);
                    }
                }));

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (gestureDetector != null) {
            if (gestureDetector.onTouchEvent(ev)) {
                // 执行滑动事件
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
