package com.glimmer.glimmermeeting.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glimmer.glimmermeeting.R
import com.glimmer.glimmermeeting.ui.theme.BlueDeep
import com.glimmer.glimmermeeting.ui.theme.BlueLight
import com.glimmer.glimmermeeting.ui.theme.GlimmerMeetingTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetingDetailedPage(
    onPageStateChanged: (String) -> Unit
) {
    Column {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White
            ),
            title = { Text(text = "会议详情") },
            navigationIcon = {
                IconButton(onClick = { onPageStateChanged("MainPage") }) {
                    Icon(Icons.Outlined.ArrowBack, contentDescription = "Arrow Back")
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.Share, contentDescription = "Share")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.more), contentDescription = "more")
                }
            }
        )
        MeetingDetailedInfo()
    }
}

@Composable
fun MeetingDetailedInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "综设进度汇报", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "12:00", fontSize = 36.sp, fontWeight = FontWeight.Bold)
                Text(text = "2023年12月7日", fontSize = 14.sp, color = Color(0xFF808080))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(text = "未开始", fontSize = 12.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.left_dots),
                        contentDescription = "left-dots"
                    )
                    Card(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = BlueDeep,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = BlueLight,
                            contentColor = BlueDeep
                        )
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(all = 4.dp),
                            text = "2小时",
                            fontSize = 12.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.right_dots),
                        contentDescription = "right-dots"
                    )
                }
                Text(text = "(GMT+08:00)", fontSize = 12.sp)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "14:00", fontSize = 36.sp, fontWeight = FontWeight.Bold)
                Text(text = "2023年12月7日", fontSize = 14.sp, color = Color(0xFF808080))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "会议室", fontSize = 17.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "信软楼西306", fontSize = 17.sp)
                IconButton(
                    modifier = Modifier
                        .size(20.dp),
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "location",
                        tint = BlueDeep
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "发起人", fontSize = 17.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.jiahua),
                    contentDescription = "Detailed User Avatar"
                )
                Text(text = "陈佳华", fontSize = 17.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeetingPageDetailedPagePreview() {
    GlimmerMeetingTheme {
        MeetingDetailedPage({})
    }
}