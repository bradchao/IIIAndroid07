package tw.org.iii.iiiandroid07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLUE);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("brad", "onClick");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v("brad", "onTouch");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        canvas.drawLine(0, 0, 200, 200, paint);
    }
}
