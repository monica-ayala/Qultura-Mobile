import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import kotlinx.coroutines.launch

class GalleriesViewModel: ViewModel() {

    private lateinit var gcaller: ApiCallerService



    fun onCreate() {
        gcaller = ApiCallerService()

    }

    fun searchGalleryList(){

        viewModelScope.launch {

            val galleryList = gcaller.searchGalleryList()
            Log.d("Salas ---> ",galleryList!!.gallery.toString())
        }

    }

}