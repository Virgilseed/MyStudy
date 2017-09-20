package study.zhangjun.mystudy.Common;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import study.zhangjun.mystudy.R;


public class BaseActivity extends ActionBarActivity{
    private android.support.v7.app.ActionBar actionBar;

    protected BaseFragment curFragment;
    protected FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        if (getIntent() != null && getIntent().getStringExtra("title") != null && !"".equals(getIntent().getStringExtra("title")))
            setTitle(getIntent().getStringExtra("title"));
        else
            setTitle("My Study");

        fragmentManager = getFragmentManager();


    }
    protected void setTitle(String title)
    {
        actionBar.setTitle(title);
        actionBar.setIcon(R.drawable.turn_left);
    }

    public String getTitles()
    {
        return actionBar.getTitle().toString();
    }

    /**
     * 切换fragment
     * 可以利用setArguments(Bundle)在Fragment之间传值
     *
     * @param viewId   要替换的视图id
     * @param fragment
     */
    public void switchView(int viewId, BaseFragment fragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ft.replace(viewId, fragment);

        curFragment = fragment;
        ft.commit();
    }

}
