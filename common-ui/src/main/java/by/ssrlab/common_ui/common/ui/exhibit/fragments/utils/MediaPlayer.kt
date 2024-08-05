package by.ssrlab.common_ui.common.ui.exhibit.fragments.utils

import android.media.MediaPlayer
import android.media.PlaybackParams
import android.view.View
import android.widget.Toast
import androidx.core.net.toUri
import by.ssrlab.common_ui.common.ui.exhibit.ExhibitActivity
import by.ssrlab.common_ui.databinding.FragmentExhibitBinding
import kotlinx.coroutines.*
import java.io.File

object MediaPlayer {

    private var mediaPlayer: MediaPlayer? = null
    private val seekBarFuns = SeekBarFunctions()

    private var speed: Float? = null
    private var playerStatus = ""

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    fun initializeMediaPlayer(
        activity: ExhibitActivity,
        binding: FragmentExhibitBinding,
        file: File,
        onSuccess: () -> Unit
    ) {
        pauseAudio(binding)
        playerStatus = "play"
        mediaPlayer = MediaPlayer()

        val uri = file.toUri()

        binding.apply {
            exhibitPlayRipple.visibility = View.VISIBLE
        }

        try {
            mediaPlayer!!.setDataSource(activity, uri)

            if (speed != null) {
                val playBackParams = PlaybackParams()
                playBackParams.speed = speed!!
                mediaPlayer!!.playbackParams = playBackParams
            }
            mediaPlayer!!.prepare()

            mediaPlayer!!.setOnPreparedListener {
                binding.apply {
//                    exhibitDurationBar.max = mediaPlayer!!.duration
//                    exhibitDurationBar.progress = 0
                    exhibitEndTime.text =
                        seekBarFuns.convertToTimerMode(mediaPlayer!!.duration)
                    exhibitCurrentTime.text =
                        seekBarFuns.convertToTimerMode(mediaPlayer!!.currentPosition)
                }

                listenProgress(binding)
                onSuccess()
            }

        } catch (e: Exception) {
            activity.runOnUiThread {
                Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun playAudio(activity: ExhibitActivity, binding: FragmentExhibitBinding) {
        scope.launch {
            when (playerStatus) {
                "pause" -> {
                    mediaPlayer!!.pause()
                    playerStatus = "play"
                }

                "play" -> {
                    try {
                        mediaPlayer!!.start()
                        playerStatus = "pause"
                        initProgressListener(activity, binding)
                    } catch (e: Exception) {
                        Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun pauseAudio(binding: FragmentExhibitBinding) {
        if (playerStatus == "pause") {
            mediaPlayer!!.pause()
            mediaPlayer!!.stop()
            mediaPlayer!!.reset()

            playerStatus = "play"
        }
    }

    fun changeAudioSpeed(speed: Float, activity: ExhibitActivity, binding: FragmentExhibitBinding) {
        val playBackParams = PlaybackParams()
        playBackParams.speed = speed
        this.speed = speed
        mediaPlayer?.playbackParams = playBackParams

        if (playerStatus == "play") {
            mediaPlayer!!.pause()
            playerStatus = "play"
        }
    }

    private suspend fun initProgressListener(
        activity: ExhibitActivity,
        binding: FragmentExhibitBinding
    ) {
        while (playerStatus == "pause") {
            scope.launch {
                activity.runOnUiThread {
                    binding.apply {
                        if (mediaPlayer?.isPlaying == true) {
                            exhibitCurrentTime.text =
                                seekBarFuns.convertToTimerMode(mediaPlayer!!.currentPosition)
                            exhibitProgress.progress = mediaPlayer!!.currentPosition
                        }
                    }
                }
            }

            delay(10)

            binding.exhibitEndTime.apply {
                if (progress == max) {
                    playerStatus = "play"

                    mediaPlayer?.seekTo(0)
                    scope.launch {
                        activity.runOnUiThread {
                            binding.apply {
//                                exhibitPlayIc.setImageResource(R.drawable.ic_play)
                                exhibitEndTime.text = 0.toString()
                                exhibitCurrentTime.text =
                                    seekBarFuns.convertToTimerMode(mediaPlayer!!.currentPosition)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun listenProgress(binding: FragmentExhibitBinding) {
        binding.exhibitDurationBar.setOnSeekBarChangeListener(
            seekBarFuns.createSeekBarProgressListener {
                mediaPlayer!!.seekTo(it)
                scope.launch {
                    binding.exhibitCurrentTime.text =
                        seekBarFuns.convertToTimerMode(mediaPlayer!!.currentPosition)
                }
            }
        )
    }
}