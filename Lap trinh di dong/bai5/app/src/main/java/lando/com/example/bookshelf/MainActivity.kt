package lando.com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lando.com.example.bookshelf.model.Book
import lando.com.example.bookshelf.ui.theme.BookShelfTheme

class MainActivity : ComponentActivity() {
    private val books = listOf(
        Book("Lịch sử Jazz", "Ted Gioia, Thea Toda, Dorald D. Megill, Richard S. Demery", R.drawable.bookshelf_book1),
        Book("Hoàng tử bé", "Antoine de Saint-Exupéry", R.drawable.bookshelf_book2),
        Book("100 năm cô đơn", "Gabriel García Márquez", R.drawable.bookshelf_book3),
        Book("Nhà giả kim", "Paulo Coelho", R.drawable.bookshelf_book4),
        Book("Bắt trẻ đồng xanh", "J. D. Salinger", R.drawable.bookshelf_book5)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookShelfTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookShelfTheme {
        Greeting("Android")
    }
}