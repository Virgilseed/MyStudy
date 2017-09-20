package study.zhangjun.mystudy.Common;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import study.zhangjun.mystudy.utils.StudyLogger;


public class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    protected String title = "未定义标题";
    protected final static String ARG_TITLE = "title";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().getString(ARG_TITLE) != null ) {
            StudyLogger.e("ARG_TITLE:%s",getArguments().getString(ARG_TITLE));
            mActivity.setTitle(getArguments().getString(ARG_TITLE));
        }
        if (title != null && !title.equals(""))
            mActivity.setTitle(getTitle());

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    /**
     * 切换Fragment
     * 可以利用setArguments(Bundle)传值
     *
     * @param viewId
     * @param fragment
     */
    public void switchFragment(int viewId, BaseFragment fragment) {
        if (mActivity == null) return;
        mActivity.switchView(viewId, fragment);
    }


    public String getTitle()
    {
        return mActivity.getTitles();
    }

}
