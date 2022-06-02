package com.example.projeto06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projeto06.ui.theme.Projeto06Theme
import com.example.projeto06.views.HeroListScreen
import com.example.projeto06.views.HeroesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<HeroesViewModel>()
        setContent {
            Projeto06Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DotaHeroes(viewModel)
                }
            }
        }
    }
}

@Composable
fun DotaHeroes(
    viewModel: HeroesViewModel
) {
    HeroListScreen(heroesViewModel = viewModel)
}
