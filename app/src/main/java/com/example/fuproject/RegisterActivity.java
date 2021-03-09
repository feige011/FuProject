package com.example.fuproject;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuproject.text.MeDo;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener, ViewTreeObserver.OnGlobalLayoutListener, TextWatcher {

    private EditText mEtRegisterUsername;
    private EditText mEtLoginPwd;
    private Button mBtRegisterSubmit;
    private LinearLayout mLlRegisterPhone;
    private LinearLayout mLlRegisterSmsCode;
    private ImageView mIvLoginLogo;
    private CheckBox mLayBackBar;
    private int mLogoHeight;
    private int mLogoWidth;
    private ImageView mIvLoginUsernameDel;
    private  ImageView mIvLoginPwdDel;
    private MeDo meDo;
    private TextView mTvRegisterSmsCall;

//    R.id.tv_register_sms_call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_step_one);

        meDo= new MeDo(this,this);
        meDo.initRegister(RegisterActivity.this);
        mEtRegisterUsername=findViewById(R.id.et_register_phone);
        mEtLoginPwd=findViewById(R.id.et_register_auth_code);
        mBtRegisterSubmit=findViewById(R.id.bt_register_submit);

        mLlRegisterPhone=findViewById(R.id.ll_register_phone);
        mLlRegisterSmsCode=findViewById(R.id.ll_retrieve_code);


        mIvLoginLogo=findViewById(R.id.iv_login_logo);
        mLayBackBar=findViewById(R.id.cb_protocol);
        mIvLoginUsernameDel=findViewById(R.id.iv_register_username_del);
        mIvLoginPwdDel=findViewById(R.id.iv_register_sms_del);

        findViewById(R.id.ib_navigation_back).setOnClickListener(this);


        mEtRegisterUsername.setOnClickListener(this);
        mEtLoginPwd.setOnClickListener(this);
        mBtRegisterSubmit.setOnClickListener(this);
//        mLlRegisterPhone.setOnClickListener(this);
//        mLlRegisterSmsCode.setOnClickListener(this);
        mIvLoginLogo.setOnClickListener(this);
        mLayBackBar.setOnClickListener(this);
        mIvLoginUsernameDel.setOnClickListener(this);
        mIvLoginPwdDel.setOnClickListener(this);
//        bt_login_register

        //注册其它事件
        mLayBackBar.getViewTreeObserver().addOnGlobalLayoutListener(this);
        mEtRegisterUsername.setOnFocusChangeListener(this);
        mEtRegisterUsername.addTextChangedListener(this);
        mEtLoginPwd.setOnFocusChangeListener(this);
        mEtLoginPwd.addTextChangedListener(this);

        mTvRegisterSmsCall=findViewById(R.id.tv_register_sms_call);
        mTvRegisterSmsCall.setOnClickListener(this);

        Log.e("feifeimmmme","!!!!!");
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.e("feifeimmmme","!!!!!");
    }

    @Override
    public void afterTextChanged(Editable s) {
        String username = mEtRegisterUsername.getText().toString().trim();
        String pwd = mEtLoginPwd.getText().toString().trim();

        //是否显示清除按钮
        if (username.length() > 0) {
            mIvLoginUsernameDel.setVisibility(View.VISIBLE);
        } else {
            mIvLoginUsernameDel.setVisibility(View.INVISIBLE);
        }
        if (pwd.length() > 0) {
            mIvLoginPwdDel.setVisibility(View.VISIBLE);
        } else {
            mIvLoginPwdDel.setVisibility(View.INVISIBLE);
        }

        //登录按钮是否可用
        Log.e("feifeimmmme","?????");
        if (!TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(username)) {
            mBtRegisterSubmit.setBackgroundResource(R.drawable.bg_login_submit);
            mBtRegisterSubmit.setTextColor(getResources().getColor(R.color.white));
        } else {
            mBtRegisterSubmit.setBackgroundResource(R.drawable.bg_login_submit_lock);
            mBtRegisterSubmit.setTextColor(getResources().getColor(R.color.account_lock_font_color));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_navigation_back:
                finish();
                break;
//            case R.id.et_register_username:
//            {
//                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
//            }
            //返回
//            finish();
//            break;
            case R.id.et_register_username:
                mEtLoginPwd.clearFocus();
                mEtRegisterUsername.setFocusableInTouchMode(true);
                mEtRegisterUsername.requestFocus();
                break;
            case R.id.et_register_phone:
                mEtRegisterUsername.clearFocus();
                mEtLoginPwd.setFocusableInTouchMode(true);
                mEtLoginPwd.requestFocus();
                break;
            case R.id.iv_register_username_del:
                //清空用户名
                mEtRegisterUsername.setText(null);
                break;
            case R.id.iv_register_pwd_del:
                //清空密码
                mEtLoginPwd.setText(null);
                break;
            case R.id.bt_register_submit:
                //注册
                Log.e("feifei","点击了");
                meDo.searchRegister(mEtRegisterUsername.getText().toString(),"a123456","a123456",mEtLoginPwd.getText().toString());
                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case  R.id.tv_register_sms_call:
                Log.e("feifei","点击了 "  +mEtRegisterUsername.getText().toString());
                meDo.searchPhone(mEtRegisterUsername.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();

        if (id == R.id.et_register_username) {
            if (hasFocus) {
                mLlRegisterPhone.setActivated(true);
//                mLlRegisterSmsCode.setActivated(false);
            }
        } else {
            if (hasFocus) {

                mLlRegisterPhone.setActivated(false);
//                mLlRegisterSmsCode.setActivated(true);
            }
        }
    }

    @Override
    public void onGlobalLayout() {
        final ImageView ivLogo = this.mIvLoginLogo;
        Rect KeypadRect = new Rect();
        mLayBackBar.getWindowVisibleDisplayFrame(KeypadRect);
        int screenHeight = mLayBackBar.getRootView().getHeight();
        int keypadHeight = screenHeight - KeypadRect.bottom;

        //隐藏logo
        if (keypadHeight > 300 && ivLogo.getTag() == null) {
            final int height = ivLogo.getHeight();
            final int width = ivLogo.getWidth();
            this.mLogoHeight = height;
            this.mLogoWidth = width;

            ivLogo.setTag(true);

            ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0);
            valueAnimator.setDuration(400).setInterpolator(new DecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animatedValue = (float) animation.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = ivLogo.getLayoutParams();
                    layoutParams.height = (int) (height * animatedValue);
                    layoutParams.width = (int) (width * animatedValue);
                    ivLogo.requestLayout();
                    ivLogo.setAlpha(animatedValue);
                }
            });

            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            valueAnimator.start();
        }
        //显示logo
        else if (keypadHeight < 300 && ivLogo.getTag() != null) {
            final int height = mLogoHeight;
            final int width = mLogoWidth;

            ivLogo.setTag(null);

            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
            valueAnimator.setDuration(400).setInterpolator(new DecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animatedValue = (float) animation.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = ivLogo.getLayoutParams();
                    layoutParams.height = (int) (height * animatedValue);
                    layoutParams.width = (int) (width * animatedValue);
                    ivLogo.requestLayout();
                    ivLogo.setAlpha(animatedValue);
                }
            });

            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            valueAnimator.start();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}