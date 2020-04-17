import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner in  = new Scanner(System.in);

        System.out.println("Please enter first number(Nr):");
        int Nr = in.nextInt();

        System.out.println("Please enter second number(Dr):");
        int Dr = in.nextInt();

        try{
            new Main().doDivide(Nr,Dr);
        } catch(Exception ex){
            System.out.println("Exception condition program is ending");
        }
    }

    public void doDivide(int a,int b) throws Exception{
        float res = a/b;
        System.out.println("Division results of "+a+"/"+b+" = " +res);
    }
}