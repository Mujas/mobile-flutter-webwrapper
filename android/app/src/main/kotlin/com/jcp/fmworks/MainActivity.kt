package com.jcp.fmworks

import android.content.Intent
import android.os.Bundle

import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity : FlutterActivity() {

    companion object {
        const val CHANNEL = "flutter.dev/wrapper"
        const val KEY_NATIVE = "showNativeView"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(this)

        MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == KEY_NATIVE) {
                val intent = Intent(this, WrapperViewActivity::class.java)
                startActivity(intent)
                finish()
                //result.success(true)
            } else {
                //result.notImplemented()
            }
        }
    }
}
