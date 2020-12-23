package somiah.jad.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var userEmail: EditText
    lateinit var userPass: EditText
    lateinit var loginBtn: Button
    lateinit var signUpBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userEmail = findViewById(R.id.user_email)
        userPass  = findViewById(R.id.user_pass)
        loginBtn = findViewById(R.id.log_in)
        signUpBtn = findViewById(R.id.sign_up)

        signUpBtn.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }
    }
}