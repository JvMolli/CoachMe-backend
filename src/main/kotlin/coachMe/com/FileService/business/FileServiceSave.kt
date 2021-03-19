package coachMe.com.FileService.business

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Files.readAllBytes
import java.nio.file.Files.write
import java.sql.Timestamp

data class FileServiceSave(val specificPath: String,
                           val imgId: Timestamp){

    private val path: String = System.getProperty("user.home")+"/images2/";

    fun saveProfilePicture (profilePicture: File): String{
        var mokedFile = getMokedImg();
        var pathSaved: String = "";
        var time = imgId.time
        var saved = File("$path/$specificPath/$time.png");
        try {
            if(File("$path/$specificPath").isDirectory()){
                saved.writeBytes(mokedFile);
            }else{
                File("$path/$specificPath").mkdirs();
                println(path)
                val out = FileOutputStream(saved);
                saved.writeBytes(mokedFile);
            }

        }catch (e: Exception){
            e.printStackTrace();
        }

        return saved.absolutePath;
    }

    fun getMokedImg(): ByteArray{
      return File("/Users/jaimem/Desktop/pepe.PNG").readBytes();
    }

}


