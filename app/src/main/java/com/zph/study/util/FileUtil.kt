package com.zph.study.util

import android.content.Context
import com.autonavi.amap.mapcore.tools.GLFileUtil.getCacheDir
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class FileUtil {
    companion object {
        fun copyAssetAndWrite(context: Context, fileName: String): Boolean {
            try {
                var cacheDir: File = getCacheDir(context)
                if (!cacheDir.exists()) {
                    cacheDir.mkdirs()
                }
                var outFile = File(cacheDir, fileName)
                if (!outFile.exists()) {
                    var res: Boolean = outFile.createNewFile()
                    if (!res) {
                        return false
                    }
                } else {
                    if (outFile.length() > 10) {
                        return true
                    }
                }
                var iss: InputStream = context.assets.open(fileName)
                var fos = FileOutputStream(outFile)
                var buffer: ByteArray? = ByteArray(1024)

                while (iss.read(buffer) != -1) {
                    var byteCount: Int = iss.read(buffer)
                    fos.write(buffer!!, 0, byteCount)
                }
                fos.flush()
                iss.close()
                fos.close()


            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }
    }
}
