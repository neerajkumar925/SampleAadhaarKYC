package com.neeraj.sampleaadhaarkyc

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.payufin.aadhaarofflinekyc.AOKYCError
import com.payufin.aadhaarofflinekyc.AadhaarOfflineKYCManager
import java.io.File

class MainActivity : AppCompatActivity(), AadhaarOfflineKYCManager.AadhaarOfflineEventsCallback {

    var textView : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView);
    }

    fun startKyc(view: View) {
        AadhaarOfflineKYCManager.getInstance().start(this, this)
    }

    override fun onAutoStartProceedClicked() {
    }

    override fun onShareCodeCleared() {
    }

    override fun onDownloadClicked() {
    }

    override fun onSubmit(p0: File?, p1: String?) {
        textView?.text = p0?.nameWithoutExtension +" Share Code "+p1
    }

    override fun onAutoStartSettingsClicked() {
    }

    override fun onFileAttached() {
    }

    override fun onShareCodeEntered() {
    }

    override fun onAutoStartPopUp() {
    }

    override fun onDownloadFinish() {
    }

    override fun onError(p0: AOKYCError?) {
        textView?.text = p0?.errorMessage
    }

}
