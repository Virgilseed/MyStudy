package study.zhangjun.mystudy.Dialog;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import study.zhangjun.mystudy.Common.BaseFragment;
import study.zhangjun.mystudy.R;

public class DialogFragment extends BaseFragment implements View.OnClickListener {

    private static String title = "Dialog测试";

    private Button mAlterDialog;



    public static DialogFragment newInstance() {
        DialogFragment fragment = new DialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public DialogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_dialog_test, container, false);
        mAlterDialog = (Button) parent.findViewById(R.id.alter_dialog);
        mAlterDialog.setOnClickListener(this);
        return parent;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.alter_dialog:
                switchFragment(getSwitchId(), AlterDialogFragment.newInstance());
                break;
        }
    }
}
