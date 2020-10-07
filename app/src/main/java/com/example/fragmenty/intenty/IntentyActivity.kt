package com.example.fragmenty.intenty

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenty.R

class IntentyActivity : AppCompatActivity(), IntentClicker {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intenty_activity)
    }

    override fun buttonContacts() {
        super.buttonContacts()
        Intent(Intent.ACTION_PICK, Uri.parse("content://contacts")).also { pickContactIntent ->
            pickContactIntent.type =
                ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE // Show user only contacts w/ phone numbers
            startActivityForResult(pickContactIntent,
                PICK_CONTACT_REQUEST
            )
        }
    }

    override fun buttonCall() {
        super.buttonCall()
        val callIntent: Intent = Uri.parse("tel:0904123456").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        startActivity(callIntent)
    }

    override fun buttonWeb() {
        super.buttonWeb()

        val webIntent: Intent = Uri.parse("http://www.android.com").let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        
        val title = "Vyber si"
        // Create intent to show chooser
        val chooser = Intent.createChooser(webIntent, title)

        // Verify the intent will resolve to at least one activity
        if (webIntent.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        }

        startActivity(webIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                Log.d("Main activity", "Odpoved prisla")
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

    companion object {
        const val PICK_CONTACT_REQUEST = 1  // The request code
    }
}
