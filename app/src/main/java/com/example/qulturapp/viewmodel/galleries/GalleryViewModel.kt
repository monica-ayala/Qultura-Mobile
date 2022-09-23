import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.galleries.GalleryResults
import kotlinx.coroutines.launch

class GalleryViewModel: ViewModel() {
    var listaGallery: MutableLiveData<List<GalleryResults>> = MutableLiveData(listOf())

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