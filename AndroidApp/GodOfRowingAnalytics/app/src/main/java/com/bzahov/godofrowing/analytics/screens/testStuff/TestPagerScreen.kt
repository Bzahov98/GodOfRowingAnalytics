package com.bzahov.godofrowing.analytics.screens.testStuff

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bzahov.godofrowing.analytics.R
import com.bzahov.godofrowing.analytics.ui.theme.GodOfRowingAnalyticsTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//private fun Sample() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(stringResource(R.string.)) },
//                backgroundColor = MaterialTheme.colors.surface,
//            )
//        },
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(Modifier.fillMaxSize()) {
//            val pagerState = rememberPagerState()
//
//            // Display 10 items
//            HorizontalPager(
//                count = 10,
//                state = pagerState,
//                // Add 32.dp horizontal padding to 'center' the pages
//                contentPadding = PaddingValues(horizontal = 32.dp),
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxWidth(),
//            ) { page ->
//                PagerSampleItem(
//                    page = page,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(1f)
//                )
//            }
//
//            HorizontalPagerIndicator(
//                pagerState = pagerState,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(16.dp),
//            )
//
//            ActionsRow(
//                pagerState = pagerState,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            )
//        }
//    }
//}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerSample() {
    // Display 10 items
    HorizontalPager(count = 10) { page ->
        // Our page content
        Text(
            text = "Page: $page",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun VerticalPagerSample() {
    // Display 10 items
    VerticalPager(count = 10) { page ->
        // Our page content
        Text(
            text = "Page: $page",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview()
@Composable
fun HorizontalPagerIndicatorSample() {
    GodOfRowingAnalyticsTheme() {
        val pagerState = rememberPagerState()
        Column {
            // Display 10 items
            HorizontalPager(count = 10) { page ->
                // Our page content
                Text(
                    text = "Page: $page",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.padding(16.dp),
            )

        }
    }
}

@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun VerticalPagerIndicatorSample() {
    val pagerState = rememberPagerState()
    Row(modifier = Modifier.fillMaxSize()) {
        // Display 10 items
        VerticalPager(
            count = 10,
            state = pagerState,
        ) { page ->
            // Our page content
            Text(
                text = "Page: $page",
                modifier = Modifier.fillMaxWidth()
            )
        }

        VerticalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Suppress("UNUSED_PARAMETER")
object AnalyticsService {
    fun sendPageSelectedEvent(page: Int) = Unit
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PageChangesSample() {
    val pagerState = rememberPagerState()

    LaunchedEffect(pagerState) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            AnalyticsService.sendPageSelectedEvent(page)
        }
    }

    VerticalPager(
        count = 10,
        state = pagerState,
    ) { page ->
        Text(text = "Page: $page")
    }
}

@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerWithTabs(pages: List<String> = listOf("ss", "szz", "fsd")) {
    val pagerState = rememberPagerState()

    TabRow(
        // Our selected tab is our current page
        selectedTabIndex = pagerState.currentPage,
        // Override the indicator, using the provided pagerTabIndicatorOffset modifier
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        // Add tabs for all of our pages
        pages.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = pagerState.currentPage == index,
                onClick = { /* TODO */ },
            )
        }
    }

    HorizontalPager(
        count = pages.size,
        state = pagerState,
    ) { page ->
        Text(text = "$page")
        Image(painterResource(id = R.drawable.ic_profile), contentDescription = "ss")
    }
}

class OnBoardViewModel : ViewModel() {
    private val _currentPage = MutableStateFlow(0)
    val currentPage: StateFlow<Int> get() = _currentPage

    fun setCurrentPage(currentPage: Int) {
        _currentPage.value = currentPage
    }
}

@ExperimentalPagerApi
class TestOnBoard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.purple_200)

        setContent {
            GodOfRowingAnalyticsTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    OnBoardScreen()
                }
            }
        }
    }
}

@Preview
@ExperimentalPagerApi
@Composable
fun OnBoardScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val onBoardViewModel: OnBoardViewModel = viewModel()
    val context = LocalContext.current
    val currentPage = onBoardViewModel.currentPage.collectAsState()

    Toast.makeText(context, "${currentPage.value}", Toast.LENGTH_SHORT).show()
    Surface(color = MaterialTheme.colors.background) {
        val pagerState = rememberPagerState(
//        pageCount = onBoardItem.size,
//        initialOffscreenLimit = 2,
//        initialPage = 0,
//        infiniteLoop = false
        )

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                LaunchedEffect(key1 = "2") {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            page = currentPage.value
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
//                    .background(Gray200)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        HorizontalPager(
                            state = pagerState,
                            count = pagerState.pageCount
                        ) { page ->
                            Column(
                                modifier = Modifier
                                    .padding(top = 65.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = onBoardItem[page].image),
                                    contentDescription = "OnBoardImage",
                                    modifier = Modifier
                                        .size(250.dp)
                                )

                                Text(
                                    text = onBoardItem[page].title,
                                    modifier = Modifier
                                        .padding(top = 50.dp),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )

                                Text(
                                    text = onBoardItem[page].desc,
                                    modifier = Modifier
                                        .padding(30.dp),
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        PagerIndicator(onBoardItem.size, pagerState.currentPage)
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = if (pagerState.currentPage != 2) {
                                Arrangement.SpaceBetween
                            } else {
                                Arrangement.Center
                            }
                        ) {
                            if (pagerState.currentPage == 2) {
                                OutlinedButton(
                                    onClick = {
                                        Toast.makeText(
                                            context,
                                            "Start the Screen",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    },
                                    shape = RoundedCornerShape(45.dp)
                                ) {
                                    Text(
                                        text = "Get Started",
                                        modifier = Modifier.padding(
                                            vertical = 8.dp,
                                            horizontal = 40.dp
                                        ),
                                        color = Color.Black
                                    )
                                }
                            } else {
                                Text(
                                    text = "Skip",
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 20.dp),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium
                                )

                                Text(
                                    text = "Next",
                                    color = Color.White,
                                    modifier = Modifier
                                        .clickable {
                                            onBoardViewModel.setCurrentPage(pagerState.currentPage + 1)
                                        }
                                        .padding(end = 20.dp),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PagerIndicator(size: Int = 5, currentPage: Int = 1) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            IndicateIcon(
                isSelected = it == currentPage
            )
        }
    }
}

@Composable
fun IndicateIcon(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp
    )

    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) {
                    Color.Green
                } else {
                    Color.Gray.copy(alpha = 0.5f)
                }
            )
    )
}

data class SampleOnBoard(
    val image: Int,
    val title: String,
    val desc: String
)

val onBoardItem = listOf(
    SampleOnBoard(
        R.drawable.ic_profile,
        "Make it Easy One",
        "Lorem Ipsum is simply dummy text of the printing and typesetting Industry."
    ),
    SampleOnBoard(
        R.drawable.ic_outline_note_24,
        "Make it Easy Two",
        "Lorem Ipsum is simply dummy text of the printing and typesetting Industry."
    ),
    SampleOnBoard(
        R.drawable.ic_google_logo,
        "Make it Easy Three",
        "Lorem Ipsum is simply dummy text of the printing and typesetting Industry."
    )
)