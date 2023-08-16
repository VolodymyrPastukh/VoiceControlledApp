package vovan.androidovych.voicecontrolledapp.utils

import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.checkAndRequestPermissions(
    list: List<String>,
    launcher: ActivityResultLauncher<Array<String>>,
    onGranted: () -> Unit = {},
) {
    val permissionsGranted = list.sumOf {
        ContextCompat.checkSelfPermission(requireContext(), it)
    }
    if (permissionsGranted != 0) launcher.launch(list.toTypedArray())
    else onGranted()
}
