package light.utils;

import android.widget.Toast;

import light.app.App;

public class Show {
    private static Toast toast;

    public static void t(String msg,boolean longtime){
        int l=longtime?Toast.LENGTH_LONG:Toast.LENGTH_SHORT;
        if (toast==null){
            toast=Toast.makeText(App.getContext(),msg,l);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }
}
