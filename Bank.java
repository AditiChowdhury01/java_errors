import java.util.*;
class MyException extends Exception{
String str;
MyException(String str){
this.str = str;
}
public String toString(){
return ("my exception occured:"+str);
}
}

class banking{
static int c;
int c_id = ++c;
String c_name;
double amount;
double balance = 0;
double withdrawal;

banking(){
Scanner sc = new Scanner(System.in);
System.out.println("enter your name:");
c_name = sc.nextLine();
}

public void deposit(){
Scanner sc = new Scanner(System.in);
System.out.println("enter the amount for deposit:");
amount = sc.nextDouble();

try{
if(amount<0){
throw new MyException("amount cannot be negtive");
}
else{
balance = balance + amount;
}
}

catch(MyException exp){
System.out.println(exp);
}
}

public void withdraw(){
Scanner sc = new Scanner(System.in);
System.out.println("enter the amount you want to withdraw:");
withdrawal = sc.nextDouble();
double rem  = balance - withdrawal;

try{

if(withdrawal<0){
throw new MyException("withdrawal cannot be negative");
}
else if(withdrawal>balance){
throw new MyException("withdrawal cannot be greater than the balance");
}
else if(rem<1000){
throw new MyException("balance cannot be less than 1000");
}
else{
System.out.println();

System.out.println("your id is: "+c_id);
System.out.println("your name is: "+c_name);
System.out.println("you want to deposit: "+amount);
System.out.println("the balance amount left in the account: "+balance);
System.out.println("you want to withdraw: "+withdrawal);
}
}

catch(MyException ex){
System.out.println(ex);
balance = balance - withdrawal;
}
}
}

public class Bank{
public static void main(String[] args){
banking bk = new banking();
bk.deposit();
bk.withdraw();
}
}