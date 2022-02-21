package com.knta.librarypractice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpEvents()
        setUpValues()

    }

    fun setUpEvents() {
//        버튼 이외의, TextView, ImageView, LinearLayout 등등도 setOnClickListener로 이벤트 처리가 가능함.

        btnCall.setOnClickListener {

//            권한 승인 여부에 따른, 행동 방안을 작성해서 => pl 변수에 담아두자.
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {

//                    승인이 OK 일때 할 행동.
                    val myUri = Uri.parse("tel:01033337777")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

//                    거절되었을 때 할 행동.
                    Toast.makeText(this@MainActivity, "권한이 거절되어, 통화가 불가능 합니다.", Toast.LENGTH_SHORT)
                        .show()

                }

            }


        }


        imgProfile.setOnClickListener {

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    fun setUpValues() {

    }
}