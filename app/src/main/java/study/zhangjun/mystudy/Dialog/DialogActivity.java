package study.zhangjun.mystudy.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import study.zhangjun.mystudy.Common.BaseActivity;
import study.zhangjun.mystudy.R;

public class DialogActivity extends BaseActivity {

    private FragmentManager fragmentManager;

    private AlterDialogFragment alterDialogFragment = null;

    private DialogFragment dialogFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);
        initView();

    }

    private void initView() {
        dialogFragment = DialogFragment.newInstance();
        switchView(getReplaceFragmentId(),dialogFragment);
    }






    private void switchView(int viewId, Fragment fragment)
    {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ft.replace(viewId, fragment);
        ft.commit();
    }

}
