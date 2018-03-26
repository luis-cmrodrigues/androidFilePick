package fmanager.luis.filemanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public String frase = "A mudar de atividade";
    public int duration = Toast.LENGTH_SHORT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void moveFileWindow(View view){
        Intent intent = new Intent(this, MoveFileActivity.class);

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, frase, duration);
        toast.show();

        startActivity(intent);

    }
}
