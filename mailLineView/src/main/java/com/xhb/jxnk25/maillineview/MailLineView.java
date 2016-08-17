package com.xhb.jxnk25.maillineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 *  time  2016-08-03
 *  @author xhb
 *  decribe：收件地址信封分割线
 */
public class MailLineView extends View {

    private int colorWidth = 7;//颜色区域宽度
    private int emptyWidth = 1;//间隔宽度
    private Paint paint;
    private Path path;

    public MailLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public MailLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MailLineView(Context context) {
        super(context);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    public void initPaint(){
        paint = new Paint();
        paint.setAntiAlias(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {

        int viewHeight = getHeight();
        int drawLength = 0;
        int count = 0;
        while (drawLength < getWidth()) {
            drawLength += emptyWidth * viewHeight;
            count++;
            /*设置paint的颜色*/
            if (count % 2 == 1) {
                paint.setColor(Color.rgb(255, 134, 134));
            } else {
                paint.setColor(Color.rgb(134, 194, 255));
            }
            /*开始画多边形*/
            path = new Path();
            path.moveTo(drawLength, viewHeight);// 此点为多边形的起点
            path.lineTo(drawLength + colorWidth * viewHeight - viewHeight, viewHeight);
            path.lineTo(drawLength + colorWidth * viewHeight, 0);
            path.lineTo(drawLength + viewHeight, 0);
            path.close(); // 使这些点构成封闭的多边形
            canvas.drawPath(path, paint);
            drawLength += colorWidth * viewHeight;
        }
    }

}
