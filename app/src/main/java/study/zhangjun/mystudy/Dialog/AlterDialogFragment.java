package study.zhangjun.mystudy.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import study.zhangjun.mystudy.Common.BaseFragment;
import study.zhangjun.mystudy.R;
import study.zhangjun.mystudy.utils.StudyLogger;

public class AlterDialogFragment extends BaseFragment implements View.OnClickListener {
    int selectIndex = 0;

    private Button noButton, hasBuuton, list, radio, checkBox, my;

    private static String title = "AlterDialog";

    public static AlterDialogFragment newInstance() {
        AlterDialogFragment fragment = new AlterDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public AlterDialogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getTitle() {
        return null;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_alter_dialog, container, false);
        noButton = (Button) parent.findViewById(R.id.no_button);
        hasBuuton = (Button) parent.findViewById(R.id.has_button);
        list = (Button) parent.findViewById(R.id.list_button);
        radio = (Button) parent.findViewById(R.id.radio_button);
        checkBox = (Button) parent.findViewById(R.id.check_box);
        my = (Button) parent.findViewById(R.id.my_dialog);
        noButton.setOnClickListener(this);
        hasBuuton.setOnClickListener(this);
        list.setOnClickListener(this);
        radio.setOnClickListener(this);
        checkBox.setOnClickListener(this);
        my.setOnClickListener(this);
        return parent;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.no_button:
                dialogNoButton(getActivity());
                break;
            case R.id.has_button:
                dialogButton(getActivity());
                break;
            case R.id.list_button:
                dialogListview(getActivity());
                break;
            case R.id.radio_button:
                dialogRadioButton(getActivity());
                break;
            case R.id.check_box:
                dialogCheckBox(getActivity());
                break;
            case R.id.my_dialog:
                dialogMyDialog1(getActivity());
                break;
        }
    }



    private void dialogNoButton(Context context)
    {
        AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        builder.setTitle("AlterDialog Test");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("hahahahah-______=++==+=");
        builder.create();
        builder.show();
    }

    /**
     * 最多三个按钮，需要几个设置几个，点击任意按钮，dialog自动关闭，
     * @param context
     */
    private void dialogButton(final Context context)
    {

        final AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        builder.setTitle("AlterDialog之按钮");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("hahahahah-______=++==+=");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "确定按钮", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("查看详情", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "查看详情按钮", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }


    private void dialogListview(final Context context)
    {

        final String[] arrayFruit = new String[] { "苹果", "橘子", "草莓", "香蕉" };



        final AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        builder.setTitle("AlterDialog之类Listview");
        builder.setIcon(R.mipmap.ic_launcher);
        //    builder.setMessage("hahahahah-______=++==+=");
        builder.setItems(arrayFruit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, arrayFruit[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "取消按钮", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
        //    builder.show();
    }


    private void dialogRadioButton(final Context context)
    {
        final String[] arrayFruit = new String[] { "苹果", "橘子", "草莓", "香蕉" };

        final AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        builder.setTitle("AlterDialog之类Listview");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(arrayFruit, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectIndex = which;
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StudyLogger.e("选中了：%s",which);
                Toast.makeText(context, "选中了" + arrayFruit[selectIndex], Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }

    private void dialogCheckBox(final Context context)
    {
        final String[] arrayFruit = new String[] { "苹果", "橘子", "草莓", "香蕉" };
        final boolean[] arrayFruitSelected = new boolean[] {true, true, false, false};

        Dialog alertDialog = new AlertDialog.Builder(context).
                setTitle("你喜欢吃哪种水果？").
                setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(arrayFruit, arrayFruitSelected, new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        arrayFruitSelected[which] = isChecked;
                    }
                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < arrayFruitSelected.length; i++) {
                            if (arrayFruitSelected[i] == true) {
                                stringBuilder.append(arrayFruit[i] + "、");
                            }
                        }
                        Toast.makeText(context, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                    }
                }).
                        setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        }).
                        create();
        alertDialog.show();
    }

    private void dialogMyDialog1(final Context context)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View myView = layoutInflater.inflate(R.layout.dialog_my_layout_, null);
        Dialog alertDialog = new AlertDialog.Builder(context).
                setTitle("用户登录").
                setIcon(R.mipmap.ic_launcher).
                setView(myView).
                setPositiveButton("登录", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                    }
                }).
                setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                    }
                }).
                create();
        //    EditText username = myView.findViewById(R.id)
        alertDialog.show();
    }


}
