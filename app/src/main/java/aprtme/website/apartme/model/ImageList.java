package aprtme.website.apartme.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

import aprtme.website.apartme.R;

/**
 * Created by patri_000 on 10/24/2017.
 */

public class ImageList {


    public static ArrayList<ImageSet> imageSets;


    public ImageList(Context ctx){
        fillImageSets(ctx);
    }


    private void fillImageSets(Context ctx)
    {

        Bitmap image00 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt00);
        Bitmap image01 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt01);
        Bitmap image02 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt02);
        Bitmap image03 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt03);

        ImageSet set0 = new ImageSet();
        set0.imageSet.add(image00);
        set0.imageSet.add(image01);
        set0.imageSet.add(image02);
        set0.imageSet.add(image03);

        imageSets.add(set0);

        Bitmap image10 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt10);
        Bitmap image11 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt11);
        Bitmap image12 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt12);
        Bitmap image13 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt13);

        ImageSet set1 = new ImageSet();
        set0.imageSet.add(image10);
        set0.imageSet.add(image11);
        set0.imageSet.add(image12);
        set0.imageSet.add(image13);

        imageSets.add(set1);

        Bitmap image20 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt20);
        Bitmap image21 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt21);
        Bitmap image22 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt22);
        Bitmap image23 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt23);

        ImageSet set2 = new ImageSet();
        set0.imageSet.add(image20);
        set0.imageSet.add(image21);
        set0.imageSet.add(image22);
        set0.imageSet.add(image23);

        imageSets.add(set2);


        Bitmap image30 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt30);
        Bitmap image31 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt31);
        Bitmap image32 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt32);
        Bitmap image33 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt33);

        ImageSet set3 = new ImageSet();
        set0.imageSet.add(image30);
        set0.imageSet.add(image31);
        set0.imageSet.add(image32);
        set0.imageSet.add(image33);

        imageSets.add(set3);

        Bitmap image40 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt40);
        Bitmap image41 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt41);
        Bitmap image42 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt42);
        Bitmap image43 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt43);

        ImageSet set4 = new ImageSet();
        set0.imageSet.add(image40);
        set0.imageSet.add(image41);
        set0.imageSet.add(image42);
        set0.imageSet.add(image43);

        imageSets.add(set4);

        Bitmap image50 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt50);
        Bitmap image51 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt51);
        Bitmap image52 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt52);
        Bitmap image53 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt53);

        ImageSet set5 = new ImageSet();
        set0.imageSet.add(image50);
        set0.imageSet.add(image51);
        set0.imageSet.add(image52);
        set0.imageSet.add(image53);

        imageSets.add(set5);


        Bitmap image60 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt60);
        Bitmap image61 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt61);
        Bitmap image62 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt62);
        Bitmap image63 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt63);

        ImageSet set6 = new ImageSet();
        set0.imageSet.add(image60);
        set0.imageSet.add(image61);
        set0.imageSet.add(image62);
        set0.imageSet.add(image63);

        imageSets.add(set6);


        Bitmap image70 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt70);
        Bitmap image71 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt71);
        Bitmap image72 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt72);
        Bitmap image73 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt73);

        ImageSet set7 = new ImageSet();
        set0.imageSet.add(image70);
        set0.imageSet.add(image71);
        set0.imageSet.add(image72);
        set0.imageSet.add(image73);

        imageSets.add(set7);


        Bitmap image80 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt80);
        Bitmap image81 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt81);
        Bitmap image82 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt82);
        Bitmap image83 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.apt83);

        ImageSet set8 = new ImageSet();
        set0.imageSet.add(image80);
        set0.imageSet.add(image81);
        set0.imageSet.add(image82);
        set0.imageSet.add(image83);

        imageSets.add(set8);

    }


}
