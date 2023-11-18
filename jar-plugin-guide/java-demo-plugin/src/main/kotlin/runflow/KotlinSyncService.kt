package runflow

import androidx.compose.runtime.Composable
import top.myrest.myflow.component.FuncPageScope
import top.myrest.myflow.component.SettingsContent
import top.myrest.myflow.data.DataSyncService

class KotlinSyncService : DataSyncService {

    override fun start() {
        // start data synchronization service
        // you should monitor any data changes from any other devices
        // if changed you should call method MyDb.syncFromQueue.offer(data), to notify us to update data
    }

    override fun stop() {
        // stop data synchronization service
    }

    override fun writeData(data: String) {
        // you can get device id by calling method OshiUtil.getSystem().hardwareUUID, to identity user devices
    }

    override fun getSettingsContent(): SettingsContent {
        return object : SettingsContent {
            override val settingsContent: @Composable FuncPageScope.(pluginId: String) -> Unit
                get() = {
                    DemoEmptyBox()
                }
        }
    }
}