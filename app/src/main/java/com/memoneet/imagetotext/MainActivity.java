package com.memoneet.imagetotext;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final String temp = "91. Which of the following statements is incorrect? (1) Viroids lack a protein coat. (2) Viruses are obligate parasites. (3) Infective constituent in viruses is the protein coat. (4) Prions consist of abnormally folded proteins. Answer (3) Sol. Infective constituent in viruses is either DNA or RNA, not protein. 92. Purines found both in DNA and RNA are (1) Adenine and thymine (2) Adenine and guanine (3) Guanine and cytosine (4) Cytosine and thymine Answer (2) Sol. Purines found both in DNA and RNA are Adenine and guanine 93. Which of the following glucose transporters is insulin-dependent? (1) GLUT I (2) GLUT II (3) GLUT III (4) GLUT IV Answer (4)";
        Log.d("Number of Charaters", Integer.toString(temp.length()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text1 = findViewById(R.id.textView);
                TextView text2 = findViewById(R.id.textView2);
                CharSequence temp1 = "s";
                String Question = null, OptionA = null, OptionB = null, OptionC = null, OptionD = null;
                int Option_a_begin, Option_b_begin, Option_c_begin,Option_d_begin, nextQuestion, Next_Question_begin;
                Option_a_begin = Option_b_begin = Option_c_begin = Option_d_begin = 0;
                nextQuestion = Next_Question_begin = 0;
                Log.d("clicked","Review Algo Fucker!");
                ArrayList<String> Questionlist = new ArrayList<String>();
                ArrayList<String> OptionAList = new ArrayList<String>();
                ArrayList<String> OptionBList = new ArrayList<String>();
                ArrayList<String> OptionCList = new ArrayList<String>();
                ArrayList<String> OptionDList = new ArrayList<String>();
                /*Pattern is formed
                Pattern p = Pattern.compile("a*b");
                Matcher Letter = p.matcher("aaaab");
                boolean LetterMatchesPattern = Letter.matches();

                List<String> Question = new ArrayList<String >();
                Question.add("Hey list is working");
                 */
                for (int i = 3; i < (temp.length()); i++) {
                    if(nextQuestion >= temp.length()){break;}
                    String str = temp.substring(i,i+3);
                    //Log.d("for Check", "We are in For Loop");
                    //if(str.equals("(1)") || str.equals("(a)") || str.equals("(A)")) {
                    if(str.matches("^\\([1aA]\\)$")) {
                        Question = temp.substring(Next_Question_begin, i - 1);
                        Option_a_begin = i + 3;
                        Log.d("Question1", Question);
                        Log.d("We are at", Integer.toString(i));
                        Questionlist.add(Question);
                    //}else if(str.equals("(2)") || str.equals("(b)") || str.equals("(B)")){
                    }else if(str.matches("^\\([2bB]\\)$")){
                        OptionA = temp.substring(Option_a_begin,i-1);
                        Option_b_begin = i+3;
                        Log.d("Opt A", OptionA);
                        Log.d("We are at", Integer.toString(i));
                        OptionAList.add(OptionA);

                    //}else if(str.equals("(3)") || str.equals("(c)") || str.equals("(C)")){
                    }else if(str.matches("^\\([3cC]\\)$")){
                        OptionB = temp.substring(Option_b_begin,i-1);
                        Option_c_begin = i+3;
                        Log.d("Opt B", OptionB);
                        Log.d("We are at", Integer.toString(i));
                        OptionBList.add(OptionB);

                    //} else if(str.equals("(4)") || str.equals("(d)") || str.equals("(D)")){
                    }else if(str.matches("^\\([4dD]\\)$")){
                        OptionC = temp.substring(Option_c_begin,i-1);
                        Option_d_begin = i+3;
                        Log.d("Opt C", OptionC);
                        Log.d("We are at", Integer.toString(i));
                        OptionCList.add(OptionC);

                    } else if(str.matches("^[0-9]{2}.$") || str.matches("^Answer$") || str.matches("^Sol$")){
                        OptionD = temp.substring(Option_d_begin,i-1);
                        Next_Question_begin = i+3;
                        Log.d("String Processing", str);
                        Log.d("Opt D", OptionD);
                        Log.d("We are at", Integer.toString(i));
                        OptionDList.add(OptionD);

                    }
                    /*if(str.matches("\d\d")){

                    }
                     */
                    nextQuestion = i+3;
                    /*
                    switch (c){

                        case '(':
                            Log.d("Found","Open bracket found");
                            if (Character.toString(temp.charAt(i+1)).matches("[1][A])")) {
                                Log.d("Into Regex", "a or 1 found");
                                if (Character.toString(temp.charAt(i+2)).equals(")")) {
                                    if (Character.toString(temp.charAt(i+3)).matches(" ")) {
                                        Question = temp.substring(0,i-1);
                                        Option_a_begin = i+4;
                                        Log.d("OptionA working",Question);
                                    }
                                }
                            }
                    }
                    */
                    //text2.setText(OptionB+OptionC+OptionD);
                    /*
                    if (Character.toString(c).matches("\\(")) {
                        if (Character.toString(temp.charAt(i+1)).matches("[a][1]]")) {
                            if (Character.toString(temp.charAt(i+2)).matches("\\)")) {
                                if (Character.toString(temp.charAt(i+3)).matches(" ")) {
                                    Question = temp.substring(0,i-1);
                                    Option_a_begin = i+4;
                                    Log.d("OptionA working",Question);
                                }
                            }
                        }
                    }else if (Character.toString(temp.charAt(i+1)).matches("[a][1]]")) {
                        if (Character.toString(temp.charAt(i+2)).matches("\\)")) {
                            if (Character.toString(temp.charAt(i+3)).matches(" ")) {
                                OptionA = temp.substring(Option_a_begin,i-1);
                                Option_b_begin = i+4;
                                Log.d("OptionB working",OptionA);
                            }
                        }
                    } else if (Character.toString(temp.charAt(i+1)).matches("[a][1]]")) {
                        if (Character.toString(temp.charAt(i+2)).matches("\\)")) {
                            if (Character.toString(temp.charAt(i+3)).matches(" ")) {
                                OptionB = temp.substring(Option_b_begin,i-1);
                                Option_c_begin = i+4;
                                Log.d("OptionC working",OptionC);
                            }
                        }
                    } else if (Character.toString(temp.charAt(i+1)).matches("[a][1]]")) {
                        if (Character.toString(temp.charAt(i+2)).matches("\\)")) {
                            if (Character.toString(temp.charAt(i+3)).matches(" ")) {
                                OptionC = temp.substring(Option_c_begin,i-1);
                                Option_d_begin = i+4;
                                Log.d("OptionD working",OptionD);
                            }
                        }
                    } else if (Character.toString(temp.charAt(i+1)).matches("[a][1]]")) {
                        if (Character.toString(temp.charAt(i+2)).matches("\\)")) {
                            if (Character.toString(temp.charAt(i+3)).matches(" ")) {
                                OptionD = temp.substring(Option_d_begin,i-1);
                                nextQuestion = i;
                                     }
                                }
                            }

                        }


                    }*/


                }
                text2.setText("Q1"+ Questionlist.get(2));
                text1.setText("Op 1:" + OptionAList.get(2) +"\n" +
                        "Op 2:" + OptionBList.get(2) +"\n" +
                        "Op 3:" + OptionCList.get(2) +"\n" +
                        "Op 4:" + OptionDList.get(2) +"\n");
            }
        });
    }
}


