package dam.pmdm.spyrothedragon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding;
import dam.pmdm.spyrothedragon.databinding.FragmentDibujoBinding;
import dam.pmdm.spyrothedragon.databinding.FragmentGuia2Binding;
import dam.pmdm.spyrothedragon.databinding.FragmentGuia3Binding;
import dam.pmdm.spyrothedragon.databinding.FragmentGuia4Binding;
import dam.pmdm.spyrothedragon.databinding.FragmentGuia5Binding;
import dam.pmdm.spyrothedragon.databinding.FragmentGuiaBinding;
import dam.pmdm.spyrothedragon.databinding.FragmentVideoBinding;

public class MainActivity extends AppCompatActivity {

    NavController navController = null;
    private ActivityMainBinding binding;
    private Boolean verGuia, GuiaCompleta;
    private FragmentGuiaBinding fragmentGuiaBinding;
    private FragmentGuia2Binding fragmentGuia2Binding;
    private FragmentGuia3Binding fragmentGuia3Binding;
    private FragmentGuia4Binding fragmentGuia4Binding;
    private FragmentGuia5Binding fragmentGuia5Binding;
    private FragmentVideoBinding fragmentVideoBinding;
    private FragmentDibujoBinding fragmentDibujoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("Guia", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences1 = getSharedPreferences("GuiaCompleta", Context.MODE_PRIVATE);
        GuiaCompleta = sharedPreferences1.getBoolean("GuiaCompleta", false);
        if (!GuiaCompleta) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Guia", true);
            editor.apply();
        }
        verGuia = sharedPreferences.getBoolean("Guia", true);


        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        if (navHostFragment != null) {
            navController = NavHostFragment.findNavController(navHostFragment);
            NavigationUI.setupWithNavController(binding.navView, navController);
            NavigationUI.setupActionBarWithNavController(this, navController);
        }

