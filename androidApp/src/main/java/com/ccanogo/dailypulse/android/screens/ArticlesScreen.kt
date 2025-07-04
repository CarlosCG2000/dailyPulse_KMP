package com.ccanogo.dailypulse.android.screens

import android.widget.Spinner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.ccanogo.dailypulse.android.screens.elements.ErrorMessage
import com.ccanogo.dailypulse.android.screens.elements.Loading
import com.ccanogo.dailypulse.articles.domain.model.Article
import com.ccanogo.dailypulse.articles.presentation.ArticlesState
import com.ccanogo.dailypulse.articles.presentation.ArticlesViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import org.koin.androidx.compose.getViewModel

//class ArticlesScreen(/*val koin: Koin*/): Screen {
//
//    @Composable
//    override fun Content() {
//        ArticlesScreenContent(koin)
//    }
//}

@Composable
fun ArticlesScreenContent(
    onAboutButtonClick: () -> Unit,
    /*koin : Koin,*/
    articlesViewModel: ArticlesViewModel = getViewModel() // koin.get(),
) {
    val articlesState = articlesViewModel.articlesState.collectAsState()

    Column {
        AppBar( onAboutButtonClick /*koin*/ )

        if (articlesState.value.loading)
            Loading()
        if (articlesState.value.error != null)
            ErrorMessage(articlesState.value.error!!)
        if (articlesState.value.articles.isNotEmpty())
            ArticlesListView( articlesViewModel )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    onAboutButtonClick: () -> Unit,
        /*koin: Koin*/
        ) {
    // val navigator = LocalNavigator.currentOrThrow

    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
//            IconButton(onClick = {
//                navigator.push(SourcesScreen(koin))
//            }) {
//                Icon(
//                    imageVector = Icons.Outlined.List,
//                    contentDescription = "Sources Button",
//                )
//            }
            IconButton(onClick = {
                onAboutButtonClick()
                // navigator.push(AboutScreen())
            }) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "El boton de About Screen",
                )
            }
        }
    )
}

@Composable
fun ArticlesListView(viewModel: ArticlesViewModel) {
    val uiState by viewModel.articlesState.collectAsState()

    SwipeRefresh(
        state = SwipeRefreshState(uiState.loading),
        onRefresh = { viewModel.getArticles(true) }) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.articlesState.value.articles) { article ->
                ArticleItemView(article = article)
            }
        }
    }

}

@Composable
fun ArticleItemView(article: Article) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
//        KamelImage(
//            resource = asyncPainterResource(data = Url(article.imageUrl)),
//            contentDescription = "article image",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.height(200.dp)
//        )
        AsyncImage(
            model = article.imageUrl,
            contentDescription = "article image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(200.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = article.desc)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}






