package com.driuft.randompets


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import id
import okhttp3.Headers
class MainActivity : AppCompatActivity() {
    private lateinit var rvPets: RecyclerView
    private lateinit var petList: MutableList<String>
    private lateinit var idlist: MutableList<String>
    private lateinit var rvid: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPets = findViewById(R.id.pet_image)
        rvid = findViewById(R.id.image_id)
        petList = mutableListOf()
        idlist = mutableListOf()
        getDogImageURL()
    }
    private fun getDogImageURL() {
        val client = AsyncHttpClient()
        client["https://dog.ceo/api/breeds/image/random/20", object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                val petImageArray = json.jsonObject.getJSONArray("message")
                for (i in 0 until petImageArray.length()) {
                    petList.add(petImageArray.getString(i))
                    idlist.add(petImageArray.getString(i))
                }
                val adapter = PetAdapter(petList)
                rvPets.adapter = adapter
                rvPets.layoutManager = LinearLayoutManager(this@MainActivity)
                rvPets.addItemDecoration(
                    DividerItemDecoration(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL
                    )
                )
                val adapter1 = id(idlist)
                rvid.adapter = adapter1
                rvid.layoutManager = LinearLayoutManager(this@MainActivity)
                rvid.addItemDecoration(
                    DividerItemDecoration(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL
                    )
                )


            }
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Dog Error", errorResponse)
            }
        }]
    }
}
