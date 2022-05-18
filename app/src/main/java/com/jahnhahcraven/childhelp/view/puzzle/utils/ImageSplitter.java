package com.jahnhahcraven.childhelp.view.puzzle.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jahnhahcraven.childhelp.model.puzzle.Tile;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ImageSplitter {

    public static ArrayList<Tile> splitImage(Context context,ArrayList<Tile>tile_list, String imgUrl, int chunkNumbers) {
        if(imgUrl.isEmpty()||imgUrl==null){
            return tile_list;
        }
        ArrayList<Bitmap> chunkedImages = new ArrayList<Bitmap>(chunkNumbers);
        Glide.with(context).asBitmap().load(imgUrl).centerCrop().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Bitmap bitmap=resource;
                Log.i("height", String.valueOf(bitmap.getHeight()));
//                Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getHeight(), bitmap.getHeight());
                int dimension = getSquareCropDimensionForBitmap(bitmap);
//              centercrop bitmap
                Bitmap scaledBitmap = ThumbnailUtils.extractThumbnail(bitmap, dimension, dimension);
                int rows= (int) Math.sqrt(chunkNumbers);
                int chunkHeight = scaledBitmap.getHeight()/rows;
                int chunkWidth = scaledBitmap.getWidth()/rows;
                for(int y=0;y<rows*chunkHeight;y+=chunkHeight){
                    for(int x=0;x<rows*chunkWidth;x+=chunkWidth){
                        chunkedImages.add(Bitmap.createBitmap(scaledBitmap, x, y, chunkWidth, chunkHeight));
                    }
                }
//
                for(int i=0;i<chunkedImages.size();i++){
                    int numero=tile_list.get(i).getNumero();
                    if(numero!=-1){
                        tile_list.get(i).setImage(chunkedImages.get(numero));
                    }
                }
            }
        });
        return tile_list;
    }


    public static int getSquareCropDimensionForBitmap(Bitmap bitmap)
    {
        //use the smallest dimension of the image to crop to
        return Math.min(bitmap.getWidth(), bitmap.getHeight());
    }
}
