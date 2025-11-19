package com.seeker.seekprivacy

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView
import android.net.Uri
import android.widget.TextView
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.text.style.ForegroundColorSpan


class DashboardActivity : AppCompatActivity() {

    private lateinit var encryptedFolderLayout: MaterialCardView
    private lateinit var decryptedFolderLayout: MaterialCardView
    private lateinit var sharedPreferences: SharedPreferences

    private val PREFS_NAME = "EncryptPrefs"
    private val KEY_VERIFICATION = "verificationKey"
    private val KEY_FIRST_LAUNCH = "firstLaunchDone"
    private var verificationString: String? = null

    private var selectedFolderEncrypted = true
    private var permissionsChecked = false

    // Launcher for READ/WRITE permissions
    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions.all { it.value }) {
                checkAllFilesAccess()
            } else {
                Toast.makeText(this, "Storage permissions are required", Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        verificationString = sharedPreferences.getString(KEY_VERIFICATION, null)

        encryptedFolderLayout = findViewById(R.id.encryptedFolderLayout)
        decryptedFolderLayout = findViewById(R.id.decryptedFolderLayout)
        
        val contactUs = findViewById<TextView>(R.id.contactUs)
val fullText = "My very first Android App: By Seeker - Founder @ SeeknWander"
val spannable = SpannableString(fullText)

val target = "Seeker - Founder @ SeeknWander"
val start = fullText.indexOf(target)
val end = start + target.length

spannable.setSpan(UnderlineSpan(), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
spannable.setSpan(
    ForegroundColorSpan(Color.parseColor("#1E88E5")),
    start, end,
    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
)

contactUs.text = spannable

contactUs.setOnClickListener {
    val url = "https://seeknwander.com?v=hypernovaGold"
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}




        encryptedFolderLayout.setOnClickListener {
            selectedFolderEncrypted = true
            handleFolderClick()
        }

        decryptedFolderLayout.setOnClickListener {
            selectedFolderEncrypted = false
            handleFolderClick()
        }

        // First launch: prompt verification string
        if (!sharedPreferences.getBoolean(KEY_FIRST_LAUNCH, false) || verificationString.isNullOrEmpty()) {
            promptVerificationString {
                sharedPreferences.edit().putBoolean(KEY_FIRST_LAUNCH, true).apply()
                checkPermissionsAtStartup()
            }
        } else {
            checkPermissionsAtStartup()
        }
    }

    private fun checkPermissionsAtStartup() {
        if (!areReadWritePermissionsGranted()) {
            showPermissionExplanationDialog()
        } else {
            checkAllFilesAccess()
        }
    }

    private fun handleFolderClick() {
        if (!permissionsChecked) {
            showPermissionExplanationDialog()
            return
        }
        openFolder(selectedFolderEncrypted)
    }

    private fun areReadWritePermissionsGranted(): Boolean {
        val readGranted =
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        val writeGranted =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        return readGranted && writeGranted
    }

    private fun isAllFilesAccessGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) Environment.isExternalStorageManager() else true
    }

    private fun showPermissionExplanationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Storage Permissions Required")
            .setMessage(
                "SeekPrivacy needs Storage and All Files Access permissions " +
                        "to manage your encrypted files safely.\n\nPlease grant permissions to continue."
            )
            .setCancelable(false)
            .setPositiveButton("Grant Permissions") { _, _ ->
                requestReadWritePermissions()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                Toast.makeText(this, "Permissions are required. App cannot continue.", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            .show()
    }

    private fun requestReadWritePermissions() {
        val permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        permissionLauncher.launch(permissions)
    }

    private fun checkAllFilesAccess() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !isAllFilesAccessGranted()) {
            // Show dialog explaining All Files Access
            AlertDialog.Builder(this)
                .setTitle("All Files Access Required")
                .setMessage(
                    "SeekPrivacy needs All Files Access to manage your encrypted files.\n\n" +
                            "Click 'Grant Access' to open settings."
                )
                .setCancelable(false)
                .setPositiveButton("Grant Access") { _, _ ->
                    try {
                        val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                        startActivity(intent) // no package URI, works reliably
                    } catch (e: Exception) {
                        Toast.makeText(
                            this,
                            "Unable to open settings automatically. Please enable manually.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    Toast.makeText(this, "All Files Access is required. App cannot continue.", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
                .show()
        } else {
            // All permissions granted
            permissionsChecked = true
        }
    }

    override fun onResume() {
        super.onResume()
        // Re-check All Files Access after returning from settings
        if (!permissionsChecked) {
            checkPermissionsAtStartup()
        }
    }

    private fun openFolder(encrypted: Boolean) {
        val intent = Intent(this, FolderFilesActivity::class.java).apply {
            putExtra("isEncryptedFolder", encrypted)
            putExtra("verificationString", verificationString)
        }
        startActivity(intent)
    }

    private fun promptVerificationString(onSaved: (() -> Unit)? = null) {
        val input = EditText(this)
        input.hint = "Enter secret verification string"
        input.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD

        AlertDialog.Builder(this)
            .setTitle("Set Verification String")
            .setMessage("This string will be used for decrypting files.")
            .setView(input)
            .setCancelable(false)
            .setPositiveButton("Save") { dialog, _ ->
                val entered = input.text.toString()
                if (entered.isBlank()) {
                    Toast.makeText(this, "Cannot be empty", Toast.LENGTH_SHORT).show()
                    promptVerificationString(onSaved)
                } else {
                    sharedPreferences.edit().putString(KEY_VERIFICATION, entered).apply()
                    verificationString = entered
                    dialog.dismiss()
                    onSaved?.invoke()
                }
            }
            .show()
    }
}

