package za.ac.iie.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.StringBuilder

class song2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_song2)

        val btnMain = findViewById<Button>(R.id.btnMain)
        val btnSee = findViewById<Button>(R.id.btnSee)
        val btnAvg = findViewById<Button>(R.id.btnAvg)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        val btnAvg = intent.getIntegerArrayListExtra("showAverage")

        if (btnAvg) {
            val rating = intent.getIntegerArrayListExtra("rate") ?: arrayListOf()
            val avg = if (rating.isNotEmpty()) rating.sum().toDouble() / rating.size else 0.0
            txtResult.text = "Avg rating is %.2f".format(avg)

        } else {
            val title = intent.getIntegerArrayListExtra("songs") ?: arrayListOf()
            val artists = intent.getIntegerArrayListExtra("artists") ?: arrayListOf()
            val rating = intent.getIntegerArrayListExtra("rate") ?: arrayListOf()
            val comment = intent.getIntegerArrayListExtra("comments") ?: arrayListOf()

            val result = StringBuilder()
            for (i in title.indices) {
                result.append("Title: ${title[i]}\n")
                result.append("artists: ${artists[i]}\n")
                result.append("rating: ${rating[i]}\n")
                result.append("comments: ${comment[i]}\n")

                txtResult.text = result
            }

            btnSee.setOnClickListener {
                val intent = Intent(this, song1::class.java)
                intent.putStringArrayListExtra("titles", title)
                intent.putStringArrayListExtra("artists", artists)
                intent.putStringArrayListExtra("rating", rating)
                intent.putStringArrayListExtra("comment", comment)
                intent.putExtra("showAverage", false)
                startActivity(intent)



                btnMain.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)


                    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                        v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                        )
                        insets
                    }
                }
            }
        }
    }
}

private fun Intent.putStringArrayListExtra(s: String, title: ArrayList<Int>) {

}
