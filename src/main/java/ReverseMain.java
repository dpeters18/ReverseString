import javax.swing.*;

public class ReverseMain {
    public static void main(String[] args) {
        int k=0;
        int error;
        do {
            error = 0;
            try {
                k = Integer.parseInt(JOptionPane.showInputDialog("How many columns do you want?" +
                        " Please type a number between 1 and 27."));
                if(k<0||k>25)
                    error=1;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please type a number between 1 and 27.");
                error = 1;
            }
        } while (error==1);

        String s=JOptionPane.showInputDialog("What would you like to name the file the results are stored to?");
        AsColumns cols = new AsColumns();
        try{
        cols.createFile(s);
        cols.toColumn((int)(Math.ceil(27.0/k)));}
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"There was an error creating and writing to the desired file.");
        }
    }
}

