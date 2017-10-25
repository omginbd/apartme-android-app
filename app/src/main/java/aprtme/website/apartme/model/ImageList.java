package aprtme.website.apartme.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

import aprtme.website.apartme.R;

/**
 * Created by patri_000 on 10/24/2017.
 */

public class ImageList {


    public static ArrayList<ImageSet> imageSets = new ArrayList<>();


    public ImageList(Context ctx){
        fillImageSets(ctx);
    }


    private void fillImageSets(Context ctx)
    {

        ImageSet set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt00, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt01, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt02, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt03, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt10, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt11, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt12, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt13, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt20, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt21, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt22, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt23, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt30, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt31, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt32, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt33, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt40, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt41, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt42, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt43, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt50, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt51, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt52, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt53, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt60, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt61, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt62, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt63, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt70, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt71, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt72, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt73, 250, 250));
        imageSets.add(set0);

        set0 = new ImageSet();
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt80, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt81, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt82, 250, 250));
        set0.imageSet.add(decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.apt83, 250, 250));
        imageSets.add(set0);

    }


    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}
