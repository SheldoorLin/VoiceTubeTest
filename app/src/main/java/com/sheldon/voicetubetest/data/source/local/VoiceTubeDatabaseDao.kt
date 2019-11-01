package com.sheldon.voicetubetest.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sheldon.voicetubetest.data.SettingStatus

@Dao
interface VoiceTubeDatabaseDao {

    @Insert
    fun insert(settingStatus: SettingStatus)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param settingStatus: [SettingStatus]
     */
    @Update
    fun update(settingStatus: SettingStatus)

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Query("DELETE FROM status_in_setting_table")
    fun clear()

    /**
     * Selects and returns all rows in the table,
     *
     * sorted by product_id in ascending order.
     */
    @Query("SELECT * FROM status_in_setting_table")
    fun getAllSetting():
            LiveData<SettingStatus>
}
