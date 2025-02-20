package com.mytodoapp.data.local

import android.content.Context
import java.io.File
import java.util.Properties

object DatabaseConfig {
    var host: String = ""
    var port: String = ""
    var database: String = ""
    var user: String = ""
    var password: String = ""

    fun loadConfig(context: Context) {
        val properties = Properties()
        val localPropertiesFile = File(context.filesDir, "../local.properties")

        if (localPropertiesFile.exists()) {
            properties.load(localPropertiesFile.inputStream())
            host = properties.getProperty("MYSQL_HOST", "")
            port = properties.getProperty("MYSQL_PORT", "")
            database = properties.getProperty("MYSQL_DATABASE", "")
            user = properties.getProperty("MYSQL_USER", "")
            password = properties.getProperty("MYSQL_PASSWORD", "")
        }
    }
}
