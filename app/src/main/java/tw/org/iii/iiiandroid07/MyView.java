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

import java.util.LinkedList;

public class MyView extends View {
    private LinkedList<Point> line;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLUE);

        line = new LinkedList<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX(), ey = event.getY();
        Point point = new Point(ex, ey);
        line.add(point);
        //  Java => repaint
        invalidate();
        return true; //super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);

        for(int i=1; i<line.size(); i++){
            Point p0 = line.get(i-1); Point p1 = line.get(i);
            canvas.drawLine(p0.x, p0.y, p1.x, p1.y, paint);
        }

    }

    private class Point {
        float x, y;
        Point(float x , float y){
            this.x = x; this.y = y;
        }
    }

}
