package com.ccanogo.dailypulse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// import com.ccanogo.dailypulse.Greeting // Modulo compartido
import com.ccanogo.dailypulse.Platform // Modulo compartido
import com.ccanogo.dailypulse.android.screens.AboutScreenContent
import com.ccanogo.dailypulse.android.screens.ArticlesScreenContent
import com.ccanogo.dailypulse.articles.presentation.ArticlesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Platform().logSystemInfo()                               // Modulo compartido
        // val articlesViewModel: ArticlesViewModel by viewModels() // Modulo compartido

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // AboutScreenContent()
                   // ArticlesScreenContent(articlesViewModel)
                    AppScaffold(/*articlesViewModel*/)
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        AboutScreenContent()
//    }
//}
