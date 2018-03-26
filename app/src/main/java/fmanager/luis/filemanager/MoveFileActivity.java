package fmanager.luis.filemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveFileActivity extends Activity {

    private static final int READ_REQUEST_CODE = 42;

    TextView filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_file);

        filePath = findViewById(R.id.txtBox);
    }


    public void backToMain(View view){
        Intent intent = new Intent(this, MenuActivity.class);

        String frase = "Back to main menu";
        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, frase, duration);
        toast.show();

        startActivity(intent);
    }


    public void fileSearch(View view){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        intent.setType("*/*");
        startActivityForResult(intent, READ_REQUEST_CODE );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData){
        if(requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri uri = null;
            if(resultData != null){
                uri = resultData.getData();

                filePath.setText(uri.getPath());

            }
        }
    }


    public void dupeFile(View view){
        //copyFile(String.valueOf(filePath.getText()), , );
    }

    private void copyFile(String inputPath, String inputFile, String outputPath) {

        InputStream in = null;
        OutputStream out = null;
        try {

            //create output directory if it doesn't exist
            File dir = new File (outputPath);
            if (!dir.exists())
            {
                dir.mkdirs();
            }


            in = new FileInputStream(inputPath + inputFile);
            out = new FileOutputStream(outputPath + inputFile);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;

            // write the output file (You have now copied the file)
            out.flush();
            out.close();
            out = null;

        }  catch (FileNotFoundException fnfe1) {
            Log.e("tag", fnfe1.getMessage());
        }
        catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

    }


}
