package com.bchilakalapudi.skillup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class StudyActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<QuestionModel> list;
    private QuestionModelAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        Intent in=getIntent();
        String examname=in.getStringExtra("exam");
        TextView title=(TextView)findViewById(R.id.study_title_txt);
        title.setText(""+examname);
        Log.d("exam",""+examname);
        list = new ArrayList<>();

        if (InternetConnection.checkConnection(getApplicationContext())) {
            new GetDataTask().execute();
        } else {
            //Snackbar.make(view, "Internet Connection Not Available", Snackbar.LENGTH_LONG).show();
        }
/**
 * Array List for Binding Data from JSON to this List
 */

        /**
         * Binding that List to Adapter
         */
        adapter = new QuestionModelAdapter(this, list);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.study_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  Snackbar.make(findViewById(R.id.parentLayout), list.get(position).getName() + " => " + list.get(position).getPhone(), Snackbar.LENGTH_LONG).show();
            }
        });

        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */
       /* Toast toast = Toast.makeText(getApplicationContext(), "Click on FloatingActionButton to Load JSON", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        */

        // Checking Internet Connection



       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {

              // Checking Internet Connection

                if (InternetConnection.checkConnection(getApplicationContext())) {
                    new GetDataTask().execute();
                } else {
                    Snackbar.make(view, "Internet Connection Not Available", Snackbar.LENGTH_LONG).show();
                }
            }
        });*/
    }

    /**
     * Creating Get Data Task for Getting Data From Web
     */
    class GetDataTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog;
        int jIndex;
        int x;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /**
             * Progress Dialog for User Interaction
             */

            x=list.size();

            if(x==0)
                jIndex=0;
            else
                jIndex=x;

            dialog = new ProgressDialog(StudyActivity.this);
            dialog.setTitle("Hey Wait Please..."+x);
            dialog.setMessage("I am getting your JSON");
            dialog.show();
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {
            Log.d("doInBackground","Success");
            /**
             * Getting JSON Object from Web Using okHttp
             */
            JSONObject jsonObject = JSONParser.getDataFromWeb();
            Log.d("jsonObject",""+jsonObject);
            try {
                /**
                 * Check Whether Its NULL???
                 */
                if (jsonObject != null) {
                    /**
                     * Check Length...
                     */
                    if(jsonObject.length() > 0) {
                        /**
                         * Getting Array named "contacts" From MAIN Json Object
                         */

                        JSONArray array = jsonObject.getJSONArray(Keys.KEY_CERTIFIED_SALESFORCE_PLATFORM_DEVELOPER_1);
                        Log.d("JSONArray",""+array.toString());
                        /**
                         * Check Length of Array...
                         */


                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for( ; jIndex < lenArray; jIndex++) {

                                /**
                                 * Creating Every time New Object
                                 * and
                                 * Adding into List
                                 */
                                QuestionModel model = new QuestionModel();

                                /**
                                 * Getting Inner Object from contacts array...
                                 * and
                                 * From that We will get Name of that Contact
                                 *
                                 */
                                JSONObject innerObject = array.getJSONObject(jIndex);
                                String question = innerObject.getString(Keys.KEY_QUESTION);
                                String a = innerObject.getString(Keys.KEY_A);
                                String b = innerObject.getString(Keys.KEY_B);
                                String c = innerObject.getString(Keys.KEY_C);
                                String d = innerObject.getString(Keys.KEY_D);
                                String answer1 = innerObject.getString(Keys.KEY_ANSWER1);
                                String answer2 = innerObject.getString(Keys.KEY_ANSWER2);
                                String answer3 = innerObject.getString(Keys.KEY_ANSWER3);

                                /**
                                 * Getting Object from Object "phone"
                                 */
                                //JSONObject phoneObject = innerObject.getJSONObject(Keys.KEY_PHONE);
                                //String phone = phoneObject.getString(Keys.KEY_MOBILE);

                                model.setQuestion(question);
                                //model.setAnswer(answer1);
                                model.setA_option(""+a);
                                model.setB_option(""+b);
                                model.setC_option(""+c);
                                model.setD_option(""+d);
                                String ans="Answer:\n";
                                if(!answer1.equals("")){
                                   ans+=answer1;
                                }
                                if(!answer2.equals("")){
                                    ans+=answer2;
                                }
                                if(!answer3.equals("")){
                                    ans+=answer3;
                                }
                                model.setAnswer(ans);

                                Log.d("model",""+model);

                                /**
                                 * Adding name and phone concatenation in List...
                                 */
                                list.add(model);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JSONParser.TAG, "" + je.getLocalizedMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            /**
             * Checking if List size if more than zero then
             * Update ListView
             */
            if(list.size() > 0) {
                adapter.notifyDataSetChanged();
            } else {
               // Snackbar.make(findViewById(R.id.parentLayout), "No Data Found", Snackbar.LENGTH_LONG).show();
            }
        }
    }


}
