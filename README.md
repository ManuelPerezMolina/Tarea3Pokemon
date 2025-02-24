# GUIA DE FUNCIONAMIENTO APP POKEMON
## Introduccion

Hemos realizado una guia superpuesta a la app clonada,en ella, damos una breve explicación de cada una de las pantallas de dicha app, así como del menu información. Tambien hemos añadido unos easter eggs, uno de video y otro de animación, que se puede activar realizando una serie de pasos que indicaremos después en la explicación del uso de la guia.
Tambien hemos creado una pantalla de bienvenida que nos introduce en la app.
La app nos presenta tres pantallas relacionadas con el mundo de Spyro (**Personajes, Mundos y Coleccionables**).

## Caracteristicas Principales

la app consta de 3 pantallas principales mas la pantalla de bienvenida.

|Pantalla Bienvenida|Pantalla Personajes|Pantalla Mundos|Pantalla Coleccionables|
|---|---|---|---|
|<img src="https://github.com/user-attachments/assets/668cfb8e-df3c-488f-a039-3795ab8cf29b" alt="Bienvenida" width="200" height="300">|<img src="https://github.com/user-attachments/assets/02c488de-1f93-4391-adab-ebdf38ab8fc5" alt="Personajes" width="200" height="300">|<img src="https://github.com/user-attachments/assets/37d2794c-2318-4e94-ab93-0a1354fdb72c" alt="Mundos" width="200" height="300">|<img src="https://github.com/user-attachments/assets/fb3867e2-0636-4e51-a347-8079fbcc6181" alt="Coleccionables" width="200" height="300">|

También tiene una pantalla acerca de (Podemos ver el nombre del desarrollador).

<img src="https://github.com/user-attachments/assets/1126e64d-cde7-4527-8669-e0cc1ce6188f" alt="Acerca de" width="200" height="300">

La guia que hemos realizado presenta las siguientes pantallas

|Pantalla Personajes|Pantalla Mundos|Pantalla Coleccionables|Pantalla Acerca de|Pantalla Resumen|
|---|---|---|---|---|
|<img src="https://github.com/user-attachments/assets/9a91e5c0-49f0-46cb-9118-9d9a848c6921" alt="Guia Personajes" width="200" height="300">|<img src="https://github.com/user-attachments/assets/19037aaa-7136-4380-9f04-fb49152226f7" alt="Guia Mundos" width="200" height="300">|<img src="https://github.com/user-attachments/assets/526bb721-b9ff-4ec7-a5c1-f1740e3c2c2f" alt="Guia Coleccionables" width="200" height="300">|<img src="https://github.com/user-attachments/assets/07fa434f-48dc-452b-998e-ddf3fd491054" alt="Guia Coleccionables" width="200" height="300">|<img src="https://github.com/user-attachments/assets/d09883e8-d97e-4512-9245-655dbcb895c4" alt="Guia Coleccionables" width="200" height="300">

Hemos añadido dos easter eggs, que se activaran realizando una serie de pasos que indicaremos después en la explicación del uso de la guia.

## Tecnologias Utilizadas.

La principal tecnologia que hemos utilizado es 

```
 <include> </include> 
```

con estas etiquetas hacemos posible ver fragment sobre los fragment de la app, y de esta forma ver la guia sobre las pantallas.

Hemos utilizado animaciones para los bocadillos de la guia.

Para que aparezca el boton siguiente en los fragment de la guia utilizamos el siguiente codigo que esperar un tiempo antes de que se realize la accion que indicamos

```
new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    fragmentGuia2Binding.bsig2.setVisibility(View.VISIBLE);
                }
            }, 7000);
```

VideoView para ver el video que hemos añadido como easter eggs.

```

VideoView videov = fragmentVideoBinding.video;
        videov.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.videospyro);
        videov.start();

```

Para el dibujo de otro easter egg, hemos utilizado canvas y animator.

```
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
                canvas.drawCircle(280,300,value,paint);
                canvas.drawCircle(280,300,value-10,paint2);
            });
            animator.start();
            invalidate();
        }

        super.onDraw(canvas);
    }
 ```

Tambien he creado varias animaciones, guardadas en res/anim, que se han utilizado en los bocadillos de información de la guia.

```
<rotate
<alpha
<translate
<scale
```

## Intrucciones de funcionamiento de la guia

La app comienza con una pantalla de bienvenida, y da paso a la aplicación al pulsar **COMENZAR**.
La guia se abre cada vez que iniciamos la app, hasta que se vea completa, a partir de ese momento ya no aparecerá.
Se puede saltar en cualquier momento pulsando sobre **SALTAR GUIA**, pero volvera a salir la siguiente vez que se abra la app.
En cada pantalla de la guía aparece un botón **SIGUIENTE**, a los segundos de abrirse dicha pantalla.
Las pantallas de la guía son transparentes y podemos ver la pantalla de la app, a la que hace referencia la guia.

## Clonar Repositorio

[Repositorio PokedexMPM](https://docs.github.com/es/repositories/creating-and-managing-repositories/cloning-a-repository)
  Seguir los pasos indicados en el docs de github.

## Conclusión del desarrollador

Esta practica ha sido interesante para ver como interactuar con varios fragment a la vez, también he visto productivo, actualizar una app ya existente añadiendole nuevas funcionalidades sin que pierda el funcionamiento de dicha app.
Me ha parecido bastante util el realizar los easter eggs, ya que es algo que no añade funcionalidad a la app, pero mejora bastante la experiencia de usuario.
