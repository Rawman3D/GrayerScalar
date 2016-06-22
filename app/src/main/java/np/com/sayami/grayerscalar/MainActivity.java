package np.com.sayami.grayerscalar;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Bitmap operation1;
    ImageView imageView;
    //    Bitmap getBmp = BitmapFactory.decodeResource(getResources(), R.drawable.david);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.bird));


    }

    //One way: get each pixel RGB and set each pixel in b/w
    public void performGrayscale(View view){
        Bitmap getBmp = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        double red = 0.299;
        double green = 0.587;
        double blue = 0.114;
             operation1 = Bitmap.createBitmap(getBmp.getWidth(),getBmp.getHeight(), getBmp.getConfig());

        Log.i("TAG", "START BHAYO");
        for(int i=0; i<getBmp.getWidth(); i++){
            for(int j=0; j<getBmp.getHeight(); j++){
                int p = getBmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);

                r = g = b = (int)(0.299 * r + 0.587 * g + 0.114 * b);
                //Color newColor = new Color(r+g+b,red+green+blue,red+green+blue);
                operation1.setPixel(i, j, Color.argb(Color.alpha(p), r, r, r));
            }
        }
        Log.i("TAG", "KAM SAKYO");
        imageView.setImageBitmap(operation1);

    }

    public void callResize(View view){

        Log.i("TAG","SATURATION SURU");
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        imageView.setColorFilter(filter);

        Bitmap getBmp = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Log.i("TAG","SATURATION SAKYO");
    }

    public void RevertImage(View view){
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.bird));
        ColorMatrix matrix = new ColorMatrix();


        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        imageView.setColorFilter(filter);
    }
}
