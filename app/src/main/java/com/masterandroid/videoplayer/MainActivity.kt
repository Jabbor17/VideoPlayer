package com.masterandroid.videoplayer

import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import net.alhazmy13.mediapicker.Image.ImagePicker
import net.alhazmy13.mediapicker.Video.VideoPicker




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       initViews()
    }
    fun initViews(){
        val playVideo = findViewById<Button>(R.id.btn_play_video)

        playVideo.setOnClickListener {
            pickVideo()
        }
    }
    fun pickVideo(){
        val videoPicker = VideoPicker.Builder(this@MainActivity)
            .mode(VideoPicker.Mode.GALLERY)
            .directory(VideoPicker.Directory.DEFAULT)
            .extension(VideoPicker.Extension.MP4)
            .enableDebuggingMode(true)

        videoPicker.build()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK){
            val videoPaths = data!!.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH)

        }
    }

}