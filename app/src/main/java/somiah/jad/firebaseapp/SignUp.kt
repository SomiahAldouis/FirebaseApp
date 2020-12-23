package somiah.jad.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class SignUp : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var loginBtn: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        loginBtn = findViewById(R.id.login)

        loginBtn.setOnClickListener {
                register()
        }
    }

    fun register(){
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(
            email.text.toString(),
            pass.text.toString()
        ).addOnCompleteListener(this) {
            if(it.isSuccessful){
                Toast.makeText(this,"User Created Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this,UserData::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Can not Create User  ", Toast.LENGTH_LONG).show()
                Log.d("failed" , it.exception.toString())
            }
        }
    }
}