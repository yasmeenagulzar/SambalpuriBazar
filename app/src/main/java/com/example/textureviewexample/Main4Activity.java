    package com.example.textureviewexample;

    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.Path;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.view.SurfaceHolder;
    import android.view.SurfaceView;



    import java.util.Random;

    public class Main4Activity extends AppCompatActivity implements SurfaceHolder.Callback {
    private static final String TAG = "Svetlin SurfaceView";
        private Path mPath;
        private Canvas mCanvas;
        private SurfaceHolder mSurfaceHolder;
        private float mX, mY, newX, newY;
        private Paint mPaint;
        private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        this.bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);

        SurfaceView view = new SurfaceView(this);
        setContentView(view);
        view.getHolder().addCallback(this);
    }



        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            tryDrawing(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }

        private void tryDrawing(SurfaceHolder holder) {
            Log.i(TAG, "Trying to draw...");

            Canvas canvas = holder.lockCanvas();
            if (canvas == null) {
                Log.e(TAG, "Cannot draw onto the canvas as it's null");
            } else {
               // drawMyStuff(canvas);
                draw(canvas);
                //drawRect();
                holder.unlockCanvasAndPost(canvas);
            }
        }

        private void drawMyStuff(final Canvas canvas) {
            Random random = new Random();
            Log.i(TAG, "Drawing...");
            canvas.drawRGB(255, 128, 128);
        }

        private void drawRect() {
            mPath = new Path();
            mPath.moveTo(mX, mY);
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.save();
            mPath.addRect(mX, mY, newX, newY, Path.Direction.CCW);
            mCanvas.drawPath(mPath, mPaint);
            mCanvas.restore();
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            mX = newX;
            mY = newY;
        }
        /*private void initi(Context context) {
            mSurfaceHolder =this.getHolder();
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setTextSize(12);
            mPaint.setColor(Color.RED);

        }*/
        public void draw(Canvas canvas) {
            canvas.drawColor(Color.GRAY);
            //canvas.drawBitmap(this.bmp, 25, 25, null);
            canvas.drawBitmap(this.bmp, 100, 100, null);
            //canvas.drawRGB(255, 128, 128);
        }
    }
