/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.data

import android.util.Log
import androidx.lifecycle.LiveData

class GardenPlantingRepository private constructor(
        private val gardenPlantingDao: GardenPlantingDao
) {

    suspend fun createGardenPlanting(plantId: String) {
        val gardenPlanting = GardenPlanting(plantId)
        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
    }

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting)
    }

    //    fun isPlanted(plantId: String) =
//            gardenPlantingDao.isPlanted(plantId)
    fun isPlanted(plantId: String): LiveData<Boolean> {
        val result = gardenPlantingDao.isPlanted(plantId)
        Log.e("测试", "plantId:$plantId $result")
        return result
    }

    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: GardenPlantingRepository? = null

        fun getInstance(gardenPlantingDao: GardenPlantingDao) =
                // 如果为null就创建实例
                instance ?: synchronized(this) {
                    instance ?: GardenPlantingRepository(gardenPlantingDao)
                            .also {
                                // also用于附加效果，此处将新对象赋值给instance
                                instance = it
                            }
                }
    }
}