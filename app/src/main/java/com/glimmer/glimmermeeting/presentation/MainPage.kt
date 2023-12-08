package com.glimmer.glimmermeeting.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glimmer.glimmermeeting.R
import com.glimmer.glimmermeeting.ui.theme.GlimmerMeetingTheme

@Composable
fun MainPage(onDrawerStageChanged: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MainPageTopBar(onDrawerStageChanged = onDrawerStageChanged)
        FunctionCard()
        MyMeetingInfo()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPageTopBar(onDrawerStageChanged: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { onDrawerStageChanged() },
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "User Avatar"
            )
            Column {
                Text(text = "陈佳华", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(text = "电子科技大学", fontSize = 14.sp, color = Color(0xFF808080))
            }
        }
        BadgedBox(
            modifier = Modifier
                .padding(end = 20.dp),
            badge = {
                Badge {
                    Text(text = "8")
                }
            }
        ) {
            Icon(
                modifier = Modifier
                    .clickable {},
                imageVector = Icons.Outlined.MailOutline,
                contentDescription = "System Message"
            )
        }
    }
}

@Composable
fun FunctionCard() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FunctionButton(
                functionDescriptor = "扫码签到",
                functionPainter = painterResource(id = R.drawable.scanner),
                onFunctionClicked = {}
            )
            FunctionButton(
                functionDescriptor = "预定会议",
                functionPainter = painterResource(id = R.drawable.add),
                onFunctionClicked = {}
            )
            FunctionButton(
                functionDescriptor = "历史会议",
                functionPainter = painterResource(id = R.drawable.history),
                onFunctionClicked = {}
            )
        }
        Divider(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 20.dp)
        )
    }
}

@Composable
fun FunctionButton(
    functionDescriptor: String,
    functionPainter: Painter,
    onFunctionClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clickable { onFunctionClicked() },
            painter = functionPainter,
            contentDescription = functionDescriptor
        )
        Text(text = functionDescriptor, fontSize = 14.sp)
    }
}

@Composable
fun MyMeetingInfo() {
}

@Composable
fun MeetingInfoDayCard() {

}

@Composable
fun MeetingInfoCard() {

}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    GlimmerMeetingTheme {
        MainPage({})
    }
}