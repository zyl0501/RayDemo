/*
 * 
 * Copyright (c) 2015, alipay.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ray.demo.andfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alipay.euler.andfix.patch.PatchManager;
import com.ray.demo.andfix.test.A;

import java.io.IOException;


/**
 * sample activity
 * 
 * @author luohou
 * @author sanping.li@alipay.com
 * 
 */
public class AndFixActivity extends AppCompatActivity {
	private static final String TAG = "AndFixDemo";

	private static final String APATCH_PATH = "/out.apatch";

	/**
	 * patch manager
	 */
	private PatchManager mPatchManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(TAG, A.a("good"));
		Log.e(TAG, "" + new A().b("s1", "s2"));
		Log.e(TAG, "" + new A().getI());
		setContentView(R.layout.activity_andfix_demo);

		findViewById(R.id.original).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPatchManager.removeAllPatch();
				toast();
			}
		});

		findViewById(R.id.init).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// initialize
				mPatchManager = new PatchManager(AndFixActivity.this);
				mPatchManager.init("1.0");
				Log.d(TAG, "inited.");

				// load patch
				mPatchManager.loadPatch();
				Log.d(TAG, "apatch loaded.");

			}
		});

		findViewById(R.id.patch).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// add patch at runtime
				try {
					// .apatch file path
					String patchFileString = AndFixActivity.this.getCacheDir()
							.getAbsolutePath() + APATCH_PATH;
					mPatchManager.addPatch(patchFileString);
					Log.d(TAG, "apatch:" + patchFileString + " added.");
				} catch (IOException e) {
					Log.e(TAG, "", e);
				}

				toast();
			}
		});
	}

	private void toast(){
		Toast.makeText(this, "old", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		android.os.Process.killProcess(android.os.Process.myPid());
	}

}
