package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class ComposeArticle: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleCodelab(
                        heading = stringResource(R.string.codelab).uppercase(),
                        para1 = stringResource(R.string.paragraph_1),
                        para2 = stringResource(R.string.paragraph_2)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleCodelab(heading: String, para1: String, para2: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = heading,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = para1,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            lineHeight = 24.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = para2,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            lineHeight = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview()
@Composable
fun ArticleCodelabPreview() {
    MyApplicationTheme {
        ArticleCodelab(
            heading = stringResource(R.string.codelab),
            para1 = stringResource(R.string.paragraph_1),
            para2 = stringResource(R.string.paragraph_2),
            modifier = Modifier
        )
    }
}