package com.botonerabenditatv.botonerabendita;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.content.ContentValues.TAG;


public class ButtonAdapter extends BaseAdapter {

    private Context context;

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

    private View.OnLongClickListener OnLong = new View.OnLongClickListener() {
        public boolean onLongClick(View v) {
            if (isStoragePermissionGranted() == true) {

                int soundResId = ((Integer) v.getTag()).intValue();

                String nombre = v.getResources().getResourceEntryName(soundResId);

                String nombreCompleto = "R.raw." + nombre;

                InputStream inputStream;
                FileOutputStream fileOutputStream;
                try {
                    inputStream = v.getResources().openRawResource(v.getResources().getIdentifier(nombre, "raw", context.getPackageName()));
                    fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "sound.mp3"));
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, length);
                    }

                    inputStream.close();
                    fileOutputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM,
                        Uri.parse("file://" + Environment.getExternalStorageDirectory() + "/sound.mp3"));
                intent.setType("audio/mp3");
                context.startActivity(Intent.createChooser(intent, "Share audio"));
            }
            return false;
        }
        };

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(((MainActivity)context), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            convertView = LayoutInflater.from(context).
                    inflate(R.layout.btn, parent, false);

            Item item = (Item) getItem(position);

            Button button = (Button) convertView.findViewById(R.id.myToggleButton);

            int sound = this.soundManager.keyAt(position);

            button.setTag(Integer.valueOf(sound));
            button.setText(this.soundManager.getSoundName(sound));
            button.setOnClickListener(this.onClickListener);
            button.setOnLongClickListener(this.OnLong);
        }
        return convertView;
    }

}