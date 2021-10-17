import androidx.compose.foundation.ExperimentalFoundationApi
import org.home.twoplayergames.ox.dagger.DaggerAppComponent

@ExperimentalFoundationApi
fun main() {
    DaggerAppComponent
        .builder()
        .build()
        .appWindow()
        .start()
}
