# SampleAadhaarKYC

Aadhaar Offline Android SDK helps to onboard customers by using the Aadhaar XML provided by UIDAI. The onboarding process is completely paperless and the SDK takes care of downloading the Aadhaar XML document from UIDAI and verifying the authenticity of the customer.

   ## Integration Steps
### 1. Import aadhaarofflinekyc.aar module in your project.

### 2. In your app/build.gradle add the aadhaarofflinekyc SDK as a dependency

       implementation project(path: ':aadhaarofflinekyc-debug')
    // appcompat required for acitivities(mandatory)
       
       implementation 'androidx.appcompat:appcompat:1.1.0'
    // customtab dependency is needed to launch uidai website (mandatory)
       
       implementation 'com.android.support:customtabs:28.0.0'
 
### 3. In your AndroidManifest.xml declare WRITE_EXTERNAL_STORAGE_PERMISSION 

    uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
    
And make sure you have the WRITE_EXTERNAL_STORAGE permission before launching the sdk flow.

otherwise sdk will throw following error

    STORAGE_PERMISSION_NOT_GRANTED(1003, "Storage permission not granted");

### 4. Initiate Aadhaar Offline KYC flow(Mandatory)

        var eventsCallback: AadhaarOfflineKYCManager.AadhaarOfflineEventsCallback =
            object : AadhaarOfflineKYCManager.AadhaarOfflineEventsCallback {
                
                override fun onDownloadClicked() {}
                
                override fun onAutoStartPopUp() {
                    //Xiomi device specific event
                }

                override fun onAutoStartProceedClicked() {
                    //Xiomi device specific event
                }

                override fun onAutoStartSettingsClicked() {
                    //Xiomi device specific event
                }

                override fun onDownloadFinish() {}
                override fun onFileAttached() {}
                override fun onShareCodeEntered() {}
                override fun onShareCodeCleared() {}
                override fun onSubmit(file: File, shareCode: String) {
                    // you get the zip file and share code
                }

                override fun onError(error: AOKYCError) {
                    // Handle the error event with your logic
                }
            }


    //Call start method when you're ready to launch sdk flow.
        
        AadhaarOfflineKYCManager.getInstance().start(activity, eventsCallback)

    
    
    
    // Error codes
            
            public enum AOKYCError {
                NO_INTERNET(1000, "No internet connection"),
                FILE_NOT_FOUND(1001, "File not found"),
                USER_CANCELLED(1002, ""),
                STORAGE_PERMISSION_NOT_GRANTED(1003, "Storage permission not
                granted");
            }


### 5. You can change the style of texts and buttons(Optional)
   
    <style name="SubmitButtonStyle" parent="Widget.AppCompat.Button.Colored">
        <item name="android:textColor">@color/white</item>
        <item name="android:textSize">@dimen/dimen_14dp</item>
        <item name="fontPath">raleway_semibold.ttf</item>
    </style>


    <style name="DownloadAadhaarButtonStyle" parent="Widget.AppCompat.Button.Colored">
        <item name="android:textColor">@color/white</item>
        <item name="android:textSize">@dimen/dimen_14dp</item>
        <item name="fontPath">raleway_semibold.ttf</item>
    </style>


    <style name="AttachAadhaarButtonStyle" parent="Widget.AppCompat.Button.Colored">
        <item name="android:textColor">@color/white</item>
        <item name="android:textSize">@dimen/dimen_14dp</item>
        <item name="fontPath">raleway_semibold.ttf</item>
    </style>


    <style name="AOKYCHeaderTextStyle" parent="Widget.AppCompat.TextView">
        <item name="fontPath">raleway_semibold.ttf</item>
    </style>
    
    
    <style name="AOKYCTextStyle" parent="Widget.AppCompat.TextView">
        <item name="fontPath">raleway_medium.ttf</item>
    </style>
 

### 6. Other details

Sdk targets following sdk versions

    minSdkVersion 21
    targetSdkVersion 28
 
