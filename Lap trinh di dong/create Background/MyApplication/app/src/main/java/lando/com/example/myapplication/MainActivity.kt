package lando.com.example.myapplication

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lando.com.example.myapplication.ui.theme.MyApplicationTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.logo_dhsp),
            contentDescription = "logo",
            Modifier.width(80.dp)
        )
        Text (
            text = "Viet Trieu",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )
        Text (
            text = "21CNTT1",
            color = Color.Blue,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(150.dp))
        Column {
            Row (
                Modifier.padding(vertical = 10.dp)
            ){
                Icon(Icons.Rounded.Phone, contentDescription = "Phone")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "+84943051861")
            }
            Row {
                Icon(Icons.Rounded.Share, contentDescription = "Share" )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "TrieuSPDN")
            }
            Row {
                Icon(Icons.Rounded.Email, contentDescription = "Email" )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "viettrieu123123@gmail.com")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}