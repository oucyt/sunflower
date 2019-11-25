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

package com.google.samples.apps.sunflower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.google.samples.apps.sunflower.databinding.ActivityGardenBinding

class GardenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityGardenBinding>(this, R.layout.activity_garden)

    }

    override fun onStart() {
        super.onStart()
        lifecycle.addObserver(DemoLifecyle())
//        Android-Lifecycle超能解析-生命周期的那些事儿 https://www.jianshu.com/p/2c9bcbf092bc
//        Android官方架构组件Lifecycle:生命周期组件详解&原理分析 https://www.jianshu.com/p/b1208012b268

//        lifecycle.
    }
}
