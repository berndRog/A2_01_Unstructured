package de.rogallab.mobile

import android.os.Bundle
import android.util.Log
import de.rogallab.mobile.databinding.ActivityMainBinding

class MainActivity : BaseActivity(TAG) {

   // local variables are deleted during a state change !!!
   // (e.g. rotating the device)
   private var _name:String = ""
   private var _email:String = ""

   // View Binding
   private lateinit var _binding: ActivityMainBinding

   // Activity is first created
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      // render screen
      // setContentView(R.layout.activity_main)

      // View Binding
      _binding = ActivityMainBinding.inflate(layoutInflater)
      val view = _binding.root
      setContentView(view)

      if (savedInstanceState != null) {
         logDebug(TAG, "onCreate() Bundle != null")
         getStateFromBundle(savedInstanceState)
      }

      // button event handler
//    findViewById<Button>(R.id.main_bt_send).setOnClickListener {
      _binding.mainBtSend.setOnClickListener {
         Log.i(TAG,"main_bt_send.OnClick()")
         getStateFromUiElements()
      }
   }

   private fun getStateFromUiElements() {
   // _name  = findViewById<EditText>(R.id.main_et_name).text.toString()
   // _email = findViewById<EditText>(R.id.main_et_email).text.toString()
      _name  = _binding.mainEtName.text.toString()
      _email = _binding.mainEtEmail.text.toString()
      logDebug(TAG, "getStateFromUiElements()\nName: $_name Email:$_email")
   }
   private fun setUiElementsFromState() {
      Log.d(TAG, "setUiElementsFromState()\nName: $_name Email:$_email")
   // findViewById<EditText>(R.id.main_et_name).setText(_name)
   // findViewById<EditText>(R.id.main_et_email).setText(_email)
      _binding.mainEtName.setText(_name)
      _binding.mainEtEmail.setText(_email)
   }

   private fun putStateToBundle(bundle: Bundle) {
      //                key    value
      bundle.putString (NAME,  _name)
      bundle.putString (EMAIL, _email)
      logDebug(TAG, "putStateToBundle()\nName: $_name Email:$_email")
   }

   private fun getStateFromBundle(savedInstanceState: Bundle) {
      _name = savedInstanceState.getString(NAME) ?: ""
      _email = savedInstanceState.getString(EMAIL) ?: ""
      logDebug(TAG, "getStateFromBundle()\nName: $_name Email:$_email")
      setUiElementsFromState()
   }


   // override save/restore state methods -------------------------------------
   // Save instance state: invoked when the activity may be temporarily destroyed,
   override fun onSaveInstanceState(savedStateBundle: Bundle) {
      super.onSaveInstanceState(savedStateBundle)
      getStateFromUiElements()
      putStateToBundle(savedStateBundle)
   }

   override fun onRestoreInstanceState(savedInstanceState: Bundle) {
      super.onRestoreInstanceState(savedInstanceState)
      getStateFromBundle(savedInstanceState)
      setUiElementsFromState()
   }

   companion object {        //12345678901234567890123
      const val isDebug = true
      const val isInfo = true
      private const val TAG = "ok>MainActivity       ."
      private const val NAME  = "MainActivityName"
      private const val EMAIL = "MainActivityEmail"
   }
}