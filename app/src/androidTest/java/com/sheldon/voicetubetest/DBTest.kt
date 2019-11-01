package com.sheldon.voicetubetest

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sheldon.voicetubetest.data.SettingStatus
import com.sheldon.voicetubetest.data.source.local.VoiceTubeDatabase
import com.sheldon.voicetubetest.data.source.local.VoiceTubeDatabaseDao
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)

class DBTest {
    private lateinit var voiceTubeDatabaseDao: VoiceTubeDatabaseDao
    private lateinit var db: VoiceTubeDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, VoiceTubeDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        voiceTubeDatabaseDao = db.voiceTubeDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() = db.close()


    @Test
    @Throws(Exception::class)
    fun updateAndGetSetting() {
        val newAddToDB = SettingStatus(
            auto_play = true,
            learn_notification = false,
            recommend_video_notification = false,
            stop_play_in_checking = false,
            subtitle_sync = false
        )

        voiceTubeDatabaseDao.update(newAddToDB)

        val settingNow = voiceTubeDatabaseDao.getAllSetting()
        assertEquals(true ,  settingNow.value?.auto_play)
    }
}
