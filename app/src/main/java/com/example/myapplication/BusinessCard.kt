package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class BusinessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowBusinessCard(
                        name = "Sandeep Gupta".uppercase(),
                        tagline = "Android Developer",
                        phoneNo = "+91 1234567890",
                        igID = "noOneExists@Social",
                        email = "notAnAddress@email"
                    )
                }
            }
        }
    }

    @Composable
    fun ShowBusinessCard(
        name: String,
        tagline: String,
        phoneNo: String,
        igID: String,
        email: String,
        modifier: Modifier = Modifier
    ) {
        val image = painterResource(R.drawable.candidateimg)
        val callIcon = painterResource(R.drawable.baseline_call_24)
        val shareIcon = painterResource(R.drawable.baseline_share_24)
        val emailIcon = painterResource(R.drawable.baseline_email_24)

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = tagline,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(128.dp))
            ContactRow(icon = callIcon, contactInfo = phoneNo)
            ContactRow(icon = shareIcon, contactInfo = igID)
            ContactRow(icon = emailIcon, contactInfo = email)
        }
    }

    @Composable
    fun ContactRow(icon: Painter, contactInfo: String) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = contactInfo,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun ShowBusinessCardPreview() {
        ShowBusinessCard(
            name = "Sandeep Gupta",
            tagline = "Android Developer",
            phoneNo = "+91 1234567890",
            igID = "noOneExists@Social",
            email = "notAnAddress@email"
        )
    }
}