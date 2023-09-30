package de.rogallab.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity(
   private val _tag: String
) : AppCompatActivity() {
   // Activity is first created
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      if (savedInstanceState == null)
         logInfo(_tag, "onCreate() Bundle == null")
      else
         logInfo(_tag, "onCreate() Bundle != null")
   }
   // Activity is restarted
   override fun onRestart() {
      super.onRestart()
      logInfo(_tag, "onRestart()")
   }

   // Start of visible lifetime
   // Activity is visible
   override fun onStart() {
      super.onStart()
      logInfo(_tag, "onStart()")
   }
   // Activity interacts with the user
   override fun onResume() {
      super.onResume()
      logInfo(_tag, "onResume()")
   }
   // User is leaving activity
   override fun onPause() {
      logInfo(_tag, "onPause()")
      super.onPause()
   }
   // Activity is no longer visible
   override fun onStop() {
      logInfo(_tag, "onStop()")
      super.onStop()
   }
   // Called before the activity is destroyed.
   override fun onDestroy() {
      logInfo(_tag, "onDestroy()")
      super.onDestroy()
   }
   // override save/restore state methods -------------------------------------
   override fun onSaveInstanceState(savedStateBundle: Bundle) {
      super.onSaveInstanceState(savedStateBundle)
      logInfo(_tag, "onSaveInstanceState()")
   }
   override fun onRestoreInstanceState(savedInstanceState: Bundle) {
      super.onRestoreInstanceState(savedInstanceState)
      logInfo(_tag, "onRestoreInstanceState()")
   }
   override fun onWindowFocusChanged(hasFocus: Boolean) {
      logInfo(_tag, "onWindowFocusChanged() $hasFocus")
      super.onWindowFocusChanged(hasFocus)
   }
}