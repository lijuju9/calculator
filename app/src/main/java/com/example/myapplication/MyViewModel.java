package com.example.myapplication;

import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//用于储存数据模型（数字模型）
public class MyViewModel extends ViewModel {
    private MutableLiveData<String>mainNum;//主数值（用户正在操作的数）
    public String sign1="",sign2="";//储存运算符号
    public String num[]={"",""};//储存参与计算的数值
    public boolean havePoint=false;//主数值中是否包含小数点
    private boolean isResultShown = false;
    public boolean isResultShown() { return isResultShown; }
    public void setResultShown(boolean resultShown) { isResultShown = resultShown; }


    public MutableLiveData<String>getMainNum(){
        if (mainNum ==null){
            mainNum= new MutableLiveData<>();
            mainNum.setValue("0");
        }
        return mainNum;
    }

    public void setMainNum(String n){
        if (mainNum.getValue().equals("0")){
            mainNum.setValue(n);
        }else {
            mainNum.setValue(mainNum.getValue()+n);
        }
    }

    public String mainNumWith_0_Tocal(){
        String value="0";
        if(mainNum.getValue().contains(".") || num[0].contains(".")){//如果两个数的其中一个有小数点的话
            switch (sign1){
                case "+":
                    value=String.valueOf(Double.valueOf(num[0]) + Double.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value=String.valueOf(Double.valueOf(num[0]) - Double.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value=String.valueOf(Double.valueOf(num[0]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if(mainNum.getValue().equals("0")){
                        value = "除数不能为0";
                    }else {
                        value = String.valueOf(Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
                    }
                    break;

            }
        }else {//如果两个数都是整数
            switch (sign1){
                case "+":
                    value=String.valueOf(Integer.valueOf(num[0]) + Integer.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value=String.valueOf(Integer.valueOf(num[0]) - Integer.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value=String.valueOf(Integer.valueOf(num[0]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    value=String.valueOf(Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
            }
        }
        return value;
    }
    public  String mainNumWithNum_1_Tocal(){
        String value="0";
        if(mainNum.getValue().contains(".") || num[1].contains(".")){//如果两个数的其中一个有小数点的话
            switch (sign2){
                case "*":
                    value=String.valueOf(Double.valueOf(num[1]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    value=String.valueOf(Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
            }
        }else {//如果两个数都是整数
            switch (sign2){
                case "*":
                    value=String.valueOf(Integer.valueOf(num[1]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    value=String.valueOf(Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
            }
        }
        return value;
    }


}
