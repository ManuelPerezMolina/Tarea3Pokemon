package dam.pmdm.spyrothedragon.egg;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Fuego extends View {


    public Fuego(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint.setARGB(255, 255, 0, 0);
        paint2.setARGB(255, 255, 255, 0);
        for (int i = 0; i < 100; i++) {
            ValueAnimator animator = ValueAnimator.ofInt(0, 100);
            animator.setDuration(4000);
            animator.addUpdateListener(animation -> {
                int value = (int) animation.getAnimatedValue();
                canvas.drawCircle(280, 300, value, paint);
                canvas.drawCircle(280, 300, value - 10, paint2);
            });
            animator.start();
            invalidate();
        }

        super.onDraw(canvas);
    }
}
