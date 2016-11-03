package com.wanli.com.multitypedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    private static final String EXTRA_URL = "extra_url";
    private static final String EXTRA_TITLE = "extra_title";
    public WebView mWebView;
//    TextSwitcher mTextSwitcher;
    private long delay = 1738L;

    private String mUrl, mTitle;


    /**
     * Using newIntent trick, return WebActivity Intent, to avoid `public static`
     * constant
     * variable everywhere
     *
     * @return Intent to start WebActivity
     */
    public static Intent newIntent(Context context, String extraURL, String extraTitle) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(EXTRA_URL, extraURL);
        intent.putExtra(EXTRA_TITLE, extraTitle);
        return intent;
    }


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mWebView = (WebView) findViewById(R.id.webView);

        mUrl = getIntent().getStringExtra(EXTRA_URL);
        mTitle = getIntent().getStringExtra(EXTRA_TITLE);

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl(mUrl);

//        mTextSwitcher.setFactory(() -> {
//            final TextView textView = new TextView(this);
//            textView.setSingleLine(true);
//            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
////            textView.postDelayed(() -> textView.setSelected(true), 1738);
//            textView.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    textView.setSelected(true);
//                }
//            } ,delay );
//            return textView;
//        });
//        mTextSwitcher.setInAnimation(this, android.R.anim.fade_in);
//        mTextSwitcher.setOutAnimation(this, android.R.anim.fade_out);
//        if (mTitle != null) setTitle(mTitle);
    }

//
//    @Override public void setTitle(CharSequence title) {
//        super.setTitle(title);
//        mTextSwitcher.setText(title);
//    }
//



    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }



    @Override protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) mWebView.destroy();
    }


}
