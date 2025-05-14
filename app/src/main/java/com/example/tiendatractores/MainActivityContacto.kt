package com.example.tiendatractores

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivityContacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_contacto)
    }

    fun btnInsta(view: View) {
        val url = "https://www.instagram.com/todo_entractores/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun btnFace(view: View) {
        val url = "https://www.facebook.com/profile.php?id=61569338763776"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun btnGmail(view: View) {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:todoentractores@gmail.com")
        }
        startActivity(emailIntent)
    }
}

