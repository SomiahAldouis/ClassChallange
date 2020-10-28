package somiah.jad.classchallange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // ********************* fragment class begin ********************* //
    val currentFragment =
        supportFragmentManager.findFragmentById(R.id.fragment)
    if (currentFragment == null) {
        val fragment = classFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment, fragment)
            .commit()
    }
    // ********************* fragment class End ********************* //
}}