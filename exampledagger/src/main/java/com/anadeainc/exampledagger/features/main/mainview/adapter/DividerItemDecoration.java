package com.anadeainc.exampledagger.features.main.mainview.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private final Paint paint;

    public DividerItemDecoration(Context context, int colorResId, int dividerWidthDimenResId) {

        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, colorResId));
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(dividerWidthDimenResId));
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(canvas, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int y = child.getBottom() + params.bottomMargin;
            canvas.drawLine(left, y, right, y, paint);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }

}
