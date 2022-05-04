package com.example.webviewkt

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_app_lock.*

class MainActivity : AppCompatActivity() {
    var lock = true // 잠금 상태 여부 확인

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_lock)
//        setContentView(R.layout.activity_main)

        init()

        // 잠금 설정 버튼을 눌렀을때
        btnSetLock.setOnClickListener {
            val intent = Intent(this, AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.ENABLE_PASSLOCK)
            }
            startActivityForResult(intent, AppLockConst.ENABLE_PASSLOCK)
        }

        // 잠금 비활성화 버튼을 눌렀을때
//        val btnSetDelLock: Button = findViewById(R.id.btnSetDelLock)
        btnSetDelLock.setOnClickListener{
            val intent = Intent(this, AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.DISABLE_PASSLOCK)
            }
            startActivityForResult(intent, AppLockConst.DISABLE_PASSLOCK)
        }

        // 암호 변경버튼을 눌렀을때
        btnChangePwd.setOnClickListener {
            val intent = Intent(this, AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.CHANGE_PASSWORD)
            }
            startActivityForResult(intent, AppLockConst.CHANGE_PASSWORD)
        }


        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.settings.javaScriptEnabled = true  // 자바 스크립트 허용

        /* 웹뷰에서 새 창이 뜨지 않도록 방지하는 구문 */
        myWebView.webViewClient = WebViewClient()
        myWebView.webChromeClient = WebChromeClient()

        myWebView.loadUrl("http://naver.com")  // 링크 주소를 load 함

    }

    // startActivityForResult 결과값을 받는다.

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            AppLockConst.ENABLE_PASSLOCK ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(this, "암호 설정 됨", Toast.LENGTH_SHORT).show()
                    init()
                    lock  = false
                }

            AppLockConst.DISABLE_PASSLOCK ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(this, "암호 삭제 됨", Toast.LENGTH_SHORT).show()
                    init()
                }

            AppLockConst.CHANGE_PASSWORD ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(this, "암호 변경 됨", Toast.LENGTH_SHORT).show()
                    lock = false
                }

            AppLockConst.UNLOCK_PASSWORD ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(this, "잠금 해제 됨", Toast.LENGTH_SHORT).show()
                    lock = false
                }
        }

    }

    // 액티비티가 onStart인 경우
    override fun onStart() {
        super.onStart()
        if(lock && AppLock(this).isPassLockSet()){
            val intent = Intent(this, AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.UNLOCK_PASSWORD)
            }
            startActivityForResult(intent, AppLockConst.UNLOCK_PASSWORD)
        }

    }

    // 액티비티가 onPause인경우
    override fun onPause() {
        super.onPause()
        if (AppLock(this).isPassLockSet()) {
            lock = true // 잠금로 변경
        }
    }

    // 버튼 비활성화
    private fun init(){
        if (AppLock(this).isPassLockSet()){
            btnSetLock.isEnabled = false
            btnSetDelLock.isEnabled = true
            btnChangePwd.isEnabled = true
            lock = true
        }
        else{
            btnSetLock.isEnabled = true
            btnSetDelLock.isEnabled = false
            btnChangePwd.isEnabled = false
            lock = false
        }
    }




    /* 뒤로가기 버튼 눌렀을 때 앱 안꺼지게 설정 + 두 번 눌러서 앱 종료 */
    private var backPressedTime : Long = 0
    override fun onBackPressed() {
        val myWebView: WebView = findViewById(R.id.webView)

        if(myWebView.canGoBack()){  // 웹사이트에서 뒤로 갈 페이지가 존재한다면(토스트 메시지 안 띄우고)
            myWebView.goBack()  // 뒤로가기
            return  // 로직 종료(토스트 메시지 안 띄우기 위해)
        }
        else if (System.currentTimeMillis() - backPressedTime < 2500){  // 뒤로 갈 페이지가 없고 & 2.5초 이내에 다시 뒤로가기 클릭 시
            super.onBackPressed()  // 본래의 백버튼 기능(= 앱 종료) 수행
            return  // 로직 종료(토스트 메시지 안 띄우기 위해)
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show()
        backPressedTime = System.currentTimeMillis()
    }
}