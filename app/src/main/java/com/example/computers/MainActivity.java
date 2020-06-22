package com.example.computers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView equationText,resultText;
    private Button buttons[] = new Button[26];

    private Check check;
    private Calculation calculation;

    //布局中所有按钮的ID
    private int buttonIds[] = new int[]{
            R.id.Empty,
            R.id.BackSpace,
            R.id.Percent,
            R.id.Logarithm,
            R.id.LBracket,
            R.id.RBracket,
            R.id.Factorial,
            R.id.Reciprocal,
            R.id.PI,
            R.id.e,
            R.id.Except,
            R.id.N7,
            R.id.N8,
            R.id.N9,
            R.id.Multiply,
            R.id.N4,
            R.id.N5,
            R.id.N6,
            R.id.Subtract,
            R.id.N1,
            R.id.N2,
            R.id.N3,
            R.id.Equal,
            R.id.N0,
            R.id.Point,
            R.id.Addition
    };
    //等式
    private String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();  //初始化控件
    }

    /**
     * 点击计算器键盘
     *
     * */
    @Override
    public void onClick(View v) {

        int id = v.getId();
        Button button = (Button)findViewById(id);
        String text = button.getText().toString();
        switch (id){
            /**
             * 按数字按钮
             * */
            case R.id.N1:
            case R.id.N2:
            case R.id.N3:
            case R.id.N4:
            case R.id.N5:
            case R.id.N6:
            case R.id.N7:
            case R.id.N8:
            case R.id.N9:
            case R.id.N0:
                check.setEquation(equation);
                if(check.checkNumberInput()){
                    equation = check.getEquation();
                    equation += text;
                }
                break;
            /**
             * 点击 + - X/
             * */
            case R.id.Addition:
            case R.id.Subtract:
            case R.id.Multiply:
            case R.id.Except:
                check.setEquation(equation);
                if(check.checkOperationsInput()){
                    equation = check.getEquation();
                    equation += text;
                }
                break;
            /**
             * 点击退格键
             *
             * */
            case R.id.BackSpace:
                check.setEquation(equation);
                check.backSpace();
                equation = check.getEquation();
                break;
            /**
             * 点击 x^y
             * */
            case R.id.Logarithm:
                check.setEquation(equation);
                if(check.checkInvolutionInput())
                    equation+="^";
                break;
            /**
             * 倒数
             * */
            case R.id.Reciprocal:
                check.setEquation(equation);
                if(check.checkReciprocalInput())
                    equation+="^(-1)";
                break;
            /**
             * 左括号
             * */
            case R.id.LBracket:
                check.setEquation(equation);
                if(check.checkLBracketInput())
                    equation+="(";
                break;
            /**
             * 右括号
             * */
            case R.id.RBracket:
                check.setEquation(equation);
                if(check.checkRBracketInput())
                    equation+=')';
                break;
            /**
             * 取余
             * */
            case R.id.Percent:
                check.setEquation(equation);
                if(check.checkRemainderInput())
                    equation+='%';
                break;
            /**
             * 求阶乘
             **/
            case R.id.Factorial:
                check.setEquation(equation);
                if(check.checkFactorialInput())
                    equation+='!';
                break;
            /**
             * 清空按钮
             * */
            case R.id.Empty:
                equation = "";
                resultText.setText("");
                break;
            /**
             * 小数点按钮
             * */
            case R.id.Point:
                check.setEquation(equation);
                if(check.checkPointInput()){
                    equation = check.getEquation();
                    equation+=text;
                }
                break;
            /**
             * 点击π
             * */
            case R.id.PI:
                check.setEquation(equation);
                if (check.checkSpecialSymbolBack()){
                    equation+="π";
                }
                break;
            /**
             * 点击e
             * */
            case R.id.e:
                check.setEquation(equation);
                if (check.checkSpecialSymbolBack()){
                    equation+="e";
                }
                break;
            case R.id.Equal:
                resultText.setText(new Calculation(equation).solveEquation());
                break;

        }
        equationText.setText(equation);
    }
    /**
     * init()初始化绑定所有的控件，并添加事件
     * */
    void init(){

        int length = buttons.length;
        for(int i=0;i<length;i++){

            buttons[i] = (Button)findViewById(buttonIds[i]);
            buttons[i].setOnClickListener(this);
        }
        equationText = (TextView)findViewById(R.id.Equation);
        resultText = (TextView)findViewById(R.id.Result);
        check = new Check();
        calculation = new Calculation(equation);
    }
}
