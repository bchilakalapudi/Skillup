package com.bchilakalapudi.skillup;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;

public class QuestionModelAdapter extends ArrayAdapter<QuestionModel> {

    List<QuestionModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public QuestionModelAdapter(Context context, List<QuestionModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public QuestionModel getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.question_layout, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        QuestionModel item = getItem(position);
            vh.question.setText(item.getQuestion());
            vh.a_option.setText(item.getA_option());
        vh.b_option.setText(item.getB_option());
        vh.c_option.setText(item.getC_option());
        vh.d_option.setText(item.getD_option());
        vh.e_option.setText(item.getE_option());
        vh.f_option.setText(item.getF_option());
        vh.g_option.setText(item.getG_option());
        vh.h_option.setText(item.getH_option());
        vh.answer.setText(item.getAnswer());

        Log.d("f_option",""+vh.f_option.getText());

        if(vh.e_option.getText().equals("")) {
            vh.e_option.setVisibility(View.GONE);
        }
        if(vh.f_option.getText().equals("")) {
            vh.f_option.setVisibility(View.GONE);
        }
        if(vh.g_option.getText().equals("")) {
            vh.g_option.setVisibility(View.GONE);
        }
        if(vh.h_option.getText().equals("")) {
            vh.h_option.setVisibility(View.GONE);
        }
        if(vh.answer.getText().equals("")) {
            vh.answer.setVisibility(View.GONE);
        }
       // vh.textViewName.setText(item.getName());
       // vh.textViewCountry.setText(item.getCountry());

        return vh.rootView;
    }

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final RelativeLayout rootView;

        public final TextView question;
        public final CheckBox a_option;
        public final CheckBox b_option;
        public final CheckBox c_option;
        public final CheckBox d_option;
        public final CheckBox e_option;
        public final CheckBox f_option;
        public final CheckBox g_option;
        public final CheckBox h_option;
        public final TextView answer;

        private ViewHolder(RelativeLayout rootView, TextView question,
                           CheckBox a_option,
                           CheckBox b_option,
                           CheckBox c_option,
                           CheckBox d_option,
                           CheckBox e_option,
                           CheckBox f_option,
                           CheckBox g_option,
                           CheckBox h_option,
                           TextView answer) {
            this.rootView = rootView;
            this.question = question;
            this.a_option = a_option;
            this.b_option = b_option;
            this.c_option = c_option;
            this.d_option = d_option;
            this.e_option = e_option;
            this.f_option = f_option;
            this.g_option = g_option;
            this.h_option = h_option;
            this.answer=answer;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView question = (TextView) rootView.findViewById(R.id.question);
            CheckBox a_option = (CheckBox) rootView.findViewById(R.id.a_option_check);
            CheckBox b_option = (CheckBox) rootView.findViewById(R.id.b_option_check);
            CheckBox c_option = (CheckBox) rootView.findViewById(R.id.c_option_check);
            CheckBox d_option = (CheckBox) rootView.findViewById(R.id.d_option_check);
            CheckBox e_option = (CheckBox) rootView.findViewById(R.id.e_option_check);
            CheckBox f_option = (CheckBox) rootView.findViewById(R.id.f_option_check);
            CheckBox g_option = (CheckBox) rootView.findViewById(R.id.g_option_check);
            CheckBox h_option = (CheckBox) rootView.findViewById(R.id.h_option_check);
            TextView answer = (TextView) rootView.findViewById(R.id.answer_txt);

            return new ViewHolder(rootView, question
                    , a_option,
                    b_option,
                    c_option,
                    d_option,
                    e_option,
                    f_option,
                    g_option,
                    h_option,
                    answer);
        }
    }

}