        binding.navView.setOnItemSelectedListener(this::selectedBottomMenu);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.navigation_characters ||
                    destination.getId() == R.id.navigation_worlds ||
                    destination.getId() == R.id.navigation_collectibles) {
                // Para las pantallas de los tabs, no queremos que aparezca la flecha de atrás
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            } else {
                // Si se navega a una pantalla donde se desea mostrar la flecha de atrás, habilítala
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            if (verGuia) {
                mostrarGuia();
            }
        });

    }

    private void mostrarGuia() {

        fragmentGuiaBinding = binding.fg;

        fragmentGuiaBinding.saltoguia.setOnClickListener(v -> {
            fragmentGuiaBinding.frGuia.setVisibility(View.GONE);
            SharedPreferences sharedPreferences = getSharedPreferences("Guia", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Guia", false);
            editor.apply();
        });

        fragmentGuiaBinding.bsig.setOnClickListener(v -> {
            mostrarGuia2();
        });

        if (verGuia) {
            fragmentGuiaBinding.frGuia.setVisibility(verGuia ? View.VISIBLE : View.GONE);
            final Animation animacion = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
            TextView bocadillo = fragmentGuiaBinding.tv;
            bocadillo.setAnimation(animacion);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuiaBinding.bsig.setVisibility(View.VISIBLE);
                }
            }, 7000);
        } else {
            fragmentGuiaBinding.frGuia.setVisibility(verGuia ? View.VISIBLE : View.GONE);
        }
    }

    @SuppressLint("ResourceType")
    private void mostrarGuia2() {

        navController.navigate(R.id.navigation_worlds);
        fragmentGuia2Binding = binding.fg2;
        fragmentGuiaBinding.frGuia.setVisibility(View.GONE);

        fragmentGuia2Binding.saltoguia2.setOnClickListener(v -> {
            fragmentGuia2Binding.frGuia2.setVisibility(View.GONE);
            SharedPreferences sharedPreferences = getSharedPreferences("Guia", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Guia", false);
            editor.apply();
        });

        fragmentGuia2Binding.bsig2.setOnClickListener(v -> {
            mostrarGuia3();
        });

        if (verGuia) {
            fragmentGuia2Binding.frGuia2.setVisibility(verGuia ? View.VISIBLE : View.GONE);
            final Animation animacion = AnimationUtils.loadAnimation(this, R.anim.giros);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.crickets);
            mp.start();
            TextView bocadillo = fragmentGuia2Binding.tv2;
            bocadillo.setAnimation(animacion);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia2Binding.bsig2.setVisibility(View.VISIBLE);
                }
            }, 7000);
        } else {
            fragmentGuia2Binding.frGuia2.setVisibility(verGuia ? View.VISIBLE : View.GONE);
        }

    }

    private void mostrarGuia3() {

        navController.navigate(R.id.navigation_collectibles);
        fragmentGuia3Binding = binding.fg3;
        fragmentGuiaBinding.frGuia.setVisibility(View.GONE);
        fragmentGuia2Binding.frGuia2.setVisibility(View.GONE);

        fragmentGuia3Binding.saltoguia3.setOnClickListener(v -> {
            fragmentGuia3Binding.frGuia3.setVisibility(View.GONE);
            SharedPreferences sharedPreferences = getSharedPreferences("Guia", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Guia", false);
            editor.apply();
        });

        fragmentGuia3Binding.bsig3.setOnClickListener(v -> {
            mostrarGuia4();
        });

        if (verGuia) {
            fragmentGuia3Binding.frGuia3.setVisibility(verGuia ? View.VISIBLE : View.GONE);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.rushingwater);
            mp.start();
            final Animation animacion = AnimationUtils.loadAnimation(this, R.anim.desvanecer);
            TextView bocadillo = fragmentGuia3Binding.tv3;
            bocadillo.setAnimation(animacion);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia3Binding.bsig3.setVisibility(View.VISIBLE);
                }
            }, 7000);
        } else {
            fragmentGuia3Binding.frGuia3.setVisibility(verGuia ? View.VISIBLE : View.GONE);
        }
    }

    private void mostrarGuia4() {

        navController.navigate(R.id.navigation_collectibles);
        fragmentGuia4Binding = binding.fg4;
        fragmentGuiaBinding.frGuia.setVisibility(View.GONE);
        fragmentGuia2Binding.frGuia2.setVisibility(View.GONE);
        fragmentGuia3Binding.frGuia3.setVisibility(View.GONE);

        fragmentGuia4Binding.saltoguia4.setOnClickListener(v -> {
            fragmentGuia4Binding.frGuia4.setVisibility(View.GONE);
            SharedPreferences sharedPreferences = getSharedPreferences("Guia", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Guia", false);
            editor.apply();
        });

        fragmentGuia4Binding.bsig4.setOnClickListener(v -> {
            mostrarGuia5();
        });

        if (verGuia) {
            fragmentGuia4Binding.frGuia4.setVisibility(verGuia ? View.VISIBLE : View.GONE);
            final Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animvaria);
            TextView bocadillo = fragmentGuia4Binding.tv4;
            bocadillo.setAnimation(animacion);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.portal1);
            mp.start();
            final Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
            ImageView dedos = fragmentGuia4Binding.dedos4;
            animacion2.setRepeatMode(5);
            dedos.setAnimation(animacion2);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia4Binding.bsig4.setVisibility(View.VISIBLE);
                }
            }, 7000);
        } else {
            fragmentGuia3Binding.frGuia3.setVisibility(verGuia ? View.VISIBLE : View.GONE);
        }
    }

    private void mostrarGuia5() {

        navController.navigate(R.id.navigation_characters);
        fragmentGuia5Binding = binding.fg5;
        fragmentGuiaBinding.frGuia.setVisibility(View.GONE);
        fragmentGuia2Binding.frGuia2.setVisibility(View.GONE);
        fragmentGuia3Binding.frGuia3.setVisibility(View.GONE);
        fragmentGuia4Binding.frGuia4.setVisibility(View.GONE);

        fragmentGuia5Binding.huevo.setOnClickListener(v -> {
            fragmentGuia5Binding.frGuia5.setVisibility(View.GONE);
            SharedPreferences sharedPreferences = getSharedPreferences("Guia", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Guia", false);
            editor.putBoolean("GuiaCompleta", true);
            editor.apply();
        });

        if (verGuia) {
            fragmentGuia5Binding.frGuia5.setVisibility(verGuia ? View.VISIBLE : View.GONE);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.frog2);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia5Binding.tv.setVisibility(View.VISIBLE);
                }
            }, 2000);
            mp.start();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia5Binding.tv1.setVisibility(View.VISIBLE);
                }
            }, 4000);
            mp.start();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia5Binding.tv2.setVisibility(View.VISIBLE);
                }
            }, 6000);
            mp.start();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia5Binding.tv3.setVisibility(View.VISIBLE);
                }
            }, 8000);
            mp.start();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia5Binding.tv4.setVisibility(View.VISIBLE);
                }
            }, 10000);
            mp.start();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia5Binding.btfinal.setVisibility(View.VISIBLE);
                }
            }, 12000);
            mp.start();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia5Binding.huevo.setVisibility(View.VISIBLE);
                }
            }, 14000);
            mp.start();
        } else {
            fragmentGuia5Binding.frGuia5.setVisibility(verGuia ? View.VISIBLE : View.GONE);
        }
    }

    private boolean selectedBottomMenu(@NonNull MenuItem menuItem) {
        SharedPreferences sharedPreferences = getSharedPreferences("Guia", Context.MODE_PRIVATE);
        verGuia = sharedPreferences.getBoolean("Guia", true);
        if (menuItem.getItemId() == R.id.nav_characters)
            navController.navigate(R.id.navigation_characters);
        else if (menuItem.getItemId() == R.id.nav_worlds)
            navController.navigate(R.id.navigation_worlds);
        else
            navController.navigate(R.id.navigation_collectibles);
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú
        getMenuInflater().inflate(R.menu.about_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Gestiona el clic en el ítem de información
        if (item.getItemId() == R.id.action_info) {
            showInfoDialog();  // Muestra el diálogo
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        // Crear un diálogo de información
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_about)
                .setMessage(R.string.text_about)
                .setPositiveButton(R.string.accept, null)
                .show();
    }

    public void verVideo() {
        fragmentVideoBinding = binding.fv;
        fragmentVideoBinding.frv.setVisibility(View.VISIBLE);
        VideoView videov = fragmentVideoBinding.video;
        videov.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videospyro);
        videov.start();
        videov.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                fragmentVideoBinding.frv.setVisibility(View.GONE);
            }
        });
    }

    public void dibujo() {
        fragmentDibujoBinding = binding.fd;
        fragmentDibujoBinding.frd.setVisibility(View.VISIBLE);
        System.out.println("dibujo");
        new Handler(Looper.getMainLooper()).postDelayed((Runnable) () ->
                fragmentDibujoBinding.frd.setVisibility(View.GONE), 4000);
    }
}