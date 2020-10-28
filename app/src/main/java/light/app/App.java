package light.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class App extends Application {
    private static Context context;
    private static Handler handler;
    private static long mainThreadId;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        handler=new Handler();
        mainThreadId=Thread.currentThread().getId();
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static long getMainThreadId() {
        return mainThreadId;
    }
    public static void runOnUI(Runnable r){
        handler.post(r);
    }
}
