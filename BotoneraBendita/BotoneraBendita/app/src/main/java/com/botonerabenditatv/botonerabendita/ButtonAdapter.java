package com.botonerabenditatv.botonerabendita;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ButtonAdapter extends BaseAdapter {
    
    private Context context;

    private static Uri soundUri = null;

    private OnClickListener onClickListener = new OnClickListener() {
        public void onClick(View v) {
            int soundResId = ((Integer) v.getTag()).intValue();

            if (ButtonAdapter.this.soundManager.play(soundResId)) {
                String name = ButtonAdapter.this.soundManager.getSoundName(soundResId);
                ButtonAdapter.this.toast.setText(name);
                ButtonAdapter.this.toast.show();
             }
        }
    };


    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        public boolean onLongClick(View v) {

            int soundResId = ((Integer) v.getTag()).intValue();

            String name = v.getResources().getResourceEntryName(soundResId);

            Uri soundPath = Uri.parse("android.resource://com.botonerabenditatv.botonerabendita/raw/" + name);

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, soundPath);
            shareIntent.setType("image/*");
            // Launch sharing dialog for image
            context.startActivity(Intent.createChooser(shareIntent, "Share Image"));

            return true;
        }
    };


    private SoundManager soundManager;
    private Toast toast;

    @SuppressLint({"ShowToast"})
    public ButtonAdapter(Context c) {
        this.context = c;
        this.soundManager = SoundManager.getInstance();
        this.toast = Toast.makeText(this.context, "", Toast.LENGTH_SHORT);
    }

    public int getCount() {
        return this.soundManager.getSize();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(this.context);
            button.setHeight(210);
            button.setBackgroundColor(R.drawable.button_border);

            button.setTextColor(-1);

            button.setOnClickListener(this.onClickListener);
            button.setOnLongClickListener(this.onLongClickListener);
        } else {
            button = (Button) convertView;
        }
        int sound = this.soundManager.keyAt(position);
        button.setTag(Integer.valueOf(sound));
        button.setText(this.soundManager.getSoundName(sound));
        return button;
    }



}