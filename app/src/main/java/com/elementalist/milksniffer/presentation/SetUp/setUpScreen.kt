package com.elementalist.milksniffer.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.elementalist.milksniffer.presentation.SetUp.SetUpViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@Composable
fun SetUpScreen(
    navController: NavHostController,
    viewModel: SetUpViewModel = SetUpViewModel()
) {
    val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    //we use activity as current context because we are following single activity model
    val activity = (LocalContext.current as? Activity)
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission Accepted: Do something
            println("permission accepted")

        } else {
            // Permission Denied: Do something
            println("permission denied")
        }
    }

    when (PackageManager.PERMISSION_GRANTED) {
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH
        ) -> {
            // Some works that require permission
            println("permission ?")
        }
        else -> {
            // Asking for permission
            println("ask permission")
            launcher.launch(Manifest.permission.BLUETOOTH)
        }
    }
}


@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SetupScreen() {

    //val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    val context = LocalContext.current
    val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    val bluetoothAdapter = bluetoothManager.adapter


}

