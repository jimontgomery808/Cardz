package com.example.josh.cardz;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

public class LinedEditText extends android.support.v7.widget.AppCompatEditText
{
    private Rect mRect;
    private Paint mPaint;

    // we need this constructor for LayoutInflater
    public LinedEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLACK); //SET YOUR OWN COLOR HERE
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //int count = getLineCount();

        int height = getHeight();
        int line_height = getLineHeight();

        int count = height / line_height;

        if (getLineCount() > count)
            count = getLineCount();//for long text with scrolling

        Rect r = mRect;
        Paint paint = mPaint;
        int baseline = getLineBounds(0, r);//first line
        Paint pink = new Paint();
        pink.setColor(Color.parseColor("#FFC0CB"));

        canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, pink);
        baseline += getLineHeight();
        for (int i = 1; i <= count; i++)
        {
            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
            baseline += getLineHeight();//next line
        }

        super.onDraw(canvas);
    }
}