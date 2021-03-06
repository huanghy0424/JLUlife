package com.brady.jlulife.Fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.brady.jlulife.Activities.DrComLoginSuccessActivity;
import com.brady.jlulife.Utils.ConstValue;
import com.brady.jlulife.R;
import com.drcom.Android.DrCOMWS.Jni;
import com.drcom.Android.DrCOMWS.Tool.DrCOMWSManagement;
import com.drcom.Android.DrCOMWS.listener.OnclientLoginListener;


/**
 * A placeholder fragment containing a simple view.
 */
public class DrcomLoginFragment extends BaseFragment {
    private static final int LOGIN_SUCCESS = 24;
    private static final int LOGIN_FAILURE = 392;
    private static final String IS_SAVED_PASSWORD = "is_saved_password";
    private static final String IS_AUTO_LOGIN = "is_auto_login";
    private static final String SAVED_NAME  = "saved_name";
    private static final String SAVED_PWD  = "saved_password";

    EditText metUname;
    EditText metUpwd;
    CheckBox cbRememberPwd;
    CheckBox cbautoLogin;
    Button btnLogin;
//    ProgressDialog mProgressDialog;
    DrCOMWSManagement management;
    static DrcomLoginFragment mfragment;

    public DrcomLoginFragment() {
        mfragment = this;
    }

    public static DrcomLoginFragment getInstance(){
        if(mfragment==null)
            mfragment = new DrcomLoginFragment();
        return mfragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drcom_login, container, false);
        setTitle("校园网登陆");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
        management = new DrCOMWSManagement(getActivity());
        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences(ConstValue.SHARED_DRCOM_INFO, Activity.MODE_PRIVATE);
        Bundle arguments = getArguments();
        Boolean islogout = false;
        if(arguments!=null)
            islogout = arguments.getBoolean("logout");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mProgressDialog = ProgressDialog.show(getContext(), "", "登陆中，请稍后");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVED_NAME, metUname.getText().toString());
                editor.putBoolean(IS_SAVED_PASSWORD,cbRememberPwd.isChecked());
                editor.putBoolean(IS_AUTO_LOGIN, cbautoLogin.isChecked());
                if(cbRememberPwd.isChecked()){
                    editor.putString(SAVED_PWD,metUpwd.getText().toString());
                }else {
                    editor.putString(SAVED_PWD,"");
                }
                editor.commit();
                showDialog();
                management.clientLogin(metUname.getText().toString(), metUpwd.getText().toString(), new OnclientLoginListener() {
                    @Override
                    public void clientLoginFail(int paramInt) {
                        if(getActivity()==null)
                            return;
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage(management.getErrorStringByCode(paramInt));
                        builder.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btnLogin.performClick();
                            }
                        });
                        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();
                        hideDialog();
                    }

                    @Override
                    public void clientLoginSuccess(boolean paramBoolean) {
                        startNewActivity(DrComLoginSuccessActivity.class);
                        hideDialog();
                    }
                });
            }
        });
        cbRememberPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                    cbautoLogin.setChecked(false);
            }
        });
        Button logout = (Button) getView().findViewById(R.id.btn_drcom_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jni authinfo = new Jni();
            }
        });
        boolean isAutoLogin = sharedPreferences.getBoolean(IS_AUTO_LOGIN, false);
        boolean isSavedPwd = sharedPreferences.getBoolean(IS_SAVED_PASSWORD, false);
        String uName = sharedPreferences.getString(SAVED_NAME,"");
        String pwd = sharedPreferences.getString(SAVED_PWD,"");
        cbautoLogin.setChecked(isAutoLogin);
        cbRememberPwd.setChecked(isSavedPwd);
        metUname.setText(uName);
        if(isSavedPwd){
            metUpwd.setText(pwd);
        }
        if(isAutoLogin&&!islogout){
            btnLogin.performClick();
        }
    }

    public void initComponents(View view) {
        metUname = (EditText) view.findViewById(R.id.et_drcom_uname);
        metUpwd = (EditText) view.findViewById(R.id.et_drcom_pwd);
        cbRememberPwd = (CheckBox) view.findViewById(R.id.checkbox_remember_pwd);
        cbautoLogin = (CheckBox) view.findViewById(R.id.checkbox_auto_login);
        btnLogin = (Button) view.findViewById(R.id.btn_drcom_login);

    }


}
