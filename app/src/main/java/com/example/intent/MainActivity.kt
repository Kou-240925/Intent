package com.example.intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current   // ← これが Activity の代わり

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                val intent = Intent(
                    context,
                    DetailActivity::class.java
                )
                context.startActivity(intent)
            }
        ) {
            Text("詳細画面へ")
        }

        Button(
            onClick = {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    android.net.Uri.parse("https://www.google.com")
                )
                context.startActivity(intent)
            }
        ) {
            Text("Google を開く")
        }

        Button(
            onClick = {
                val intent = Intent(context, DetailActivity::class.java)

                // ★ メッセージを渡す
                intent.putExtra("message", "こんにちは光生さん")

                context.startActivity(intent)
            }
        ) {
            Text("詳細画面へ")
        }


    }
}
