package com.example.softuser.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.softuser.R


class AboutUSFragment : Fragment() {
    private lateinit var myWebview : WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_about_u_s, container, false)
        val mWebView: WebView? = view?.findViewById(R.id.web) as WebView
        mWebView?.loadUrl("https://softwarica.edu.np/")

        val webSettings = mWebView?.getSettings()
        webSettings?.setJavaScriptEnabled(true)

        return view
    }

}