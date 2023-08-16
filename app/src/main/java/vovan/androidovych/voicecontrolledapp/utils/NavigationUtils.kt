package vovan.androidovych.voicecontrolledapp.utils

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(
    direction: NavDirections,
) {
    findNavController().safeNavigate(direction)
}

fun Fragment.backTo() {
    findNavController().popBackStack()
}

/**
 * Safe navigation function to prevent collisions in navigation
 */
private fun NavController.safeNavigate(direction: NavDirections) {
    currentDestination?.getAction(direction.actionId)?.run { navigate(direction) }
}