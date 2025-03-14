package com.tencent.mlvb.apiexample;

import android.app.Application;

import androidx.multidex.MultiDex;


import com.nimo.facebeauty.FBEffect;
import com.nimo.facebeauty.FBEffect.InitCallback;
import com.tencent.live2.V2TXLiveDef.V2TXLiveLogConfig;
import com.tencent.live2.V2TXLivePremier;
import com.tencent.mlvb.debug.GenerateTestUserSig;

public class MLVBApplication extends Application {

    private static MLVBApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        instance = this;
        V2TXLiveLogConfig liveLogConfig = new V2TXLiveLogConfig();
        liveLogConfig.enableConsole = true;
        V2TXLivePremier.setLogConfig(liveLogConfig);
        V2TXLivePremier.setLicence(instance, GenerateTestUserSig.LICENSEURL, GenerateTestUserSig.LICENSEURLKEY);

        //todo --- facebeauty start ---
        FBEffect.shareInstance().initFaceBeauty( this, "YOUR_APP_ID", new InitCallback() {
            @Override public void onInitSuccess() {

            }

            @Override public void onInitFailure() {

            }
        });
        //todo --- facebeauty end ---
    }

}
