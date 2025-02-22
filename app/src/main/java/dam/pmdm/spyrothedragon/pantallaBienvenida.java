package dam.pmdm.spyrothedragon;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class pantallaBienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida);
        ImageView iv = findViewById(R.id.diamante);
        llegadaImagen(iv);
        Button boton = findViewById(R.id.bcomenzar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantallaBienvenida.this, MainActivity.class);
                startActivity(intent);
                MediaPlayer mp = MediaPlayer.create(v.getContext(), R.raw.up);
                mp.start();
            }
        });


    }

    private void llegadaImagen(ImageView image) {
        final ValueAnimator anim = ValueAnimator.ofFloat(0.1f, 1.5f);
        anim.setDuration(4000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                image.setScaleX((Float) animation.getAnimatedValue());
                image.setScaleY((Float) animation.getAnimatedValue());
            }
        });
        anim.start();
    }
}
