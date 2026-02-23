package com.example.intent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra("message") ?: "メッセージなし"

        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)   // ← 背景を白に固定
                    .padding(top = 40.dp)      // ← ステータスバーと重ならない

            ) {
                Text("ここは詳細画面です")
                Text("ここは詳細画面です")
                Text("ここは詳細画面です")
                Text("ここは詳細画面です")
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("受け取ったメッセージ：$message")

                Button(
                    onClick = {
                        finish()   // ← 元の画面へ戻る
                    },
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    Text("戻る")
                }
            }
        }
    }
}