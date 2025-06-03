package com.composeuitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.composeuitask.ui.SignUpScreen
import com.composeuitask.ui.theme.ComposeUITaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUITaskTheme {
                SignUpScreen()
            }
        }
    }
}
