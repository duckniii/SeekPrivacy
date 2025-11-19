package com.seeker.seekprivacy

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SplashActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE = 100
    private val SPLASH_DURATION_MS = 3000L
    private val handler = Handler(Looper.getMainLooper())

    // Launcher for "Manage All Files Access"
    /*private val manageAllFilesLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (allPermissionsGranted()) {
                launchDashboard()
            } else {
                Toast.makeText(this, "Permissions still missing.", Toast.LENGTH_LONG).show()
                finish()
            }
        }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Simple splash screen layout
        val layout = FrameLayout(this)
        val textView = TextView(this).apply {
            text = "Made with ❤️ by Seeker."
            setTextColor(Color.WHITE)
            textSize = 24f
            gravity = Gravity.CENTER
        }
        layout.setBackgroundColor(Color.BLACK)
        layout.addView(textView)
        setContentView(layout)

        // Delay splash then check permissions
        /*handler.postDelayed({
            checkAndRequestPermissions()
        }, SPLASH_DURATION_MS)*/
        
        handler.postDelayed({
    startActivity(Intent(this, DashboardActivity::class.java))
    finish()
}, SPLASH_DURATION_MS)

    }

  /*  private fun allPermissionsGranted(): Boolean {
        val readGranted =
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        val writeGranted =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        val manageFiles = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else true
        return readGranted && writeGranted && manageFiles
    }

    private fun checkAndRequestPermissions() {
        if (allPermissionsGranted()) {
            launchDashboard()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                PERMISSION_REQUEST_CODE
            )

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
                try {
                    val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                    manageAllFilesLauncher.launch(intent) //  proper result handling
                } catch (e: Exception) {
                    Toast.makeText(
                        this,
                        "Please grant all file permissions in settings.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() &&
                grantResults.all { it == PackageManager.PERMISSION_GRANTED } &&
                allPermissionsGranted()
            ) {
                launchDashboard()
            } else {
                Toast.makeText(
                    this,
                    "Permissions denied. App cannot continue.",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
    }

    private fun launchDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish() //  ensures SplashActivity is destroyed
    }*/
}

