package com.example.learning

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //now the features which helps in debugging

        Log.i("Sidd","Create Called")//see this on logcat and do debugging
        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show()//this will appear on the screen when we are handling the main-activity

        super.onCreate(savedInstanceState)//super helps to inherit all possible functionalities and properties from the parent class and adding new functionalities and properties to the concerned function

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root //root is not the id, it is the starting of all the xml file
        setContentView(view)

        setSupportActionBar(binding.toolbar) //top bar

        //this is where all logic is written  --> logic for all multiple pages
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        var count=0;
        binding.fab.setOnClickListener { view ->
            count=count+1
            Snackbar.make(view, "Count"+count, Snackbar.LENGTH_LONG)//on every click count will increase
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }

    override fun onStart(){
        Log.i("Sidd","Start Called")//see this on logcat and do debugging
        Toast.makeText(this,"Started",Toast.LENGTH_SHORT).show()
        super.onStart()
    }

    override fun onResume() {
        Log.i("Sidd","Resume Called")//see this on logcat and do debugging
        Toast.makeText(this,"Resumed",Toast.LENGTH_SHORT).show()
        super.onResume()
    }

    override fun onPause(){
        Log.i("Sidd","Pause Called")//see this on logcat and do debugging
        Toast.makeText(this,"Paused",Toast.LENGTH_SHORT).show()
        super.onPause()
    }

    override fun onStop(){
        Log.i("Sidd","Stop Called")//see this on logcat and do debugging
        Toast.makeText(this,"Stopped",Toast.LENGTH_SHORT).show()
        super.onStop()
    }

    override fun onDestroy(){
        Log.i("Sidd","Destroy Called")//see this on logcat and do debugging
        Toast.makeText(this,"Destroyed",Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}