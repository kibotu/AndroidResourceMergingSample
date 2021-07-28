package de.check24.merging

import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import com.github.florent37.application.provider.application

class RuntimeConfig : Config {

    override fun initFlipper() {
        SoLoader.init(application, false)

        if (!FlipperUtils.shouldEnableFlipper(application))
            return

        with(AndroidFlipperClient.getInstance(application)) {
            addPlugin(InspectorFlipperPlugin(application, DescriptorMapping.withDefaults()))
            addPlugin(DatabasesFlipperPlugin(application))
            addPlugin(SharedPreferencesFlipperPlugin(application))
            start()
        }
    }
}