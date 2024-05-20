package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class ComposeQuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantCompose(
                        q1_Heading = "Text composable",
                        q1_tagline = stringResource(R.string.displays_text_and_follows),
                        q2_Heading = "Image composable",
                        q2_tagline = stringResource(R.string.creates_a_composable_that),
                        q3_Heading = "Row composable",
                        q3_tagline = stringResource(R.string.a_layout_composable_that),
                        q4_Heading = "Column composable",
                        q4_tagline = stringResource(R.string.ts_children_in_a_vertical_sequence)
                    )
                }
            }
        }
    }

    @Composable
    fun QuadrantCompose(
        q1_Heading: String,
        q1_tagline: String,
        q2_Heading: String,
        q2_tagline: String,
        q3_Heading: String,
        q3_tagline: String,
        q4_Heading: String,
        q4_tagline: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                QuadrantItem(
                    heading = q1_Heading,
                    tagline = q1_tagline,
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f)
                )
                QuadrantItem(
                    heading = q2_Heading,
                    tagline = q2_tagline,
                    backgroundColor = Color(0xFFD0BCFF),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier.weight(1f)
            ) {
                QuadrantItem(
                    heading = q3_Heading,
                    tagline = q3_tagline,
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f)
                )
                QuadrantItem(
                    heading = q4_Heading,
                    tagline = q4_tagline,
                    backgroundColor = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    fun QuadrantItem(heading: String, tagline: String, backgroundColor: Color, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp)
        ) {
            Text(
                text = heading,
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tagline,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun QuadrantComposePreview() {
        QuadrantCompose(
            q1_Heading = "Text composable",
            q1_tagline = stringResource(R.string.displays_text_and_follows),
            q2_Heading = "Image composable",
            q2_tagline = stringResource(R.string.creates_a_composable_that),
            q3_Heading = "Row composable",
            q3_tagline = stringResource(R.string.a_layout_composable_that),
            q4_Heading = "Column composable",
            q4_tagline = stringResource(R.string.ts_children_in_a_vertical_sequence)
        )
    }
}
