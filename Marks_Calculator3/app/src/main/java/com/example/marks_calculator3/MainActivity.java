package com.example.marks_calculator3;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.marks_calculator3.databinding.ActivityMainBinding;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {
private View lightmode;
    private View darkmode;
    private Switch darkLightSwitch;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());







        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View btn_scan = findViewById(R.id.btn_scan);
                btn_scan.setOnClickListener(v->
                {
                    scanCode();
                });
            }
            private void scanCode()
            {
                ScanOptions options = new ScanOptions();
                options.setPrompt("Volume up to flash on");
                options.setBeepEnabled(true);
                options.setOrientationLocked(true);
                options.setCaptureActivity(CaptureAct.class);
                barLaucher.launch(options);
            }
            ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result->
            {
                if(result.getContents() !=null)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result");
                    builder.setMessage(result.getContents());
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            dialogInterface.dismiss();
                        }
                    }).show();
                }
            });
        });



        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_aboutus, R.id.nav_sgpa, R.id.nav_birthday, R.id.nav_gtop, R.id.nav_nc, R.id.nav_rta, R.id.nav_stta)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

  return true;
    }






    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void openGitHubLink(View view) {
        // Replace 'github_repo_url' with your actual GitHub repository URL
        String gitHubRepoUrl = "https://github.com/PrajwalPawar1042/Marks_Calculator.git";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(gitHubRepoUrl));
        startActivity(intent);
    }
}
