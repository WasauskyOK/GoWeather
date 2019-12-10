package com.example.goweather;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.view.ViewCompat;

public class CuadroDialogoMensajeLongClick {

    ImageView imagencancela;
    Animation animation;
    LinearLayout linearLayout;
public CuadroDialogoMensajeLongClick(Context contexto){

    final Dialog dialogo=new Dialog(contexto);
    //dialogo sin titulo
    dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialogo.setCancelable(false);
    dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    dialogo.setContentView(R.layout.dialogomensajeclicklong);
    imagencancela=dialogo.findViewById(R.id.idCloseVentanamensajeclicklong);

    linearLayout=dialogo.findViewById(R.id.lyprincipalprofile);
    animation= AnimationUtils.loadAnimation(contexto,R.anim.animacionfirst);

   // ViewCompat.animate(dialogo).setStartDelay().alpha(100)start();
    linearLayout.startAnimation(animation);
    ViewCompat.animate(linearLayout).setStartDelay(2000).alpha(1).start();
    imagencancela.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialogo.dismiss();
        }
    });

    dialogo.show();

}



}
