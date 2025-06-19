package za.ac.iie.musicapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TabWidget
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class song1 : AppCompatActivity() {

    val songs = arrayListOf(
        "Not Like Us", "Cha Cha Slide", "All of Me", "House of Memories"
    )

    val artists = arrayListOf(
        "Kendrick Lemar", "DJ Casper", "John Legend", "Panic! At The Disco"
    )

    val rate = arrayListOf(
        "4", "1", "2", "3"
    )

    val comments = arrayListOf(
        "Rap", "Dance song", "Best love song", "Memories"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_song1)

        val btnAddsong = findViewById<Button>(R.id.btnAddSong)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val inputArtist = findViewById<EditText>(R.id.edtArtist)
        val inputComment = findViewById<EditText>(R.id.edtComments)
        val inputTitle = findViewById<EditText>(R.id.edtTitle)
        val btnOUT = findViewById<Button>(R.id.btnOUT)
        val inputRating = findViewById<EditText>(R.id.edtRate)

        btnAddsong.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("add song")

            val layout = LinearLayout(this)
            layout.orientation = LinearLayout.VERTICAL

            val inputTitle = EditText(this)
            inputTitle.hint = "song title"
            layout.addView(inputTitle)

            val inputArtist = EditText(this)
            inputArtist.hint = "artist name"
            layout.addView(inputArtist)

            val inputRating = EditText(this)
            inputRating.hint = "Rating(1-5)"
            layout.addView(inputRating)

            val inputComment = EditText(this)
            inputComment.hint = "comment"
            layout.addView(inputComment)

            builder.setView(layout)

            builder.setPositiveButton("add") { _, _ ->
                val title = inputTitle.text.toString()
                val artist = inputArtist.text.toString()
                val rating = inputRating.text.toString().toIntOrNull() ?: 0
                val comment = inputComment.text.toString()

                if (title.isNotBlank() && artist.isNotBlank() && rating in 1..5) {
                    songs.add(title)
                    artists.add(artist)
                    rate.add(rating.toString()
                    comments.add(comment)
                    Toast.makeText(this, "song added!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please enter correct song or comment", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setNegativeButton("cancel", null)
            builder.show()
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, song2::class.java)
            startActivity(intent)




            btnOUT.setOnClickListener {
                finishAffinity()
            }
        }
    }
}
