package mx.netsquare.permisos;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class App extends AppCompatActivity {
    private static final int WRITE_EXTERNAL_STORAGE=1;
    private static final int REQUEST_CODE_ASK_PERMISSION=123;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        layout = findViewById(R.id.Llayout);
    }

    private void checkPermissions(){

    }

    private void verificarPermisos(){
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            Snackbar.make(layout, "Android es menor a 6", Snackbar.LENGTH_SHORT).show();
        }
        else{

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == WRITE_EXTERNAL_STORAGE){
            if (grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(getTitle().toString(),"Tenemos permiso en la SD");
            }
            else
                Log.d(getTitle().toString(), "Sin permiso en la SD");
        }
        else if(requestCode == REQUEST_CODE_ASK_PERMISSION){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(getTitle().toString(), "Tenemos permiso para la camara");
                }
            else
                Log.d(getTitle().toString(),"Sin permiso para la camara");

            }
        }

    }
